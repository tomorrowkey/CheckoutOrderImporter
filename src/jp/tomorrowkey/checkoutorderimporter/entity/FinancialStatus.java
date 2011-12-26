
package jp.tomorrowkey.checkoutorderimporter.entity;

/**
 * 金融状態
 */
public enum FinancialStatus {
    CHARGED, // 発送済み
    CANCELLED, // キャンセル
    CANCELLED_BY_GOOGLE, // Googleによりキャンセル
    CHARGEABLE, // 発送可能
    PAYMENT_DECLINED, // 支払い不承認
    REVIEWING, // 請求中
    REFUND, // 払い戻し
}
