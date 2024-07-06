import java.util.HashMap;
import java.util.Scanner;

class Account{

    // initialize instance variable
    // These instance variable hold specific value to the individual object
    // Each object has their own specific data of instance variable
    Integer accountNumber;
    String username;
    double accountBalance;
    String accountPassword;

    // when each object is created, the constructor store specific value upon creating an object
    // e.g person1(1001, "Sak", 2, "123") will have its constructor store those specific value to the instance variable
    Account(Integer accountNo, String name, double balance, String password){
        this.accountNumber = accountNo;
        this.username = name;
        this.accountBalance = balance;
        this.accountPassword = password;
    }

    // Method to calculate the withdrawal amount
    void withdraw(double withdrawAmount){
        accountBalance-=withdrawAmount;
        System.out.println("\n\t\tWithdrawal successful!");
        System.out.println("\t\tRemaining balance: " + accountBalance);
    }

    // Method to calculate the deposit amount
    void deposit(double depositAmount){
        accountBalance+=depositAmount;
        System.out.println("\n\t\tDeposit successful!");
        System.out.println("\t\tCurrent balance: " + accountBalance);
    }

    // Method to calculate the transfer amount between account
    void transfer(Account transferAccount, double transferAmount){
        accountBalance-=transferAmount;
        transferAccount.accountBalance+=transferAmount; // add the transfer amount to the designated account
        System.out.println("\n\t\tTransfer complete!");

        /*  Debug showing another user balance 
        System.out.println(transferAccount.accountBalance);
        */

        System.out.println("\t\tRemaining balance: " + accountBalance); // shows out balance
    }
}

public class Exercise4{

    // Method to display all the options
    static void displayOption(){
        System.out.println("\n\t\t---------------------------");
        System.out.println("\t\t\tATM OPTION");
        System.out.println("\t\t---------------------------");
        System.out.println("\t\ta. Balance");
        System.out.println("\t\tb. Withdraw");
        System.out.println("\t\tc. Deposit");
        System.out.println("\t\td. Transfer");
        System.out.println("\t\te. Exit program");
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.print("\033\143"); // clear terminal

        String inputOption; // store user input
        Scanner input = new Scanner(System.in); // Scanner object

        // Create Account object with data
        Account person1 = new Account(1001, "Sak", 2, "123");
        Account person2 = new Account(2002, "Seth", 3, "234");
        Account person3 = new Account(3003, "Serey", 100, "999");
        Account person4 = new Account(4004, "Vicheka", 20, "111");
        Account person5 = new Account(5005, "Nara", 69, "4444");

        HashMap<Integer, Account> accounts = new HashMap<>(); // Create hashmap with class as value

        // input all the accounts into the hashmap
        accounts.put(person1.accountNumber, person1);
        accounts.put(person2.accountNumber, person2);
        accounts.put(person3.accountNumber, person3);
        accounts.put(person4.accountNumber, person4);
        accounts.put(person5.accountNumber, person5);

        // Infinite loop asking user to input their account info
        while(true){

            System.out.print("\t\tEnter account number: ");
            Integer inputAccountNumber = input.nextInt(); // user account number

            input.nextLine(); // clear buffer

            System.out.print("\t\tEnter account password: ");
            String inputPassword = input.nextLine(); // user account password

            // If both user account number and password is correct
            if(accounts.containsKey(inputAccountNumber) && (accounts.get(inputAccountNumber).accountPassword.equals(inputPassword))){
                System.out.print("\033\143"); // clear terminal
                System.out.println("\n\t\tLogin successful!"); 

                // Shows user option, if user enter e, program will terminate
                do { 
                    displayOption();
                    
                    System.out.print("\n\t\tEnter: ");
                    inputOption = input.nextLine();

                    // break out of the do{} loop if user enters "e"
                    if("e".equals(inputOption)){
                        break;
                    }

                    // switch case checking for user option
                    // Java version 22.0.1
                    switch(inputOption){

                        case "a" -> {
                            System.out.print("\033\143"); // clear terminal
                            System.out.println("\t\tPlease wait...\n");
                            Thread.sleep(1500); // Delay the program by 1.5s
                            System.out.println("\t\t-----------------------------");
                            System.out.print(String.format("\t\t\t%-27s", accounts.get(inputAccountNumber).username + "'s Account"));
                            System.out.println("\n\t\t-----------------------------");
                            System.out.println("\t\tBalance: " + accounts.get(inputAccountNumber).accountBalance);
                        }

                        case "b" -> {
                            // While loop to keep asking user withdrawal amount
                            while(true){
                                System.out.print("\033\143"); // clear terminal
                                System.out.print("\t\tEnter withdraw amount: ");
                                double withdraw = input.nextDouble();

                                // If the account balance matches or more than the withdrawal amount
                                if(accounts.get(inputAccountNumber).accountBalance >= withdraw){
                                    System.out.println("\n\t\tProcessing...");
                                    Thread.sleep(1500);
                                    accounts.get(inputAccountNumber).withdraw(withdraw);
                                    input.nextLine(); // clear buffer
                                    break; // break out of the while loop
                                }

                                // if the user does not have enough money
                                else{
                                    System.out.println("\t\tSorry, you have insufficient balance");
                                    System.out.println("\t\ta. Back\n\t\tb. Enter another amount"); // ask if user want to retry
                                    System.out.print("\t\tEnter: ");
                                    input.nextLine(); // clear buffer
                                    inputOption = input.nextLine();

                                    if("a".equals(inputOption)){
                                        System.out.print("\033\143"); // clear terminal
                                        break; // break out of the while loop
                                    }
                                }
                            }
                        }

                        case "c" -> {
                            System.out.print("\033\143"); // clear terminal
                            System.out.print("\t\tEnter deposit amount: ");
                            double deposit = input.nextDouble();

                            System.out.println("\n\t\tProcessing...");
                            Thread.sleep(1500); // delay 1.5s
                            accounts.get(inputAccountNumber).deposit(deposit); // get account object and deposit 
                            input.nextLine(); // clear buffer
                        }

                        case "d" -> {

                            // keep asking user about transfering, until user want to go back to option menu
                            do{
                                System.out.print("\033\143"); // clear terminal
                                System.out.print("\t\tEnter account number you want to transfer to: ");
                                Integer accountTransfer = input.nextInt();

                                System.out.print("\t\tEnter transfer amount: ");
                                double transferAmount = input.nextDouble();

                                System.out.print("\t\tEnter password: ");
                                input.nextLine(); // clear buffer
                                String userPAssword = input.nextLine();

                                // check if the transfer account doesnt exist
                                if(!accounts.containsKey(accountTransfer)){
                                    System.out.print("\033\143"); // clear terminal
                                    System.out.println("\t\tAccount not found!");
                                    System.out.println("\t\ta. Back\n\t\tb. Try again");
                                    System.out.print("\t\tEnter: ");
                                    inputOption = input.nextLine();
                                    System.out.print("\033\143"); // clear terminal
                                }

                                // check if the password is incorrect
                                else if(!userPAssword.equals(accounts.get(inputAccountNumber).accountPassword)){
                                    System.out.print("\033\143"); // clear terminal
                                    System.out.println("\t\tWrong password!");
                                    System.out.println("\t\ta. Back\n\t\tb. Try again");
                                    System.out.print("\t\tEnter: ");
                                    inputOption = input.nextLine();
                                    System.out.print("\033\143"); // clear terminal
                                }

                                // check if the balance is insufficient
                                else if(accounts.get(inputAccountNumber).accountBalance < transferAmount){
                                    System.out.print("\033\143"); // clear terminal
                                    System.out.println("\t\tInsufficient balance!");
                                    System.out.println("\t\ta. Back\n\t\tb. Try again");
                                    System.out.print("\t\tEnter: ");
                                    inputOption = input.nextLine();
                                    System.out.print("\033\143"); // clear terminal
                                }

                                // transfer success
                                else{
                                    System.out.println("\n\t\tTransferring...");
                                    Thread.sleep(1500);
                                    System.out.print("\033\143"); // clear terminal
                                    accounts.get(inputAccountNumber).transfer(accounts.get(accountTransfer), transferAmount);
                                    break; // break from do{} loop
                                }
                            }while(!"a".equals(inputOption)); 
                        }

                        // if user enter anything other than the option mentioned
                        default -> {
                            System.out.print("\033\143"); // clear terminal
                            System.out.println("\t\tInvalid option!");
                            break;
                        }
                }
                } while (!"e".equals(inputOption)); // run as long as user doesnt enter "e"

                System.out.print("\033\143"); // clear terminal
                System.out.println("\t\tExit complete");
                input.close();
                System.exit(0); 
            }

            // if user credential doesnt match the one stored in hashmap
            else{
                System.out.print("\033\143"); // clear terminal
                System.out.println("\t\tLogin not successful, try again!");
                Thread.sleep(1500);
                System.out.print("\033\143"); // clear terminal
            } 
        }
    }
}