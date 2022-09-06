package account;

import utils.FileHandler;
import utils.MenuMessages;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class AccountModel {
    private final List<String> menuOptions = List.of("View balance", "Withdraw", "Deposite", "Transfer");
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        boolean logout = false;
        switch (selectedOption) {
            case 1 -> System.out.println("View balance");
            case 2 -> System.out.println("Withdraw");
            case 3 -> System.out.println("Deposite");
            case 4 -> System.out.println("Transfer");
            case 5 -> logout = true;
            default -> throw new IndexOutOfBoundsException();
        }
    }
    protected void viewBalance(String filename) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
        String inputFromFile;
        FileHandler fileObject = new FileHandler();

        fileObject.createFile();
        while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
            inputFromFile = randomAccessFile.readLine();
            System.out.println("Your output is "+inputFromFile);
        }
    }
}
