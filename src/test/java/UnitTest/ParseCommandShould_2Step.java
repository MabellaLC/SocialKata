package UnitTest;

import SocialNetwork.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ParseCommandShould_2Step {
    OutputConsole consoleOutput;
    Users users;

    @BeforeEach
    public void init(){
        consoleOutput = mock(OutputConsole.class);

    }

    @Test
    public void check_process_command_post(){
        //mockeamos users para falsear el contenido de la clase
        users = mock(Users.class);

        ParseCommand parseCommand = new ParseCommand(consoleOutput, users);
        parseCommand.parseCommand("Miriam -> Hola team");

        //users como command, no hay queries(queries=preguntas/pedir externamente)
        //verificamos que el comando se ha partido y llega a la función addPost correctamente (función no imlpementada aún)
        verify(users).addPost("Hola team","Miriam");
    }

    @Test
    public void check_process_command_read(){
        //mockeamos users para falsear el contenido de la clase
        users = mock(Users.class);
        //creamos una fake list de post que sera el retorno de la función findPostUser
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("Hola team", "Miriam"));
        postList.add(new Post("Eiiii", "Miriam"));
        postList.add(new Post("How are you?", "Miriam"));

        //fake de la función de findPostUser amb el seu retorn sense implementar a la clase, ja que fem mock
        //en este momento esta función retorna una ¡Excepción!
        when(users.findPostUser(new User("Miriam"))).thenReturn(postList);

        //pasem comandos
        ParseCommand parseCommand = new ParseCommand(consoleOutput, users);
        //introducimos varios post
        parseCommand.parseCommand("Miriam -> Hola team");
        parseCommand.parseCommand("Miriam -> Eiiii");
        parseCommand.parseCommand("Miriam -> How are you?");
        //solo con el nombre nos deberia retornar una lista de post introducidos anteriormente
        //si no existe el usuario no devuelve nada
        parseCommand.parseCommand("Miriam");


        verify(consoleOutput).printLine("How are you?");
        verify(consoleOutput).printLine("Eiiii");
        verify(consoleOutput).printLine("Hola team");
    }


    @Test
    public void check_process_command_follow(){
        users = mock(Users.class);

        User user1 = new User("Miriam");
        User user2 = new User("Sandra");

        when(users.findUser(any())).thenReturn(user1, user2);

        ParseCommand parseCommand = new ParseCommand(consoleOutput, users);

        parseCommand.parseCommand("Miriam follows Sandra");

        //users como command, no hay queries
        verify(users).addFriend(new User("Miriam"),new User("Sandra"));
    }

    @Test
    public void check_process_command_wall(){
        //mockeamos users para falsear el contenido de la clase
        users = mock(Users.class);

        //creamos una fake list de post que sera el retorno de la función findAllPostForWall
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("Hola team", "Miriam"));
        postList.add(new Post("How are you?", "Sandra"));

        //fake de la función de findAllPostForWall amb el seu retorn sense implementar a la clase, ja que fem mock
        //en este momento esta función retorna una ¡Excepción!
        when(users.findAllPostForWall(new User("Miriam"))).thenReturn(postList);

        ParseCommand parseCommand = new ParseCommand(consoleOutput, users);

        parseCommand.parseCommand("Miriam -> Hola team");
        parseCommand.parseCommand("Miriam follows Sandra");
        parseCommand.parseCommand("Sandra -> How are you?");
        parseCommand.parseCommand("Miriam wall");


        verify(consoleOutput).printLine("Miriam - Hola team");
        verify(consoleOutput).printLine("Sandra - How are you?");
    }

}
