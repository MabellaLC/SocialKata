package SocialNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String userName;
    List<Post> postUserList = new ArrayList<>();
    List<Friend> friendUserList = new ArrayList<>();

    public User (String userName){
        this.userName = userName;
    }

    public void addPost(Post post){
        if (post != null)
            postUserList.add(post);
    }

    public void addFriend(Friend userFriend){
        //add a una llista de friends el usuari
        friendUserList.add(userFriend);

    }
    public List<Post> friendsPostList(){
        for (Friend userFriend : friendUserList) {
            return userFriend.friendsPostList();
        }
        return null;
    }



    public List<Post> getPosts(){
        return new ArrayList<Post>(postUserList);
    }
    public List<Friend> getFriends() {

        return new ArrayList<Friend>(friendUserList);}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
