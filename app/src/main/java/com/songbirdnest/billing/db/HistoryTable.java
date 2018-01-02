package com.songbirdnest.billing.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.songbirdnest.billing.PurchaseState;
import com.songbirdnest.database.AbstractTable;
import com.songbirdnest.database.Column;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.database.DataMapper;
import com.songbirdnest.util.Logger;

public class HistoryTable extends AbstractTable<Order> {
    private static final int DEVELOPER_PAYLOAD_COLUMN = 5;
    public static final String HISTORY_DEVELOPER_PAYLOAD = "developerPayload";
    public static final String HISTORY_ORDER = "orderId";
    public static final String HISTORY_PRODUCT_ID = "productId";
    public static final String HISTORY_PURCHASE_TIME = "purchaseTime";
    public static final String HISTORY_STATE = "state";
    private static final int ID_COLUMN = 0;
    private static final int ORDER_ID_COLUMN = 1;
    private static final int PRODUCT_ID_COLUMN = 2;
    private static final int PURCHASE_TIME_COLUMN = 4;
    private static final int STATE_COLUMN = 3;
    public static final String TABLE_NAME = "history";
    private DataMapper<Order> mapper = new OrderMapper();

    public class OrderMapper implements DataMapper<Order> {
        public void write(ContentValues cv, Column column, Order order) {
            switch (column.getColumnPosition()) {
                case 1:
                    if (order.getOrderId() != null) {
                        cv.put(HistoryTable.HISTORY_ORDER, order.getOrderId());
                        return;
                    }
                    return;
                case 2:
                    if (order.getProductId() != null) {
                        cv.put(HistoryTable.HISTORY_PRODUCT_ID, order.getProductId());
                        return;
                    }
                    return;
                case 3:
                    cv.put(HistoryTable.HISTORY_STATE, Integer.valueOf(order.getState().ordinal()));
                    return;
                case 4:
                    cv.put(HistoryTable.HISTORY_PURCHASE_TIME, Long.valueOf(order.getPurchaseTime()));
                    return;
                case 5:
                    if (order.getDeveloperPayload() != null) {
                        cv.put(HistoryTable.HISTORY_DEVELOPER_PAYLOAD, order.getDeveloperPayload());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void read(Cursor cursor, Column column, Order order) {
            int columnIndex = getColumnIndex(cursor, column.getName());
            if (columnIndex == -1) {
                Logger.error((Object) this, "HistoryTable.OrderMapper.read: Column " + column.getName() + " does not exist in cursor");
                return;
            }
            switch (column.getColumnPosition()) {
                case 0:
                    order.setId(cursor.getLong(columnIndex));
                    return;
                case 1:
                    order.setOrderId(cursor.getString(columnIndex));
                    return;
                case 2:
                    order.setProductId(cursor.getString(columnIndex));
                    return;
                case 3:
                    order.setState(PurchaseState.valueOf(cursor.getInt(columnIndex)));
                    return;
                case 4:
                    order.setPurchaseTime(cursor.getLong(columnIndex));
                    return;
                case 5:
                    order.setDeveloperPayload(cursor.getString(columnIndex));
                    return;
                default:
                    return;
            }
        }

        private int getColumnIndex(Cursor cursor, String column) {
            return cursor.getColumnIndex(column);
        }
    }

    public HistoryTable() {
        super(TABLE_NAME);
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column(HISTORY_ORDER, COLUMN_TYPE.TEXT));
        addColumn(new Column(HISTORY_PRODUCT_ID, COLUMN_TYPE.TEXT));
        addColumn(new Column(HISTORY_STATE, COLUMN_TYPE.INTEGER));
        addColumn(new Column(HISTORY_PURCHASE_TIME, COLUMN_TYPE.LONG));
        addColumn(new Column(HISTORY_DEVELOPER_PAYLOAD, COLUMN_TYPE.TEXT));
    }

    public DataMapper<Order> getMapper() {
        return this.mapper;
    }
}
