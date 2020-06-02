# Distinct string
## Problem statement
Given a String return if it contains duplicate characters.

### Additional Constrains
The String contains only lowercase latin characters `[a-z]` and is not null.

## Solutions

### Brute force
Iterate in a outer loop over the characters of the String.
In each iteration additionally iterate over all characters further to the left and compare them.

Time Complexity: `O(n²)` because we have a loop nested within another loop and both are linearly
dependent on the length of the input.

### Sorting
Sort the characters of the String based on their ascii-value.
After that iterate over the String and compare each character with its subsequent neighbour.

Time Complexity: `O(n log n)` because we need `n log n` amount of time to sort the array and `n` to iterate
once over the array after the sorting.

### External Array
The solution makes use of the fact that we know that all characters of the input String must be
lowercase latin characters, which means their ascii-value is between (inclusively) `97` and `122`.
We instantiate a boolean array with one field for each character, which means we have an array with 
length `26` and all values are `false`. After that iterate over the String and check for each
character that the corresponding field in the boolean-array is `false` and set it to true
afterwards.

Time Complexity: `O(n)` since there is only one iteration over the String.
