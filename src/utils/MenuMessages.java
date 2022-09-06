package utils;

public abstract class MenuMessages {
    public void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public void printRequest() {
        System.out.print("Choose an option press enter: ");
    }
}
