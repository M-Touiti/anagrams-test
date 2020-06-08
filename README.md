# Anangram Task

## Description
The aim of this test is to create an application that takes as input a given file which contains one word per line and return the list of all anagram words from it printing them on the console.

Two words are anagrams if they are written using the same exact letters. For example, ‘race’ and ‘care’ are anagrams of each other.

## Technologies
* **Java**
* **Fork/Join Framework**
* **Maven**
* **Junit**

## Requirements 
* **Maven 3 (using mvn 3.3.9 version)**
* **Java 8 (using 1.8.0_201)**

## How to build

In terminal run command:
```bash
mvn clean install
```

## How to run
After building, you can run the program using two options ; either you run it using default values without passing in your own list or by specifying the file path as a command argument:

```bash
./run.sh
    or
./run.sh <path to file>

# Example:
./run.sh
./run.sh "src/main/resources/sample.txt"
```

Or calling jar directly:

```bash
java -jar target/anagrams-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar "src/main/resources/sample.txt"
```
Example:

The content of the test file "src/main/resources/sample.txt":  
act  
cat  
tree  
race  
care  
acre  
bee

```bash
java -jar target/anagrams-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar "src/main/resources/sample.txt"

race acre care
act cat
```
