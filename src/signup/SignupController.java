package signup;

import utils.PrintHandler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SignupController {
    private SignupModel model;
    private SignupView view;
    private final Scanner scanner;
    public SignupController(SignupModel model, SignupView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }
    public void requestSignUpInput() throws IOException, NoSuchAlgorithmException {
        String input;

        System.out.println("Signup menu");
        PrintHandler.printMessage.accept("Enter your full name");
        input = scanner.nextLine();
        model.setFullname(input);
        PrintHandler.printMessage.accept("Enter your user name");
        input = scanner.nextLine();
        model.setUsername(input);
        PrintHandler.printMessage.accept("Enter password");
        input = scanner.nextLine();
        model.setPassword(input);
        PrintHandler.printMessage.accept("Welcome "+model.getFullname());
        model.createNewUserInFile();
    }


}
