package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class auj {
    private static final String f5504a = auj.class.getName();
    private static final Object f5505b = new Object();

    public static apl m7198a(Exception exception, Context context) {
        apl com_ushareit_listenit_apl = new apl(aop.m6484b(), aop.m6485c(), new aui(ate.m7118a(exception), aor.f5091f, true));
        m7201a(com_ushareit_listenit_apl, context);
        return com_ushareit_listenit_apl;
    }

    public static JSONArray m7199a(Context context) {
        FileInputStream openFileInput;
        InputStreamReader inputStreamReader;
        Throwable e;
        InputStreamReader inputStreamReader2;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        JSONArray jSONArray = new JSONArray();
        synchronized (f5505b) {
            BufferedReader bufferedReader2;
            try {
                if (new File(context.getFilesDir(), "crasheslog").exists()) {
                    openFileInput = context.openFileInput("crasheslog");
                    try {
                        inputStreamReader = new InputStreamReader(openFileInput);
                        try {
                            bufferedReader2 = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    jSONArray.put(new JSONObject(readLine));
                                } catch (Exception e2) {
                                    e = e2;
                                    inputStreamReader2 = inputStreamReader;
                                    fileInputStream = openFileInput;
                                } catch (Throwable th) {
                                    e = th;
                                    bufferedReader = bufferedReader2;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader2 = null;
                            inputStreamReader2 = inputStreamReader;
                            fileInputStream = openFileInput;
                            try {
                                Log.e(f5504a, "Failed to read crashes", e);
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (Throwable e4) {
                                        Log.e(f5504a, "Failed to close buffers", e4);
                                    }
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return jSONArray;
                            } catch (Throwable th2) {
                                e4 = th2;
                                openFileInput = fileInputStream;
                                inputStreamReader = inputStreamReader2;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e5) {
                                        Log.e(f5504a, "Failed to close buffers", e5);
                                        throw e4;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (openFileInput != null) {
                                    openFileInput.close();
                                }
                                throw e4;
                            }
                        } catch (Throwable th3) {
                            e4 = th3;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (openFileInput != null) {
                                openFileInput.close();
                            }
                            throw e4;
                        }
                    } catch (Exception e6) {
                        e4 = e6;
                        bufferedReader2 = null;
                        fileInputStream = openFileInput;
                        Log.e(f5504a, "Failed to read crashes", e4);
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return jSONArray;
                    } catch (Throwable th4) {
                        e4 = th4;
                        inputStreamReader = null;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (openFileInput != null) {
                            openFileInput.close();
                        }
                        throw e4;
                    }
                }
                bufferedReader2 = null;
                inputStreamReader = null;
                openFileInput = null;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable e42) {
                        Log.e(f5504a, "Failed to close buffers", e42);
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
            } catch (Exception e7) {
                e42 = e7;
                bufferedReader2 = null;
                fileInputStream = null;
                Log.e(f5504a, "Failed to read crashes", e42);
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return jSONArray;
            } catch (Throwable th5) {
                e42 = th5;
                inputStreamReader = null;
                openFileInput = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
                throw e42;
            }
        }
        return jSONArray;
    }

    private static JSONObject m7200a(apl com_ushareit_listenit_apl) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", UUID.randomUUID().toString());
        jSONObject.put(VastExtensionXmlManager.TYPE, com_ushareit_listenit_apl.mo738b());
        jSONObject.put("time", atz.m7158a(com_ushareit_listenit_apl.m6495e()));
        jSONObject.put("session_time", atz.m7158a(com_ushareit_listenit_apl.m6496f()));
        jSONObject.put("session_id", com_ushareit_listenit_apl.m6497g());
        jSONObject.put("data", com_ushareit_listenit_apl.m6498h() != null ? new JSONObject(com_ushareit_listenit_apl.m6498h()) : new JSONObject());
        return jSONObject;
    }

    public static void m7201a(apl com_ushareit_listenit_apl, Context context) {
        if (com_ushareit_listenit_apl != null && context != null) {
            synchronized (f5505b) {
                try {
                    JSONObject a = m7200a(com_ushareit_listenit_apl);
                    FileOutputStream openFileOutput = context.openFileOutput("crasheslog", 32768);
                    openFileOutput.write((a.toString() + "\n").getBytes());
                    openFileOutput.close();
                } catch (Throwable e) {
                    Log.e(f5504a, "Failed to store crash", e);
                }
            }
        }
    }

    public static void m7202b(Context context) {
        synchronized (f5505b) {
            File file = new File(context.getFilesDir(), "crasheslog");
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
