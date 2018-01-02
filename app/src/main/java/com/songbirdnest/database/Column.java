package com.songbirdnest.database;

public class Column {
    protected int column_position;
    protected boolean key = false;
    protected String name;
    protected boolean notNull = false;
    protected COLUMN_TYPE type;
    protected boolean unique = false;

    public enum COLUMN_TYPE {
        INTEGER,
        LONG,
        TEXT,
        FLOAT,
        BOOLEAN,
        TIMESTAMP,
        BLOB
    }

    public Column(String name, COLUMN_TYPE type) {
        this.name = name;
        this.type = type;
    }

    public Column(String name, COLUMN_TYPE type, boolean key) {
        this.key = key;
        this.name = name;
        this.type = type;
    }

    public boolean isKey() {
        return this.key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public boolean isNotNull() {
        return this.notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean isUnique() {
        return this.unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public COLUMN_TYPE getType() {
        return this.type;
    }

    public void setType(COLUMN_TYPE type) {
        this.type = type;
    }

    public String getCreateString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(" ").append(this.type.toString()).append(" ");
        if (this.key) {
            builder.append(" PRIMARY KEY AUTOINCREMENT ");
        }
        if (this.notNull) {
            builder.append(" NOT NULL ");
        }
        if (this.unique) {
            builder.append(" UNIQUE ");
        }
        return builder.toString();
    }

    public int getColumnPosition() {
        return this.column_position;
    }

    public void setColumnPosition(int column_position) {
        this.column_position = column_position;
    }
}
