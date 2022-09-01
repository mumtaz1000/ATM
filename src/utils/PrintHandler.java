package utils;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class PrintHandler {
    public static Consumer<String> printMessage = message -> System.out.println(message);

    public static String splitFileString(List<String> listOfContacts, int option){
        String requiredData = null;

        for (String contact: listOfContacts) {
            String[] elements = contact.split(",");
            requiredData = elements[option];
        }
        return requiredData;
    }
    public static void clearScreen(){
        String operatingSystem = System.getProperty("os.name");

        if(operatingSystem.equals("Windows")) {
            clearScreenWindows();
        } else {
            clearScreenUnix();
        }
    }
    public static void menuOptionList(List<String> options){
        for(int index=0; index<options.size(); index++){
            int number = index+1;
            String label = options.get(index);

            System.out.println("["+number+"]"+ label);
        }
    }
    private static void clearScreenUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";

        Consumer<String> clearScreenFunction = clearString -> System.out.println(clearString);
        clearScreenFunction.accept(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearScreenWindows() {
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(IOException | InterruptedException error){
            System.out.println("Error while clearing screen on windows");
        }
    }
}
