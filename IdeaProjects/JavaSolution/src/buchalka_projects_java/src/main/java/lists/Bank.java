package lists;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        System.out.println("Can not add this Branch, please check if " + branchName + " Branch already exists.");
            return false;
    }

    public boolean addNewCustomerToBranch(String branchName, String customerName, double initialAmount) {
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null) {
            existingBranch.addNewCustomer(customerName, initialAmount);
            return true;
        }
        System.out.println("Can not add Customer record to Branch, please check if " + branchName + " Branch  does exist.");
        return false;

        //
    }

    public boolean addNewTransactionToCustomer(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null) {
            existingBranch.addCustomerTransaction(customerName, amount);
            return true;
        }
        System.out.println("Can not add Customer transaction at this Branch, please check if " + branchName + " Branch does exist.");
        return false;
    }

    public boolean showCustomerTransactionList(String branchName, boolean showTransacions) {
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null && showTransacions) {
            System.out.println("Customer & Transaction List of " + branchName + " Branch:");
            existingBranch.customerTransactionList(showTransacions);
            return true;
        }
        else if(existingBranch != null && !showTransacions) {
            System.out.println("Customer List of " + branchName + " Branch:");
            existingBranch.customerTransactionList(showTransacions);
            return true;
        }
        System.out.println("Can not print Customer List for " + branchName + ", please check if " + branchName + " Branch does exist.");
        return false;
    }

    public void showBranchesList() {
        System.out.println("List of " + this.name + " branches: ");
        for (int i = 0; i < this.branches.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.branches.get(i).getName());
        }
        if (branches.isEmpty())
            System.out.println("Branches List is empty.");
    }


    private Branch findBranch(String branchName) {
        for(int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

}
