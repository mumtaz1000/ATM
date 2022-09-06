package account;


public class Account {
    public Account(){
        AccountModel model = new AccountModel();
        AccountView view = new AccountView(model.getMenuOptions());
        AccountController controller = new AccountController(model, view);

        controller.requestUserInput();
    }

}
