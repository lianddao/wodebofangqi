package com.miui.micloud;

import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.kss.IDataFactory;
import cn.kuaipan.android.kss.IKssUploadRequestResult;

public class MiCloudDataFactory implements IDataFactory {
    public IKssUploadRequestResult createUploadRequestResult(String requestStr) throws KscException {
        return MiCloudUploadRequestResult.create(requestStr);
    }
}
