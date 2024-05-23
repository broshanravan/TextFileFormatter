Fruugo Programming Test
=======================

Note the submission requirements below.

Write a simple program with plain old Java (no frameworks) that:

1. reads from a single input file containing text
2. applies one or more converters (as described below)
3. writes the converted result to a single output file.

You are required to provide four standard converters:

[1] Converts all the '7' characters to 'e'
[2] Reverses all strings
[3] Removes whitespace
[4] If the ASCII code of the character is between 32 and 63 inclusive, convert the character to its ASCII value plus one

The program should be driven via a main method that accepts program arguments to specify:
* the input file
* the output file
* the sequence of converters to be applied

The sequence length must be between 1 and 20, and any converter may be invoked multiple times.

For example, the program arguments might look something like:
input1.txt output-1-2.3.1.2.txt 2 3 1 2 4

We are expecting there to be a future requirement for significantly more converters.

Input files can be found in the 'input' directory in this project's root.
Output files should go in the 'output' directory in this project's root.

You may use the web as a resource.

Submitting your Solution: Requirements
======================================

Please submit clean code.

Rename the ZIP to include your full name

Please submit your ZIP with detailed instructions for how to run your solution in a file called INSTRUCTIONS.
