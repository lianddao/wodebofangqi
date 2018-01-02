package com.ushareit.listenit;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class it extends SingleLineTransformationMethod {
    private Locale f15597a;

    public it(Context context) {
        this.f15597a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        return transformation != null ? transformation.toString().toUpperCase(this.f15597a) : null;
    }
}
