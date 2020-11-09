package cl.org.signup.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtil {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
            .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PASSWORD_REGEX = Pattern
            .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.{2,}\\d)[a-zA-Z\\d]{8,}$");

    public boolean verifyMail(String email) {
        boolean retorno = false;
        if (email != null && !email.isEmpty()) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
            retorno = matcher.find();
        }
        return retorno;
    }

    public boolean verifyPassword(String password) {
        boolean retorno = false;
        if (password != null && !password.isEmpty()) {
            Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
            retorno = matcher.find();
        }
        return retorno;
    }
}
