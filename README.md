# Djikstras-Shortest-Path-WordLadder-Java-Implimentation

The purpose of this project was to write, in Java, programs to investigate word
ladders composed of five letter words. A word ladder is a sequence of words, each member of
the sequence di↵ering from its predecessor in exactly one position. For example, the following
ladder, of length 6, ‘transforms’ the word flour into the word bread:
flour ! floor ! flood ! blood ! brood ! broad ! bread

A dictionary file words5.txt is used, which contains a set of nearly 2000 five-letter
words that should be used to construct ladders.

---------------------------------------------------------------------------------------------
Program 1. 

The first program reads in a dictionary file, together with two more five
letter words, i.e. the program takes 3 command-line arguments:

1. a dictionary file;
2. a start word;
3. an end word.

The program produces on the standard output channel the length of the shortest path
and a path/ladder of shortest length that transforms the start word into the end word, or
reports that no ladder is possible. The final line of output reports the execution
time of the program in seconds. (Note that it represents elapsed time, so may not be an accurate reflection
of actual running time depending on other processes that may be executing on the computer.)

----------------------------------------------------------------------------------------------
Program 2. 

The second program considers a weighted version of the word ladder problem
where the weight of a transformation (i.e. edge of the corresponding graph) is the absolute
di↵erence in the positions of the alphabet of the non-matching letter. For example, the weight
of the edge between angel and anger equals the position of r minus the position of l which is
6.

This second program implements Dijkstra’s algorithm for finding the shortest paths.
Similarly to the first case, the program reads in a dictionary file, together with two
more five letter words the program and report on the standard output channel the minimum
distance between the words together with a corresponding path, or reports that no
ladder is possible. As for the first program, the final line of output reports the execution
time of the program in seconds.

-----------------------------------------------------------------------------------------------

Enclosed is also a report specificing the intricacies of implimentations and analysis of efficiency/run-time improvements. 
