**Longest consecutive string problem**

Given an array(list) strarr of strings with n size and an integer k. The task is to return the first longest string consisting of k consecutive strings taken in the array.

**Example:**

strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2

Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
The first that came is "folingtrashy" so
longest_consec(strarr, 2) should return ONLY "folingtrashy".
If either of following constraints are met, the method should return an empty string.

**Constraints**

0 < k < n