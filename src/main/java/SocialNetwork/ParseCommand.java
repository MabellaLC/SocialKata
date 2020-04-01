package SocialNetwork;

import java.util.List;

public class ParseCommand {
    //Single responsability: esta clase separa el comando y ya está
    //Delega a otras clases para que hagan sus operaciones
    private final String POST_SYMBOL = " -> ";
    private final String FOLLOWS_SYMBOL = " follows ";

    private OutputConsole console;
    private Users users;

    public ParseCommand(OutputConsole console, Users users) {

        this.console = console;
        this.users = users;
    }

    public void parseCommand(String commando) {

        if (commando.contains(POST_SYMBOL)) {
            //Dividimos el input
            String[] splitCommand = commando.split(POST_SYMBOL);
            String userName = splitCommand[0];
            String postMessage = splitCommand[1];

            //Delegamos a Users para gestionar 0 y 1
            users.addPost(postMessage, userName);
            return;
        }

        //asumo que el comando es el nombre del usuario y quiero imprimir los posts
        User userCommando = new User(commando);
        //retorno una lista de post para este nombre de usuario
        List <Post> userPosts = users.findPostUser(userCommando);
        //cojo cada post de la lista y los imprimo por consola
        for (Post post: userPosts) {
            console.printLine(post.toString());
        }
        //mirar si usuario existe y cargar sus posts en orden inverso(reverse)
        //imprimir posts en orden inverso
    }
}



