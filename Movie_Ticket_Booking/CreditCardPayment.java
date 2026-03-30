class CreditCardPayment implements Payment {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
        return true;
    }
}