//********************************************************************
//  Account.java       Author: Lewis/Loftus/Cocking
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import java.text.NumberFormat;
import java.util.*;

public class Account
{
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();
   private Scanner scan = new Scanner(System.in);
   
   private final double RATE = 0.035;  // interest rate of 3.5%

   private int acctNumber;
   private double balance;
   private String name;

   
   /**
   * Sets up the account by defining its owner, account number,
   *  and initial balance.
   */
   public Account (String owner, int account, double initial)
   {
      name = owner;
      acctNumber = account;
      balance = initial;
   }
   
   
   
   /**
    * Sets up account with balance of 0 with just name and acct number
    */
   public Account (String owner, int account)
   {
       name = owner;
       acctNumber = account;
       balance = 0;
   }
   
   
   
   /**
   *  Validates the transaction, then deposits the specified amount
   *  into the account. Returns the new balance.
   */
   public double deposit (double amount)
   {
      if (amount < 0)  // deposit value is negative
      {
         System.out.println ();
         System.out.println ("Error: Deposit amount is invalid.");
         System.out.println (acctNumber + "  " + fmt.format(amount));
      }
      else
         balance = balance + amount;
      return balance;
   }

   
   
   
   /**
   *  Validates the transaction, then withdraws the specified amount
   *  from the account. Returns the new balance.
   */
   public double withdraw (double amount, double fee)
   {
      amount += fee;

      if (amount < 0)  // withdraw value is negative
      {
         System.out.println ();
         System.out.println ("Error: Withdraw amount is invalid.");
         System.out.println ("Account: " + acctNumber);
         System.out.println ("Requested: " + fmt.format(amount));
      }
      else
         if (amount > balance)  // withdraw value exceeds balance
         {
            System.out.println ();
            System.out.println ("Error: Insufficient funds.");
            System.out.println ("Account: " + acctNumber);
            System.out.println ("Requested: " + fmt.format(amount));
            System.out.println ("Available: " + fmt.format(balance));
         }
         else
            balance = balance - amount;

      return balance;
   }

   
   
   /**
   *  Asks the user for amount to transfer
   *  from one account to another.
   */
   public void transfer (Account acct)
   {
       System.out.print("Enter amount to transfer");
       double trans = 0;
       trans = scan.nextDouble();
       
       if (trans < 0)
       {
           System.out.println("Error. Cannot transfer negative value.");
       }
       else
       {
           if (trans > balance)
           {
               System.out.println("Error. Cannot transfer more than in account.");
               System.out.println("Transfer Amount: " + fmt.format(trans) + "\nAccount Balance: "+ fmt.format(balance));
           }
           else
           {
               balance-=trans;
               acct.deposit(trans);
               System.out.println("Transaction Complete.");
               System.out.println("Sending Account Balance: "+this.getBalance());
               System.out.println("Recieving Account Balance: "+acct.getBalance());
           }        
       }
   }

   
   
   /**
   *  Adds interest to the account and returns the new balance.
   */
   public double addInterest ()
   {
      balance += (balance * RATE);
      return balance;
   }

   
   
   /**
   *  Returns the current balance of the account.
   */
   public double getBalance()
   {
       return balance;
    }
    
    
    
   /**
   *  Returns the account number.
   */
   public double getNumber()
   {
       return acctNumber;
    }
   
    
    
   /**
   *  Returns a one-line description of the account as a string.
   */
   public String toString ()
   {
      return ("supply correct data");
   }
}
