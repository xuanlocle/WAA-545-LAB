package miu.waa.xuanloc.lab1.waalab1.repository;

import miu.waa.xuanloc.lab1.waalab1.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static List<PostEntity> posts = new ArrayList<>();
    private static int postId = 4;

    static {
        PostEntity p1 = new PostEntity(1, "Title1", "Content1", "Author1");
        PostEntity p2 = new PostEntity(2, "Title2", "Content2", "Author2");
        PostEntity p3 = new PostEntity(3, "Title3", "Content3", "Author3");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return List.copyOf(posts);
    }

    @Override
    public PostEntity getPostById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createPost(PostEntity post) {
        post.setId(postId);
        postId++;
        posts.add(post);
    }

    @Override
    public List<PostEntity> getAllPostsByAuthor(String author) {
        return posts.stream().filter(post -> post.getAuthor().equalsIgnoreCase(author)).toList();
    }

    @Override
    public List<PostEntity> getAllPostsByAuthorContain(String authorContain) {
        return posts.stream().filter(post -> post.getAuthor().contains(authorContain)).toList();
    }

    @Override
    public void deletePostById(int id) {
        posts.removeIf(post -> post.getId() == id);
    }

    @Override
    public void updatePostById(int id, PostEntity postDto) {
        PostEntity toUpdate = posts.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

        if (toUpdate != null) {
            if (postDto.getAuthor() != null) {
                toUpdate.setAuthor(postDto.getAuthor());
            }
            if (postDto.getTitle() != null) {
                toUpdate.setTitle(postDto.getTitle());
            }
            if (postDto.getContent() != null) {
                toUpdate.setContent(postDto.getContent());
            }
        }

    }
}
