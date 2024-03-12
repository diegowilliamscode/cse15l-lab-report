### Lab 5
## Student Submission
Hello, I have ran into an unfamiliar error. I have modified my `ChatServer.java` but I do not understand the error message especially since my code is psassing the other tests.
** These are my test results: **
![Image](lab5_testresults.png)

** This is the bash script I ran: ** 
![Image](lab5_bashtest.png)

** These images show the file organization: ** 
![Image](lab5_allfiles.png)
![Image](lab5_subdirectory.png)

** This is my tester: ** 
![Image](lab5_semanticanalysistests.png)

** This is my ChatServer.java (Would have taken 3 images so I copied and pasted): **
`ChatServer.java`
```
import java.io.IOException;
import java.net.URI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class ChatHandler implements URLHandler {
  String chatHistory = "";

  public String handleRequest(URI url) {

    // expect /chat?user=<name>&message=<string>
    if (url.getPath().equals("/chat")) {
      String[] params = url.getQuery().split("&");
      String[] shouldBeUser = params[0].split("=");
      String[] shouldBeMessage = params[1].split("=");
      if (shouldBeUser[0].equals("user") && shouldBeMessage[0].equals("message")) {
        String user = shouldBeUser[1];
        String message = shouldBeMessage[1];
        this.chatHistory += user + ": " + message + "\n\n";
        return this.chatHistory;
      } else {
        return "Invalid parameters: " + String.join("&", params);
      }
    }
    else if (url.getPath().equals("/")){
      return this.chatHistory;
    }
    // expect /retrieve-history?file=<name>
    else if (url.getPath().equals("/retrieve-history")) {
      String[] params = url.getQuery().split("&");
      String[] shouldBeFile = params[0].split("=");
      if (shouldBeFile[0].equals("file")) {
        String fileName = shouldBeFile[1];
        ChatHistoryReader reader = new ChatHistoryReader();
        try {
          String[] contents = reader.readFileAsArray("chathistory/" + fileName);
          for (String line : contents) {
            this.chatHistory += line + "\n\n";
          }
        } catch (IOException e) {
          System.err.println("Error reading file: " + e.getMessage());
        }
      }
      return this.chatHistory;
    }
    // expect /save?name=<name>
    else if (url.getPath().equals("/save")) {
      String[] params = url.getQuery().split("&");
      String[] shouldBeFileName = params[0].split("=");
      if (shouldBeFileName[0].equals("name")) {
        File directory = new File("chathistory");
        File file = new File(directory, shouldBeFileName[1]);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
          writer.write(this.chatHistory);
          return "Data written to " + shouldBeFileName[1] + "in 'chat-history' folder.";
        } catch (IOException e) {
          e.printStackTrace();
          return "Error: Something wrong happen during file save, check StackTrace";
        }
      }
    }
    // expect /semantic-analysis?user=<name>
    else if (url.getPath().equals("/semantic-analysis")) {
      String[] params = url.getQuery().split("&");
      String[] shouldBeUser = params[0].split("=");
      String matchingMessages = "";
      if (shouldBeUser[0].equals("user")) {
        String[] chatHistoryArr = this.chatHistory.split("\n\n");
        int index = 0;
        while (index < chatHistoryArr.length) {
          String line = chatHistoryArr[index];
          int numberOfExclamationMarks = 0;
          String analysis = "";
          index += 1;
          int[] codePoints = new int[0];
          if (line.contains(shouldBeUser[1]))
            codePoints = line.codePoints().toArray();
            int characterIndex = 0;
            while (characterIndex < codePoints.length) {
              int character = codePoints[characterIndex];
              if (character == (int) '!') {
                numberOfExclamationMarks += 1;
              }
              if (new String(Character.toChars(character)).equals("😂")) {
                analysis = " This message has a LOL vibe.";
              }
              if (new String(Character.toChars(character)).equals("🥹")) {
                analysis = " This message has a awwww vibe.";
              } else {
              characterIndex += 1;
               }
            }
            if (numberOfExclamationMarks > 2) {
              analysis += " This message ends forcefully.";
            }
            matchingMessages += line + analysis + "\n\n";
          }
        }
      
      return matchingMessages;
    }
    return this.chatHistory;
  }
}

class ChatServer {
  public static void main(String[] args) throws IOException {
    int port = Integer.parseInt(args[0]);
    Server.start(port, new ChatHandler());
  }
}
```
## Tutor Clarification 
No problem. Good job sending all the files necessary for debugging. Can you 


## Student Modification
![Image](lab5_.png)
## Solution

## Reflection
