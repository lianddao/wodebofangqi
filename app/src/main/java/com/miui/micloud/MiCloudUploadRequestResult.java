package com.miui.micloud;

import cn.kuaipan.android.exception.ErrorCode;
import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.kss.UploadRequestResult;
import cn.kuaipan.android.utils.ApiDataHelper;
import cn.kuaipan.android.utils.ApiDataHelper.IKscData;
import cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser;
import cn.kuaipan.android.utils.IObtainable;
import cn.kuaipan.android.utils.JsonUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.zip.DataFormatException;
import org.json.JSONException;
import org.json.JSONObject;

public class MiCloudUploadRequestResult extends UploadRequestResult implements IKscData {
    public static final String MAP_KEY_KSS = "kss_map";
    public static final String MAP_KEY_REQUEST_ID = "requestId";
    public static final String MAP_KEY_RESULT = "result_map";
    public static final Parser<MiCloudUploadRequestResult> PARSER = new C03281();
    public final String requestId;

    static class C03281 implements Parser<MiCloudUploadRequestResult> {
        C03281() {
        }

        public MiCloudUploadRequestResult parserMap(Map<String, Object> map, String... requireds) throws DataFormatException, KscException {
            return new MiCloudUploadRequestResult(map);
        }
    }

    public MiCloudUploadRequestResult(Map<String, Object> resultData) throws KscException {
        super(resultData);
        this.requestId = ApiDataHelper.asString(resultData, MAP_KEY_REQUEST_ID);
    }

    public static MiCloudUploadRequestResult create(String kssStr) throws KscException {
        Map<String, Object> map = null;
        try {
            map = (Map) JsonUtils.parser(new StringReader(kssStr));
            MiCloudUploadRequestResult miCloudUploadRequestResult = new MiCloudUploadRequestResult(map);
            if (map != null && (map instanceof IObtainable)) {
                ((IObtainable) map).recycle();
            }
            return miCloudUploadRequestResult;
        } catch (IOException e) {
            throw new KscException(ErrorCode.DATA_IS_EMPTY, "kss is null", e);
        } catch (JSONException e2) {
            throw new KscException(ErrorCode.DATA_IS_NOT_JSON, "kss is not json", e2);
        } catch (Throwable th) {
            if (map != null && (map instanceof IObtainable)) {
                ((IObtainable) map).recycle();
            }
        }
    }

    public String toString() {
        String superString = super.toString();
        try {
            return new JSONObject(superString).put(MAP_KEY_REQUEST_ID, this.requestId).toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return superString;
        }
    }
}
