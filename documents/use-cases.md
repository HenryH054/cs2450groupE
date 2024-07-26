# User Stories
## User Story 1

As an instructor, I want a extremely simplified version of assembly instructions so that students are able to learn the fundamentals of assembly without having to learn the x86 instruction set.

## User Story 2

As a student, I want to learn the fundamentals of assembly while using a reliable emulator so that I am better able to understand the fundamentals of computing and can have a more holistic view of the world.

# Use Cases

Use Case 1: Save User Input

Actor: UVSim
Goal: Have UVSim save user input

Steps:

    Read code input and identify code 010.
    Ask for user input of a word (6-digit decimal number).
    Save the user-inputted word into the operand of the command code initially passed in.

Use Case 2: Output a Word

Actor: UVSim
Goal: Have UVSim output a word

Steps:

    Read input operation 011.
    Load memory array at the operand's location (e.g., 011012 would be location 012).
    Print out the word stored at the operand's location.

Use Case 3: Perform Addition Operations

Actor: UVSim
Goal: Perform addition operations

Steps:

    Read input operation 030.
    Find the operand of the initial operation.
    Add the word at the operand's location to what is currently in the accumulator.
    Assign the accumulator to the new value.

Use Case 4: Perform Subtraction Operations

Actor: UVSim
Goal: Perform subtraction operations

Steps:

    Read input operation 031.
    Find the operand of the initial operation.
    Subtract the word at the operand's location from what is currently in the accumulator.
    Assign the accumulator to the new value.

Use Case 5: Perform Division Operations

Actor: UVSim
Goal: Perform divide operations

Steps:

    Read input operation 032.
    Find the operand of the initial operation.
    Divide the word at the operand's location from what is currently in the accumulator.
    Assign the accumulator to the new value.

Use Case 6: Perform Multiplication Operations

Actor: UVSim
Goal: Perform multiplication

Steps:

    Read input command 033.
    Find the operand of the initial operation.
    Collect the word at the value of the initial operation.
    Multiply the collected word and the accumulator.
    Assign the accumulator to the new value.

Use Case 7: Load a Word into the Accumulator

Actor: UVSim
Goal: Put a word into the accumulator

Steps:

    Look for input command 020.
    Find the operand of the input.
    Access memory at the operand's location.
    Assign the accumulator to the value in memory.

Use Case 8: Store a Word from the Accumulator

Actor: UVSim
Goal: Store a word from the accumulator

Steps:

    Look for input command 021.
    Access the operand attached to the input command.
    Store information from the accumulator into the operand's location.

Use Case 9: Execute a Specific Instruction Based on Text File Input

Actor: UVSim
Goal: Execute a specific instruction based on text file input

Steps:

    Load a system file.
    Read the file one line at a time.
    On each line, parse out the operand and operation.
    Pass each operand into the associated operations function.

Use Case 10: Stop the Program from Continuing to Run

Actor: UVSim
Goal: Stop the program from continuing to run

Steps:

    Look for input command 043.
    When command 043 is passed in, stop execution of the program.

Use Case 11: Handle Expanded Memory and File Format

Actor: UVSim
Goal: Support files with up to 250 lines and 6-digit words

Steps:

    Expand internal memory registers to support addresses from 000 to 249.
    Modify the application to handle 6-digit words, ensuring proper overflow handling.
    Ensure that any command referencing a line number between 000 and 249 is valid; any command outside this range is invalid.
    Prevent the loading or editing of files with more than 250 lines.

Use Case 12: Support Old and New File Formats

Actor: UVSim
Goal: Support both 4-digit and 6-digit word files

Steps:

    Implement a way to differentiate between old and new files at load or run time.
    Edit and run both 4-digit and 6-digit word files within the application.
    Prevent mixing and matching 4-digit and 6-digit words within an individual file.

Use Case 13: Multiple File Handling

Actor: UVSim
Goal: Allow multiple files to be opened and managed simultaneously

Steps:

    Implement a system to open multiple files within the application instance (e.g., GUI tabs, sub-windows).
    Allow users to switch between, edit, and execute each file in any order.
    Ensure only one file can be executed at a time.
    Allow users to edit or execute another file only after the current file execution has finished or is manually stopped.

Use Case 14: Convert 4-Digit Files to 6-Digit Format

Actor: UVSim
Goal: Provide a conversion feature for 4-digit to 6-digit word files

Steps:

    Implement a conversion process feature in the application.
    Convert 4-digit files to 6-digit form by appending leading zeroes.
    Save the converted file to the new format.
    Ensure the conversion algorithm differentiates between function codes and raw numbers, adhering to the restriction that raw number values do not use valid function codes for the first two digits.