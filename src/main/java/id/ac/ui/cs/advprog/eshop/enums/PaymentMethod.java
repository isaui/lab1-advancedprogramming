package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentMethod {

    COD("Cash On Delivery"), PAYMENT_BY_VOUCHER("Payment by Voucher"), PAYMENT_BY_BANK_TRANSFER("Payment by Bank Transfer");

    private final String value;
    private PaymentMethod(String value){
        this.value = value;
    }
    public static boolean contains(String params){
        for(PaymentMethod method: PaymentMethod.values()){
            if(method.getValue().equals(params)){
                return true;
            }
        }
        return false;
    }
}
