package SocialNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Friend {
    private User user;
    //List <User> userList = new ArrayList<>();

    public Friend(User user){
        //userList.add(user);
        this.user = user;
    }

    public List<Post> getPostsFriend() {
        return  user.getPosts();
    }

    /*public List<Post> friendsPostList(){
        for (User user : userList) {
            return user.getPosts();
        }
        return null;
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(user, friend.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
