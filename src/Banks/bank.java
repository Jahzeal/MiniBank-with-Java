package Banks;

import java.util.Scanner;
    public class bank {
        int balance = 0;

        public void deposit() {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("enter amount to deposit");
                int depositAmount = input.nextInt();
                if (depositAmount <= 10) {
                    System.out.println("please deposit a valid amount");
                } else {
                    balance += depositAmount;
                    System.out.println("new balance: " + balance);
                    break;
                }
            }
        }
        public void withdraw() {
            Scanner withdrawAmountScanner = new Scanner(System.in);
            while (true) {
                System.out.println("How much would you like to withdraw?");
                int withdrawAmount = withdrawAmountScanner.nextInt();
                if (withdrawAmount > balance - 100) {
                    System.out.println("Insufficient balance. Withdrawal would leave less than 100 in the account.");
                } else if (withdrawAmount > balance) {
                    System.out.println("Insufficient balance. Your account balance is " + balance + ".");
                } else {
                    Scanner bankNameScanner = new Scanner(System.in);
                    System.out.println("Enter bank name:");
                    String bankName = bankNameScanner.nextLine();

                    while (true) {
                        Scanner accountNumberScanner = new Scanner(System.in);
                        System.out.println("Enter 10-digit account number:");
                        String accountNumberString = accountNumberScanner.nextLine();

                        try {
                            long accountNumber = Long.parseLong(accountNumberString);  // Use long for larger numbers
                            if (accountNumberString.length() == 10) {
                                balance -= withdrawAmount;
                                System.out.println("New balance: " + balance + " and you sent " + withdrawAmount + " to " + accountNumber + " at " + bankName + " bank.");
                                // ... (rest of the code for viewing menu or exiting)
                                Scanner options = new Scanner(System.in);
                                System.out.println("1 to view menu ");
                                System.out.println("2 to end");
                                while (true){
                                    int option = options.nextInt();
                                    if ((!(option == 1 || option == 2))){
                                        System.out.println("enter 1(view menu), 2(end)");
                                    }
                                    else {
                                        if (option == 1) {
                                            showMenu();
                                        } else {
                                            System.out.println("Thank you for using our bank!");
                                            System.exit(0);
                                        }
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Invalid account number! Please enter exactly 10 digits.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid account number format. Please enter only numerical digits.");
                        }
                    }
                }
            }
        }





        public void checkbalance() {
            System.out.println("your current balance is " + balance);
        }


        public static void main(String[] args) {
            showMenu();
        }

        public static void showMenu(){
            System.out.println("welcome to your bank (Students Account");
            bank banks = new bank();
            banks.deposit();
            Scanner AskQues = new Scanner(System.in);
            System.out.println("what would you like to do?");
            System.out.println("1. check balance");
            System.out.println("2.deposit");
            System.out.println("3.withdraw(savings account)");
            int numChoice = AskQues.nextInt();
            switch (numChoice) {
                case 1 -> banks.checkbalance();
                case 2 -> banks.deposit();
                case 3 -> banks.withdraw();
                default -> System.out.println("Enter 1,2 or 3");

            }
        }
    }

