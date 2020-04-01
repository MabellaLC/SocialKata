package SocialNetwork;

public class SocialNetWorkApp {

    private ParseCommand parseCommand;

    public SocialNetWorkApp(ParseCommand parseCommand){
        this.parseCommand = parseCommand;
    }

    public void inputCommand(String command) {
        parseCommand.parseCommand(command);

    }

}
