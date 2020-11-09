package cl.org.signup.service;

import cl.org.signup.model.User;
import cl.org.signup.repository.UserRepository;
import cl.org.signup.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getUser() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public UserTO saveUser(UserTO userTO) {
    UUID uuid = UUID.randomUUID();
    User user = userTO.toUser();
    user.setToken(uuid.toString());
    userRepository.save(user);
    return UserTO.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).created(user.getCreated()).lastLogin(user.getCreated()).modified(user.getModified()).active(user.isActive()).password(user.getPassword()).token(user.getToken()).build();
  }

  @Override
  public UserTO findByMail(UserTO userTO) {
    User user = userRepository.FindByEmail(userTO.getEmail());
    if (user != null) {
      return UserTO.builder().id(user.getId()).email(user.getEmail()).build();
    }
    return null;
  }
}
