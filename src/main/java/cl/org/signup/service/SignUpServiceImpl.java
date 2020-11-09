package cl.org.signup.service;

import cl.org.signup.to.ErrorTO;
import cl.org.signup.to.UserTO;
import cl.org.signup.util.ExceptionUtil;
import cl.org.signup.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserService userService;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public UserTO signup(UserTO userTO) {
        UserTO taken = userService.findByMail(userTO);
        if (taken == null) {
            if (validationUtil.verifyMail(userTO.getEmail())) {
                if (validationUtil.verifyPassword(userTO.getPassword())) {
                    return userService.saveUser(userTO);
                } else {
                    ErrorTO errorTO = new ErrorTO();
                    errorTO.setMensaje("La contraseña debe contener al meno una letra Mayúscula, una letra minúscula y dos números.");
                    ExceptionUtil.create(HttpStatus.INTERNAL_SERVER_ERROR, errorTO, true);
                }
            } else {
                ErrorTO errorTO = new ErrorTO();
                errorTO.setMensaje("El formato del email es incorrecto.");
                ExceptionUtil.create(HttpStatus.INTERNAL_SERVER_ERROR, errorTO, true);
            }
        } else {
            ErrorTO errorTO = new ErrorTO();
            errorTO.setMensaje("Correo ya está registrado.");
            ExceptionUtil.create(HttpStatus.INTERNAL_SERVER_ERROR, errorTO, true);
        }
        return null;
    }
}
