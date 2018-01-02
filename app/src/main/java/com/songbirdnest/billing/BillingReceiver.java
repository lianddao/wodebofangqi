package com.songbirdnest.billing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.util.Logger;

public class BillingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Constants.ACTION_PURCHASE_STATE_CHANGED.equals(action)) {
            purchaseStateChanged(context, intent.getStringExtra(Constants.INAPP_SIGNED_DATA), intent.getStringExtra(Constants.INAPP_SIGNATURE));
        } else if (Constants.ACTION_NOTIFY.equals(action)) {
            String notifyId = intent.getStringExtra(Constants.NOTIFICATION_ID);
            if (BillingHelper.debugging) {
                Logger.debug(this, "notifyId: " + notifyId);
            }
            notify(context, notifyId);
        } else if (Constants.ACTION_RESPONSE_CODE.equals(action)) {
            checkResponseCode(context, intent.getLongExtra(Constants.INAPP_REQUEST_ID, -1), intent.getIntExtra(Constants.INAPP_RESPONSE_CODE, ResponseCode.RESULT_ERROR.ordinal()));
        } else {
            Logger.error((Object) this, "unexpected action: " + action);
        }
    }

    private void purchaseStateChanged(Context context, String signedData, String signature) {
        Intent intent = new Intent(Constants.ACTION_PURCHASE_STATE_CHANGED);
        intent.setClass(context, BillingService.class);
        intent.putExtra(Constants.INAPP_SIGNED_DATA, signedData);
        intent.putExtra(Constants.INAPP_SIGNATURE, signature);
        context.startService(intent);
    }

    private void notify(Context context, String notifyId) {
        Intent intent = new Intent(Constants.ACTION_GET_PURCHASE_INFORMATION);
        intent.setClass(context, BillingService.class);
        intent.putExtra(Constants.NOTIFICATION_ID, notifyId);
        context.startService(intent);
    }

    private void checkResponseCode(Context context, long requestId, int responseCodeIndex) {
        Intent intent = new Intent(Constants.ACTION_RESPONSE_CODE);
        intent.setClass(context, BillingService.class);
        intent.putExtra(Constants.INAPP_REQUEST_ID, requestId);
        intent.putExtra(Constants.INAPP_RESPONSE_CODE, responseCodeIndex);
        context.startService(intent);
    }
}
