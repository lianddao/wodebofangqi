package com.miui.micloud;

import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.utils.ApiDataHelper;
import cn.kuaipan.android.utils.ApiDataHelper.IKscData;
import cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser;
import java.util.Map;
import java.util.zip.DataFormatException;

public class MiCloudCommitResult implements IKscData {
    public static final Parser<MiCloudCommitResult> PARSER = new C03261();
    public final String stat;

    static class C03261 implements Parser<MiCloudCommitResult> {
        C03261() {
        }

        public MiCloudCommitResult parserMap(Map<String, Object> map, String... requireds) throws DataFormatException, KscException {
            return new MiCloudCommitResult(map);
        }
    }

    private MiCloudCommitResult(Map<String, Object> map) {
        this.stat = ApiDataHelper.asString(map, "stat");
    }
}
