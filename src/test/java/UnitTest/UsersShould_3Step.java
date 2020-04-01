package UnitTest;

import SocialNetwork.Post;
import SocialNetwork.User;
import SocialNetwork.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersShould_3Step {

    @BeforeEach
    public void init(){}

    @Test
    public void check_if_user_exist_and_if_he_have_the_post(){
        //añadimos un user y su mensaje
        Users users = new Users();
        users.addPost("Hola team","Miriam");

        //esperamos que coincida con este userName, y le añadimos un post, asi testeamos que se añada
        User userExpected = new User("Miriam");
        userExpected.addPost(new Post("Hola team"));

        //miramos que la lista de usuarios contiene este userExpected
        assertTrue(users.getList().contains(userExpected));

        //como si contiene este userExpected, cogemos ese User que esta en la primera posicion de la lista (pq solo tenemos un user)
        User user = users.getList().get(0);
        //y cogemos su lista de posts, comparandola con el expectedUser
        assertEquals(user.getPosts(), userExpected.getPosts());
    }

    @Test
    public void test(){


        //users retorni na llista de posts (copia)
    }

    //test ver que tiene dos post i un solo usuario no 2
}
