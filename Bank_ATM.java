import java.util.Scanner;
class ATM 
{
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) 
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void start() 
    {
        boolean running = true;
        while (running) 
        {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");   
            int choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private void withdraw() 
    {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && account.getBalance() >= amount) 
        {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } 
        else 
        {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
    private void deposit() 
    {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) 
        {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } 
        else 
        {
            System.out.println("Invalid amount.");
        }
    }
    private void checkBalance() 
    {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

class BankAccount 
{
    private double balance;
    public BankAccount(double initialBalance) 
    {
        if (initialBalance >= 0) 
        {
            this.balance = initialBalance;
        } 
        else 
        {
            this.balance = 0;
        }
    }
    public double getBalance() 
    {
        return balance;
    }
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
        }
    }
    public void withdraw(double amount) 
    {
        if (amount > 0 && balance >= amount) 
        {
            balance -= amount;
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(3000.00);
        ATM atm = new ATM(account);
        atm.start();
    }
}
