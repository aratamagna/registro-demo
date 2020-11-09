package cl.org.signup.util;

import cl.org.signup.service.SignUpServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class ValidationUtilTest {

    @InjectMocks
    private ValidationUtil validationUtil;

    @Before
    public void init() {
        validationUtil = new ValidationUtil();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyMailOK() {
        Assert.assertTrue(validationUtil.verifyMail("alberto.guerreroic@gmail.com"));
    }

    @Test
    public void verifyPasswordOK() {
        Assert.assertTrue(validationUtil.verifyPassword("Cryptosafe11"));
    }

    @Test
    public void verifyMail() {
        Assert.assertFalse(validationUtil.verifyMail(""));
    }

    @Test
    public void verifyPassword() {
        Assert.assertFalse(validationUtil.verifyPassword(""));
    }
}