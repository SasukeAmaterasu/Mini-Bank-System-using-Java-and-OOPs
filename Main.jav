import java.util.*;


//Abstract class

abstract class BankAccount{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accNum, String name, double bal){
        this.accountNumber = accNum;
        this.accountHolderName = name;
        this.balance = bal;
    }

    public String getAccountNumber(){ return accountNumber;}
    public String getAccountHolderName(){ return accountHolderName;}
    public double getBalance(){ return balance;}

    protected void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited:"+amount);
        }
        else{
            System.out.println("Invalid deposit amount");
        }

    }
    public abstract void withdraw(double amount);
 }

 //Saving Account

 class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accNum, String name, double balance,double interestRate){
        super(accNum, name, balance);
        this.interestRate = interestRate;
    }
     
    @Override
    public void withdraw(double amount){
        if(amount>getBalance()){
           System.out.println("Insufficient funds!!!!");
           System.out.println("Amount can be withdraw:"+getBalance());
        } 
        else{
           setBalance(getBalance()-amount);
            System.out.println("Withdrawn"+amount);
        }
    }

    public void addInterest(){
        double interest = getBalance()*interestRate/100;
        setBalance(getBalance()+interest);
        System.out.println("Interest added:"+interest);
        System.out.println("Total Balance:"+getBalance());
    }
 }

 //Current Account

 class CurrentAccount extends BankAccount{
    private double overdraftLimit;

    public CurrentAccount(String accNum,String name, double balance, double overdraftLimit){
        super(accNum, name, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void withdraw(double amount){
        if(amount>0 && getBalance()+overdraftLimit>=amount){
            setBalance(getBalance()-amount);
            System.out.println("Withdraw:"+amount);
            System.out.println("Remaining Balance:"+getBalance());
        }
        else{
            System.out.println("Insufficient funds!!!");
            System.out.println("Amount can be withdraw:"+getBalance()+overdraftLimit);

        }
    }

    
 }

 class Bank{
   private List<BankAccount> accounts = new ArrayList<>();

   public void createAccount(BankAccount account){
    accounts.add(account);
    System.out.println("Account created succcessfully!");
   }

   public BankAccount getAccountByNumber(String accountNumber){
    for(BankAccount acc: accounts){
        if(acc.getAccountNumber().equals(accountNumber)){
            return acc;
        }
    }
    return null;
   }
   public void displayAllAccount(){
    for(BankAccount acc: accounts){
        System.out.println(acc.getAccountNumber()+" - "+acc.getAccountHolderName()+"-Balance: "+acc.getBalance());
    }
   }
 }

 public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();

        while (true) {
            System.out.println("\n=== Mini Bank System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. view All Accounts");
            System.out.println("6. Exit");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Account Number:");
                    String accnum = sc.nextLine();
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Initial Balance:");
                    double balance = sc.nextDouble();
                    System.out.println("Account Type (1-Saving   2-Current )");
                    int type = sc.nextInt();
                    if(type==1){
                        b.createAccount(new SavingsAccount(accnum, name, balance,0.05));
                    }
                    else{
                        b.createAccount(new CurrentAccount(accnum, name, balance, 5000));
                    }
                    break;

                case 2:
                     System.out.println("Enter Account Number:");
                     accnum = sc.nextLine();
                     BankAccount acc = b.getAccountByNumber(accnum);
                     if(acc!=null){
                        System.out.println("Enter amount:");
                        acc.deposit(sc.nextDouble());
                     }
                     else{
                        System.out.println("Account not found!");
                     }
                     System.out.println("Balance: "+acc.getBalance());
                     break;

                case 3:
                    System.out.println("Enter Account Number:");
                    accnum = sc.nextLine();
                    acc = b.getAccountByNumber(accnum);
                    if(acc!=null){
                        System.out.println("Enter the amount: ");
                        acc.withdraw(sc.nextDouble());
                    }
                    else{
                        System.out.println("Account not found!");
                    }
                    System.out.println("Balance: "+acc.getBalance());
                    break;

                case 4:
                      System.out.println("Enter the Account Number: ");
                      accnum = sc.nextLine();
                      acc = b.getAccountByNumber(accnum);
                      if(acc!=null){
                        System.out.println("Balance "+acc.getBalance());
                      }
                      else{
                        System.out.println("Accont not found!");
                      }
                      break;

                case 5:
                     b.displayAllAccount();
                     break;

                case 6:
                     System.out.println("Exiting...");
                     return;

                default:
                    System.out.println("Invalid choice!");
            }
            sc.close();
        }
        
    }
 }
