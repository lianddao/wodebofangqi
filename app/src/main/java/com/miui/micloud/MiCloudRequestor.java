package com.miui.micloud;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import cn.kuaipan.android.exception.ErrorCode;
import cn.kuaipan.android.exception.ErrorHelper;
import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.exception.ServerException;
import cn.kuaipan.android.exception.ServerMsgException;
import cn.kuaipan.android.http.KscHttpRequest;
import cn.kuaipan.android.http.KscHttpRequest.HttpMethod;
import cn.kuaipan.android.http.KscHttpResponse;
import cn.kuaipan.android.http.KscHttpTransmitter;
import cn.kuaipan.android.kss.IKssRequestor;
import cn.kuaipan.android.kss.KssMaster.IRemote;
import cn.kuaipan.android.kss.upload.KssUploadInfo;
import cn.kuaipan.android.kss.upload.UploadFileInfo;
import cn.kuaipan.android.utils.ApiDataHelper;
import cn.kuaipan.android.utils.IObtainable;
import cn.kuaipan.android.utils.JsonUtils;
import com.miui.player.meta.MetaManager;
import com.xiaomi.micloudsdk.request.CloudRequestHelper;
import com.xiaomi.micloudsdk.utils.CloudUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import miui.net.CloudCoder;
import miui.net.CloudManager;
import miui.net.ExtendedAuthToken;
import miui.net.exception.MiCloudServerException;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MiCloudRequestor<T extends IRemote> implements IKssRequestor<T> {
    private static final String COM_XIAOMI = "com.xiaomi";
    public static final String JSON_TAG_DATA = "data";
    public static final String JSON_TAG_SIGNATURE = "signature";
    private static final String TAG = "MiCloudRequestor";
    protected Account mAccount;
    private Context mContext;
    protected ExtendedAuthToken mExtToken;
    private final KscHttpTransmitter mTransmitter;

    public class ApiConfig {
        public final HttpMethod method;
        private Uri uri;

        public ApiConfig(HttpMethod method, String uri) throws MiCloudServerException {
            this.method = method;
            this.uri = Uri.parse(CloudUtils.updateRequestHost(uri));
        }

        Uri getUri() {
            return this.uri;
        }

        public List<NameValuePair> filterQuerys(Map<String, ? extends Object> params, String postData, KscHttpRequest request) throws KscException, InterruptedException {
            Collection result = new ArrayList();
            if (!(params == null || params.isEmpty())) {
                for (String key : params.keySet()) {
                    result.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
                }
            }
            if (postData != null) {
                try {
                    String value = postData.toString();
                    if (MiCloudRequestor.this.mExtToken != null) {
                        value = MiCloudRequestor.encodeData(MiCloudRequestor.this.mExtToken.security, value);
                    }
                    result.add(new BasicNameValuePair("data", value));
                } catch (IllegalBlockSizeException e) {
                    throw KscException.newException(e, "filterQuerys failed.");
                } catch (BadPaddingException e2) {
                    e2.printStackTrace();
                    throw KscException.newException(e2, "filterQuerys failed.");
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    throw KscException.newException(e3, "filterQuerys failed.");
                }
            }
            Header cookies = null;
            if (!(MiCloudRequestor.this.mAccount == null || MiCloudRequestor.this.mExtToken == null)) {
                result.add(new BasicNameValuePair("signature", MiCloudRequestor.getSignature(this.method, this.uri.toString(), result, MiCloudRequestor.this.mExtToken.security)));
                cookies = MiCloudRequestor.getCookies(MiCloudRequestor.this.mAccount, MiCloudRequestor.this.mExtToken);
            }
            if (HttpMethod.GET == this.method) {
                request.appendQueryParameters(result);
            } else {
                request.appendPostParameters(result);
            }
            request.getRequest().setHeader(cookies);
            return result;
        }
    }

    protected abstract String getCommitUploadPostString(T t, KssUploadInfo kssUploadInfo) throws JSONException;

    protected abstract String getCommitUploadURL(T t, KssUploadInfo kssUploadInfo);

    protected abstract String getRequestDownloadURL(T t);

    protected abstract String getRequestUploadPostString(T t, UploadFileInfo uploadFileInfo) throws JSONException;

    protected abstract String getRequestUploadURL(T t);

    protected abstract JSONObject handleCommitUploadResult(JSONObject jSONObject, T t) throws JSONException;

    protected abstract JSONObject handleRequestDownloadResultJson(JSONObject jSONObject, T t) throws JSONException;

    protected abstract JSONObject handleRequestUploadResultJson(JSONObject jSONObject, T t) throws JSONException;

    public MiCloudRequestor(Context context, Account account, ExtendedAuthToken extToken) {
        this.mTransmitter = new KscHttpTransmitter(context);
        this.mTransmitter.setUserAgent(2, getUserAgent());
        this.mAccount = account;
        this.mExtToken = extToken;
        this.mContext = context;
    }

    private static String getUserAgent() {
        return CloudManager.getUserAgent();
    }

    public MiCloudUploadRequestResult requestUpload(File localFile, T remoteInfo, UploadFileInfo fileInfo) throws KscException, InterruptedException, MiCloudServerException {
        String requestUploadUrl = getRequestUploadURL(remoteInfo);
        if (TextUtils.isEmpty(requestUploadUrl)) {
            throw new KscException((int) ErrorCode.INVALID_DATA, "requestUploadUrl is null or empty.");
        }
        try {
            JSONObject resultJson = exec(new ApiConfig(HttpMethod.POST, requestUploadUrl), getRequestUploadParams(remoteInfo, fileInfo), getRequestUploadPostString(remoteInfo, fileInfo));
            JSONObject kssJson = handleRequestUploadResultJson(resultJson, remoteInfo);
            if (kssJson != null && kssJson.length() > 0) {
                return (MiCloudUploadRequestResult) ApiDataHelper.parser(resultJson, contentKssJsonToMap(kssJson), MiCloudUploadRequestResult.class, new String[0]);
            }
            throw new KscException((int) ErrorCode.INVALID_DATA, "kssJson is null or empty, result:" + resultJson.toString());
        } catch (JSONException e) {
            throw KscException.newException(e, "requestUpload failed.");
        }
    }

    protected HashMap<String, String> getRequestUploadParams(T t, UploadFileInfo fileInfo) throws KscException, InterruptedException {
        return null;
    }

    public void commitUpload(File localFile, T remoteInfo, KssUploadInfo uploadInfo) throws KscException, InterruptedException, MiCloudServerException {
        if (uploadInfo == null) {
            Log.e(TAG, "UploadResult is null.");
            return;
        }
        String commitUrl = getCommitUploadURL(remoteInfo, uploadInfo);
        if (TextUtils.isEmpty(commitUrl)) {
            throw new KscException((int) ErrorCode.INVALID_DATA, "commitUrl is null or empty.");
        }
        ApiConfig commitRequestConfig = new ApiConfig(HttpMethod.POST, commitUrl);
        HashMap<String, String> params = getCommitUploadParams(remoteInfo, uploadInfo);
        try {
            JSONObject resultJson = exec(commitRequestConfig, params, getCommitUploadPostString(remoteInfo, uploadInfo));
            JSONObject kssJson = handleCommitUploadResult(resultJson, remoteInfo);
            if (kssJson == null || kssJson.length() <= 0) {
                throw new KscException((int) ErrorCode.INVALID_DATA, "kssJson is null or empty, result:" + resultJson.toString());
            }
            MiCloudCommitResult result = (MiCloudCommitResult) ApiDataHelper.parser(resultJson, contentKssJsonToMap(kssJson), MiCloudCommitResult.class, new String[0]);
            if (!"OK".equalsIgnoreCase(result.stat)) {
                if (requestUpload(localFile, (IRemote) remoteInfo, uploadInfo.getFileInfo()).getStatus() != 1) {
                    throw new ServerMsgException(200, result.stat);
                }
            }
        } catch (JSONException e) {
            throw KscException.newException(e, "commitUpload failed.");
        }
    }

    protected HashMap<String, String> getCommitUploadParams(T t, KssUploadInfo uploadInfo) throws KscException, InterruptedException {
        return null;
    }

    public MiCloudDownloadRequestResult requestDownload(T remoteInfo) throws KscException, InterruptedException, MiCloudServerException {
        String requestDownloadUrl = getRequestDownloadURL(remoteInfo);
        if (TextUtils.isEmpty(requestDownloadUrl)) {
            throw new KscException((int) ErrorCode.INVALID_DATA, "requestDownloadUrl is null or empty.");
        }
        JSONObject resultJson = exec(new ApiConfig(HttpMethod.GET, requestDownloadUrl), getRequestDownloadParams(remoteInfo), getRequestDownloadPostString(remoteInfo));
        try {
            JSONObject kssJson = handleRequestDownloadResultJson(resultJson, remoteInfo);
            if (kssJson != null && kssJson.length() > 0) {
                return (MiCloudDownloadRequestResult) ApiDataHelper.parser(resultJson, contentKssJsonToMap(kssJson), MiCloudDownloadRequestResult.class, new String[0]);
            }
            throw new KscException((int) ErrorCode.INVALID_DATA, "kssJson is null or empty, result:" + resultJson.toString());
        } catch (JSONException e) {
            throw KscException.newException(e, "handleRequestDownloadResultJson failed.");
        }
    }

    protected HashMap<String, String> getRequestDownloadParams(T t) throws KscException, InterruptedException {
        return null;
    }

    protected String getRequestDownloadPostString(T t) {
        return null;
    }

    private JSONObject exec(ApiConfig config, Map<String, String> params, String postData) throws KscException, InterruptedException, MiCloudServerException {
        KscHttpResponse response = null;
        try {
            response = execute(config, params, postData, 0);
            ErrorHelper.throwError(response);
            verify(response, false);
            InputStream in = response.getContent();
            if (in == null) {
                throw new KscException((int) ErrorCode.DATA_IS_NOT_JSON, response.dump());
            }
            JSONObject resultJson = getResultJSON(in, this.mExtToken.security);
            if (null != null && (null instanceof IObtainable)) {
                ((IObtainable) null).recycle();
            }
            try {
                response.release();
            } catch (Throwable th) {
            }
            return resultJson;
        } catch (IllegalStateException e) {
            throw KscException.newException(e, "exec failed.");
        } catch (IOException e2) {
            throw KscException.newException(e2, "exec failed.");
        } catch (BadPaddingException e3) {
            throw KscException.newException(e3, "exec failed.");
        } catch (IllegalBlockSizeException e4) {
            throw KscException.newException(e4, "exec failed.");
        } catch (Throwable th2) {
            if (null != null && (null instanceof IObtainable)) {
                ((IObtainable) null).recycle();
            }
            try {
                response.release();
            } catch (Throwable th3) {
            }
        }
    }

    public static Map<String, Object> contentKssJsonToMap(JSONObject kssJson) throws KscException, InterruptedException {
        try {
            JsonReader reader = new JsonReader(new StringReader(kssJson.toString()));
            Map<String, Object> resultMap = (Map) JsonUtils.parser(reader);
            if (reader.peek() != JsonToken.END_DOCUMENT) {
                throw new JSONException("Document not end of EOF");
            }
            if (resultMap != null) {
                if (!resultMap.isEmpty()) {
                    return resultMap;
                }
            }
            throw new KscException((int) ErrorCode.DATA_TYPE_INVALID, kssJson.toString());
        } catch (IOException e) {
            throw KscException.newException(e, "contentKssJsonToMap failed.");
        } catch (JSONException e2) {
            throw KscException.newException(e2, "contentKssJsonToMap failed.");
        }
    }

    public static JSONObject getResultJSON(InputStream in, String security) throws KscException, InterruptedException {
        try {
            String resultString = decodeData(security, in);
            if (TextUtils.isEmpty(resultString)) {
                return null;
            }
            return new JSONObject(resultString);
        } catch (IllegalBlockSizeException e) {
            throw KscException.newException(e, "getResultJSON failed.");
        } catch (BadPaddingException e2) {
            throw KscException.newException(e2, "getResultJSON failed.");
        } catch (IOException e3) {
            throw KscException.newException(e3, "getResultJSON failed.");
        } catch (JSONException e4) {
            throw KscException.newException(e4, "getResultJSON failed.");
        }
    }

    private void verify(KscHttpResponse response, boolean b) throws ServerException, MiCloudServerException {
        int statusCode = response.getStatusCode();
        if (MiCloudServerException.isMiCloudServerException(statusCode)) {
            throw new MiCloudServerException(statusCode, response.getResponse());
        } else if (statusCode != 200) {
            throw new ServerException(statusCode, response.dump());
        }
    }

    private KscHttpResponse execute(ApiConfig config, Map<String, ? extends Object> params, String postData, int redirectCount) throws KscException, InterruptedException, IllegalBlockSizeException, BadPaddingException, IOException, MiCloudServerException {
        if (config == null) {
            throw new RuntimeException("API Config can not be null");
        }
        KscHttpRequest request = new KscHttpRequest(config.method, config.getUri(), null);
        config.filterQuerys(params, postData, request);
        if (redirectCount > 0) {
            request.getRequest().setHeader(CloudUtils.X_XIAOMI_REDIRECT_COUNT, redirectCount + MetaManager.UNKNOWN_STRING);
        }
        request.getRequest().setHeader(CloudUtils.X_XIAOMI_SUPPORT_REDIRECT, "true");
        KscHttpResponse response = this.mTransmitter.execute(request, 2);
        Log.d(TAG, "execute response status code: " + response.getStatusCode());
        if (response.getStatusCode() != 200) {
            return response;
        }
        String resp = CloudRequestHelper.decodeData(this.mExtToken.security, response.getResponse().getEntity().getContent());
        Log.d(TAG, resp);
        String redirectUrl = CloudUtils.checkRedirect(resp, redirectCount);
        if (TextUtils.isEmpty(redirectUrl)) {
            return response;
        }
        redirectCount++;
        config.uri = Uri.parse(redirectUrl);
        return execute(config, params, postData, redirectCount);
    }

    public static String encodeData(String security, String data) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return Base64.encodeToString(CloudCoder.newAESCipher(security, 1).doFinal(data.getBytes("UTF-8")), 2);
    }

    public static String decodeData(String security, InputStream is) throws IllegalBlockSizeException, BadPaddingException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is), 1024);
        while (true) {
            try {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        }
        try {
            return new String(CloudCoder.newAESCipher(security, 2).doFinal(Base64.decode(builder.toString(), 2)));
        } catch (IllegalArgumentException e2) {
            throw new IOException();
        }
    }

    public static String getSignature(HttpMethod httpMethod, String url, List<NameValuePair> result, String security) throws UnsupportedEncodingException {
        TreeMap<String, String> params = new TreeMap();
        if (result != null) {
            for (NameValuePair pair : result) {
                params.put(pair.getName(), pair.getValue());
            }
        }
        return CloudCoder.generateSignature(httpMethod.name(), url, params, security);
    }

    public static Header getCookies(Account account, ExtendedAuthToken extToken) {
        StringBuilder builder = new StringBuilder();
        builder.append("serviceToken=");
        builder.append(extToken.authToken);
        builder.append("; userId=");
        builder.append(account.name);
        return new BasicHeader("Cookie", builder.toString());
    }
}
