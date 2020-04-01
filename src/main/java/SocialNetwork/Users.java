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
                user.addPost(new Post(postMessage));
            }
        }
    }


    public User findUser(User user) {
        //li paso user comando
        //aquest usercomando busca a la llista de users si aquest nome de user existeix
        //si existeix em quedo el user que ja hi es a la llista
        throw new UnsupportedOperationException();
    }

    public List<Post> findPostUser(User userCommando) {
        throw new UnsupportedOperationException();
    }

    public List<User> getList (){
        return new ArrayList<User>(userList); //copia exacta de array de users (no es getter exacte)
                                //immutabilitat, al fer new no podriem modificar la llista real
        }
}

