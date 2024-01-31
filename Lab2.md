
**Methods Called:**
- The screenshots, the method called is `handleRequest` in the `Handler` class.
- This method is called whenever a request is made to the server with the path `/add-message`.

**Relevant Arguments and Field Values:**

For the request `/add-message?s=Hello&user=jpolitz`:
- Relevant Arguments: `URI` object with path `/add-message` and query `s=Hello&user=jpolitz`.
- Relevant Field Values:
  - `chatHistory`: Initially an empty `ArrayList`.
- Changes in Field Values:
  - `chatHistory`: Changes from empty to containing one element: "jpolitz: Hello".

For the request `/add-message?s=How are you&user=yash`:
- Relevant Arguments: `URI` object with path `/add-message` and query `s=How are you&user=yash`.
- Relevant Field Values:
  - `chatHistory`: Contains one element: "jpolitz: Hello".
- Changes in Field Values:
  - `chatHistory`: Changes from containing one element to two elements: "jpolitz: Hello" and "yash: How are you".

**Explanation of Field Changes:**
- The values of the `chatHistory` field change with each request because the `handleRequest` method adds new chat messages to this list based on the incoming requests.
- If no values got changed, it would imply that either the request was invalid or it didn't match the conditions to add a message to the chat history. For example, if the request didn't contain both the `s` and `user` parameters, or if the parameters were empty, the chat history would remain unchanged.
