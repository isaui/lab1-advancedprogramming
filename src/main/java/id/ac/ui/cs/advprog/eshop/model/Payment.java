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
    @SuppressWarnings("null")
    public void setStatus(String status) {
        if(this.method == "Payment by Voucher Code"){
            String code = paymentData.get("voucherCode");
            if(code == null){
                System.out.println("code");
                this.status = PaymentStatus.REJECTED.getValue();
            }
            else if(code.length() > 16 || code.length() < 16){
                System.out.println("code1");
                this.status = PaymentStatus.REJECTED.getValue();
            }
            else if(! code.startsWith("ESHOP")){
                System.out.println("code2");
                this.status = PaymentStatus.REJECTED.getValue();
            }
            else if(code.chars().mapToObj(c -> (char) c).filter(Character::isDigit).count() != 8){
                System.out.println("code3");
                this.status = PaymentStatus.REJECTED.getValue();
            }
            else{
                System.out.println("code4");
                this.status = PaymentStatus.SUCCESS.getValue();
            }
        }
        else{
            if(PaymentStatus.contains(status)){
                this.status = status;
            }
            else{
                throw new IllegalArgumentException();
            }
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
