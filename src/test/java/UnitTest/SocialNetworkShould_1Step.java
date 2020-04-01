package UnitTest;

import SocialNetwork.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class SocialNetworkShould_1Step {

    SocialNetWorkApp socialNetWorkApp;
    InOrder inOrder;
    ParseCommand parseCommand;

    @BeforeEach
    public void init(){
        parseCommand = mock(ParseCommand.class);
        socialNetWorkApp = new SocialNetWorkApp(parseCommand);
        inOrder = inOrder(parseCommand);
    }

    @Test
    public void add_a_new_post(){
        socialNetWorkApp.inputCommand("Miriam -> Hola team");

        String comand = "Miriam -> Hola team";
        verify(parseCommand).parseCommand(comand);
    }

    @Test
    public void print_user_timeline(){
        socialNetWorkApp.inputCommand("Miriam -> Hola team");
        socialNetWorkApp.inputCommand("Miriam -> Ey");
        socialNetWorkApp.inputCommand("Miriam");

        inOrder.verify(parseCommand).parseCommand("Miriam -> Hola team");
        inOrder.verify(parseCommand).parseCommand("Miriam -> Ey");
        inOrder.verify(parseCommand).parseCommand("Miriam");
    }


}
