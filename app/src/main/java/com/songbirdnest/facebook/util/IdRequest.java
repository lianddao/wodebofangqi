package com.songbirdnest.facebook.util;

import android.os.Handler;
import android.os.Message;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.facebook.FacebookAPICallback;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.stream.StreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONObject;

public class IdRequest implements FacebookAPICallback {
    Handler mHandler;

    public IdRequest(Handler pHandler) {
        this.mHandler = pHandler;
    }

    public void onRequestCompleted(String aResponse) {
        try {
            JSONObject aObject = new JSONObject(aResponse);
            if (aObject.has("id")) {
                final String aID = aObject.getString("id");
                final String aName = aObject.getString(CookieTable.NAME);
                SoundboardServer.get().setUser(aID, aName, aObject.getString("email"), new SoundboardListener<String>() {
                    public void onSuccess(String id) {
                        Friend aCaller = new Friend();
                        aCaller.setFacebookId(aID);
                        aCaller.setFullName(aName);
                        Message aMess = new Message();
                        aMess.obj = aCaller;
                        aMess.what = 1;
                        IdRequest.this.mHandler.sendMessage(aMess);
                    }

                    public void onFailure(String message, StreamException exception) {
                        IdRequest.this.handleError(message);
                    }
                });
            }
        } catch (Exception e) {
            handleError(e.getMessage());
        }
    }

    public void onRequestCanceled() {
        handleError("Cancelled");
    }

    public void onRequestError(String aResponse) {
        handleError(aResponse);
    }

    public void onFileNotFoundException(FileNotFoundException aException) {
        handleError(aException.getMessage());
    }

    public void onIOException(IOException aIOException) {
        handleError(aIOException.getMessage());
    }

    public void onMalformedURLException(MalformedURLException aMalformedException) {
        handleError(aMalformedException.getMessage());
    }

    private void handleError(String error) {
        Message aMess = new Message();
        aMess.obj = error;
        aMess.what = 2;
        this.mHandler.sendMessage(aMess);
    }
}
