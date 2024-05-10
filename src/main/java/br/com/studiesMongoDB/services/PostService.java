package br.com.studiesMongoDB.services;

import br.com.studiesMongoDB.domain.Post;
import br.com.studiesMongoDB.repositories.PostRepository;
import br.com.studiesMongoDB.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(()-> new ObjectNotFoundException("Object not found!"));
    }
}