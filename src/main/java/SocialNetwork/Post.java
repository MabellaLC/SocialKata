package SocialNetwork;

import java.util.Objects;

public class Post {

    private String postMessage;

    public Post(String postMessage) {

        this.postMessage = postMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postMessage, post.postMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postMessage);
    }

    @Override
    public String toString() {
        return postMessage;
    }
}
