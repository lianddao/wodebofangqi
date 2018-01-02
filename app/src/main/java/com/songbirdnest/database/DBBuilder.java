package com.songbirdnest.database;

import android.content.Context;
import android.database.Cursor;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBBuilder {
    protected BaseDatabaseHelper baseDatabaseHelper;
    protected Context context;
    protected String databaseName;
    protected String mainTableName;
    protected Map<String, TableItem> tableItems = new HashMap();
    protected List<Table> tables = new ArrayList();
    protected int version = 1;

    class DBBuilderBaseDatabaseHelper extends BaseDatabaseHelper {
        protected DBBuilderBaseDatabaseHelper(Context context, String databaseName, String mainTableName, int version) {
            super(context, databaseName, mainTableName, version);
        }

        protected void createLocalDB() {
            this.localDatabase = new Database(this.sqLiteDatabase);
            this.localDatabase.setTables(DBBuilder.this.tables);
        }
    }

    public DBBuilder(Context context) {
        this.context = context;
    }

    public void setMainTableName(String mainTableName) {
        this.mainTableName = mainTableName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Table addTable(String tableName) {
        Table table = new AbstractTable(tableName);
        this.tables.add(table);
        this.tableItems.put(tableName, new TableItem(table, tableName));
        table.addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        return table;
    }

    public void addTable(String tableName, List<String> columnNames) {
        Table table = addTable(tableName);
        for (String columnName : columnNames) {
            table.addColumn(new Column(columnName, COLUMN_TYPE.TEXT));
        }
    }

    public void addTableColumn(String tableName, String columnName) {
        Table table;
        TableItem tableItem = (TableItem) this.tableItems.get(tableName);
        if (tableItem == null) {
            table = addTable(tableName);
        } else {
            table = tableItem.table;
        }
        table.addColumn(new Column(columnName, COLUMN_TYPE.TEXT));
    }

    public TableEntry getTableEntry(String tableName) {
        return (TableEntry) this.tableItems.get(tableName);
    }

    public BaseDatabaseHelper build() throws DBException {
        if (this.databaseName == null || this.mainTableName == null || this.tables.size() == 0) {
            throw new DBException("Database, table name & tables must be set before building");
        }
        this.baseDatabaseHelper = new DBBuilderBaseDatabaseHelper(this.context, this.databaseName, this.mainTableName, this.version);
        return this.baseDatabaseHelper;
    }

    public static void testDBuilder(Context context) {
        DBBuilder builder = new DBBuilder(context);
        builder.setDatabaseName("testing.db");
        String testingTable = "testingTable";
        builder.setMainTableName(testingTable);
        List<String> columns = new ArrayList();
        columns.add("col1");
        columns.add("col2");
        columns.add("col3");
        columns.add("col4");
        builder.addTable(testingTable, columns);
        BaseDatabaseHelper buildHelper = builder.build();
        buildHelper.dropDatabase();
        List data = new ArrayList();
        data.add("data1-1");
        data.add("data1-2");
        data.add("data1-3");
        data.add("data1-4");
        long row1Id = buildHelper.insertEntry(builder.getTableEntry(testingTable), data);
        Logger.debug(context, "Id is " + row1Id);
        data.clear();
        data.add("data2-1");
        data.add("data2-2");
        data.add("data2-3");
        data.add("data2-4");
        long row2Id = buildHelper.insertEntry(builder.getTableEntry(testingTable), data);
        Cursor allEntries = buildHelper.getAllEntries(builder.getTableEntry(testingTable));
        Logger.debug(context, "After inserting row " + row2Id);
        if (allEntries != null) {
            if (allEntries.moveToFirst()) {
                printCursor(context, allEntries);
            }
            allEntries.close();
        }
        Cursor cursor = buildHelper.getEntry(builder.getTableEntry(testingTable), row1Id);
        Logger.debug(context, "Searching for row " + row1Id);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    printCursor(context, cursor);
                }
                cursor.close();
            } catch (DBException e) {
                e.printStackTrace();
                return;
            } catch (Throwable th) {
                cursor.close();
            }
        }
        cursor = buildHelper.getEntry(builder.getTableEntry(testingTable), "col2", "data1-2");
        Logger.debug(context, "Searching for data1-2");
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                printCursor(context, cursor);
            }
            cursor.close();
        }
        buildHelper.deleteEntry(builder.getTableEntry(testingTable), Long.valueOf(row1Id));
        Logger.debug(context, "After deleting row " + row1Id);
        allEntries = buildHelper.getAllEntries(builder.getTableEntry(testingTable));
        if (allEntries != null) {
            if (allEntries.moveToFirst()) {
                printCursor(context, allEntries);
            }
            allEntries.close();
        }
        data.clear();
        data.add(String.valueOf(row2Id));
        data.add("data2-2-1");
        data.add("data2-2-2");
        data.add("data2-2-3");
        data.add("data2-2-4");
        buildHelper.updateEntry(builder.getTableEntry(testingTable), data, String.valueOf(row2Id));
        cursor = buildHelper.getEntry(builder.getTableEntry(testingTable), row2Id);
        Logger.debug(context, "After updating row " + row2Id);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                printCursor(context, cursor);
            }
            cursor.close();
        }
    }

    private static void printCursor(Context context, Cursor cursor) {
        int count = cursor.getCount();
        Logger.debug(context, "Found " + count + " items");
        String[] columnNames = cursor.getColumnNames();
        for (String columnName : columnNames) {
            Logger.debug(context, "Column: " + columnName);
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < columnNames.length; j++) {
                int columnIndex = cursor.getColumnIndex(columnNames[j]);
                if (columnIndex != -1) {
                    Logger.debug(context, "Data for column: " + j + " is " + cursor.getString(columnIndex));
                } else {
                    Logger.debug(context, "Data for column: " + columnNames[j] + " not found ");
                }
            }
            cursor.moveToNext();
        }
    }
}
