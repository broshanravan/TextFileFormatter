The purpose of this application is
1. reads from a single input file containing text
2. applies one or more converters (as described below)
3. writes the converted result to a single output file.


1- Converts all the '7' characters to 'e'
2- Reverses all strings
3- Removes whitespace
4- If the ASCII code of the character is between 32 and 63 inclusive, convert the character to its ASCII value plus one

The program is driven via the main method that accepts arguments as specified below:
* the input file
* the output file
* the sequence of converters to be applied
