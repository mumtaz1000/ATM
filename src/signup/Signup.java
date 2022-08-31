package signup;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Signup {
    public Signup() throws IOException, NoSuchAlgorithmException {
        SignupModel model = new SignupModel();
        SignupView view = new SignupView();
        SignupController controller = new SignupController(model, view);

        controller.requestSignUpInput();
    }
}
