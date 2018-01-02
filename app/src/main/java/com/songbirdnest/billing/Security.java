package com.songbirdnest.billing;

import android.content.Context;
import android.text.TextUtils;
import com.songbirdnest.billing.db.HistoryTable;
import com.songbirdnest.billing.util.Base64;
import com.songbirdnest.billing.util.Base64DecoderException;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.util.Logger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Security {
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static boolean debugging = false;
    private static HashSet<Long> sKnownNonces = new HashSet();

    public static class VerifiedPurchase {
        public String developerPayload;
        public String notificationId;
        public String orderId;
        public String productId;
        public PurchaseState purchaseState;
        public long purchaseTime;

        public VerifiedPurchase(PurchaseState purchaseState, String notificationId, String productId, String orderId, long purchaseTime, String developerPayload) {
            this.purchaseState = purchaseState;
            this.notificationId = notificationId;
            this.productId = productId;
            this.orderId = orderId;
            this.purchaseTime = purchaseTime;
            this.developerPayload = developerPayload;
        }
    }

    public static long generateNonce() {
        long nonce = RANDOM.nextLong();
        sKnownNonces.add(Long.valueOf(nonce));
        return nonce;
    }

    public static void removeNonce(long nonce) {
        sKnownNonces.remove(Long.valueOf(nonce));
    }

    public static boolean isNonceKnown(long nonce) {
        return sKnownNonces.contains(Long.valueOf(nonce));
    }

    public static ArrayList<VerifiedPurchase> verifyPurchase(Context context, String signedData, String signature) {
        if (signedData == null) {
            Logger.error((Object) Security.class, "data is null");
            return null;
        }
        if (debugging) {
            Logger.debug(Security.class, "signedData: " + signedData);
        }
        boolean verified = false;
        if (!TextUtils.isEmpty(signature)) {
            StringBuilder base64EncodedPublicKey = new StringBuilder();
            base64EncodedPublicKey.append(context.getString(C0116R.string.billing_key1));
            base64EncodedPublicKey.append(context.getString(C0116R.string.billing_key2));
            base64EncodedPublicKey.append(context.getString(C0116R.string.billing_key3));
            base64EncodedPublicKey.append(context.getString(C0116R.string.billing_key4));
            verified = verify(generatePublicKey(base64EncodedPublicKey.toString()), signedData, signature);
            if (!verified) {
                Logger.debug(Security.class, "signature does not match data.");
                return null;
            }
        }
        int numTransactions = 0;
        try {
            JSONObject jObject = new JSONObject(signedData);
            long nonce = jObject.optLong("nonce");
            JSONArray jTransactionsArray = jObject.optJSONArray("orders");
            if (jTransactionsArray != null) {
                numTransactions = jTransactionsArray.length();
            }
            if (isNonceKnown(nonce)) {
                ArrayList<VerifiedPurchase> purchases = new ArrayList();
                int i = 0;
                while (i < numTransactions) {
                    try {
                        JSONObject jElement = jTransactionsArray.getJSONObject(i);
                        PurchaseState purchaseState = PurchaseState.valueOf(jElement.getInt("purchaseState"));
                        String productId = jElement.getString(HistoryTable.HISTORY_PRODUCT_ID);
                        String packageName = jElement.getString("packageName");
                        long purchaseTime = jElement.getLong(HistoryTable.HISTORY_PURCHASE_TIME);
                        String orderId = jElement.optString(HistoryTable.HISTORY_ORDER, "");
                        String notifyId = null;
                        if (jElement.has("notificationId")) {
                            notifyId = jElement.getString("notificationId");
                        }
                        String developerPayload = jElement.optString(HistoryTable.HISTORY_DEVELOPER_PAYLOAD, null);
                        if (purchaseState != PurchaseState.PURCHASED || verified) {
                            purchases.add(new VerifiedPurchase(purchaseState, notifyId, productId, orderId, purchaseTime, developerPayload));
                        }
                        i++;
                    } catch (JSONException e) {
                        Logger.error(Security.class, "JSON exception: ", e);
                        return null;
                    }
                }
                removeNonce(nonce);
                return purchases;
            }
            Logger.debug(Security.class, "Nonce not found: " + nonce);
            return null;
        } catch (JSONException e2) {
            Logger.error(Security.class, "Problems parsing orders", e2);
            return null;
        }
    }

    public static PublicKey generatePublicKey(String encodedPublicKey) {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(encodedPublicKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            Logger.error((Object) Security.class, "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        } catch (Base64DecoderException e3) {
            Logger.error((Object) Security.class, "Base64 decoding failed.");
            throw new IllegalArgumentException(e3);
        }
    }

    public static boolean verify(PublicKey publicKey, String signedData, String signature) {
        if (debugging) {
            Logger.debug(Security.class, "signature: " + signature);
        }
        try {
            Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(publicKey);
            sig.update(signedData.getBytes());
            if (sig.verify(Base64.decode(signature))) {
                return true;
            }
            Logger.error((Object) Security.class, "Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            Logger.error((Object) Security.class, "NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            Logger.error((Object) Security.class, "Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            Logger.error((Object) Security.class, "Signature exception.");
            return false;
        } catch (Base64DecoderException e4) {
            Logger.error((Object) Security.class, "Base64 decoding failed.");
            return false;
        }
    }
}
