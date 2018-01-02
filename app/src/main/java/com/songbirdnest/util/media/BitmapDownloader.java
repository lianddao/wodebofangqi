package com.songbirdnest.util.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.util.Logger;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

public class BitmapDownloader {
    public static int BUFFER_LENGTH = 64000;
    private static int defaultBufferSize = 8192;
    private static boolean timing = false;
    private boolean errorOccurred = false;
    private ExecutorService mDownloadExecutator;

    class DownloadImagesRunnable implements Runnable {
        BitmapLoadInfo bitmapLoadInfo;

        class C04711 extends AbstractStreamHandler<Bitmap> {
            C04711() {
            }

            public Bitmap processInputStream(InputStream stream, long contentLength) throws StreamException {
                if (stream != null) {
                    return BitmapDownloader.readBitmap(stream);
                }
                return null;
            }
        }

        DownloadImagesRunnable(BitmapLoadInfo bitmapLoadInfo) {
            this.bitmapLoadInfo = bitmapLoadInfo;
        }

        public void run() {
            Bitmap aBitmap = null;
            long start = System.currentTimeMillis();
            try {
                if (this.bitmapLoadInfo.url == null) {
                    Logger.error((Object) this, "No URL to download image for id " + this.bitmapLoadInfo.id);
                    return;
                }
                aBitmap = BitmapDownloader.this.getFileImage(this.bitmapLoadInfo);
                if (aBitmap == null) {
                    try {
                        aBitmap = (Bitmap) new StreamProcessor(this.bitmapLoadInfo.url, new C04711()).processInputStream();
                        if (!(aBitmap == null || this.bitmapLoadInfo.postProcessor == null)) {
                            Bitmap postProcessedBitmap = this.bitmapLoadInfo.postProcessor.postProcess(aBitmap);
                            if (postProcessedBitmap != aBitmap) {
                                aBitmap.recycle();
                                aBitmap = postProcessedBitmap;
                            }
                        }
                        if (aBitmap == null && this.bitmapLoadInfo.imageReadyListener != null) {
                            this.bitmapLoadInfo.imageReadyListener.error(this.bitmapLoadInfo.id, null);
                        }
                    } catch (StreamException e) {
                        Logger.error(this, "DownloadImagesRunnable: Problems Downloading Facebook Image " + this.bitmapLoadInfo.url, e);
                        BitmapDownloader.this.errorOccurred = true;
                        if (this.bitmapLoadInfo.imageReadyListener != null) {
                            this.bitmapLoadInfo.imageReadyListener.error(this.bitmapLoadInfo.id, e);
                        }
                    }
                    if (BitmapDownloader.timing) {
                        Logger.debug(this, "Time to download Bitmap Image was " + (System.currentTimeMillis() - start) + " ms");
                    }
                }
                if (aBitmap != null && this.bitmapLoadInfo.imageReadyListener != null) {
                    this.bitmapLoadInfo.imageReadyListener.ready(this.bitmapLoadInfo.id, aBitmap);
                }
            } catch (Exception e2) {
                Logger.error(this, "Problems Downloading Image " + this.bitmapLoadInfo.url, e2);
                BitmapDownloader.this.errorOccurred = true;
                if (this.bitmapLoadInfo.imageReadyListener != null) {
                    this.bitmapLoadInfo.imageReadyListener.error(this.bitmapLoadInfo.id, e2);
                }
            }
        }
    }

    public BitmapDownloader(ExecutorService mDownloadExecutator) {
        this.mDownloadExecutator = mDownloadExecutator;
    }

    public void startDownload(BitmapLoadInfo bitmapLoadInfo) {
        this.mDownloadExecutator.execute(new DownloadImagesRunnable(bitmapLoadInfo));
    }

    public Bitmap getFileImage(BitmapLoadInfo bitmapLoadInfo) {
        Bitmap bitmap = null;
        if (bitmapLoadInfo.filePath != null && new File(bitmapLoadInfo.filePath).exists()) {
            try {
                bitmap = BitmapFactory.decodeStream(new FileInputStream(bitmapLoadInfo.filePath));
            } catch (FileNotFoundException e) {
                Logger.error(this, "Problems getting Image " + bitmapLoadInfo.filePath, e);
            } catch (OutOfMemoryError e2) {
                Logger.error(this, "Problems getting Image " + bitmapLoadInfo.filePath, e2);
            }
        }
        return bitmap;
    }

    public static Bitmap readBitmap(InputStream stream) {
        long start = System.currentTimeMillis();
        BufferedInputStream inputStream = new BufferedInputStream(stream, defaultBufferSize);
        byte[] buffer = new byte[BUFFER_LENGTH];
        Bitmap bitmap = null;
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            for (int read = inputStream.read(buffer); read > 0; read = inputStream.read(buffer)) {
                bytes.write(buffer, 0, read);
            }
            bytes.close();
            inputStream.close();
            byte[] imageBytes = bytes.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            if (timing) {
                Logger.debug(BitmapDownloader.class, "Took " + (System.currentTimeMillis() - start) + " ms to download and read bitmap");
            }
        } catch (IOException e) {
            Logger.error(BitmapDownloader.class, "Problems reading Bitmap", e);
        } catch (OutOfMemoryError e2) {
            Logger.error(BitmapDownloader.class, "Problems reading Bitmap: Out of Memory", e2);
        }
        return bitmap;
    }
}
