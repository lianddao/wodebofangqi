package com.songbirdnest.billing.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.songbirdnest.database.AbstractTable;
import com.songbirdnest.database.Column;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.database.DataMapper;
import com.songbirdnest.util.Logger;

public class PurchasedTable extends AbstractTable<Purchase> {
    private static final int ID_COLUMN = 0;
    public static final String PRODUCT_ID = "product_id";
    private static final int PRODUCT_ID_COLUMN = 1;
    public static final String QUANTITY = "quantity";
    private static final int QUANTITY_COLUMN = 2;
    public static final String TABLE_NAME = "purchased";
    private DataMapper<Purchase> mapper = new PurchaseMapper();

    public class PurchaseMapper implements DataMapper<Purchase> {
        public void write(ContentValues cv, Column column, Purchase purchase) {
            switch (column.getColumnPosition()) {
                case 1:
                    if (purchase.getProductId() != null) {
                        cv.put(PurchasedTable.PRODUCT_ID, purchase.getProductId());
                        return;
                    }
                    return;
                case 2:
                    cv.put(PurchasedTable.QUANTITY, Integer.valueOf(purchase.getQuantity()));
                    return;
                default:
                    return;
            }
        }

        public void read(Cursor cursor, Column column, Purchase purchase) {
            int columnIndex = getColumnIndex(cursor, column.getName());
            if (columnIndex == -1) {
                Logger.error((Object) this, "PurchasedTable.PurchaseMapper.read: Column " + column.getName() + " does not exist in cursor");
                return;
            }
            switch (column.getColumnPosition()) {
                case 0:
                    purchase.setId(cursor.getLong(columnIndex));
                    return;
                case 1:
                    purchase.setProductId(cursor.getString(columnIndex));
                    return;
                case 2:
                    purchase.setQuantity(cursor.getInt(columnIndex));
                    return;
                default:
                    return;
            }
        }

        private int getColumnIndex(Cursor cursor, String column) {
            return cursor.getColumnIndex(column);
        }
    }

    public PurchasedTable() {
        super(TABLE_NAME);
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column(PRODUCT_ID, COLUMN_TYPE.INTEGER));
        addColumn(new Column(QUANTITY, COLUMN_TYPE.INTEGER));
    }

    public DataMapper<Purchase> getMapper() {
        return this.mapper;
    }
}
