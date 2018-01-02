package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;
import com.ushareit.listenit.widget.LineEditView;

class gge {
    gge() {
    }

    boolean m21921a(String str, TextView textView, LineEditView lineEditView) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(C0349R.string.email_error_info_email_validator_1);
            lineEditView.setErrorState(true);
            return false;
        } else if (m21917b(str)) {
            textView.setVisibility(4);
            textView.setText("");
            lineEditView.setErrorState(false);
            return true;
        } else {
            textView.setVisibility(0);
            textView.setText(C0349R.string.email_error_info_email_validator_2);
            lineEditView.setErrorState(true);
            return false;
        }
    }

    private boolean m21917b(String str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    boolean m21920a(String str, TextView textView) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(C0349R.string.email_error_info_password_validator_1);
            return false;
        } else if (m21918c(str)) {
            textView.setVisibility(4);
            textView.setText("");
            return true;
        } else {
            textView.setVisibility(0);
            textView.setText(eys.m18562a().getResources().getString(C0349R.string.email_error_info_password_validator_2, new Object[]{Integer.valueOf(6)}));
            return false;
        }
    }

    boolean m21922b(String str, TextView textView) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(C0349R.string.email_error_info_password_validator_1);
            return false;
        } else if (m21918c(str)) {
            textView.setVisibility(4);
            textView.setText("");
            return true;
        } else {
            textView.setVisibility(0);
            textView.setText(C0349R.string.email_error_info_password_validator_3);
            return false;
        }
    }

    private boolean m21918c(String str) {
        boolean z;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (Character.isLetter(str.charAt(i3))) {
                i2++;
            }
            if (Character.isDigit(str.charAt(i3))) {
                i++;
            }
        }
        if (i == 0 || i2 == 0) {
            z = false;
        } else {
            z = true;
        }
        if (i + i2 < str.length()) {
            z = false;
        }
        if (str.length() < 6) {
            return false;
        }
        return z;
    }

    boolean m21919a(String str) {
        return !TextUtils.isEmpty(str);
    }
}
