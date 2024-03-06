package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

    WAITING_PAYMENT("WAITING_PAYMENT"),
    FAILED("FAILED"),
    SUCCESS("SUCCESS"),
    CANCELLED("CANCELLED");

    private final String value;
    private OrderStatus(String value){
        this.value = value;
    }
    public static boolean contains(String params){
        for(OrderStatus orderStatus: OrderStatus.values()){
            if(orderStatus.name().equals(params)){
                return true;
            }
        }
        return false;
    }
}
