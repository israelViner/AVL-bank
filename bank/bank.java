import java.util.*;  // Import the Scanner class

public class bank {
         BinaryTree accounts = new BinaryTree(0, "empty");
         Scanner scanner = new Scanner(System.in);
         
         public void play() {
             System.out.println("Welcome to the bank");
             System.out.println("1. Open account");
             System.out.println("2. Balance inquiry");
             System.out.println("3. Deposit");
             System.out.println("4. withdrawal");
             System.out.println("5. Closing account");
             int x = scanner.nextInt();
             while (x != 6) {
                 System.out.println("Enter your ID number");
                 int y = scanner.nextInt();
                 if (x == 1) {
                     System.out.println("Enter your name");
                     scanner.nextLine();
                     String name = scanner.nextLine();
                     openAccount(y, name);
                     System.out.println("The account has been opened successfully");
                     System.out.println("Would you be interested in depositing money into your account? if so, press 1");
                     int res = scanner.nextInt();
                     if (res == 1) {
                        System.out.println("Enter the sum you want to deposit");
                        int sum = scanner.nextInt();
                        deposit(y, sum);
                        System.out.println("The money has been deposited successfully");
                     }
                     else
                        continue;
                 }
                 else {
                     int i = 0;
                     while (accounts.searchNode1(y) == null && i < 3) {
                        System.out.println("Account not found:( please try again");
                        y = scanner.nextInt();
                        i++;
                     }
                     
                     if (accounts.searchNode1(y) == null) {
                          System.out.println("Failed");
                          return;
                     }
                     
                     if (x == 2) {
                         System.out.println("your balance is: " + balanceInquiry(y));
                     }
             
                     if (x == 3) {
                             System.out.println("Enter the sum you want to deposit");
                             int sum = scanner.nextInt();
                             deposit(y, sum);
                             System.out.println("The money has been deposited successfully");
                             System.out.println("Your balance now is: " + balanceInquiry(y));
                     }
             
                     if (x == 4) {
                             System.out.println("Enter the sum you want to withdraw");
                             int sum = scanner.nextInt();
                             withdrawal(y, sum);
                             System.out.println("Your balance now is: " + balanceInquiry(y));
                     }
             
                     if (x == 5) {
                             deleteAccount(y);
                             System.out.println("Your account has been successfully closed, thank you for using our bank services");
                             return;
                     } 
                 }
                 System.out.println("Would you like to perform another action in your account? If so, enter the appropriate number, else press 6");
                 x = scanner.nextInt();
             }
             System.out.println("Thank you for using our bank services, enjoy your day :)");
         }
         
         
         
         private void openAccount(int ID, String Name) {
              accounts.addN(ID, Name);
         }
         
         private void deleteAccount(int ID) {
             accounts.deleteNode1(ID);
         }
         
         private void deposit(int ID, int sum) {
             this.accounts.searchNode1(ID).setKeyBalance(sum);
         }
         
         private void withdrawal(int ID, int sum) {
             this.accounts.searchNode1(ID).setKeyBalance(-sum);
         }
         
         private double balanceInquiry(int ID) {
             return this.accounts.searchNode1(ID).getKeyBalance();
         }
         
}
