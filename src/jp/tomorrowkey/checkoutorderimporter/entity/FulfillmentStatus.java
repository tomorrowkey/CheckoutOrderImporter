
package jp.tomorrowkey.checkoutorderimporter.entity;

/**
 * 履行状態
 */
public enum FulfillmentStatus {
    DELIVERED, // 配送済み
    WILL_NOT_DELIVER, // 配送していない
    NEW, // 新規
}
