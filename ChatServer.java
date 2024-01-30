import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;


class Handler implements URLHandler {
    public String handleRequest(URI url) {
        String[] chats = new String[1000];
        if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("&");
            String user = "";
            String message = "";
            for (String parameter : parameters) {
                String[] keyValue = parameter.split("=");
                if (keyValue[0].equals("user")) {
                    user = keyValue[1];
                } else if (keyValue[0].equals("s")) {
                    message = keyValue[1];
                }
            }
            String chatMessage = user + ": " + message;
            chats.add(chatMessage);
            return chats;
        }else{
            return "404 Message NOt Found";
        }
    }

}

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
