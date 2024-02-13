
Failure Inducing Input:
`@Test
    public void testAverageWithoutLowest_Failure() {
        double[] arr = {4.5, 2.5, 3.5, 2.5};
        assertEquals(3.5, averageWithoutLowest(arr), 0.001);
    }`

Non-Failure Inducing Input:
`@Test
    public void testAverageWithoutLowest_NoFailure() {
        double[] arr = {4.5, 2.5, 3.5, 5.5};
        assertEquals(4.166, averageWithoutLowest(arr), 0.001);
    }`

Symptom:
insert image

The Buggy Code:
` static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
      if(num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
  }
`

Fixed Code:
` static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { 
    return 0.0; 
    }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) {
      lowest = num; 
      }
    }
    int count = 0
    double sum = 0;
    for(double num: arr) {
      if(num != lowest) { 
      sum += num;
      count ++;
      }
    }
    return sum / count;
  }
`
In the corrected version, I added a count to keep track of the number of non-lowest numbers in the array (even if multiple are present). Instead of dividing by arr.length - 1, it divides by count to get the correct average.

*`Grep` Command*

`grep -n`

Display the matched lines and their line numbers.

`grep -B n`

Prints searched line and n lines before the result.

`grep –i`

Ignores, case for matching

`grep -l`

Displays list of a filenames only.
