package lists;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        System.out.println("Can not add this record, please check if " + customerName + " Customer already exists.");
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransactions(amount);
            return true;
        }
        System.out.println("Can not add transaction, please check if " + customerName + " Customer record does exist.");
        return false;
    }

    public void customerTransactionList(boolean showTransacions) {
            for (int i = 0; i < this.customers.size(); i++) {
                if(showTransacions) {
                    System.out.println((i + 1) + "." +
                            this.customers.get(i).getName() + " -> " +
                            this.customers.get(i).getTransactions());
                }
                System.out.println((i + 1) + "." +
                        this.customers.get(i).getName());
            }
            if (customers.size() == 0)
                System.out.println("Customer & Transaction List is empty...");
        }

    private Customer findCustomer(String customerName) {                   // Finding process
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(customerName)) {
                return this.customers.get(i);
            }
        }
        return null;
    }
}
