package com.ushareit.listenit;

public final class blm implements blq {
    private final int f6896a;

    public blm() {
        this(0);
    }

    public blm(int i) {
        this.f6896a = i;
    }

    public blo mo1012a(int i, blp com_ushareit_listenit_blp) {
        boolean z = true;
        switch (i) {
            case 2:
                return new bls();
            case 3:
            case 4:
                return new bmb(com_ushareit_listenit_blp.f6908b);
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                if ((this.f6896a & 2) == 0) {
                    return new bll(false, com_ushareit_listenit_blp.f6908b);
                }
                return null;
            case 21:
                return new bma();
            case 27:
                if ((this.f6896a & 4) != 0) {
                    return null;
                }
                boolean z2 = (this.f6896a & 1) != 0;
                if ((this.f6896a & 8) == 0) {
                    z = false;
                }
                return new blu(z2, z);
            case 36:
                return new bly();
            case 129:
            case 135:
                return new bli(com_ushareit_listenit_blp.f6908b);
            case 130:
            case 138:
                return new bln(com_ushareit_listenit_blp.f6908b);
            default:
                return null;
        }
    }
}
