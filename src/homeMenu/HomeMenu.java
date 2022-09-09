package homeMenu;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class HomeMenu {
    public HomeMenu() throws IOException, NoSuchAlgorithmException {
        HomeMenuModel model = new HomeMenuModel();
        HomeMenuView view = new HomeMenuView(model.getMenuOptions());
        HomeMenuController controller = new HomeMenuController(model, view);

        controller.requestUserInput();
    }
}