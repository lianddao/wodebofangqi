package com.ushareit.listenit.equalizer;

import android.content.Context;
import android.media.AudioManager;
import android.media.audiofx.LoudnessEnhancer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.fuo;
import com.ushareit.listenit.fup;
import com.ushareit.listenit.fuq;
import com.ushareit.listenit.fur;
import com.ushareit.listenit.gvj;

public class VolumeControlView extends LinearLayout {
    private SeekBar f11586a;
    private TextView f11587b;
    private ImageView f11588c;
    private View f11589d;
    private AudioManager f11590e;
    private LoudnessEnhancer f11591f;
    private fur f11592g;
    private fuq f11593h;
    private OnClickListener f11594i;
    private OnClickListener f11595j = new fuo(this);
    private OnSeekBarChangeListener f11596k = new fup(this);

    private boolean m17538b(int r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:10:0x0047 in [B:7:0x003d, B:10:0x0047, B:11:0x0048]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:64)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = 0;
        r5 = 3;
        r1 = r6.f11590e;
        r2 = r1.getStreamVolume(r5);
        r1 = r6.f11590e;	 Catch:{ Exception -> 0x0021, all -> 0x0034 }
        r3 = 3;	 Catch:{ Exception -> 0x0021, all -> 0x0034 }
        r4 = 0;	 Catch:{ Exception -> 0x0021, all -> 0x0034 }
        r1.adjustStreamVolume(r3, r7, r4);	 Catch:{ Exception -> 0x0021, all -> 0x0034 }
        r1 = r6.f11590e;
        r1 = r1.getStreamVolume(r5);
        if (r2 != r1) goto L_0x0048;
    L_0x0017:
        r1 = r6.f11593h;
        if (r1 == 0) goto L_0x0020;
    L_0x001b:
        r1 = r6.f11593h;
        r1.mo2602a();
    L_0x0020:
        return r0;
    L_0x0021:
        r1 = move-exception;
        r1 = r6.f11590e;
        r1 = r1.getStreamVolume(r5);
        if (r2 != r1) goto L_0x0048;
    L_0x002a:
        r1 = r6.f11593h;
        if (r1 == 0) goto L_0x0020;
    L_0x002e:
        r1 = r6.f11593h;
        r1.mo2602a();
        goto L_0x0020;
    L_0x0034:
        r1 = move-exception;
        r3 = r6.f11590e;
        r3 = r3.getStreamVolume(r5);
        if (r2 != r3) goto L_0x0047;
    L_0x003d:
        r1 = r6.f11593h;
        if (r1 == 0) goto L_0x0020;
    L_0x0041:
        r1 = r6.f11593h;
        r1.mo2602a();
        goto L_0x0020;
    L_0x0047:
        throw r1;
    L_0x0048:
        r0 = com.ushareit.listenit.eys.m18562a();
        com.ushareit.listenit.fii.m19309c(r0);
        r0 = 1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.equalizer.VolumeControlView.b(int):boolean");
    }

    private boolean m17540c(int r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:12:0x004e in [B:8:0x0043, B:12:0x004e, B:13:0x004f]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:64)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r6 = 3;
        r2 = r7.f11590e;
        r2 = r2.getStreamVolume(r6);
        if (r8 != r2) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r3 = r7.f11590e;	 Catch:{ Exception -> 0x0026, all -> 0x003a }
        r4 = 3;	 Catch:{ Exception -> 0x0026, all -> 0x003a }
        r5 = 0;	 Catch:{ Exception -> 0x0026, all -> 0x003a }
        r3.setStreamVolume(r4, r8, r5);	 Catch:{ Exception -> 0x0026, all -> 0x003a }
        r3 = r7.f11590e;
        r3 = r3.getStreamVolume(r6);
        if (r2 != r3) goto L_0x004f;
    L_0x001b:
        r0 = r7.f11593h;
        if (r0 == 0) goto L_0x0024;
    L_0x001f:
        r0 = r7.f11593h;
        r0.mo2602a();
    L_0x0024:
        r0 = r1;
        goto L_0x000b;
    L_0x0026:
        r3 = move-exception;
        r3 = r7.f11590e;
        r3 = r3.getStreamVolume(r6);
        if (r2 != r3) goto L_0x004f;
    L_0x002f:
        r0 = r7.f11593h;
        if (r0 == 0) goto L_0x0038;
    L_0x0033:
        r0 = r7.f11593h;
        r0.mo2602a();
    L_0x0038:
        r0 = r1;
        goto L_0x000b;
    L_0x003a:
        r0 = move-exception;
        r3 = r7.f11590e;
        r3 = r3.getStreamVolume(r6);
        if (r2 != r3) goto L_0x004e;
    L_0x0043:
        r0 = r7.f11593h;
        if (r0 == 0) goto L_0x004c;
    L_0x0047:
        r0 = r7.f11593h;
        r0.mo2602a();
    L_0x004c:
        r0 = r1;
        goto L_0x000b;
    L_0x004e:
        throw r0;
    L_0x004f:
        r1 = com.ushareit.listenit.eys.m18562a();
        com.ushareit.listenit.fii.m19309c(r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.equalizer.VolumeControlView.c(int):boolean");
    }

    public VolumeControlView(Context context, LoudnessEnhancer loudnessEnhancer) {
        super(context);
        m17532a(context, loudnessEnhancer);
    }

    public void setOnVolumeTouchChangedListener(fur com_ushareit_listenit_fur) {
        this.f11592g = com_ushareit_listenit_fur;
    }

    public void setOnAdjustVolumeFailureListener(fuq com_ushareit_listenit_fuq) {
        this.f11593h = com_ushareit_listenit_fuq;
    }

    public void setOnBoosterSwitchClickListener(OnClickListener onClickListener) {
        this.f11594i = onClickListener;
    }

    private void m17532a(Context context, LoudnessEnhancer loudnessEnhancer) {
        View inflate = View.inflate(context, C0349R.layout.volume_control_view, this);
        this.f11586a = (SeekBar) inflate.findViewById(C0349R.id.volume_progress);
        this.f11586a.setOnSeekBarChangeListener(this.f11596k);
        this.f11587b = (TextView) inflate.findViewById(C0349R.id.boost_value);
        this.f11588c = (ImageView) inflate.findViewById(C0349R.id.switch_boost);
        this.f11589d = inflate.findViewById(C0349R.id.boost_area);
        this.f11590e = (AudioManager) context.getSystemService("audio");
        this.f11586a.setMax(this.f11590e.getStreamMaxVolume(3));
        this.f11586a.setProgress(this.f11590e.getStreamVolume(3));
        this.f11591f = loudnessEnhancer;
        m17542e();
    }

    public boolean m17544a(int i, Context context) {
        switch (i) {
            case 24:
                return m17535a();
            case 25:
                return m17537b();
            default:
                return false;
        }
    }

    private boolean m17535a() {
        boolean z = true;
        if (this.f11590e.getStreamVolume(3) < this.f11590e.getStreamMaxVolume(3)) {
            z = m17538b(1);
        } else {
            m17534a(true);
        }
        m17542e();
        return z;
    }

    private boolean m17537b() {
        int streamVolume = this.f11590e.getStreamVolume(3);
        int streamMaxVolume = this.f11590e.getStreamMaxVolume(3);
        boolean z = true;
        if (getBoosterValue() > 0) {
            m17534a(false);
        } else if (streamVolume == streamMaxVolume) {
            z = m17538b(-1);
        } else {
            z = m17538b(-1);
        }
        m17542e();
        return z;
    }

    private void m17531a(int i) {
        if (m17540c(i)) {
            m17541d();
            m17542e();
        }
    }

    private void m17534a(boolean z) {
        int i = 7500;
        if (this.f11591f != null) {
            if (z) {
                try {
                    if (!this.f11591f.getEnabled() && gvj.m22961g()) {
                        m17539c();
                    }
                } catch (Throwable th) {
                    return;
                }
            }
            int targetGain = (int) (((float) (z ? 750 : -750)) + this.f11591f.getTargetGain());
            if (targetGain < 0) {
                targetGain = 0;
            }
            if (targetGain <= 7500) {
                i = targetGain;
            }
            this.f11591f.setTargetGain(i);
            if (!z && this.f11591f.getEnabled() && this.f11591f.getTargetGain() == 0.0f) {
                m17541d();
            }
            fii.m19314d(eys.m18562a());
        }
    }

    private void m17539c() {
        try {
            if (this.f11591f != null && !this.f11591f.getEnabled()) {
                this.f11591f.setEnabled(true);
                this.f11591f.setTargetGain(0);
            }
        } catch (Throwable th) {
        }
    }

    private void m17541d() {
        try {
            if (this.f11591f != null && this.f11591f.getEnabled()) {
                this.f11591f.setTargetGain(0);
                this.f11591f.setEnabled(false);
                if (!gvj.m22969h()) {
                    gvj.m22925c(false);
                }
            }
        } catch (Throwable th) {
        }
    }

    private int getBoosterValue() {
        try {
            if (this.f11591f != null && this.f11591f.getEnabled()) {
                return (int) this.f11591f.getTargetGain();
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    private void m17542e() {
        int streamVolume = this.f11590e.getStreamVolume(3);
        this.f11590e.getStreamMaxVolume(3);
        if (this.f11586a.getProgress() != streamVolume) {
            this.f11586a.setProgress(streamVolume);
        }
        m17543f();
    }

    private void m17543f() {
        if (this.f11591f == null) {
            this.f11589d.setVisibility(8);
            return;
        }
        this.f11589d.setVisibility(0);
        int streamVolume = this.f11590e.getStreamVolume(3);
        int streamMaxVolume = this.f11590e.getStreamMaxVolume(3);
        int boosterValue = getBoosterValue();
        if (streamVolume < streamMaxVolume) {
            this.f11587b.setVisibility(4);
            this.f11588c.setVisibility(0);
            this.f11588c.setImageResource(C0349R.drawable.boost_normal);
            this.f11589d.setOnClickListener(null);
        } else if (streamVolume == streamMaxVolume && boosterValue == 0) {
            this.f11587b.setVisibility(4);
            this.f11588c.setVisibility(0);
            this.f11588c.setImageResource(C0349R.drawable.boost_selected);
            this.f11589d.setOnClickListener(this.f11595j);
        } else {
            this.f11587b.setVisibility(0);
            this.f11588c.setVisibility(4);
            this.f11589d.setOnClickListener(null);
            this.f11587b.setText("+" + ((boosterValue * 100) / 7500) + "%");
        }
    }
}
