package com.miui.micloud;

import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.kss.DownloadRequestResult;
import cn.kuaipan.android.utils.ApiDataHelper.IKscData;
import cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser;
import java.util.Map;
import java.util.zip.DataFormatException;

public class MiCloudDownloadRequestResult extends DownloadRequestResult implements IKscData {
    public static final Parser<MiCloudDownloadRequestResult> PARSER = new C03271();

    static class C03271 implements Parser<MiCloudDownloadRequestResult> {
        C03271() {
        }

        public MiCloudDownloadRequestResult parserMap(Map<String, Object> map, String... requireds) throws DataFormatException, KscException {
            return new MiCloudDownloadRequestResult(map);
        }
    }

    public MiCloudDownloadRequestResult(Map<String, Object> map) throws KscException {
        super(map);
    }
}
