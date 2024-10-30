import java.util.Scanner;

class BankAccount{
    double balance;

    double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited amount: Rs " + amount);
        }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount that is withdrawn: Rs" + amount);
            return true;
        } else{
            System.out.println("Insufficient balance.");
            return false;
        } 
    }
}

class ATM{
    public void displayMenu() {
        System.out.printf("\nATM Menu:\n1.Withdraw\n2.Deposit\n3.Check Balance\n4.Exit\n");
    }

    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void checkBalance(BankAccount account) {
        System.out.printf("Current balance: Rs %.2f\n", account.getBalance());
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        ATM atm = new ATM();
        int choice = 0;

        while (choice != 4) {
            atm.displayMenu();
            System.out.print("Select an option: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to withdraw: Rs");
                double amount = sc.nextDouble();
                atm.withdraw(account, amount);
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: Rs");
                double amount = sc.nextDouble();
                atm.deposit(account, amount);
            } else if (choice == 3) {
                atm.checkBalance(account);
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option !");
            }
        }
    }
}
