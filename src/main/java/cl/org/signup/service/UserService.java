package cl.org.signup.service;

import cl.org.signup.model.User;
import cl.org.signup.to.UserTO;

import java.util.List;

public interface UserService {

  public List<User> getUser();

  public UserTO saveUser(UserTO user);

  public UserTO findByMail(UserTO userTO);
}
