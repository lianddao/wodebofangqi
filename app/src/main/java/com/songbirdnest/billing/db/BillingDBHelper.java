package com.songbirdnest.billing.db;

import android.content.Context;
import com.songbirdnest.billing.BillingHelper;
import com.songbirdnest.billing.InAppPurchases;
import com.songbirdnest.billing.PurchaseState;
import com.songbirdnest.database.BaseDatabaseHelper;
import com.songbirdnest.util.Logger;
import java.util.List;

public class BillingDBHelper extends BaseDatabaseHelper {
    protected static String DATABASE = "purchase.db";
    protected static final int version = 1;
    private HistoryTable historyTable;
    private PurchasedTable purchaseTable;

    public BillingDBHelper(Context context) {
        super(context, DATABASE, HistoryTable.TABLE_NAME, 1);
    }

    protected void createLocalDB() {
        this.localDatabase = new BillingDatabase(this.sqLiteDatabase);
        this.historyTable = (HistoryTable) this.localDatabase.getTable(HistoryTable.TABLE_NAME);
        this.purchaseTable = (PurchasedTable) this.localDatabase.getTable(PurchasedTable.TABLE_NAME);
    }

    public synchronized Order insertOrder(String orderId, String productId, PurchaseState state, long purchaseTime, String developerPayload) {
        Order order;
        open();
        order = new Order();
        order.setOrderId(orderId);
        order.setProductId(productId);
        order.setState(state);
        order.setPurchaseTime(purchaseTime);
        order.setDeveloperPayload(developerPayload);
        long id = this.historyTable.insertEntry(this.localDatabase, order, this.historyTable.getMapper());
        if (id < 0) {
            Logger.error((Object) this, "insertOrder: problems inserting order " + orderId + " product " + productId + " purchase State " + state);
        } else if (BillingHelper.debugging) {
            Logger.debug(this, "insertOrder: inserted order " + orderId + " product " + productId + " purchase State " + state);
        }
        order.setId(id);
        return order;
    }

    public synchronized Order getOrder(String orderId) {
        open();
        return (Order) this.historyTable.getEntry(this.localDatabase, new Order(), HistoryTable.HISTORY_ORDER, orderId, this.historyTable.getMapper());
    }

    public synchronized Order getProductOrder(String productId) {
        open();
        return (Order) this.historyTable.getEntry(this.localDatabase, new Order(), HistoryTable.HISTORY_PRODUCT_ID, productId, this.historyTable.getMapper());
    }

    public synchronized int updateOrder(Order order) {
        open();
        return this.historyTable.updateEntry(this.localDatabase, order, HistoryTable.HISTORY_ORDER, order.getOrderId(), this.historyTable.getMapper());
    }

    public synchronized Purchase updatePurchasedItem(String productId, int quantity) {
        Purchase purchase;
        if (quantity == 0) {
            purchase = null;
        } else {
            open();
            purchase = new Purchase();
            purchase = (Purchase) this.purchaseTable.getEntry(this.localDatabase, purchase, PurchasedTable.PRODUCT_ID, productId, this.purchaseTable.getMapper());
            if (purchase == null || purchase.getProductId() == null) {
                purchase = new Purchase();
                purchase.setQuantity(quantity);
                purchase.setProductId(productId);
                long id = this.purchaseTable.insertEntry(this.localDatabase, purchase, this.purchaseTable.getMapper());
                if (id < 0) {
                    Logger.error((Object) this, "updatePurchasedItem: problems inserting purchase product " + productId + " quantity " + quantity);
                } else if (BillingHelper.debugging) {
                    Logger.debug(this, "updatePurchasedItem: inserted purchase product " + productId + " quantity " + quantity);
                }
                purchase.setId(id);
            } else {
                purchase.setQuantity(quantity);
                if (this.purchaseTable.updateEntry(this.localDatabase, purchase, productId, this.purchaseTable.getMapper()) < 0) {
                    Logger.error((Object) this, "updatePurchasedItem: problems updating purchase product " + productId + " quantity " + quantity);
                } else if (BillingHelper.debugging) {
                    Logger.debug(this, "updatePurchasedItem: updated purchase product " + productId + " quantity " + quantity);
                }
            }
        }
        return purchase;
    }

    public synchronized List<Purchase> getPurchases() {
        open();
        return this.purchaseTable.getAllEntries(this.localDatabase, Purchase.class, this.purchaseTable.getMapper());
    }

    public synchronized int updatePurchase(String orderId, String productId, PurchaseState purchaseState, long purchaseTime, String developerPayload) {
        int quantity;
        open();
        insertOrder(orderId, productId, purchaseState, purchaseTime, developerPayload);
        quantity = 0;
        for (Order purchaseOrder : this.historyTable.getAllEntriesWhere(this.localDatabase, Order.class, HistoryTable.HISTORY_PRODUCT_ID, productId, this.historyTable.getMapper())) {
            if (purchaseOrder.getState() == PurchaseState.PURCHASED || purchaseOrder.getState() == PurchaseState.REFUNDED) {
                quantity++;
            }
            if (BillingHelper.debugging) {
                Logger.debug(this, "updatePurchase: found order. Product Id " + purchaseOrder.getProductId() + " order " + purchaseOrder.getOrderId() + " state " + purchaseOrder.getState());
            }
        }
        updatePurchasedItem(productId, quantity);
        return quantity;
    }

    public synchronized boolean purchaseExists(InAppPurchases purchase) {
        open();
        return ((Purchase) this.purchaseTable.getEntry(this.localDatabase, new Purchase(), PurchasedTable.PRODUCT_ID, purchase.getProductId(), this.purchaseTable.getMapper())) != null;
    }

    public static void testBillingHelper(Context context) {
        BillingDBHelper helper = new BillingDBHelper(context);
        try {
            helper.dropDatabase();
            Order order1 = helper.insertOrder("order1", "product1", PurchaseState.PURCHASED, System.currentTimeMillis(), null);
            if (order1 == null) {
                Logger.error((Object) BillingDBHelper.class, "Could not insert order1");
                return;
            }
            Order order2 = helper.getOrder("order1");
            if (order2 == null) {
                Logger.error((Object) BillingDBHelper.class, "Could not find order1");
                helper.dropDatabase();
                helper.close();
            } else if (order1.equals(order2)) {
                order1.setPurchaseTime(System.currentTimeMillis());
                order1.setState(PurchaseState.REFUNDED);
                if (helper.updateOrder(order1) <= 0) {
                    Logger.error((Object) BillingDBHelper.class, "Could not update order1");
                    helper.dropDatabase();
                    helper.close();
                    return;
                }
                Order order3 = helper.getOrder("order1");
                if (order3 == null) {
                    Logger.error((Object) BillingDBHelper.class, "Could not get order1");
                    helper.dropDatabase();
                    helper.close();
                } else if (!order1.equals(order3)) {
                    Logger.error((Object) BillingDBHelper.class, "order1 and order3 are not equal");
                    helper.dropDatabase();
                    helper.close();
                } else if (helper.updatePurchase("order2", "product2", PurchaseState.PURCHASED, System.currentTimeMillis(), null) != 1) {
                    Logger.error((Object) BillingDBHelper.class, "quantity is not 1 for order2");
                    helper.dropDatabase();
                    helper.close();
                } else if (helper.updatePurchase("order2", "product2", PurchaseState.PURCHASED, System.currentTimeMillis(), null) != 2) {
                    Logger.error((Object) BillingDBHelper.class, "quantity is not 2 for order2");
                    helper.dropDatabase();
                    helper.close();
                } else {
                    helper.dropDatabase();
                    helper.close();
                }
            } else {
                Logger.error((Object) BillingDBHelper.class, "order1 and order2 are not equal");
                helper.dropDatabase();
                helper.close();
            }
        } catch (Exception e) {
            Logger.error(BillingDBHelper.class, "Problems with BillingHelper", e);
        } finally {
            helper.dropDatabase();
            helper.close();
        }
    }
}
