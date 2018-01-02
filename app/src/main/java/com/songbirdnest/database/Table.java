package com.songbirdnest.database;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public abstract class Table<T> {
    public static final String ID = "_id";
    protected List<Column> columns = new ArrayList();
    protected String idField = "_id";
    protected String[] projection;
    protected String tableName;
    protected int version = 1;

    public static class ContentValueBuilder {
        ContentValues contentValues;

        public ContentValueBuilder addContentValue(String field, String value) {
            if (this.contentValues == null) {
                this.contentValues = new ContentValues();
            }
            this.contentValues.put(field, value);
            return this;
        }

        public ContentValues build() {
            return this.contentValues;
        }
    }

    public abstract void deleteAllEntries(Database database);

    public abstract void deleteEntry(Database database, Object obj);

    public abstract void deleteEntryWhere(Database database, String str, String[] strArr);

    public abstract Cursor getAllEntries(Database database);

    public abstract List<T> getAllEntries(Database database, Class<T> cls);

    public abstract Cursor getEntry(Database database, long j);

    public abstract Cursor getEntry(Database database, String str, String str2);

    public abstract T getEntry(Database database, Object obj);

    public abstract long insertEntry(Database database, ContentValues contentValues);

    public abstract long insertEntry(Database database, List<String> list);

    public abstract T insertEntry(Database database, T t);

    public abstract int updateEntry(Database database, ContentValues contentValues, Object obj);

    public abstract int updateEntry(Database database, List<String> list, Object obj);

    public abstract T updateEntry(Database database, T t, Object obj);

    public abstract int updateEntryWhere(Database database, ContentValues contentValues, String str, String[] strArr);

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(List<Column> columns, String tableName) {
        this.columns = columns;
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Column getColumn(int index) {
        if (index < this.columns.size()) {
            return null;
        }
        return (Column) this.columns.get(index);
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public void removeColumn(Column column) {
        this.columns.remove(column);
    }

    public String getCreateTableString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE ").append(this.tableName).append(" (");
        boolean firstColumn = true;
        for (Column column : this.columns) {
            if (!firstColumn) {
                builder.append(", ");
            }
            firstColumn = false;
            builder.append(column.getCreateString());
        }
        builder.append(")");
        return builder.toString();
    }

    public String[] getProjection() {
        if (this.projection == null) {
            this.projection = new String[this.columns.size()];
            int count = 0;
            for (Column column : this.columns) {
                int count2 = count + 1;
                this.projection[count] = column.getName();
                count = count2;
            }
        }
        return this.projection;
    }

    public String getIdField() {
        return this.idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public ContentValues addContentValue(ContentValues cv, String field, String value) {
        if (cv == null) {
            cv = new ContentValues();
        }
        cv.put(field, value);
        return cv;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
