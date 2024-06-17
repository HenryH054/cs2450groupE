# User Stories
## User Story 1

As an instructor, I want a extremely simplified version of assembly instructions so that students are able to learn the fundamentals of assembly without having to learn the x86 instruction set.

## User Story 2

As a student, I want to learn the fundamentals of assembly while using a reliable emulator so that I am better able to understand the fundamentals of computing and can have a more holistic view of the world.

# Use Cases
1) Actor: UVSim
  * Read code input and identify code 10
  * Ask for user input of a word(4-digit decimal number)
  * Save the user inputted word into the operand of the command code initially passed in
Goal: Have UVSim save user input

2) Actor: UVSim
  * Read input operation 11
  * Load memory array at the operands location(eg: 1112 would be location 12)
  * print out word stored at operands location
Goal: Have UVSim output a word

3) Actor: UVSim
  * Read input operation 30
  * Find the operand of the initial operation
  * Add the word at operands location to what is currently in the accumulator
  * Assign accumulator to the new value
Goal: Perform addition operations

4) Actor: UVSim
  * Read input operation 31
  * Find the operand of the initial operation
  * Subtract the word at operands location from what is currently in accumulator
  * Assign accumulator to the new value
Goal: Perform subtraction operations

5) Actor: UVSim
  * Read input operation 32
  * Find the operand of the initial operation
  * Divide the word at operands location from what is currently in accumulator
  * Assign accumulator to the new value
Goal: Perform divide operations

6) Actor: UVSim
  * Read input command 33
  * Find the operand of the initial operation
  * Collect the word at the value of the initial operation
  * Multiply the collected word and the accumulator
  * Assign the accumulator to the new value
Goal: Perform multiplication

7) Actor: UVSim
  * Look for input command 20
  * Find operand of input
  * access memory at operands location
  * assign accumulator to the value in memory
Goal: Put a word into the accumulator

8) Actor: UVSim
  * Look for input command 21
  * Access operand attached to input command
  * store information from accumulator into operands location
Goal: Store a word from accumulator

9) Actor: UVSim
  * Load a system file
  * read file one line at a time
  * on each line parse out operand and operation
  * pass each operand into associated operations function
Goal: Execute a specific instruction based on text file input

10) Actor: UVSim
  * Look for input command 43
  * When command 43 is passed in stop execution of program.
Goal: Stop the program from continuing to run
