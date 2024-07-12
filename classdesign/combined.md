# Design Document

## Functional

1. The system shall allow users to view and edit the loaded program through an edit window.

2. The system shall provide a "Save changes" checkbox, allowing users to persist modifications made to program instructions when closing the edit window.

3. The system shall provide a "Done" button in the edit window that, when clicked, closes the edit window and applies any saved changes to the program instructions in memory.

4. The system shall provide a "Scroll to top" button in the edit window, allowing users to quickly navigate to the beginning of the instruction list.

5. The system shall limit the number of instructions to a maximum of 100, automatically truncating any excess instructions when saving or running the program.

6. The system shall allow the user to load a BasicML program from a text file by selecting the “load program” button in the GUI and selecting the file in the pop up window.

7. The system shall provide an input field for user input.

8. The system shall provide an output area to display results and messages.

9. The system shall increment the program counter after executing an instruction, except for branch and halt instructions

10. The system shall truncate any instruction to four digits before loading it into memory.

11. The system shall clear the memory and reset the accumulator and program counter when a new program is loaded.

12. The system shall add a value from memory to the accumulator when an ADD instruction is executed.

13. The system shall subtract a value from memory from the accumulator when a SUBTRACT instruction is executed.

14. The system shall divide the accumulator by a value from memory when a DIVIDE instruction is executed.

15. The system shall multiply the accumulator by a value from memory when a MULTIPLY instruction is executed.

## Non-functional


1. The system shall provide scrolling functionality for the output area and edit window to accommodate longer programs or output.

2. The system shall use a consistent color scheme and layout for the GUI components.

3. The system shall display a warning message in the edit window, notifying users that instructions exceeding the 100-instruction limit will be removed.

4. The UVSim system shall provide an intuitive user interface with clear labeling and a logical workflow, making it easy for students to load, execute, and debug BasicML programs.

5. The UVSim system shall be compatible with Windows, macOS, and Linux operating systems to ensure accessibility for all students regardless of their computer platform.
