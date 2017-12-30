package cn.ldm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import cn.ldm.player.core.MusicScanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * 仪器化测试，将在Android设备上执行。
 * https://developer.android.com/studio/test/index.html
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        assertEquals("cn.ldm.player", mContext.getPackageName());
    }

    Context mContext = InstrumentationRegistry.getTargetContext();// 被测试应用程序的上下文
    MusicScanner mScanner = MusicScanner.getInstance(mContext);

    @Test
    public void retrieveMusic() throws Exception {
        ArrayList<MediaMetadata> result = new ArrayList<>();
        if (mScanner.retrieveMedia(result)) {
            assertNotNull(result);
            for (MediaMetadata media : result) {
                Bitmap bitmap = mScanner.retrieveAlbumArt(media);
                if (bitmap != null) assertNotNull("专辑图片", bitmap);
                else assertNull("专辑图片", bitmap);
            }
        }
    }

}
