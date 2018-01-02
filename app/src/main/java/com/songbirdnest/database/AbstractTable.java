package com.songbirdnest.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class AbstractTable<T> extends Table<T> {
    public AbstractTable(String tableName) {
        super(tableName);
    }

    public AbstractTable(List<Column> columns, String tableName) {
        super(columns, tableName);
    }

    public T insertEntry(Database database, T t) {
        return null;
    }

    public long insertEntry(Database database, T data, DataMapper<T> mapper) {
        int columnPosition = 0;
        ContentValues cv = new ContentValues();
        for (Column column : this.columns) {
            if (column.column_position == 0) {
                column.column_position = columnPosition;
            }
            mapper.write(cv, column, data);
            columnPosition++;
        }
        return insertEntry(database, cv);
    }

    public long insertEntry(Database database, List<String> data) {
        ContentValues cv = new ContentValues();
        int columnSize = this.columns.size();
        int dataSize = data.size();
        if (dataSize > columnSize - 1) {
            Logger.error((Object) this, "You cannot insert more data than there are columns");
            return 0;
        }
        int i = 0;
        while (i < dataSize && i < columnSize) {
            cv.put(((Column) this.columns.get(i + 1)).getName(), (String) data.get(i));
            i++;
        }
        return insertEntry(database, cv);
    }

    public long insertEntry(Database database, ContentValues data) {
        long id = 0;
        try {
            return database.getDatabase().insert(getTableName(), getIdField(), data);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return id;
        }
    }

    public void deleteEntry(Database database, Object key) {
        try {
            database.getDatabase().delete(getTableName(), getIdField() + "=?", new String[]{String.valueOf(key)});
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void deleteEntryWhere(Database database, String whereClause, String[] whereArgs) {
        try {
            database.getDatabase().delete(getTableName(), whereClause, whereArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void deleteAllEntries(Database database) {
        try {
            database.getDatabase().delete(getTableName(), null, null);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public T getEntry(Database database, Object key) {
        return null;
    }

    public T getEntry(Database database, Object key, T data, DataMapper<T> mapper) {
        Cursor cursor = null;
        try {
            cursor = database.getDatabase().query(getTableName(), getProjection(), getIdField() + "=?", new String[]{String.valueOf(key)}, null, null, null);
            if (cursor == null) {
                data = null;
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor.moveToNext()) {
                int columnPosition = 0;
                for (Column column : this.columns) {
                    if (column.column_position == 0) {
                        column.column_position = columnPosition;
                    }
                    mapper.read(cursor, column, data);
                    columnPosition++;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                cursor.close();
                data = null;
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            data = null;
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return data;
    }

    public T getEntry(Database database, T data, String columnName, String columnValue, DataMapper<T> mapper) {
        Cursor cursor = null;
        try {
            cursor = database.getDatabase().query(getTableName(), getProjection(), columnName + "=?", new String[]{String.valueOf(columnValue)}, null, null, null);
            if (cursor == null) {
                data = null;
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor.moveToNext()) {
                int columnPosition = 0;
                for (Column column : this.columns) {
                    if (column.column_position == 0) {
                        column.column_position = columnPosition;
                    }
                    mapper.read(cursor, column, data);
                    columnPosition++;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                cursor.close();
                data = null;
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            data = null;
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return data;
    }

    public Cursor getEntry(Database database, long id) {
        Cursor cursor = null;
        try {
            cursor = database.getDatabase().query(getTableName(), getProjection(), getIdField() + "=?", new String[]{String.valueOf(id)}, null, null, null);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return cursor;
    }

    public Cursor getEntry(Database database, String columnName, String columnValue) {
        Cursor cursor = null;
        try {
            cursor = database.getDatabase().query(getTableName(), getProjection(), columnName + "=?", new String[]{columnValue}, null, null, null);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return cursor;
    }

    public T updateEntry(Database database, T t, Object key) {
        return null;
    }

    public int updateEntry(Database database, List<String> data, Object key) {
        ContentValues cv = new ContentValues();
        int columnSize = this.columns.size();
        int dataSize = data.size();
        int i = 0;
        while (i < dataSize && i < columnSize) {
            cv.put(((Column) this.columns.get(i)).getName(), (String) data.get(i));
            i++;
        }
        return updateEntry(database, cv, key);
    }

    public int updateEntry(Database database, ContentValues data, Object key) {
        int i = 0;
        try {
            i = database.getDatabase().update(getTableName(), data, getIdField() + "=?", new String[]{String.valueOf(key)});
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return i;
    }

    public int updateEntry(Database database, T data, Object key, DataMapper<T> mapper) {
        int i = 0;
        try {
            String[] whereArgs = new String[]{String.valueOf(key)};
            int columnPosition = 0;
            ContentValues cv = new ContentValues();
            for (Column column : this.columns) {
                if (column.column_position == 0) {
                    column.column_position = columnPosition;
                }
                mapper.write(cv, column, data);
                columnPosition++;
            }
            i = database.getDatabase().update(getTableName(), cv, getIdField() + "=?", whereArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return i;
    }

    public int updateEntry(Database database, T data, String columnName, String columnValue, DataMapper<T> mapper) {
        try {
            String[] whereArgs = new String[]{columnValue};
            int columnPosition = 0;
            ContentValues cv = new ContentValues();
            for (Column column : this.columns) {
                if (column.column_position == 0) {
                    column.column_position = columnPosition;
                }
                mapper.write(cv, column, data);
                columnPosition++;
            }
            return database.getDatabase().update(getTableName(), cv, columnName + "=?", whereArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return 0;
        }
    }

    public int updateEntryWhere(Database database, ContentValues cv, String whereClause, String[] whereArgs) {
        try {
            return database.getDatabase().update(getTableName(), cv, whereClause, whereArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return 0;
        }
    }

    public List<T> getAllEntries(Database database, Class<T> cls, DataMapper<T> mapper) {
        List<T> dataList = new ArrayList();
        try {
            Cursor cursor = database.getDatabase().query(getTableName(), getProjection(), null, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        int columnPosition = 0;
                        T data = cls.newInstance();
                        for (Column column : this.columns) {
                            if (column.column_position == 0) {
                                column.column_position = columnPosition;
                            }
                            mapper.read(cursor, column, data);
                            columnPosition++;
                        }
                        dataList.add(data);
                    } while (cursor.moveToNext());
                } else {
                    cursor.close();
                }
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        } catch (InstantiationException e2) {
            Logger.error((Object) this, e2.getMessage());
        } catch (IllegalAccessException e3) {
            Logger.error((Object) this, e3.getMessage());
        }
        return dataList;
    }

    public List<T> getAllEntriesWhere(Database database, Class<T> cls, String columnName, String columnValue, DataMapper<T> mapper) {
        List<T> dataList = new ArrayList();
        try {
            Cursor cursor = database.getDatabase().query(getTableName(), getProjection(), columnName + "=?", new String[]{String.valueOf(columnValue)}, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        int columnPosition = 0;
                        T data = cls.newInstance();
                        for (Column column : this.columns) {
                            if (column.column_position == 0) {
                                column.column_position = columnPosition;
                            }
                            mapper.read(cursor, column, data);
                            columnPosition++;
                        }
                        dataList.add(data);
                    } while (cursor.moveToNext());
                } else {
                    cursor.close();
                }
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        } catch (InstantiationException e2) {
            Logger.error((Object) this, e2.getMessage());
        } catch (IllegalAccessException e3) {
            Logger.error((Object) this, e3.getMessage());
        }
        return dataList;
    }

    public Cursor getAllEntries(Database database) {
        try {
            Cursor cursor = database.getDatabase().query(getTableName(), getProjection(), null, null, null, null, null);
            if (cursor.moveToFirst()) {
                return cursor;
            }
            cursor.close();
            return null;
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return null;
        }
    }

    public List<T> getAllEntries(Database database, Class<T> cls) {
        return null;
    }
}
