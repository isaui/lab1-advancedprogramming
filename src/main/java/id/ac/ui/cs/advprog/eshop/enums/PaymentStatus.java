package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {

    SUCCESS("SUCCESS"), REJECTED("REJECTED");
    private final String value;
    private PaymentStatus(String value){
        this.value = value;
    }
    public static boolean contains(String params){
        for(PaymentStatus paymentStatus: PaymentStatus.values()){
            if(paymentStatus.name().equals(params)){
                return true;
            }
        }
        return false;
    }
}
