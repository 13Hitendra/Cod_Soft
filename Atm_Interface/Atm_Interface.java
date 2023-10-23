import java.util.Scanner;

public class Atm_Interface {
    public static void main(String[] args) {
        double initialBalance = 1000;

        ATM atm = new ATM(initialBalance);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            atm.processOption(option);
            System.out.println();
        }  
    }
}

class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                   checkBalance();
                     break;
            case 2:
                    withdraw();
                      break;
            case 3:
                     deposit();
                       break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: INR " + balance);
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: INR ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: INR " + balance);
        }
        
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in) ;
            System.out.print("Enter the amount to deposit: INR ");
            double amount = scanner.nextDouble();
            balance += amount;
        
        System.out.println("Deposit successful. Current balance: INR " + balance);
    }
    
}