package com.ushareit.listenit;

import android.os.IInterface;
import com.google.firebase.database.connection.idl.ConnectionConfig;
import java.util.List;

public interface edx extends IInterface {
    void compareAndPut(List<String> list, ckg com_ushareit_listenit_ckg, String str, eed com_ushareit_listenit_eed);

    void initialize();

    void interrupt(String str);

    boolean isInterrupted(String str);

    void listen(List<String> list, ckg com_ushareit_listenit_ckg, edu com_ushareit_listenit_edu, long j, eed com_ushareit_listenit_eed);

    void merge(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed);

    void onDisconnectCancel(List<String> list, eed com_ushareit_listenit_eed);

    void onDisconnectMerge(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed);

    void onDisconnectPut(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed);

    void purgeOutstandingWrites();

    void put(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed);

    void refreshAuthToken();

    void refreshAuthToken2(String str);

    void resume(String str);

    void setup(ConnectionConfig connectionConfig, edo com_ushareit_listenit_edo, ckg com_ushareit_listenit_ckg, eea com_ushareit_listenit_eea);

    void shutdown();

    void unlisten(List<String> list, ckg com_ushareit_listenit_ckg);
}
