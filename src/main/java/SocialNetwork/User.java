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
    public List<Post> friendsPostList(){  //lista d epost de cada uno de los friends
        List<Post> temporalPost = new ArrayList<>();
        for (Friend userFriend : friendUserList) {
            List<Post> lista = userFriend.getPostsFriend();
            temporalPost.addAll(lista);
        }
        return temporalPost;
    }/*public List<Post> friendsPostList(){  //lista d epost de cada uno de los friends
        for (Friend userFriend : friendUserList) {
            return userFriend.friendsPostList1();
        }
        return getPosts();
    }*/

    /*public List<Post> friendsPostList1(){
        for (User user : userList) {
            return user.getPosts();
        }
        return null;
    }*/


    public List<Post> allPostsForWall(){
        List<Post> temporalList = new ArrayList<>();
        //juntar mis post con post de friends
        temporalList.addAll(getPosts());
        temporalList.addAll(friendsPostList());
        return temporalList;
        //throw new UnsupportedOperationException();
    }



    public List<Post> getPosts(){ //lista de post de este usuario
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

    @Override
    public String toString() {
        return userName + "-";
    }
}
