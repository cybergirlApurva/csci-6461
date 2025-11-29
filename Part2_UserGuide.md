# Part II User Guide - Computer Architecture Simulator

## Team Members
- Apurva Tiwari
- Mihnea Popescu  
- James Xu
- Sinchana

Date: November 27, 2025

---

## Introduction

This is user guide for our computer architecture simulator project Part 2. In this part we implemented cache system and created program 2 which demonstrates the cache working with memory operations and I/O stuff.

---

## How to Run Simulator

Running the simulator is pretty straighforward, just follow these steps:

1. First open terminal on your computer
2. Then navigate to project folder:
```
   cd /path/to/csci-6461
```
   (replace with your actual path)

3. Run jar file with this command:
```
   java -jar csci-6461.jar
```

4. GUI window should open up with all the registers, memory content, cache, and control buttons

---

## Understanding the GUI Layout

When you open simulator you will see these main sections:

**Registers Section** (top):
- GPR (General Purpose Registers): GPR 0, GPR 1, GPR 2, GPR 3
- IXR (Index Registers): IXR 1, IXR 2, IXR 3
- Control Registers: PC, MAR, MBR, IR, CC, MFR

**Memory Content** (left side):
Shows the memory addresses and thier values in binary format. You can scroll to see different memory locations.

**Cache Content** (left bottom):
This shows cache statistics like hits, misses, hit rate percentage. Also shows individual cache lines with address, data, valid bit and time stamp.

**Input/Output Areas** (right side):
- Octal Input: for inputing data
- Binary Output: shows program outputs
- Console Input: where you type inputs when program asks
- Printer: displays execution messages and status

**Control Buttons** (bottom):
- Load: loads program file
- Run: executes loaded program
- Step: execute one instruction at time
- Halt: stops execution
- IPL: Initial Program Load (this button automatically loads file.txt)
- Store/Store+: for storing data

---

## How to Test Program 2

Program 2 is our main demonstration program for Part II. It searches for word in a paragraph stored in memory. Here's how to run it:

### Step by Step Instructions:

1. **Load the Program**
   - Make sure file.txt is in project directory
   - Click the **IPL** button
   - You should see "Program loaded succesfully" in Printer area
   - Memory content will fill up with program instructions and data

2. **Run the Program**
   - Click **Run** button
   - Program will start executing
   - You'll see "CPU waiting for input..." message in Printer

3. **Provide Input**
   - Click in Console Input field
   - Type a number (we tested with 5, 10, and 999)
   - Press **Enter** key (important!)
   - Program will recieve your input and continue execution

4. **Observe Results**
   - Check Printer area for execution messages
   - Look at Cache Content section for statistics
   - You should see cache hits, misses, and hit rate percentage
   - Register values will update showing final state

### Test Cases We Tried:

**Test 1: Input = 5**
- Program searches for number 5 in the paragraph
- You can see cache statistics updating
- Hit rate was around 10% on first run

**Test 2: Input = 10**  
- Searches for number 10
- Different cache pattern because accessing different memory locations

**Test 3: Input = 999**
- Number not in paragraph
- Still demonstrates cache usage while searching

---

## Understanding Cache Statistics

The cache section shows important performance metrics:

**Hits**: How many times data was found in cache (faster access)

**Misses**: How many times CPU had to fetch from main memory (slower)

**Hit Rate**: Percentage calculated as (Hits / Total Accesses) × 100

**Why is hit rate low?**
On first execution, cache is empty so we get lot of misses. If you run program again without restarting, hit rate should improve because some data already in cache.

The cache content table shows:
- **Address**: Memory address cached
- **Data**: The actual value stored
- **Valid**: Whether cache line has valid data (true/false)
- **Time**: Timestamp for replacement policy

---

## Memory Organization

Our simulator uses this memory layout:
```
Address 0-5:        System/Reserved area
Address 100-119:    Paragraph data (20 words for Program 2)
Address 200-204:    Working variables and counters
Address 1000+:      Program code starts here
```

Program 2 specifically uses:
- Location 0: Trap table base address
- Locations 100-119: Paragraph with words to search
- Location 200: Stores search word from input
- Location 201: Counter for occurences
- Location 202: Position of first match
- Location 203: Current address pointer
- Location 204: Loop counter

---

## Troubleshooting Common Issues

**Problem: Program won't load**
- Make sure file.txt exists in same directory as jar file
- Try clicking IPL button instead of Load button
- Check file permissions

**Problem: No output showing**
- Make sure you pressed Enter after typing input
- Check Printer area for messages
- Look at Binary Output and Octal Input areas

**Problem: GUI doesn't open**
- Make sure you have Java installed (version 11 or higher)
- Try running from terminal to see error messages
- Check if jar file is corrupted

**Problem: Cache statistics not updating**
- This is normal if program hasn't run yet
- Statistics update after program executes instructions
- Click Run to see cache working

---

## Program Files Included

We have several program files:

- **file.txt**: Main Program 2 (word search demonstration)
- **test4.txt**: Simple test program for basic validation
- **program1.txt**: Program from Part I
- **test1.txt, test2.txt, test3.txt**: Other test programs

---

## Tips for Using Simulator

1. Always click INIT or restart simulator between test runs for clean state
2. IPL button is easiest way to load programs (hardcoded for file.txt)
3. Watch the Printer area - it shows whats happening step by step
4. Cache statistics are cumulative, reset by restarting program
5. If program seems stuck, check if its waiting for input in Console Input field

---

## Conclusion

This simulator demonstrates complete implementation of Part II requirements including cache system, all instructions (except floating point and vector), and working I/O operations. The GUI makes it easy to see whats happening inside the computer during program execution.

For any questions or issues, check the source code in GitHub repository or contact team members.

---

## Quick Reference Commands
```bash
# Clone repository
git clone https://github.com/mihnea-popescu/csci-6461.git

# Navigate to folder
cd csci-6461

# Run simulator
java -jar csci-6461.jar
```

That's it! Hope this guide helps you use the simulator effectively.
