# Sorting_Tool
A kotlin practice
https://hyperskill.org/projects/106

# About
In the modern world, data has become so abundant that processing it is no easy business. How can anyone make sense of all these words and numbers? In this project, you will write a program that processes textual and numeric data and sorts it. Your program will be able to determine the biggest or most frequent pieces of data and perform the necessary calculations on them. Data is waiting to be sorted!

## Learning outcomes
Become familiar with Collections and learn to work with files, arguments, and the command line.
This project is a part of the following track
**Kotlin Developer**

# Stages
## Stage 1/6
Start by teaching your program to process numeric data. Feed it some numbers and ask it to determine the largest value and its frequency in the data set.

## Stage 2/6
Data can also be words or phrases, and your program should be able to handle them just as well. Enable your program to process different types of data and determine the greatest/longest input elements, as well as their frequency in the data set.

## Stage 3/6
Start implementing the core part of your program: sorting.

## Stage 4/6
Implement sorting for all types of data and learn how to use Collections to calculate, store, and display the elements’ frequency.

## Stage 5/6
Oh no! Someone is misusing the arguments! Make the program notify users about such errors if they occur.

## Stage 6/6
Make it possible for your program to use files for input and output.

### Description
Sometimes it's useful to read data that is from a file, rather than from the standard input, and write the result to another file instead of printing it to the console. Add this functionality to your program along with the appropriate command-line argument support.

### Objectives
Update command-line arguments parsing to support the -inputFile and -outputFile arguments.

If _-inputFile_ is provided followed by the file name, read the input data from the file.

If _-outputFile_ is provided followed by the file name, output only the error messages to the console and print the results to the file.

### Examples
#### Example 1: input file is defined

`java SortingTool -sortingType byCount -inputFile input.txt`

#### Example 2: input and output files are defined

`java SortingTool -sortingType byCount -inputFile data.dat -outputFile out.txt`
