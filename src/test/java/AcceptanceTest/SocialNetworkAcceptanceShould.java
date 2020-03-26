package AcceptanceTest;

import SocialNetwork.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class SocialNetworkAcceptanceShould {
    OutputConsole outputConsole;
    SocialNetWorkApp socialNetWorkApp;
    Posts postsUser;
    InOrder inOrder;
    InputCommand inputCommand;

    @Before
    public void init(){
        outputConsole = mock(OutputConsole.class);
        postsUser = new Posts();
        inputCommand = new InputCommand();
        socialNetWorkApp = new SocialNetWorkApp(postsUser, outputConsole, inputCommand);
        inOrder = inOrder(outputConsole);
    }

    @Test
    public void test(){
        //POST
        socialNetWorkApp.inputCommand("Miriam -> Hola team");
        socialNetWorkApp.inputCommand("Sandra -> Good afternoon");
        socialNetWorkApp.inputCommand("Sandra -> Nice to meet you");
        //READING
        socialNetWorkApp.inputCommand("Miriam");
        socialNetWorkApp.inputCommand("Sandra");
        //FOLLOWS
        socialNetWorkApp.inputCommand("Miriam follows Sandra");
        //WALL
        socialNetWorkApp.inputCommand("Miriam wall");

        inOrder.verify(outputConsole).printLine("Hola team");
        inOrder.verify(outputConsole).printLine("Good afternoon");
        inOrder.verify(outputConsole).printLine("Nice to meet you");
        inOrder.verify(outputConsole).printLine("Miriam - Hola team");
        inOrder.verify(outputConsole).printLine("Sandra - Good afternoon");
        inOrder.verify(outputConsole).printLine("Sandra - Nice to meet you");






    }



}
