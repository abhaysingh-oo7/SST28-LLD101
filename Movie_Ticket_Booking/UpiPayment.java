class UpiPayment implements Payment {

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using UPI: " + upiId);
        return true;
    }
}