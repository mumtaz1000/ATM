package account;


import java.security.NoSuchAlgorithmException;

public class Account {
    public Account(String nameNumberString) throws NoSuchAlgorithmException {
        AccountModel model = new AccountModel();
        AccountView view = new AccountView(model.getMenuOptions());
        AccountController controller = new AccountController(model, view);

        controller.requestUserInput(nameNumberString);
    }

}
