package com.songbirdnest.facebook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface FacebookAPICallback {
    void onFileNotFoundException(FileNotFoundException fileNotFoundException);

    void onIOException(IOException iOException);

    void onMalformedURLException(MalformedURLException malformedURLException);

    void onRequestCanceled();

    void onRequestCompleted(String str);

    void onRequestError(String str);
}
