package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;



public class Payment {
    
    private String id;
    private String method;
    private String status;
    private Map<String,String> paymentData;

    public Payment(String id, String method, String status, Map<String,String> paymentData){
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        setStatus(status);
    }
    public Payment(String id, String method, Map<String,String> paymentData){
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        setStatus("SUCCESS");
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public void setPaymentData(Map<String, String> paymentData) {
        this.paymentData = paymentData;
    }
    public void setStatus(String status) {
        if(PaymentStatus.contains(status)){
            this.status = status;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    public String getId() {
        return id;
    }
    public String getMethod() {
        return method;
    }
    public Map<String, String> getPaymentData() {
        return paymentData;
    }
    public String getStatus() {
        return status;
    }
}
