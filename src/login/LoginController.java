package login;

import utils.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LoginController{
    private final LoginView view;
    private final LoginModel model;
    private final Scanner scanner;



    public LoginController(LoginView view, LoginModel model){
        this.view = view;
        this.model = model;
        this.scanner = new Scanner(System.in);
    }
    public void requestUserInput() throws IOException, NoSuchAlgorithmException {
        model.requestToLogin();
    }


}
