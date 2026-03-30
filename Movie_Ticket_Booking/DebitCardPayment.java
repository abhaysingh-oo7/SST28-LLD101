class DebitCardPayment implements Payment {

    private String cardNumber;

    public DebitCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card: " + cardNumber);
        return true;
    }
}