package br.com.studiesMongoDB.config;

import br.com.studiesMongoDB.domain.Post;
import br.com.studiesMongoDB.domain.User;
import br.com.studiesMongoDB.dto.AuthorDTO;
import br.com.studiesMongoDB.repositories.PostRepository;
import br.com.studiesMongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User dwight = new User(null, "Dwight Schrute", "dwight@gmail.com");
        User jim = new User(null, "Jim Halpert", "jim@gmail.com");
        User pam = new User(null, "Pam Halpert", "pam@gmail.com");

        userRepository.saveAll(Arrays.asList(dwight, jim, pam));

        Post post1 = new Post(null, LocalDate.parse("14/05/2012", fmt), "Learning", "Today i start to learn this new tool.", new AuthorDTO(dwight));
        Post post2 = new Post(null, LocalDate.parse("16/05/2012", fmt), "Pathetic", "I don't understand why anyone would use this.", new AuthorDTO(dwight));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
