package com.ushareit.listenit;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class ckj<T> extends ckh {
    private final T f8384a;

    private ckj(T t) {
        this.f8384a = t;
    }

    public static <T> ckg m11512a(T t) {
        return new ckj(t);
    }

    public static <T> T m11513a(ckg com_ushareit_listenit_ckg) {
        if (com_ushareit_listenit_ckg instanceof ckj) {
            return ((ckj) com_ushareit_listenit_ckg).f8384a;
        }
        IBinder asBinder = com_ushareit_listenit_ckg.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
        throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
    }
}
