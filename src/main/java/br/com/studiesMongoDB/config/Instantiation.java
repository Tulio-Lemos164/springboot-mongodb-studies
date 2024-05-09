package br.com.studiesMongoDB.config;

import br.com.studiesMongoDB.domain.User;
import br.com.studiesMongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User dwight = new User(null, "Dwight Schrute", "dwight@gmail.com");
        User jim = new User(null, "Jim Halpert", "jim@gmail.com");
        User pam = new User(null, "Pam Halpert", "pam@gmail.com");

        userRepository.saveAll(Arrays.asList(dwight, jim, pam));
    }
}
