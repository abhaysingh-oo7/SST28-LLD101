class Refund {
    private String refundId;
    private double amount;

    public Refund(String refundId, double amount) {
        this.refundId = refundId;
        this.amount = amount;
    }

    public void initiateRefund() {
        System.out.println("Refund of amount " + amount + " initiated.");
    }
}