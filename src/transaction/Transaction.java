package transaction;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static utils.PrintHandler.splitFileString;

public class Transaction {
    public int getRequiredAmount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount ");
        return scanner.nextInt();
    }
    public void viewBalance(String personInformation) {
        int totalBalance = Integer.parseInt(splitFileString(Collections.singletonList(personInformation),3));
        System.out.println("Your total balance is "+totalBalance);
    }
    public String withDrawMoney(String dataString, int amount){
        int totalBalance = Integer.parseInt(splitFileString(List.of(dataString),3));

        totalBalance -= amount;
        return createRequiredString(dataString, String.valueOf(totalBalance));
    }
    public String depositeMoney(String dataString, int amount){
        int totalBalance = Integer.parseInt(splitFileString(List.of(dataString),3));

        totalBalance += amount;
        return createRequiredString(dataString, String.valueOf(totalBalance));
    }
    public String getTransferAccountName(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the user name of the person to whom you want to transfer money");
        return scanner.next();
    }
    public String createRequiredString(String dataString, String amount){
        return splitFileString(List.of(dataString),0)+","+
                splitFileString(List.of(dataString),1)+","+
                splitFileString(List.of(dataString),2)+","+
                amount;
    }
}
