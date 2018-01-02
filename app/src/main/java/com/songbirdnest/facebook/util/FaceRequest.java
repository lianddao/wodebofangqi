package com.songbirdnest.facebook.util;

import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.facebook.FacebookAPICallback;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONArray;
import org.json.JSONObject;

public class FaceRequest implements FacebookAPICallback {
    ImageBackend mBackend;

    public FaceRequest(ImageBackend pBackend) {
        this.mBackend = pBackend;
    }

    public void onRequestCompleted(String aResponse) {
        try {
            JSONArray aArray = new JSONArray(aResponse);
            for (int i = 0; i < aArray.length(); i++) {
                JSONObject aJSON = aArray.getJSONObject(i);
                this.mBackend.addId(Long.valueOf(aJSON.getLong("uid")));
                this.mBackend.addName(aJSON.getString(CookieTable.NAME));
            }
            this.mBackend.updateDone();
        } catch (Exception e) {
        }
    }

    public void onRequestCanceled() {
    }

    public void onRequestError(String aResponse) {
    }

    public void onFileNotFoundException(FileNotFoundException aException) {
    }

    public void onIOException(IOException aIOException) {
    }

    public void onMalformedURLException(MalformedURLException aMalformedException) {
    }
}
