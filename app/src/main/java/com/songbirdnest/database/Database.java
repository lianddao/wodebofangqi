package com.songbirdnest.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class Database {
    protected SQLiteDatabase database;
    protected List<Table> tables = new ArrayList();

    public Database(SQLiteDatabase database) {
        this.database = database;
    }

    public List<Table> getTables() {
        return this.tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Table getTableByName(String tableName) {
        for (Table table : this.tables) {
            if (tableName.equalsIgnoreCase(table.getTableName())) {
                return table;
            }
        }
        return null;
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public Table getTable(String name) {
        for (Table table : this.tables) {
            if (table.getTableName().equalsIgnoreCase(name)) {
                return table;
            }
        }
        return null;
    }

    public void createDatabase() {
        try {
            for (Table table : this.tables) {
                this.database.execSQL(table.getCreateTableString());
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void dropDatabase() {
        try {
            for (Table table : this.tables) {
                this.database.execSQL("DROP TABLE IF EXISTS " + table.getTableName());
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void execSQL(String sql) {
        try {
            this.database.execSQL(sql);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public Object insertTableEntry(Table table, Object data) {
        return table.insertEntry(this, data);
    }

    public void deleteTableEntry(Table table, Object data) {
        table.deleteEntry(this, data);
    }

    public Object updateTableEntry(Table table, Object data, Object key) {
        return table.updateEntry(this, data, key);
    }

    public Object getTableEntry(Table table, Object data) {
        return table.getEntry(this, data);
    }

    public Object getAllTableEntries(Table table) {
        return table.getAllEntries(this);
    }
}
