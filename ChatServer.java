import java.io.*;
import java.net.URI;
import java.util.ArrayList;


class Handler implements URLHandler {
    ArrayList<String> chats = new ArrayList<>();
    public String handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("&");
            String user = "";
            String message = "";
            for (String parameter : parameters) {
                String[] type = parameter.split("=");
                if (keyValue[0].equals("user")) {
                    user = type[1];
                } else if (type[0].equals("s")) {
                    message = type[1];
                }
            }
            String chatMessage = user + ": " + message;
            chats.add(chatMessage);
            String response = "";
            for (String chat : chats) {
                response += chat + "\n";
            }
            return response;
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
