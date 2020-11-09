package cl.org.signup.service;

import cl.org.signup.model.User;
import cl.org.signup.repository.UserRepository;
import cl.org.signup.to.UserTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        userService = new UserServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveUser() {
        UserTO userTO = new UserTO();
        userTO.setName("Alberto Guerrero Campos");
        userTO.setPassword("Cryptosafe11");
        userTO.setEmail("alberto.guerreroic@gmail.com");
        User user = userTO.toUser();
        user.setToken("randomstring");
        user.setActive(true);
        user.setModified(new Date());
        user.setCreated(new Date());
        user.setId(1L);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        userService.saveUser(userTO);
    }

    @Test
    public void findByMail() {
        UserTO userTO = new UserTO();
        userTO.setName("Alberto Guerrero Campos");
        userTO.setPassword("Cryptosafe11");
        userTO.setEmail("alberto.guerreroic@gmail.com");
        userService.findByMail(userTO);
    }
}