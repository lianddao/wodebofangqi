package com.ushareit.listenit;

public final class doi<L> {
    private final L f10089a;
    private final String f10090b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof doi)) {
            return false;
        }
        doi com_ushareit_listenit_doi = (doi) obj;
        return this.f10089a == com_ushareit_listenit_doi.f10089a && this.f10090b.equals(com_ushareit_listenit_doi.f10090b);
    }

    public int hashCode() {
        return (System.identityHashCode(this.f10089a) * 31) + this.f10090b.hashCode();
    }
}
