package UnitTest;

import SocialNetwork.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersShould_3Step {

    @BeforeEach
    public void init(){}

    @Test
    public void check_if_user_exist_and_if_user_have_the_post(){
        //añadimos un user y su mensaje
        Users users = new Users();
        users.addPost("Hola team","Miriam");

        //esperamos que coincida con este userName, y le añadimos un post, asi testeamos que se añada
        User userExpected = new User("Miriam");
        userExpected.addPost(new Post("Hola team", "Miriam"));

        //miramos que la lista de usuarios contiene este userExpected
        assertTrue(users.getUserList().contains(userExpected));

        //como si contiene este userExpected, cogemos ese User que esta en la primera posicion de la lista (pq solo tenemos un user)
        User user = users.getUserList().get(0);
        //y cogemos su lista de posts, comparandola con el expectedUser
        assertEquals(user.getPosts(), userExpected.getPosts());
    }

    @Test
    public void check_if_userName_has_a_list_of_posts(){
        Users users = new Users();
        users.addPost("Hola team","Miriam");
        users.addPost("How are you?","Miriam");

        User userExpected = new User("Miriam");
        userExpected.addPost(new Post("Hola team","Miriam"));
        userExpected.addPost(new Post("How are you?","Miriam"));

        User user = users.getUserList().get(0);
        assertEquals(users.findPostUser(userExpected), user.getPosts());
    }

    @Test
    public void check_if_user_add_friend(){
        Users users = new Users();
        User miriamUser = new User("Miriam");
        users.addFriend(miriamUser, new User("Sandra"));

        User userMimi = new User("Miriam");
        userMimi.addFriend(new Friend(new User("Sandra")));

        assertEquals(miriamUser.getFriends(), userMimi.getFriends());
    }

    @Test
    public void check_if_user_have_the_posts_of_her_friend(){
        Users users = new Users();
        users.addPost("Hola team","Miriam");
        users.addPost("How are you?","Sandra");
        User mimiUser = users.findUser(new User("Miriam"));
        User sanUser = users.findUser((new User("Sandra")));
        users.addFriend(mimiUser, sanUser);

        User miriamUser = new User("Miriam");
        miriamUser.addPost(new Post("Hola team", "Miriam"));
        User sandraUser = new User("Sandra");
        miriamUser.addFriend(new Friend(sandraUser));
        sandraUser.addPost(new Post("How are you?", "Sandra"));

        assertEquals(users.findAllPostForWall(miriamUser), miriamUser.allPostsForWall());
    }

    @Test
    public void check_if_user_have_the_posts_of_her_multiple_friends(){
        Users users = new Users();
        users.addPost("Hola team","Miriam");
        users.addPost("Ei","Xavi");
        users.addPost("How are you?","Sandra");
        User mimiUser = users.findUser(new User("Miriam"));
        User xaviUser = users.findUser((new User("Xavi")));
        User sanUser = users.findUser((new User("Sandra")));
        users.addFriend(mimiUser, sanUser);
        users.addFriend(mimiUser, xaviUser);

        User miriamUser = new User("Miriam");
        miriamUser.addPost(new Post("Hola team", "Miriam"));
        User sandraUser = new User("Sandra");
        miriamUser.addFriend(new Friend(sandraUser));
        sandraUser.addPost(new Post("How are you?", "Sandra"));
        User xavierUser = new User("Xavi");
        miriamUser.addFriend(new Friend(xavierUser));
        sandraUser.addPost(new Post("Ei", "Xavi"));

        assertEquals(users.findAllPostForWall(miriamUser), miriamUser.allPostsForWall());
    }


}
