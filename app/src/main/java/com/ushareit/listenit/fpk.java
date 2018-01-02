package com.ushareit.listenit;

import com.umeng.analytics.pro.C0277j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fpk extends fpm {
    private static int[] f13183r = new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, C0277j.f3691b, 192, 224, C0277j.f3694e, 320, 0};
    private static int[] f13184s = new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, C0277j.f3691b, 0};
    private static int[] f13185t = new int[]{44100, 48000, 32000, 0};
    private static int[] f13186u = new int[]{22050, 24000, 16000, 0};
    private int f13187a;
    private int[] f13188b;
    private int[] f13189h;
    private int[] f13190i;
    private int f13191j;
    private int f13192k;
    private int f13193l;
    private int f13194m;
    private int f13195n;
    private int f13196o;
    private int f13197p;
    private int f13198q;

    public static fpn m20303a() {
        return new fpl();
    }

    public int mo2515b() {
        return this.f13187a;
    }

    public int mo2516c() {
        return 1152;
    }

    public int[] mo2517d() {
        return this.f13190i;
    }

    public int mo2518e() {
        return this.f13192k;
    }

    public int mo2519f() {
        return this.f13193l;
    }

    public String mo2520g() {
        return "MP3";
    }

    public void mo2513a(File file) {
        super.mo2513a(file);
        this.f13187a = 0;
        this.f13195n = 64;
        this.f13188b = new int[this.f13195n];
        this.f13189h = new int[this.f13195n];
        this.f13190i = new int[this.f13195n];
        this.f13196o = 0;
        this.f13197p = 255;
        this.f13198q = 0;
        this.f13191j = (int) this.g.length();
        FileInputStream fileInputStream = new FileInputStream(this.g);
        int i = 0;
        int i2 = 0;
        byte[] bArr = new byte[12];
        while (i < this.f13191j - 12) {
            for (i2 = 
/*
Method generation error in method: com.ushareit.listenit.fpk.a(java.io.File):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0_16 'i2' int) = (r0_15 'i2' int), (r0_99 'i2' int) binds: {(r0_15 'i2' int)=B:0:0x0000, (r0_99 'i2' int)=B:79:0x003c} in method: com.ushareit.listenit.fpk.a(java.io.File):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 20 more

*/

            public void mo2514a(File file, int i, int i2) {
                int i3;
                file.createNewFile();
                FileInputStream fileInputStream = new FileInputStream(this.g);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                int i4 = 0;
                for (i3 = 0; i3 < i2; i3++) {
                    if (this.f13189h[i + i3] > i4) {
                        i4 = this.f13189h[i + i3];
                    }
                }
                byte[] bArr = new byte[i4];
                i3 = 0;
                i4 = 0;
                while (i3 < i2) {
                    int i5 = this.f13188b[i + i3] - i4;
                    int i6 = this.f13189h[i + i3];
                    if (i5 > 0) {
                        fileInputStream.skip((long) i5);
                        i4 += i5;
                    }
                    fileInputStream.read(bArr, 0, i6);
                    fileOutputStream.write(bArr, 0, i6);
                    i3++;
                    i4 += i6;
                }
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
