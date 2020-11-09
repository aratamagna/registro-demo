package cl.org.signup.controller;

import cl.org.signup.model.User;
import cl.org.signup.service.SignUpService;
import cl.org.signup.service.UserService;
import cl.org.signup.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class signupController {

    @Autowired
    private UserService userService;

    @Autowired
    private SignUpService signUpService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> guardarAbogado() {
        return new ResponseEntity<List<User>>(userService.getUser(), HttpStatus.OK);
    }

    @PostMapping(
            value = "/registrar",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserTO> changeMeControllerPost(@RequestBody UserTO userTO) {
        return new ResponseEntity<UserTO>(signUpService.signup(userTO), HttpStatus.OK);
    }

}
