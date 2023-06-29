import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.io.IOException;

public class OptionMenu extends Account {
  Scanner menuInput= new Scanner(System.in);
  DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

  HashMap<Integer,Integer> data= new HashMap<Integer,Integer>();

  public void getLogin() throws IOException {
    int x=1;
    do{
      try {
         data.put(952141, 191904);
         data.put(989947, 71976);

         System.out.println("Welcome to the ATM Project!");
         System.out.println("Enter your customer Number");
         setCustomerNumber(menuInput.nextInt());

         System.out.print("Enter your PIN Number: ");
         setPinNumber(menuInput.nextInt());
         }
         catch (Exception e) {
           System.out.println("\n"+ "Invalid Character(s). Only Numbers."+"\n");
           x=2;
         }
         /*for(Map.Entry<Integer,Integer> it : data.entrySet()){
           if(it.getkey()==getCustomerNumber() && it.getValue()==getPinNumber){
             getAccountType();
           }
         }*/
         int cn=getCustomerNumber();
         int pn=getPinNumber();
         if(data.containsKey(cn) && data.get(cn)==pn){
             getAccountType();
         }else
         System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
      System.out.println("\n" + " If you Don't have Account please Create Account!" + "\n");
		System.out.println("Enter your customer Number ");
		int cst_no=acc.nextInt();
		System.out.println("Enter PIN to be register");
		int pin=acc.nextInt();
		data.put(cst_no,pin);
		System.out.println("Your New Account has been Successfuly Registered! ");
		System.out.println("Redirecting to login.............");
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();

	public void getLogin() throws IOException {
		boolean end = false;
		int customerNumber = 0;
		int pinNumber = 0;
		while (!end) {
			try {
				System.out.print("\nEnter your customer number: ");
				customerNumber = menuInput.nextInt();
				System.out.print("\nEnter your PIN number: ");
				pinNumber = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();
					if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
						getAccountType(acc);
						end = true;
						break;
					}
				}
				if (!end) {
					System.out.println("\nWrong Customer Number or Pin Number");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Character(s). Only Numbers.");
			}
		}
	}

	public void getAccountType(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSelect the account you want to access: ");
				System.out.println(" Type 1 - Checkings Account");
				System.out.println(" Type 2 - Savings Account");
				System.out.println(" Type 3 - Exit");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					getChecking(acc);
					break;
				case 2:
					getSaving(acc);
					break;
				case 3:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getChecking(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCheckings Account: ");
				System.out.println(" Type 1 - View Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					System.out.println("\nCheckings Account Balance: " + moneyFormat.format(acc.getCheckingBalance()));
					break;
				case 2:
					acc.getCheckingWithdrawInput();
					break;
				case 3:
					acc.getCheckingDepositInput();
					break;

				case 4:
					acc.getTransferInput("Checkings");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getSaving(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSavings Account: ");
				System.out.println(" Type 1 - View Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("Choice: ");
				int selection = menuInput.nextInt();
				switch (selection) {
				case 1:
					System.out.println("\nSavings Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
					break;
				case 2:
					acc.getsavingWithdrawInput();
					break;
				case 3:
					acc.getSavingDepositInput();
					break;
				case 4:
					acc.getTransferInput("Savings");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void createAccount() throws IOException {
		int cst_no = 0;
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nEnter your customer number ");
				cst_no = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					if (!data.containsKey(cst_no)) {
						end = true;
					}
				}
				if (!end) {
					System.out.println("\nThis customer number is already registered");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\nEnter PIN to be registered");
		int pin = menuInput.nextInt();
		data.put(cst_no, new Account(cst_no, pin));
		System.out.println("\nYour new account has been successfuly registered!");
		System.out.println("\nRedirecting to login.............");
		getLogin();
    }while(x==1);
  }

  public void getAccountType(){
    System.out.println("Select the Account you Want to Access: ");
    System.out.println(" Type 1 - Checking Account");
    System.out.println(" Type 2 - Saving Account");
    System.out.println(" Type 3 - Exit");

    int selection= menuInput.nextInt();

    switch (selection) {
      case 1:
      getChecking();
      break;

      case 2:
      getSaving();
      break;

      case 3:
      System.out.println("Thank You for using this ATM, bye.  \n");
      break;

      default:
      System.out.println("\n" + "Invalid Choice." + "\n");
      getAccountType();
    }
  }

  public void getChecking(){
    System.out.println("Checking Account: ");
    System.out.println(" Type 1 - View Balance");
    System.out.println(" Type 2 - Withdraw Funds");
    System.out.println(" Type 3 - Deposit Funds");
    System.out.println(" Type 4 - Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
      System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
      getAccountType();
      break;

      case 2:
      getCheckingWithdrawInput();
      getAccountType();
      break;

      case 3:
      getCheckingDepositInput();
      getAccountType();
      break;

      case 4:
      System.out.println("Thank You for using this ATM, bye.");
      break;

      default:
      System.out.println("\n" + "Invalid Choice." + "\n");
      getChecking();
    }
  }


  public void getSaving(){
    System.out.println("Saving Account: ");
    System.out.println(" Type 1 - View Balance");
    System.out.println(" Type 2 - Withdraw Funds");
    System.out.println(" Type 3 - Deposit Funds");
    System.out.println(" Type 4 - Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
      System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
      getAccountType();
      break;

      case 2:
      getsavingWithdrawInput();
      getAccountType();
      break;

      case 3:
      getSavingDepositInput();
      getAccountType();
      break;

      case 4:
      System.out.println("Thank You for using this ATM, bye.");
      break;

      default:
      System.out.println("\n" + "Invalid Choice." + "\n");
      getChecking();
    }
  }

	}

	public void mainMenu() throws IOException {
		data.put(952141, new Account(952141, 191904, 1000, 5000));
		data.put(123, new Account(123, 123, 20000, 50000));
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\n Type 1 - Login");
				System.out.println(" Type 2 - Create Account");
				System.out.print("\nChoice: ");
				int choice = menuInput.nextInt();
				switch (choice) {
				case 1:
					getLogin();
					end = true;
					break;
				case 2:
					createAccount();
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\nThank You for using this ATM.\n");
		menuInput.close();
		System.exit(0);
	}
}
