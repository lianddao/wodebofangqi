package cn.ldm.player;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.ldm.player.core.MusicMetadataDataSource;
import cn.ldm.player.core.maicong.KuGou;

import static org.junit.Assert.assertEquals;

/**
 * 仪器化测试，将在Android设备上执行。
 * https://developer.android.com/studio/test/index.html
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    Context mContext = InstrumentationRegistry.getTargetContext();// 被测试应用程序的上下文
    MusicMetadataDataSource dataSource = MusicMetadataDataSource.getInstance(mContext);
    //    MediaBrowser.MediaItem mParentItem = new MediaBrowser.MediaItem(new MediaDescription.Builder()
    //            .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM)
    //            .build(),
    //            MediaBrowser.MediaItem.FLAG_BROWSABLE
    //    );

    public ServiceTestRule serviceTestRule = new ServiceTestRule();
    ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    MainActivity mainActivity;


    @Before
    public void setup() throws Exception {
        activityRule.launchActivity(null);
        mainActivity = activityRule.getActivity();
    }

    @After
    public void uninstall() throws Exception {

    }

    @Test
    public void useAppContext() throws Exception {
        assertEquals("cn.ldm.player", mContext.getPackageName());
    }

    @Test
    public void bindService() throws Exception {
        //        IBinder iBinder = serviceTestRule.bindService(new Intent(mContext, MyMediaBrowserService.class));
        //        MyMediaBrowserService service = ((MyMediaBrowserService.LocalBinder) iBinder).getService();
    }

    @Test
    public void startService() throws Exception {
        //        serviceTestRule.startService(new Intent(mContext, MyMediaBrowserService.class));
    }
}
