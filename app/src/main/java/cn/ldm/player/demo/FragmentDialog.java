package cn.ldm.player.demo;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.ldm.player.R;

public class FragmentDialog extends Activity {
    int mStackLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dialog);
        View tv = findViewById(R.id.text);
        ((TextView) tv).setText("Example of displaying dialogs with a DialogFragment.  "
                + "Press the show button below to see the first dialog; pressing "
                + "successive show buttons will display other dialog styles as a "
                + "stack, with dismissing or back going to the previous dialog.");
        // Watch for button clicks.
        Button button = (Button) findViewById(R.id.show);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog();
            }
        });
        if (savedInstanceState != null) {
            mStackLevel = savedInstanceState.getInt("level");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("level", mStackLevel);
    }

    //BEGIN_INCLUDE(add_dialog)
    void showDialog() {
        mStackLevel++;
        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        // Create and show the dialog.
        DialogFragment newFragment = MyDialogFragment.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }

    //END_INCLUDE(add_dialog)
    static String getNameForNum(int num) {
        switch ((num - 1) % 6) {
            case 1:
                return "STYLE_NO_TITLE";
            case 2:
                return "STYLE_NO_FRAME";
            case 3:
                return "STYLE_NO_INPUT (this window can't receive input, so "
                        + "you will need to press the bottom show button)";
            case 4:
                return "STYLE_NORMAL with light fullscreen theme";
            case 5:
                return "STYLE_NORMAL with dark fullscreen theme";
        }
        return "STYLE_NORMAL";
    }

    //BEGIN_INCLUDE(dialog)
    public static class MyDialogFragment extends DialogFragment {
        int mNum;

        /**
         * Create a new instance of MyDialogFragment, providing "num"
         * as an argument.
         */
        public static MyDialogFragment newInstance(int num) {
            MyDialogFragment f = new MyDialogFragment();
            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments().getInt("num");
            // Pick a style based on the num.
            int style = DialogFragment.STYLE_NORMAL, theme = 0;
            switch ((mNum - 1) % 6) {
                case 1:
                    style = DialogFragment.STYLE_NO_TITLE;
                    break;
                case 2:
                    style = DialogFragment.STYLE_NO_FRAME;
                    break;
                case 3:
                    style = DialogFragment.STYLE_NO_INPUT;
                    break;
                case 4:
                    style = DialogFragment.STYLE_NORMAL;
                    break;
                case 5:
                    style = DialogFragment.STYLE_NORMAL;
                    break;
            }
            switch ((mNum - 1) % 6) {
                case 4:
                    theme = android.R.style.Theme_Light;
                    break;
                case 5:
                    theme = android.R.style.Theme;
                    break;
            }
            setStyle(style, theme);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_dialog, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView) tv).setText("Dialog #" + mNum + ": using style "
                    + getNameForNum(mNum));
            // Watch for button clicks.
            Button button = (Button) v.findViewById(R.id.show);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // When button is clicked, call up to owning activity.
                    ((FragmentDialog) getActivity()).showDialog();
                }
            });
            return v;
        }
    }
    //END_INCLUDE(dialog)
}