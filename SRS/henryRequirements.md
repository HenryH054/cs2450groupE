
# Requirements

## Functional

1) The UVSim system shall load a BasicML program into memory starting at location 00.
1) The UVSim system shall read a word from the keyboard into a specific memory location with the READ (10) instruction.
1) The UVSim system shall write a word from a specific memory location to the screen using the WRITE (11) instruction.
1) The UVSim system shall load a word from a specific memory location into the accumulator using the LOAD (20) instruction.
1) The UVSim system shall store a word from the accumulator into a specific memory location using the STORE (21) instruction.
1) The UVSim system shall add a word from a specific memory location to the accumulator using the ADD (30) instruction.
1) The UVSim system shall subtract a word from a specific memory location from the accumulator using the SUBTRACT (31) instruction.
1) The UVSim system shall divide the accumulator by a word from a specific memory location using the DIVIDE (32) instruction.
1) The UVSim system shall multiply a word from a specific memory location by the accumulator using the MULTIPLY (33) instruction.
1) The UVSim system shall jump to a specific memory location using the BRANCH (40) instruction.
1) The UVSim system shall jump to a specific memory location if the accumulator is negative using the BRANCHNEG (41) instruction.
1) The UVSim system shall jump to a specific memory location if the accumulator is zero using the BRANCHZERO (42) instruction.
1) The UVSim system shall halt the program execution with the HALT (43) instruction.
1) The UVSim system shall handle each BasicML instruction and data word as a signed four-digit decimal number.
1) The UVSim system shall execute BasicML instructions in order unless a control operation changes the flow.

## Non-functional

1) The UVSim system shall execute BasicML instructions with a response time of less than 100 milliseconds per instruction to ensure a smooth learning experience.
1) The UVSim system shall provide an intuitive user interface with clear labeling and a logical workflow, making it easy for students to load, execute, and debug BasicML programs.
1) The UVSim system shall be compatible with Windows, macOS, and Linux operating systems to ensure accessibility for all students regardless of their computer platform.
