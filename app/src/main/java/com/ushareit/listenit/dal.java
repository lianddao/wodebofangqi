package com.ushareit.listenit;

import java.lang.reflect.Field;
import java.util.Locale;

enum dal extends dah {
    dal(String str, int i) {
        super(str, i);
    }

    public String mo1701a(Field field) {
        return dah.m13638b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
}
