package com.java.AtMproject;

import java.sql.SQLOutput;
import java.util.Scanner;

public class accountManager {

    private accountDAO accountDAO;
    private Scanner input;
    private helper h;

    public accountManager(){
        h =new helper();
        input = new Scanner(System.in);
        accountDAO = new accountDAO();
    }
    public void addAccount(){
        h.banner("Adding Account");
        System.out.print("Enter name : ");
        String name = input.nextLine();
        System.out.print("Enter amount : ");
        Double amount = input.nextDouble();
        System.out.print("Are you account is classial or special? c/s : ");
        char cOrs = input.next().charAt(0);
       AccountType accountType;
        if(cOrs == 'c'){
           accountType =AccountType.CLASSICAL;
        }else{
            accountType = AccountType.SPECIAL;
        }
        accountDAO.addItem(new Account(generateId(),name,amount,accountType));
        System.out.println("Account Adding Success..");
    }
    public void showAllAccounts(){
        MyArray accounts = accountDAO.showItems();
        h.banner("Display All Accounts");
        for(int i=0 ;i<accounts.getItemCount();i++){
            Account account = (Account) accounts.get(i);
            System.out.println(account.displayAccount());
        }
    }
    public void showAccountById(){
        h.banner("Display Account");
        System.out.print("Enter id to search : ");
        int id = input.nextInt();
        Account account = searchId(id);
        System.out.println(account.displayAccount());
    }
    public void updateAccountById(){
        h.banner("Update Account");
        System.out.print("Enter id to update : ");
        int id = input.nextInt();
        input.nextLine();
        Account sAccount = searchId(id);
        System.out.println(sAccount.displayAccount());
        System.out.print("Enter name to update : ");
        String uName = input.nextLine();
        System.out.print("Enter amount to update : ");
        Double uAmount = input.nextDouble();
        System.out.print("Enter account type c or s :"  );
        char cOrs = input.next().charAt(0);
        AccountType accountType;
        if(cOrs == 'c'){
            accountType = AccountType.CLASSICAL;
        }else
        {
            accountType = AccountType.SPECIAL;
        }
        accountDAO.updateAccount(new Account(id,uName,uAmount,accountType));
        System.out.println("Updating Success...");
    }
    public void TransferMoney(){
        h.banner("Transaction Money");
        MyArray accounts = accountDAO.showItems();
        System.out.print("Enter id to transfer : ");
        int tid = input.nextInt();
        input.nextLine();
        Account taccount = searchId(tid);
        System.out.println(taccount.displayAccount());
        System.out.print("Enter id to receive : ");
        int rid = input.nextInt();
        System.out.print("Enter amount to tranfer : ");
        double amount = input.nextDouble();
        Account raccount = searchId(rid);
        accountDAO.transferAccount(new Account(taccount.getId(),taccount.getName(),taccount.getAmount(),taccount.getAccountType()),amount);
        accountDAO.receiveAccount(new Account(raccount.getId(),raccount.getName(),raccount.getAmount(),raccount.getAccountType()),amount);
        System.out.println("Transaction Success");
    }
    public void deleteAccount(){
        h.banner("Delete Account");
        System.out.print("Enter id to delete : ");
        int id = input.nextInt();
        Account account = searchId(id);
        System.out.println(account.displayAccount());
        System.out.print("Are you sure to delete account ?y/n : ");
        char yORn = input.next().charAt(0);
        if(yORn == 'y'){
            accountDAO.deleteAccount(id);
            System.out.println("Account deleting Success...");
        }else{
            System.out.println("Account not to delete..");

        }
    }

    private int generateId(){
        MyArray accounts = accountDAO.showItems();
        if(!accounts.isEmpty()){
            Account lastAccount = (Account) accounts.get(accounts.getItemCount()-1);
            return lastAccount.getId()+1;
        }
        return 1001;
    }

   private Account searchId(int sId){
        Account account = null;
        MyArray accounts = accountDAO.showItems();
        for(int i=0;i<accounts.getItemCount();i++){
            Account sAccount = (Account) accounts.get(i);
            if(sAccount.getId() == sId){
                account = sAccount;
                break;
            }
        }
        return account;
   }
}
