package utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public interface Menus {

    default void displayMenuOptions(List<String> menuOptions){
        PrintHandler.clearScreen();
        System.out.println("Main menu options:");
        PrintHandler.menuOptionList(menuOptions);
        printRequest();
    }
         default void requestUserInput() {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                try {
                        int selectedOption = Integer.parseInt(input);

                        handleOption(selectedOption);
                }
                catch (NumberFormatException | IndexOutOfBoundsException exception) {
                        printInvalidOption();
                        printRequest();
                        requestUserInput();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
         }

        default void handleOption(int selectedOption) throws IOException, NoSuchAlgorithmException {}
        static void printInvalidOption() {
                System.out.println("⚠️ Invalid option");
        }

        static void printRequest() {
                System.out.print("Choose an option press enter: ");
        }

}
