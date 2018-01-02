package com.ushareit.listenit;

public enum anx {
    UNKNOWN(9000, "An unknown error has occurred."),
    DATABASE_SELECT(3001, "Failed to read from database."),
    DATABASE_INSERT(3002, "Failed to insert row into database."),
    DATABASE_UPDATE(3003, "Failed to update row in database."),
    DATABASE_DELETE(3004, "Failed to delete row from database.");
    
    private final int f5008f;
    private final String f5009g;

    private anx(int i, String str) {
        this.f5008f = i;
        this.f5009g = str;
    }

    public int m6434a() {
        return this.f5008f;
    }

    public String m6435b() {
        return this.f5009g;
    }
}
