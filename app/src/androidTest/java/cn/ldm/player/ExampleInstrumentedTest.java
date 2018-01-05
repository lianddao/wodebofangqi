package cn.ldm.player;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import cn.ldm.player.core.MusicMetadataDataSource;

import static org.junit.Assert.assertEquals;

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
    MusicMetadataDataSource dataSource = MusicMetadataDataSource.getInstance(mContext);

    @Test
    public void retrieveMusic() throws Exception {
        dataSource.toStringPlaylist();
    }

}
