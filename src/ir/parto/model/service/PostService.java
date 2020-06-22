package ir.parto.model.service;

import ir.parto.model.entity.Post;
import ir.parto.model.repository.PostRepository;

import java.util.List;

public class PostService {
    PostRepository postRepository = new PostRepository();

    public Post addPost(Post post){
        return postRepository.insertPost(post);
    }

    public Post updatePost(Post post){
        return postRepository.updatePost(post);
    }

    public List<Post> removePost(Post post) {
        return postRepository.deletePost(post);
    }

    public List<Post> findAllPost() {
        return postRepository.selectPost();
    }

    public Post findPost(Post post){
        return postRepository.selectOnePost(post);
    }
}
