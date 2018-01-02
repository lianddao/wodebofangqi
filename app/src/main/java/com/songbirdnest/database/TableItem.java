package com.songbirdnest.database;

public class TableItem implements TableEntry {
    protected Table table;
    protected String tableName;

    public TableItem(Table table, String tableName) {
        this.table = table;
        this.tableName = tableName;
    }

    public Table getTable() {
        return this.table;
    }

    public String getName() {
        return this.tableName;
    }
}
