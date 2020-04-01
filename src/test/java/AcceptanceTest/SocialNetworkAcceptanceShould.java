package AcceptanceTest;

import SocialNetwork.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class SocialNetworkAcceptanceShould {
    OutputConsole outputConsole;
    SocialNetWorkApp socialNetWorkApp;
    InOrder inOrder;
    ParseCommand parseCommand;
    Users users;

    @BeforeEach
    public void init(){
        outputConsole = mock(OutputConsole.class);
        users = new Users();
        parseCommand = new ParseCommand(outputConsole, users);
        socialNetWorkApp = new SocialNetWorkApp(parseCommand);
        inOrder = inOrder(outputConsole);
    }

    @Test
    public void Sandra_can_publish_messages_to_a_personal_timeline(){
        //POST-READ//
        socialNetWorkApp.inputCommand("Sandra -> Good afternoon");
        socialNetWorkApp.inputCommand("Sandra -> Nice to meet you");
        socialNetWorkApp.inputCommand("Sandra");

        inOrder.verify(outputConsole).printLine("Good afternoon");
        inOrder.verify(outputConsole).printLine("Nice to meet you");

    }

    @Test
    public void Miriam_can_read_all_messages_from_her_wall(){
        //POSTS
        socialNetWorkApp.inputCommand("Miriam -> Hola team");
        socialNetWorkApp.inputCommand("Sandra -> Good afternoon");
        socialNetWorkApp.inputCommand("Sandra -> Good afternoon");
        //FOLLOWS
        socialNetWorkApp.inputCommand("Miriam follows Sandra");
        //WALL
        socialNetWorkApp.inputCommand("Miriam wall");

        inOrder.verify(outputConsole).printLine("Miriam - Hola team");
        inOrder.verify(outputConsole).printLine("Sandra - Good afternoon");
        inOrder.verify(outputConsole).printLine("Sandra - Nice to meet you");
    }



}
