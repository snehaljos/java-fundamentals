# Anagram
## Problem statement
Given a two Strings return if they are Anagrams of each other. A String is an Anagram of another String
if its characters can be rearranged to form the other String.

**Example:** AABB -> ABBA (true)
<br>ABC -> ABCD (false)

## Solutions

### Sorting
Sort the characters of the Strings.
After that, iterate over both String and compare the values at each position.

Time Complexity: `O(n log n)` because we need `n log n` amount of time to sort the Strings and `n` to iterate
once over the Strings after the sorting.

### External Map
Another option is to iterate over the first String and store the occurrences of each character within a HashMap.
After that, we iterate over the second String and check if the occurrences are equal.

Time Complexity: `O(n)` where n is the length of both Strings since there is only one iteration over each String.<br>
Space Complexity: `O(n)`where n is the amount of different symbol that the Strings contain, as we need to store them in our Map.
