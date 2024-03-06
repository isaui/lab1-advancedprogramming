package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import java.lang.IllegalArgumentException;


public class Payment {
    
    private String id;
    private String method;
    private String status;
    private Map<String,String> paymentData;

    public Payment(String id, String method, Map<String,String> paymentData){
        if(paymentData == null){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.paymentData = paymentData;
        setMethod(method);
        _assignStatusBasedMethod();
    }
    public Payment(String id, String method, String status ,Map<String,String> paymentData){
        this(id, method, paymentData);
        setStatus(status);
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setMethod(String method) {
        if(PaymentMethod.contains(method)){
            this.method = method;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    private void _assignStatusBasedMethod(){
        if(this.method.equals(PaymentMethod.PAYMENT_BY_VOUCHER.getValue())){    
            setStatusBasedPaymentByVoucherCodeMethod();
        }
        else if(this.method.equals(PaymentMethod.COD.getValue())){
            String address = this.paymentData.get("address");
            String deliveryFee = this.paymentData.get("deliveryFee");
            boolean isAddressValid = address != null && !address.trim().isEmpty();
            boolean isDeliveryFeeValid = deliveryFee != null && !deliveryFee.trim().isEmpty();
            if(isAddressValid && isDeliveryFeeValid){
                _setStatus(PaymentStatus.SUCCESS.getValue());
            }
            else{
                _setStatus(PaymentStatus.REJECTED.getValue());
            }
        }
    }

    private boolean _isPaymentVoucherValid(){
        String code = paymentData.get("voucherCode");
        boolean isCodeExist = code != null;
        boolean isCodeLength16 = code == null? false: code.trim().length() == 16;
        boolean isStartWithEshop = code == null? false:  code.startsWith("ESHOP");
        @SuppressWarnings("null")
        boolean isDigitCount8 = code == null? false: code.chars().mapToObj(c -> (char) c).filter(Character::isDigit).count() == 8;
        return isCodeExist && isCodeLength16 && isStartWithEshop && isDigitCount8;
    }

    private void setStatusBasedPaymentByVoucherCodeMethod(){
        if(_isPaymentVoucherValid()){
            _setStatus(PaymentStatus.SUCCESS.getValue());
        }
        else{
            _setStatus(PaymentStatus.REJECTED.getValue());
        }
    }

    public void setPaymentData(Map<String, String> paymentData) {
        this.paymentData = paymentData;
    }

    private void _setStatus(String status){
        this.status = status;
    }
    
    public void setStatus(String status) {
        if(PaymentStatus.contains(status)){
           if(PaymentMethod.PAYMENT_BY_VOUCHER.getValue().equals(this.method)){
            _assignStatusBasedMethod();
           }
           else if(PaymentMethod.COD.getValue().equals(this.method)){
            String address = this.paymentData.get("address");
            String deliveryFee = this.paymentData.get("deliveryFee");
            boolean isAddressValid = address != null && !address.trim().isEmpty();
            boolean isDeliveryFeeValid = deliveryFee != null && !deliveryFee.trim().isEmpty();
            if(isAddressValid && isDeliveryFeeValid){
                _setStatus(PaymentStatus.SUCCESS.getValue());
            }
            else{
                _setStatus(PaymentStatus.REJECTED.getValue());
            }
           }
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
