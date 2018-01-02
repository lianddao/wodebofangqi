package com.ushareit.listenit;

import java.math.BigDecimal;

class dxq {
    final int f10587a;
    BigDecimal f10588b;
    BigDecimal f10589c;
    BigDecimal f10590d;
    final boolean f10591e;

    public dxq(dri com_ushareit_listenit_dri) {
        cfi.m11080a((Object) com_ushareit_listenit_dri);
        boolean z = true;
        if (com_ushareit_listenit_dri.f10193a == null || com_ushareit_listenit_dri.f10193a.intValue() == 0) {
            z = false;
        } else if (com_ushareit_listenit_dri.f10193a.intValue() != 4) {
            if (com_ushareit_listenit_dri.f10195c == null) {
                z = false;
            }
        } else if (com_ushareit_listenit_dri.f10196d == null || com_ushareit_listenit_dri.f10197e == null) {
            z = false;
        }
        if (z) {
            this.f10587a = com_ushareit_listenit_dri.f10193a.intValue();
            if (com_ushareit_listenit_dri.f10193a.intValue() == 4) {
                if (!(dwk.m15940n(com_ushareit_listenit_dri.f10196d) && dwk.m15940n(com_ushareit_listenit_dri.f10197e))) {
                    z = false;
                }
                try {
                    this.f10589c = new BigDecimal(com_ushareit_listenit_dri.f10196d);
                    this.f10590d = new BigDecimal(com_ushareit_listenit_dri.f10197e);
                } catch (NumberFormatException e) {
                    z = false;
                }
            } else {
                if (!dwk.m15940n(com_ushareit_listenit_dri.f10195c)) {
                    z = false;
                }
                try {
                    this.f10588b = new BigDecimal(com_ushareit_listenit_dri.f10195c);
                } catch (NumberFormatException e2) {
                    z = false;
                }
            }
        } else {
            this.f10587a = 0;
        }
        this.f10591e = z;
    }

    private Boolean m16301a(BigDecimal bigDecimal) {
        boolean z = true;
        if (!this.f10591e) {
            return null;
        }
        if (bigDecimal == null) {
            return null;
        }
        switch (this.f10587a) {
            case 1:
                if (bigDecimal.compareTo(this.f10588b) != -1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (bigDecimal.compareTo(this.f10588b) != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (bigDecimal.compareTo(this.f10588b) != 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                if (bigDecimal.compareTo(this.f10589c) == -1 || bigDecimal.compareTo(this.f10590d) == 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean m16302a(double d) {
        boolean z = true;
        if (!this.f10591e) {
            return null;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(d);
            switch (this.f10587a) {
                case 1:
                    if (bigDecimal.compareTo(this.f10588b) != -1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 2:
                    if (bigDecimal.compareTo(this.f10588b) != 1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 3:
                    if (!(bigDecimal.compareTo(this.f10588b.subtract(new BigDecimal(Math.ulp(d)).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(this.f10588b.add(new BigDecimal(Math.ulp(d)).multiply(new BigDecimal(2)))) == -1)) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 4:
                    if (bigDecimal.compareTo(this.f10589c) == -1 || bigDecimal.compareTo(this.f10590d) == 1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean m16303a(long j) {
        try {
            return m16301a(new BigDecimal(j));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean m16304a(String str) {
        Boolean bool = null;
        if (dwk.m15940n(str)) {
            try {
                bool = m16301a(new BigDecimal(str));
            } catch (NumberFormatException e) {
            }
        }
        return bool;
    }
}
