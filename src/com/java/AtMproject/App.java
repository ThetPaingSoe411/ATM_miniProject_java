package com.java.AtMproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       System.out.println("ATM PROJECTS");
        System.out.println("#################");
        App a = new App();
        a.display();
    }

    private void display(){
       while(true){
           Scanner input = new Scanner(System.in);
           helper h = new helper();
           accountManager accountManager = new accountManager();
           System.out.println("1. Add Account");
           System.out.println("2. Display All Accounts");
           System.out.println("3. Display Account By ID");
           System.out.println("4. Update Account By ID ");
           System.out.println("5. Transfer Money From ID To ID");
           System.out.println("6. Delete Account By ID");
           System.out.println("0. Exists");
           System.out.println();
           System.out.print("Enter your option => ");
           String option = input.nextLine();

           switch (option){
               case "1":
                   accountManager.addAccount();
                   break;
               case "2":

                   accountManager.showAllAccounts();
                   break;
               case "3":

                   accountManager.showAccountById();
                   break;
               case "4":

                   accountManager.updateAccountById();
                   break;
               case "5":

                   accountManager.TransferMoney();
                   break;
               case "6":
                   accountManager.deleteAccount();
                   break;
               case "0":
                   System.exit(0);
           }
       }
    }
}
