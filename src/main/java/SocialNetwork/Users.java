package SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class Users {

    List<User> userList = new ArrayList<>();

    public void addPost(String postMessage, String userName) {

        if(!userList.contains(userName)){
            User newUser = new User(userName);
            userList.add(newUser);
        }
        for (User user : userList){
            if (user.equals(new User(userName))){
                user.addPost(new Post(postMessage, userName));
            }
        }
    }


    public User findUser(User userComando) { //li paso user comando
        //aquest usercomando busca a la llista de users si aquest nomede user existeix
        int indexOfUser = userList.indexOf(userComando);
        if(indexOfUser == -1){
            return null;
        }
        return userList.get(indexOfUser);
    }

    public List<Post> findPostUser(User userCommando) {
        User user = findUser(userCommando);
        return user.getPosts();
    }

    public void addFriend(User user1, User user2) {
        //tenim user1 add user2 a una llista de friends
        user1.addFriend(new Friend(user2));
    }


    public List<Post> findAllPostForWall(User userName) {
        User user = findUser(userName); //existe?
        //user.getFriends();//tiene amigos?

        return user.allPostsForWall();
        //throw new UnsupportedOperationException();
    }

    public List<User> getUserList(){
        return new ArrayList<User>(userList); //copia exacta de array de users (no es getter exacte)
                                //immutabilitat, al fer new no podriem modificar la llista real
        }
}

