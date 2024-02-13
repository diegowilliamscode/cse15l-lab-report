# Lab 3
## Bugs
### Failure Inducing Input:
```
@Test
    public void testAverageWithoutLowest_Failure() {
        double[] arr = {4.5, 2.5, 3.5, 2.5};
        assertEquals(3.5, averageWithoutLowest(arr), 0.001);
    }
```

### Non-Failure Inducing Input:
```
@Test
    public void testAverageWithoutLowest_NoFailure() {
        double[] arr = {4.5, 2.5, 3.5, 5.5};
        assertEquals(4.166, averageWithoutLowest(arr), 0.001);
    }
```
### Symptom:
![Image](ArrayListExample_AvgFail.png)
![Image](ArrayListExampleAvgFail.png)

### The Buggy Code:
```
static double averageWithoutLowest(double[] arr) {
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
```

### Fixed Code:
```
static double averageWithoutLowest(double[] arr) {
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
```

In the corrected version, I added a count to keep track of the number of non-lowest numbers in the array (even if multiple are present). Instead of dividing by arr.length - 1, it divides by count to get the correct average.

## `Grep` Command*

### `grep -n`

Display the matched lines and their line numbers.

**Input:** `[ddw004@ieng6-201]:Media:438$ grep -n "9/11" Terrorist_Attack.txt`

**Output:** `20:still making headlines, known as simply "9/11."`

**Input:** `[ddw004@ieng6-201]:Media:440$ grep -n "El Paso" *`

**Output:** `Entities_Merge.txt:16:stretches from El Paso to Corpus Christi, Harlingen to Austin.
Texas_Lawyer.txt:15:Austin south to the Rio Grande Valley and west to El Paso. The
man_on_national_team.txt:9:Chihuahuita home in South El Paso.
man_on_national_team.txt:53:El Paso, was one of the friends who pitched in for the trip.
man_on_national_team.txt:61:meeting, he wore the clothes all El Pasoans recognize him in: his
man_on_national_team.txt:78:At about the same time, El Paso gallery owner Adair Margo was
man_on_national_team.txt:79:involved in a Junior League of El Paso project that was documenting
man_on_national_team.txt:92:on their trips to El Paso.
[ddw004@ieng6-201]:Media:441$ `

### `grep -B n`

Prints searched line and n lines before the result.

**Input:** `[ddw004@ieng6-201]:Media:432$ grep -B 2 "grants" Legal_hotline.txt`

**Output:** `The hotline, which is part of Legal Services of Northern
California, was the only California application from 24 submitted
nationwide for $1.5 million in grants. "It was because of a`

**Input:** `[ddw004@ieng6-201]:Media:441$ grep -B 3 "operating budget" Aid_Gets_7_Million.txt`

**Output:** `the office has survived federal funding crises while similar
organizations have not. In 1995 Congress cut a third of funding to
Legal Services Corp., which caused Southern Arizona Legal Aid to
lose roughly a quarter of its $4 million operating budget.`

### `grep –i`

Ignores, case for matching

**Input:** `[ddw004@ieng6-201]:Media:435$ grep -i "MedicAid" Anthem_Payout.txt`

**Output:** `Poorest Policyholders could lose Medicaid, other Benefits
by losing their benefits under Medicaid, food-stamp and other
TO avoid losing valuable benefits such as a Medicaid-paid spot
elderly residents in Medicaid nursing-home beds.
To qualify for Medicaid and some other state-administered aid
Medicaid threshold is even lower, $1500.
spokeswoman Lauren Green-Caldwell. But after talking to Medicaid
eligibility policy for Kentucky Department for Medicaid Services.
spend the money on. Kentucky advocates and Medicaid officials
Otherwise, when you report spending to Medicaid - as is required -`

**Input:** `[ddw004@ieng6-201]:Media:444$ grep -i "UniVersITY laW sChooL" *`

**Output:** `Entities_Merge.txt:University Law School to involve students at the University of
Legal_system_fails_poor.txt:director of clinical programs at Rutgers University Law School in`

### `grep -l`

Displays list of a filenames only.

**Input:** `[ddw004@ieng6-201]:Media:433$ grep -l "findings" *`

**Output:** `Farm_workers.txt
Legal_system_fails_poor.txt
Low-income_children.txt
Survey.txt
Terrorist_Attack.txt`

**Input:** `[ddw004@ieng6-201]:Media:431$ grep -l "University" *`

**Output:** `Assuring_Underprivileged.txt
Attorney_gives_his_time.txt
Avoids_Budget_Cut.txt
Barnes_Volunteers.txt
Barnes_new_job.txt
Boone_legal_service.txt
Bridging_legal_aid_gap.txt
CommercialAppealMemphis2.txt
Donald_Hilliker.txt
Entities_Merge.txt
Ginny_Kilgore.txt
Good_guys_reward.txt
GreensburgDailyNews.txt
Helping_Hands.txt
Kiosks_for_court_forms.txt
Law-school_grads.txt
Law_Award_from_College.txt
Law_Schools.txt
Legal-aid_chief.txt
Legal_Aid_attorney.txt
Legal_system_fails_poor.txt
Lindsays_legacy.txt
Low-income_children.txt
Major_Changes.txt
Marylands_Legal_Aid.txt
Poverty_Lawyers.txt
Raising_the_Bar.txt
Survey.txt
Terrorist_Attack.txt
Texas_Lawyer.txt
Texas_Supreme_Court.txt
Valley_Needing_Legal_Services.txt
Wilmington_lawyer.txt`
