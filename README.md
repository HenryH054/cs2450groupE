UVSim - A BasicML Virtual Machine Simulator

Overview
UVSim is a simple virtual machine designed to help computer science students learn about machine language and computer architecture. UVSim interprets a machine language called BasicML and allows students to execute their programs on the simulator.
UVSim consists of:
    • A CPU
    • An accumulator register
    • A main memory with 100 words, each word being a signed four-digit decimal number

Prerequisites
To run UVSim, you need:
    • Java Development Kit (JDK) installed on your machine. You can download it from Oracle's official website or AdoptOpenJDK.

Installation
    1. Download and Install JDK
        ◦ Ensure the JDK is installed and added to your system's PATH.
    2. Clone the Repository
        ◦ Clone the UVSim repository from the source.
    3. Navigate to the Project Directory
        ◦ Open a terminal or command prompt and navigate to the directory containing the UVSim project files.

How to Run UVSim
    1. Compile the program
                • In your terminal or command prompt, navigate to the src/main/java directory:
			cd path/to/UVSim/src/main/java
                • Compile the UVSim program using the following command:
			javac org/example/UVSim.java
    2. Prepare the Input File
    • Create a text file containing your BasicML instructions. Each instruction should be on a separate line. For example:
				1007 
				2008 
				3009 
				2101 
				4300
    3. Run the Program
                • Execute the UVSim program with the following command, specifying the path to your instruction file:
			java org.example.UVSim “path/to/your/Test1.txt”
	
BasicML Instruction Set
    • I/O Operations
        ◦ READ = 10: Read a word from the keyboard into a specific location in memory.
        ◦ WRITE = 11: Write a word from a specific location in memory to the screen.
    • Load/Store Operations
        ◦ LOAD = 20: Load a word from a specific location in memory into the accumulator.
        ◦ STORE = 21: Store a word from the accumulator into a specific location in memory.
    • Arithmetic Operations
        ◦ ADD = 30: Add a word from a specific location in memory to the word in the accumulator.
        ◦ SUBTRACT = 31: Subtract a word from a specific location in memory from the word in the accumulator.
        ◦ DIVIDE = 32: Divide the word in the accumulator by a word from a specific location in memory.
        ◦ MULTIPLY = 33: Multiply a word from a specific location in memory by the word in the accumulator.
    • Control Operations
        ◦ BRANCH = 40: Branch to a specific location in memory.
        ◦ BRANCHNEG = 41: Branch to a specific location in memory if the accumulator is negative.
        ◦ BRANCHZERO = 42: Branch to a specific location in memory if the accumulator is zero.
        ◦ HALT = 43: Stop the program.
Example
Example Input File (Test1.txt)
				1007 
				2008 
				3009 
				2101 
				4300

Explanation
    • 1007: Read a word from the keyboard into memory location 07.
    • 2008: Load the word from memory location 08 into the accumulator.
    • 3009: Add the word from memory location 09 to the word in the accumulator.
    • 2101: Store the result from the accumulator into memory location 01.
    • 4300: Halt the program.
