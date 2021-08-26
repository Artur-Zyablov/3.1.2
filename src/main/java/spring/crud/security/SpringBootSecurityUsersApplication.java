package spring.crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.crud.security.model.Role;
import spring.crud.security.model.User;
import spring.crud.security.service.RoleRepository;
import spring.crud.security.service.UserRepository;

import java.util.HashSet;

@SpringBootApplication
public class SpringBootSecurityUsersApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SpringBootSecurityUsersApplication(RoleRepository roleRepository,
                                              UserRepository userRepository,
                                              PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityUsersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");
        roleRepository.save(admin);
        roleRepository.save(user);
        roleRepository.save(new Role("ROLE_GUEST"));

        userRepository.save(new User("Arty", "Amou", 49, "admin@gmail.com",
                passwordEncoder.encode("admin"),
                new HashSet<>() {{
                    add(admin);
                    add(user);
                }}));
        userRepository.save(new User("User", "User", 46, "user@gmail.com",
                passwordEncoder.encode("user"),
                new HashSet<>() {{
                    add(user);
                }}));
    }
}
