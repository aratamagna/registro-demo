package cl.org.signup.to;

import cl.org.signup.model.User;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTO implements Serializable {
    private static final long serialVersionUID = 7713925588372696673L;
    private String token;
    private Long id;
    private String name;
    private String email;
    private String password;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private boolean active;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User toUser() {
        Date now = new Date();
        User u = new User();
        u.setId(this.id);
        u.setName(this.name);
        u.setEmail(this.email);
        u.setPassword(this.password);
        u.setCreated(now);
        u.setModified(now);
        u.setActive(true);
        return u;
    }
}
