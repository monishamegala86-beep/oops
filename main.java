
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

class Bank implements BankAccount {
    String name;
    int accNo;
    double balance;

    Bank(String name, int accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid Amount");

        balance += amount;
        System.out.println("Amount Deposited Successfully");
        checkBalance();
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid Amount");

        if (amount > balance)
            throw new ArithmeticException("Insufficient Balance");

        balance -= amount;
        System.out.println("Amount Withdrawn Successfully");
        checkBalance();
    }

    public void checkBalance() {
        System.out.println("Available Balance : Rs. " + balance);
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount b = new Bank(name, accNo, balance);

        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        try {
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            if (choice == 1)
                b.deposit(amount);
            else if (choice == 2)
                b.withdraw(amount);
            else
                System.out.println("Invalid Choice");
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}

