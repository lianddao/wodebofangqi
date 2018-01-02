package com.xiaomi.music.cloud;

import android.accounts.Account;
import com.xiaomi.music.Result;
import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.json.JSONException;

public abstract class CloudCommand<T> {
    protected final Account mAccount;
    protected final MusicAuthToken mToken;

    public abstract Result<T> execute() throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException;

    public CloudCommand(Account account, MusicAuthToken token) {
        this.mAccount = account;
        this.mToken = token;
    }

    public Result<T> createError(int err) {
        return Result.create(err);
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public MusicAuthToken getToken() {
        return this.mToken;
    }
}
