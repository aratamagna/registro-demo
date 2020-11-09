package cl.org.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ALBERTO GUERRERO CAMPOS
 */
@SpringBootApplication
@EnableAsync
@EntityScan("cl.org.signup.model")
@Import({
})
public class SignupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignupApplication.class, args);
    }
}
