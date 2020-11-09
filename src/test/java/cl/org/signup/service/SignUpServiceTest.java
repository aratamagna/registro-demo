package cl.org.signup.service;

import cl.org.signup.to.UserTO;
import cl.org.signup.util.ValidationUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

public class SignUpServiceTest {

    @InjectMocks
    private SignUpServiceImpl signUpService;

    @Mock
    private UserService userService;

    @Mock
    private ValidationUtil validationUtil;

    @Before
    public void init() {
        signUpService = new SignUpServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void signup() {
        UserTO userTO = new UserTO();
        userTO.setName("Alberto Guerrero Campos");
        userTO.setPassword("Cryptosafe11");
        userTO.setEmail("alberto.guerreroic@gmail.com");
        Mockito.when(userService.findByMail(userTO)).thenReturn(null);
        Mockito.when(validationUtil.verifyMail(userTO.getEmail())).thenReturn(true);
        Mockito.when(validationUtil.verifyPassword(userTO.getPassword())).thenReturn(true);
        signUpService.signup(userTO);
    }

    @Test(expected = Exception.class)
    public void signupErrorValidarMail() {
        UserTO userTO = new UserTO();
        userTO.setName("Alberto Guerrero Campos");
        userTO.setPassword("Cryptosafe11");
        userTO.setEmail("alberto.guerreroic@gmail.com");
        Mockito.when(userService.findByMail(userTO)).thenReturn(null);
        Mockito.when(validationUtil.verifyMail(userTO.getEmail())).thenReturn(false);
        Mockito.when(validationUtil.verifyPassword(userTO.getPassword())).thenReturn(true);
        signUpService.signup(userTO);
    }

    @Test(expected = Exception.class)
    public void signupErrorValidarPassword() {
        UserTO userTO = new UserTO();
        userTO.setName("Alberto Guerrero Campos");
        userTO.setPassword("Cryptosafe11");
        userTO.setEmail("alberto.guerreroic@gmail.com");
        Mockito.when(userService.findByMail(userTO)).thenReturn(null);
        Mockito.when(validationUtil.verifyMail(userTO.getEmail())).thenReturn(true);
        Mockito.when(validationUtil.verifyPassword(userTO.getPassword())).thenReturn(false);
        signUpService.signup(userTO);
    }

    @Test(expected = Exception.class)
    public void signupTaken() {
        UserTO userTO = new UserTO();
        userTO.setName("Alberto Guerrero Campos");
        userTO.setPassword("Cryptosafe11");
        userTO.setEmail("alberto.guerreroic@gmail.com");
        Mockito.when(userService.findByMail(userTO)).thenReturn(userTO);
        signUpService.signup(userTO);
    }
}