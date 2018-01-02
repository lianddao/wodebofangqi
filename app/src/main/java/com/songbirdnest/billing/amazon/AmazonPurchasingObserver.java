package com.songbirdnest.billing.amazon;

import android.content.Context;
import com.amazon.inapp.purchasing.BasePurchasingObserver;
import com.amazon.inapp.purchasing.GetUserIdResponse;
import com.amazon.inapp.purchasing.GetUserIdResponse.GetUserIdRequestStatus;
import com.amazon.inapp.purchasing.ItemDataResponse;
import com.amazon.inapp.purchasing.PurchaseResponse;
import com.amazon.inapp.purchasing.PurchaseResponse.PurchaseRequestStatus;
import com.amazon.inapp.purchasing.PurchaseUpdatesResponse;
import com.amazon.inapp.purchasing.PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus;
import com.amazon.inapp.purchasing.PurchasingManager;
import com.amazon.inapp.purchasing.Receipt;
import com.songbirdnest.billing.BillingHelper;
import com.songbirdnest.billing.InAppPurchases;
import com.songbirdnest.billing.PurchaseState;
import com.songbirdnest.billing.ResponseCode;
import com.songbirdnest.util.Logger;
import java.util.Set;
import java.util.UUID;

public class AmazonPurchasingObserver extends BasePurchasingObserver {
    protected BillingHelper billingHelper;
    protected String currentUser;

    public AmazonPurchasingObserver(Context context, BillingHelper billingHelper) {
        super(context);
        this.billingHelper = billingHelper;
    }

    public void onGetUserIdResponse(GetUserIdResponse getUserIdResponse) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "onGetUserIdResponse " + getUserIdResponse);
        }
        if (getUserIdResponse != null && getUserIdResponse.getUserIdRequestStatus() == GetUserIdRequestStatus.SUCCESSFUL) {
            this.currentUser = getUserIdResponse.getUserId();
            this.billingHelper.fireBillingSupported(true);
        }
    }

    public void onItemDataResponse(ItemDataResponse itemDataResponse) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "onItemDataResponse: " + itemDataResponse);
        }
    }

    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "onPurchaseResponse " + purchaseResponse);
        }
        if (purchaseResponse == null) {
            return;
        }
        if (purchaseResponse.getPurchaseRequestStatus() != PurchaseRequestStatus.SUCCESSFUL && purchaseResponse.getPurchaseRequestStatus() != PurchaseRequestStatus.ALREADY_ENTITLED) {
            return;
        }
        if (purchaseResponse.getPurchaseRequestStatus() == PurchaseRequestStatus.ALREADY_ENTITLED) {
            InAppPurchases currentPurchasingItem = this.billingHelper.getCurrentPurchasingItem();
            if (!this.billingHelper.purchaseExists(currentPurchasingItem)) {
                if (BillingHelper.debugging) {
                    Logger.debug(this, "onPurchaseUpdatesResponse: Product " + currentPurchasingItem.getProductId() + " does not exist");
                }
                this.billingHelper.updatePurchase(UUID.randomUUID().toString(), currentPurchasingItem.getProductId(), PurchaseState.PURCHASED, System.currentTimeMillis(), null);
            }
            this.billingHelper.firePurchased(currentPurchasingItem.getProductId(), true);
            if (BillingHelper.debugging) {
                Logger.debug(this, "onPurchaseUpdatesResponse: currentPurchasingItem " + currentPurchasingItem);
                return;
            }
            return;
        }
        Receipt receipt = purchaseResponse.getReceipt();
        if (receipt != null) {
            this.billingHelper.updatePurchase(UUID.randomUUID().toString(), receipt.getSku(), PurchaseState.PURCHASED, System.currentTimeMillis(), null);
            this.billingHelper.firePurchased(receipt.getSku(), true);
            if (BillingHelper.debugging) {
                Logger.debug(this, "onPurchaseUpdatesResponse: receipt " + receipt);
            }
        }
    }

    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "onPurchaseUpdatesResponse " + purchaseUpdatesResponse);
        }
        if (purchaseUpdatesResponse != null && purchaseUpdatesResponse.getPurchaseUpdatesRequestStatus() == PurchaseUpdatesRequestStatus.SUCCESSFUL) {
            Set<Receipt> receipts = purchaseUpdatesResponse.getReceipts();
            if (receipts != null) {
                for (Receipt receipt : receipts) {
                    if (BillingHelper.debugging) {
                        Logger.debug(this, "onPurchaseUpdatesResponse: receipt " + receipt);
                    }
                    this.billingHelper.updatePurchase(receipt.getPurchaseToken(), receipt.getSku(), PurchaseState.PURCHASED, System.currentTimeMillis(), null);
                }
            }
            this.billingHelper.fireRestoreTransactions(ResponseCode.RESULT_OK);
        }
    }

    public void onSdkAvailable(boolean isSandboxMode) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "onSdkAvailable: Sandbox mode " + isSandboxMode);
        }
        PurchasingManager.initiateGetUserIdRequest();
    }
}
