*`ChatServer.java` Code:*
![Image](chatserver_code.png)
*`ChatServer.java` Attempt 1:*
![Image](chatserver_1.png)
*`ChatServer.java` Attempt 2:*
![Image](chatserver_2.png)

**Methods Called:**
- In the screenshots, the method called is `handleRequest` in the `Handler` class which interpretes and acts on the `URI` request.
- The method is called when a request is made to the server with the path `/add-message`.

**Relevant Arguments and Field Values:**

For the request `/add-message?s=Hello&user=Diego`:
- Relevant Arguments: `URI` object with path `/add-message` and query `s=Hello&user=Diego`.
- Relevant Field Values:
  - `chats`: Initially an empty `ArrayList`.
- Changes in Field Values:
  - `chats`: Changes from empty to containing one element: "Diego: Hello".

For the request `/add-message?s=How are you&user=yash`:
- Relevant Arguments: `URI` object with path `/add-message` and query `s=world&user=Diego`.
- Relevant Field Values:
  - `chats`: Contains one element: "Diego: Hello".
- Changes in Field Values:
  - `chats`: Changes from containing one element to two elements: "Diego: Hello" and "Diego: World".

**Explanation of Field Changes:**
- The values of the `chats` field change with each request because the `handleRequest` method adds new chat messages to this list based on the incoming requests.
- If no values got changed, it would imply that either the request was invalid or it didn't match the conditions to add a message to the chat history. For example, if the request didn't contain both the `s` and `user` parameters, or if the parameters were empty, the chat history would remain unchanged.

![Image](path_private_key.png)
![Image](path_public_key.png)
![Image](no_pass_login.png)
