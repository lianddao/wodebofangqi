package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;

public final class clp {
    private static final SparseArray<Pair<String, String>> f8434a = new SparseArray();

    static {
        f8434a.put(17000, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
        f8434a.put(17002, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
        f8434a.put(17004, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
        f8434a.put(17008, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
        f8434a.put(17009, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
        f8434a.put(17024, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
        f8434a.put(17014, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
        f8434a.put(17012, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
        f8434a.put(17007, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
        f8434a.put(17025, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
        f8434a.put(17005, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
        f8434a.put(17021, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
        f8434a.put(17011, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
        f8434a.put(17017, new Pair("ERROR_INVALID_USER_TOKEN", "The user's credential is no longer valid. The user must sign in again."));
        f8434a.put(17006, new Pair("ERROR_OPERATION_NOT_ALLOWED", "This operation is not allowed. You must enable this service in the console."));
        f8434a.put(17026, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
    }

    public static eal m11601a(Status status) {
        int h = status.m2259h();
        switch (h) {
            case 17000:
            case 17002:
            case 17004:
            case 17008:
            case 17009:
            case 17024:
                return new ebe(m11602a(h), m11604b(h));
            case 17005:
            case 17011:
            case 17017:
            case 17021:
                return new ebf(m11602a(h), m11604b(h));
            case 17006:
                return new ebd(m11602a(h), m11604b(h));
            case 17007:
            case 17012:
            case 17025:
                return new ebh(m11602a(h), m11604b(h));
            case 17010:
                return new eao(m11603a("We have blocked all requests from this device due to unusual activity. Try again later.", status));
            case 17014:
                return new ebg(m11602a(h), m11604b(h));
            case 17015:
                return new eal("User has already been linked to the given provider.");
            case 17016:
                return new eal("User was not linked to an account with the given provider.");
            case 17020:
                return new eam("A network error (such as timeout, interrupted connection or unreachable host) has occurred.");
            case 17026:
                return new ebi(m11602a(h), m11603a(m11604b(h), status), status.m2254c());
            case 17495:
                return new cza("Please sign in before trying to get a token.");
            case 17499:
                return new eal(m11603a("An internal error has occurred.", status));
            default:
                return new eal("An internal error has occurred.");
        }
    }

    private static String m11602a(int i) {
        Pair pair = (Pair) f8434a.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    private static String m11603a(String str, Status status) {
        if (TextUtils.isEmpty(status.m2254c())) {
            return str;
        }
        return String.format(String.valueOf(str).concat(" [ %s ]"), new Object[]{status.m2254c()});
    }

    private static String m11604b(int i) {
        Pair pair = (Pair) f8434a.get(i);
        return pair != null ? (String) pair.second : "An internal error happened";
    }
}
