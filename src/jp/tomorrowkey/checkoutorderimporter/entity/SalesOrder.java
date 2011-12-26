
package jp.tomorrowkey.checkoutorderimporter.entity;

import java.util.Date;

public class SalesOrder {

    private String orderID;

    private String merchantOrderNumber;

    private Long orderCreationDate;

    private Currency currencyOfTransaction;

    private Double orderAmount;

    private Double amountCharged;

    private FulfillmentStatus fulfillmentStatus;

    private String linkToOrder;

    private Double totalTax;

    private Double totalShipping;

    private Double amountRefunded;

    private Double amountChargedBack;

    private YesNo chargebackProtection;

    private String shippingMethod;

    private YesNo emailMarketing;

    private String buyerEmailAddress;

    private String buyerName;

    private String buyerAddress1;

    private String buyerAddress2;

    private String buyerCity;

    private String buyerState;

    private String buyerPostalCode;

    private Country buyerCountry;

    private String buyerPhoneNumber;

    private String trackingData;

    private String item1ID;

    private String item1Name;

    private String item1Description;

    private Double item1Price;

    private Integer item1Quantity;

    private String item2ID;

    private String item2Name;

    private String item2Description;

    private Double item2Price;

    private Integer item2Quantity;

    private String orderNumber;

    private Date orderChargedDate;

    private Long orderChargedTimestamp;

    private FinancialStatus financialStatus;

    private Date payoutDate;

    private String deviceModel;

    private String productTitle;

    private String productID;

    private Currency currencyOfSale;

    private Double itemPrice;

    private Double taxesCollected;

    private Double chargedAmount;

    private Currency merchantCurrency;

    private Double estimatedFXRate;

    private Double merchantReceives;

    private String cityOfBuyer;

    private String stateOfBuyer;

    private String postalCodeOfBuyer;

    private CountryCode countryOfBuyer;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderChargedDate() {
        return orderChargedDate;
    }

    public void setOrderChargedDate(Date orderChargedDate) {
        this.orderChargedDate = orderChargedDate;
    }

    public Long getOrderChargedTimestamp() {
        return orderChargedTimestamp;
    }

    public void setOrderChargedTimestamp(Long orderChargedTimestamp) {
        this.orderChargedTimestamp = orderChargedTimestamp;
    }

    public FinancialStatus getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(FinancialStatus financialStatus) {
        this.financialStatus = financialStatus;
    }

    public Date getPayoutDate() {
        return payoutDate;
    }

    public void setPayoutDate(Date payoutDate) {
        this.payoutDate = payoutDate;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Currency getCurrencyOfSale() {
        return currencyOfSale;
    }

    public void setCurrencyOfSale(Currency currencyOfSale) {
        this.currencyOfSale = currencyOfSale;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getTaxesCollected() {
        return taxesCollected;
    }

    public void setTaxesCollected(Double taxesCollected) {
        this.taxesCollected = taxesCollected;
    }

    public Double getChargedAmount() {
        return chargedAmount;
    }

    public void setChargedAmount(Double chargedAmount) {
        this.chargedAmount = chargedAmount;
    }

    public Currency getMerchantCurrency() {
        return merchantCurrency;
    }

    public void setMerchantCurrency(Currency merchantCurrency) {
        this.merchantCurrency = merchantCurrency;
    }

    public Double getEstimatedFXRate() {
        return estimatedFXRate;
    }

    public void setEstimatedFXRate(Double estimatedFXRate) {
        this.estimatedFXRate = estimatedFXRate;
    }

    public Double getMerchantReceives() {
        return merchantReceives;
    }

    public void setMerchantReceives(Double merchantReceives) {
        this.merchantReceives = merchantReceives;
    }

    public String getCityOfBuyer() {
        return cityOfBuyer;
    }

    public void setCityOfBuyer(String cityOfBuyer) {
        this.cityOfBuyer = cityOfBuyer;
    }

    public String getStateOfBuyer() {
        return stateOfBuyer;
    }

    public void setStateOfBuyer(String stateOfBuyer) {
        this.stateOfBuyer = stateOfBuyer;
    }

    public String getPostalCodeOfBuyer() {
        return postalCodeOfBuyer;
    }

    public void setPostalCodeOfBuyer(String postalCodeOfBuyer) {
        this.postalCodeOfBuyer = postalCodeOfBuyer;
    }

    public CountryCode getCountryOfBuyer() {
        return countryOfBuyer;
    }

    public void setCountryOfBuyer(CountryCode countryOfBuyer) {
        this.countryOfBuyer = countryOfBuyer;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getMerchantOrderNumber() {
        return merchantOrderNumber;
    }

    public void setMerchantOrderNumber(String merchantOrderNumber) {
        this.merchantOrderNumber = merchantOrderNumber;
    }

    public Long getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Long orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public Currency getCurrencyOfTransaction() {
        return currencyOfTransaction;
    }

    public void setCurrencyOfTransaction(Currency currencyOfTransaction) {
        this.currencyOfTransaction = currencyOfTransaction;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(Double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public FulfillmentStatus getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(FulfillmentStatus fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getLinkToOrder() {
        return linkToOrder;
    }

    public void setLinkToOrder(String linkToOrder) {
        this.linkToOrder = linkToOrder;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(Double totalShipping) {
        this.totalShipping = totalShipping;
    }

    public Double getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Double amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public Double getAmountChargedBack() {
        return amountChargedBack;
    }

    public void setAmountChargedBack(Double amountChargedBack) {
        this.amountChargedBack = amountChargedBack;
    }

    public YesNo getChargebackProtection() {
        return chargebackProtection;
    }

    public void setChargebackProtection(YesNo chargebackProtection) {
        this.chargebackProtection = chargebackProtection;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public YesNo getEmailMarketing() {
        return emailMarketing;
    }

    public void setEmailMarketing(YesNo emailMarketing) {
        this.emailMarketing = emailMarketing;
    }

    public String getBuyerEmailAddress() {
        return buyerEmailAddress;
    }

    public void setBuyerEmailAddress(String buyerEmailAddress) {
        this.buyerEmailAddress = buyerEmailAddress;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress1() {
        return buyerAddress1;
    }

    public void setBuyerAddress1(String buyerAddress1) {
        this.buyerAddress1 = buyerAddress1;
    }

    public String getBuyerAddress2() {
        return buyerAddress2;
    }

    public void setBuyerAddress2(String buyerAddress2) {
        this.buyerAddress2 = buyerAddress2;
    }

    public String getBuyerCity() {
        return buyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }

    public String getBuyerState() {
        return buyerState;
    }

    public void setBuyerState(String buyerState) {
        this.buyerState = buyerState;
    }

    public String getBuyerPostalCode() {
        return buyerPostalCode;
    }

    public void setBuyerPostalCode(String buyerPostalCode) {
        this.buyerPostalCode = buyerPostalCode;
    }

    public Country getBuyerCountry() {
        return buyerCountry;
    }

    public void setBuyerCountry(Country buyerCountry) {
        this.buyerCountry = buyerCountry;
    }

    public String getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }

    public void setBuyerPhoneNumber(String buyerPhoneNumber) {
        this.buyerPhoneNumber = buyerPhoneNumber;
    }

    public String getTrackingData() {
        return trackingData;
    }

    public void setTrackingData(String trackingData) {
        this.trackingData = trackingData;
    }

    public String getItem1ID() {
        return item1ID;
    }

    public void setItem1ID(String item1id) {
        item1ID = item1id;
    }

    public String getItem1Name() {
        return item1Name;
    }

    public void setItem1Name(String item1Name) {
        this.item1Name = item1Name;
    }

    public String getItem1Description() {
        return item1Description;
    }

    public void setItem1Description(String item1Description) {
        this.item1Description = item1Description;
    }

    public Double getItem1Price() {
        return item1Price;
    }

    public void setItem1Price(Double item1Price) {
        this.item1Price = item1Price;
    }

    public Integer getItem1Quantity() {
        return item1Quantity;
    }

    public void setItem1Quantity(Integer item1Quantity) {
        this.item1Quantity = item1Quantity;
    }

    public String getItem2ID() {
        return item2ID;
    }

    public void setItem2ID(String item2id) {
        item2ID = item2id;
    }

    public String getItem2Name() {
        return item2Name;
    }

    public void setItem2Name(String item2Name) {
        this.item2Name = item2Name;
    }

    public String getItem2Description() {
        return item2Description;
    }

    public void setItem2Description(String item2Description) {
        this.item2Description = item2Description;
    }

    public Double getItem2Price() {
        return item2Price;
    }

    public void setItem2Price(Double item2Price) {
        this.item2Price = item2Price;
    }

    public Integer getItem2Quantity() {
        return item2Quantity;
    }

    public void setItem2Quantity(Integer item2Quantity) {
        this.item2Quantity = item2Quantity;
    }

    public String getId() {
        if (orderNumber != null && orderNumber.length() > 0) {
            return orderNumber;
        } else if (orderID != null && orderID.length() > 0) {
            return orderID.substring(orderID.length() - 15, orderID.length());
        } else {
            throw new RuntimeException("not found order number");
        }
    }
}
