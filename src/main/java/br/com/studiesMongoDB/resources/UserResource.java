package br.com.studiesMongoDB.resources;

import br.com.studiesMongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User dwight = new User(1L, "Dwight", "dwight@gmail.com");
        User jim = new User(2L, "Jim", "jim@gmail.com");

        List<User> myList = new ArrayList<>();
        myList.add(dwight);
        myList.add(jim);

        return ResponseEntity.ok().body(myList);
    }
}
