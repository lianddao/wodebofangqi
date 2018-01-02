package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;

public enum ehi extends UrlAction {
    public ehi(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return "deeplink+".equalsIgnoreCase(uri.getScheme());
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        if ("navigate".equalsIgnoreCase(uri.getHost())) {
            try {
                String queryParameter = uri.getQueryParameter("primaryUrl");
                Iterable queryParameters = uri.getQueryParameters("primaryTrackingUrl");
                String queryParameter2 = uri.getQueryParameter("fallbackUrl");
                Iterable queryParameters2 = uri.getQueryParameters("fallbackTrackingUrl");
                if (queryParameter == null) {
                    throw new IntentNotResolvableException("Deeplink+ did not have 'primaryUrl' query param.");
                }
                Uri parse = Uri.parse(queryParameter);
                if (shouldTryHandlingUrl(parse)) {
                    throw new IntentNotResolvableException("Deeplink+ had another Deeplink+ as the 'primaryUrl'.");
                }
                try {
                    Intents.launchApplicationUrl(context, parse);
                    TrackingRequest.makeTrackingHttpRequest(queryParameters, context, Name.CLICK_REQUEST);
                    return;
                } catch (IntentNotResolvableException e) {
                    if (queryParameter2 == null) {
                        throw new IntentNotResolvableException("Unable to handle 'primaryUrl' for Deeplink+ and 'fallbackUrl' was missing.");
                    } else if (shouldTryHandlingUrl(Uri.parse(queryParameter2))) {
                        throw new IntentNotResolvableException("Deeplink+ URL had another Deeplink+ URL as the 'fallbackUrl'.");
                    } else {
                        urlHandler.handleUrl(context, queryParameter2, true, queryParameters2);
                        return;
                    }
                }
            } catch (UnsupportedOperationException e2) {
                throw new IntentNotResolvableException("Deeplink+ URL was not a hierarchical URI.");
            }
        }
        throw new IntentNotResolvableException("Deeplink+ URL did not have 'navigate' as the host.");
    }
}
