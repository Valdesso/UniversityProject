package lists;

public class Main {
    public static void main(String[] args) {
        welcomeBank();

        Bank bank = new Bank("American National Bank");
        bank.addNewBranch("New York");
        bank.addNewBranch("Los Angeles");
        bank.addNewCustomerToBranch("New York", "Jack", 50.40);
        bank.addNewCustomerToBranch("Los Angeles","Vladimir", 45.00);
        bank.addNewTransactionToCustomer("Los Angeles","Vladimir", 100.30);
        bank.showBranchesList();
        bank.showCustomerTransactionList("Los Angeles", true);
        bank.showCustomerTransactionList("New York", false);
    }







    private static void welcomeBank() {
        System.out.println("Welcome to the Bank's management.");
    }
}
