package com.java.AtMproject;

import java.io.*;

public class accountDAO {
    private File file;



    public accountDAO(){
       file = new File("C:\\Users\\User\\IdeaProjects\\ATMproject\\src\\Files\\data.txt");

    }

    public void addItem(Account account){
        MyArray accounts = loadAllDataFromID();
        accounts.add(account);
        writeAllDataFromId(accounts);

    }
    public MyArray showItems(){

        return loadAllDataFromID();
    }
    public Account getItem(int id){
        MyArray accounts = loadAllDataFromID();
        if(!accounts.isEmpty()){
            for(int i=0;i<accounts.getItemCount();i++){
                Account account = (Account) accounts.get(i);
                if(account.getId() == id){
                    return account;
                }
            }
        }
       return null;
    }
    public void updateAccount(Account account){
        MyArray accounts = loadAllDataFromID();
        for(int i=0;i<accounts.getItemCount();i++){
            Account uAccount = (Account) accounts.get(i);
            if(uAccount.getId() == account.getId()){
                uAccount.setName(account.getName());
                uAccount.setAmount(account.getAmount());
                uAccount.setAccountType(account.getAccountType());
                break;
            }
        }
        writeAllDataFromId(accounts);
    }
    public void transferAccount(Account account,double value){
        MyArray accounts = loadAllDataFromID();
        for(int i=0;i<accounts.getItemCount();i++){
            Account taccount =(Account) accounts.get(i);
            if(account.getId() == taccount.getId()){
                taccount.setAmount(minus(taccount.getAmount(),value));
                break;
            }
        }
        writeAllDataFromId(accounts);
    }
    public void receiveAccount(Account account,double value){
        MyArray accounts = loadAllDataFromID();
        for(int i=0;i<accounts.getItemCount();i++){
            Account raccount = (Account) accounts.get(i);
            if(account.getId() == raccount.getId()){
                raccount.setAmount(add(raccount.getAmount(),value));
                break;
            }
        }
        writeAllDataFromId(accounts);
    }
    public void deleteAccount(int id){
        MyArray accounts = loadAllDataFromID();
        for(int i=0;i<accounts.getItemCount();i++){
            Account dAccount = (Account) accounts.get(i);
            if(dAccount.getId() == id){
                accounts.delete(i);
            }
        }
        writeAllDataFromId(accounts);
    }
    private double add(double value1,double value2){
        return value1+value2;
    }
    private double minus(double value1,double value2){
        return value1 - value2;
    }
   private void writeAllDataFromId(MyArray accounts){
        try(
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
                ){
           if(!accounts.isEmpty()){
               for(int i=0;i<accounts.getItemCount();i++){
                   Account account = (Account) accounts.get(i);
                       writer.write(account.displayAccount());
                       writer.write("\n");
               }
           }
        }catch(IOException e){
            e.printStackTrace();
        }
   }
   private MyArray loadAllDataFromID(){
        MyArray accounts = new MyArray(50);
        try(
                BufferedReader reader = new BufferedReader(new FileReader(file))
                ){
            String line;
          while((line = reader.readLine()) != null){
              String[] data = line.split(" ");
              int id = Integer.parseInt(data[0]);
              String name = data[1];
              Double amount =Double.parseDouble(data[2]);
              AccountType accountType = AccountType.valueOf(data[3]);
              accounts.add(new Account(id,name,amount,accountType));
          }
        }catch(IOException e){
            e.printStackTrace();
        }
        return accounts;
   }

}
