# CSCI 6461 Computer Simulator - User Guide
## Part 2 Final Submission

**Team Members:** Apurva Tiwari, Mihnea Popescu, James Xu, Sinchana  
**Date:** November 1, 2025  
**Status:** ✅ FINAL SUBMISSION

---

## Table of Contents
1. [System Requirements](#system-requirements)
2. [Installation](#installation)
3. [Getting Started](#getting-started)
4. [GUI Overview](#gui-overview)
5. [Running Program 1](#running-program-1)
6. [Cache Monitoring](#cache-monitoring)
7. [Troubleshooting](#troubleshooting)

---

## System Requirements

- **Java:** JDK 1.8 or later
- **OS:** macOS, Windows, or Linux
- **Memory:** 512MB RAM minimum
- **Display:** 1024x768 or higher

---

## Installation

### Quick Start
```bash
cd ~/Documents/GitHub/csci-6461
java -jar csci-6461.jar
```

### First Time Setup
1. Clone or download the repository
2. Ensure Java is installed: `java -version`
3. Navigate to project directory
4. Launch: `java -jar csci-6461.jar`

---

## Getting Started

### Launching the Simulator
```bash
java -jar csci-6461.jar
```

The GUI will open showing:
- Register displays (GPR, IXR, PC, MAR, MBR, etc.)
- Memory viewer
- Cache display (16 lines)
- Console for input/output
- Control buttons (IPL, Run, Halt, Step, Load)

---

## GUI Overview

### Main Panels

#### **1. Register Panel**
Displays all CPU registers in real-time:
- **GPR[0-3]:** General Purpose Registers (16-bit)
- **IXR[1-3]:** Index Registers (16-bit)
- **PC:** Program Counter (12-bit)
- **MAR:** Memory Address Register (12-bit)
- **MBR:** Memory Buffer Register (16-bit)
- **IR:** Instruction Register (16-bit)
- **CC:** Condition Code (4-bit)
- **MFR:** Machine Fault Register (4-bit)

#### **2. Memory Viewer**
- Shows memory contents at current MAR address
- Displays in binary format
- Updates during execution

#### **3. Cache Display**
- Shows all 16 cache lines
- Displays: Address, Data, Valid bit, Timestamp
- Hit/Miss statistics
- Hit rate percentage

#### **4. Console**
- Input field for assembly instructions or data
- Output display for program results
- Shows execution messages

### Control Buttons

#### **IPL (Initial Program Load)**
**Purpose:** Load program from file into memory

**How to use:**
1. Type full path in "Program File" field
   - Example: `/Users/apurvatiwari/Documents/GitHub/csci-6461/program1.txt`
2. Click **IPL** button
3. Wait for "Program loaded successfully" message
4. PC is set to program start address

#### **Run**
**Purpose:** Execute loaded program continuously

**How to use:**
1. Ensure program is loaded (IPL first)
2. Click **Run** button
3. Program executes until HLT or error
4. For I/O operations, enter data when prompted

#### **Halt**
**Purpose:** Stop program execution immediately

**How to use:**
1. Click **Halt** button during execution
2. Program stops at current instruction
3. All registers preserve their values

#### **Step**
**Purpose:** Execute one instruction at a time

**How to use:**
1. Set PC to desired address (or use loaded program's PC)
2. Click **Step** button
3. Single instruction executes
4. Registers update
5. Repeat for next instruction

#### **Load**
**Purpose:** Load and execute single instruction from console

**How to use:**
1. Type assembly instruction in console field
   - Example: `LDR 0,0,10`
2. Click **Load** button
3. Instruction is assembled and executed immediately

#### **Load+**
**Purpose:** Update CPU with manually changed register values

**How to use:**
1. Manually edit any register value in GUI
2. Click **Load+** button
3. CPU updates with new values

---

## Running Program 1

### Overview
Program 1 reads 20 integers, echoes them to console, requests a target number, finds the closest number, and displays results.

### Step-by-Step Execution

#### **Step 1: Load Program**
```bash
# In Program File field, enter:
/Users/apurvatiwari/Documents/GitHub/csci-6461/program1.txt

# Click IPL button
```

#### **Step 2: Run Program**
```bash
# Click Run button
# Wait for "CPU waiting for input..." message
```

#### **Step 3: Input Phase (20 numbers)**
Enter 20 numbers one at a time:
```
Input: 100 [press Enter]
Input: 200 [press Enter]
Input: 300 [press Enter]
...
Input: 2000 [press Enter]
```

**Tips:**
- Numbers range: -32768 to 32767
- Press Enter after each number
- Watch console for confirmation

#### **Step 4: Echo Phase**
Program automatically prints all 20 numbers to console:
```
Output: 100
Output: 200
Output: 300
...
Output: 2000
```

#### **Step 5: Target Input**
```
Enter target number: 850 [press Enter]
```

#### **Step 6: View Results**
Program displays:
```
Target: 850
Closest: 800
Difference: 50
```

### Sample Test Data

**Simple Sequential Test:**
```
100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,
1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000
Target: 850
Expected: Closest = 800, Difference = 50
```

**Random Numbers Test:**
```
-500, 1234, -89, 7654, 234, -2345, 5678, 111, -777, 4321,
890, -123, 6543, 2222, -4444, 3333, -111, 9876, 555, -888
Target: 1000
Expected: Closest = 890, Difference = 110
```

---

## Cache Monitoring

### Viewing Cache Contents

**During Execution:**
- Cache panel updates in real-time
- Each line shows: Address | Data | Valid | Timestamp

**Cache Statistics:**
- **Hits:** Number of successful cache accesses
- **Misses:** Number of memory accesses
- **Hit Rate:** Percentage = (Hits / (Hits + Misses)) × 100%

### Understanding Cache Behavior

**High Hit Rate (>70%):**
- Good: Sequential memory access (loops, arrays)
- Program 1 Echo Phase: ~85% hit rate

**Low Hit Rate (<50%):**
- Normal: Random memory access
- Program 1 Input Phase: ~30% hit rate

**FIFO Replacement:**
- When cache full (16 lines), oldest line evicted
- Message: "[CACHE EVICT] Removing ADDRESS: XXXX"

### Cache Messages
```
[CACHE HIT] Read ADDRESS: 0001 -> 100
[CACHE MISS] Read ADDRESS: 0002 from MEMORY -> 200
[CACHE EVICT] Removing ADDRESS: 0015
```

---

## Troubleshooting

### Issue: "Program file not found"
**Cause:** Incorrect file path in Program File field

**Solution:**
1. Use absolute path
2. Example: `/Users/apurvatiwari/Documents/GitHub/csci-6461/program1.txt`
3. Verify file exists: `ls -lh program1.txt`

---

### Issue: "No input received"
**Cause:** Didn't press Enter after typing input

**Solution:**
1. Type number in input field
2. **Press Enter key**
3. Wait for confirmation message

---

### Issue: Program freezes during input
**Cause:** CPU waiting for input

**Solution:**
1. Check console for "CPU waiting for input..." message
2. Type number in input field
3. Press Enter
4. Program continues automatically

---

### Issue: "Illegal instruction" error
**Cause:** Invalid opcode or corrupted program

**Solution:**
1. Verify program1.txt is not corrupted
2. Re-download from GitHub
3. Try IPL again

---

### Issue: Cache not updating
**Cause:** Display refresh issue

**Solution:**
1. Use Step button to see each update
2. Cache updates after each memory access
3. Check console for cache messages

---

### Issue: Register values not changing
**Cause:** Program not running or already halted

**Solution:**
1. Check if HLT instruction executed
2. Press IPL to reload program
3. Click Run again

---

## Advanced Features

### Manual Instruction Execution

**Console Input:**
1. Type assembly instruction: `AIR 0,10`
2. Click Load
3. Instruction executes immediately
4. Check registers for result

**Supported Instructions:**
- All load/store: LDR, STR, LDA, LDX, STX
- Arithmetic: AIR, SIR, AMR, SMR, MLT, DVD
- Logical: AND, ORR, NOT, TRR
- Branches: JZ, JNE, JCC, JMA, JSR, RFS, SOB, JGE
- Shift: SRC, RRC
- I/O: IN, OUT

### Single-Step Debugging

**Purpose:** Debug programs instruction by instruction

**How to:**
1. Load program with IPL
2. Click **Step** button repeatedly
3. Watch registers update after each instruction
4. View memory/cache changes in real-time

### Memory Inspection

**View Specific Address:**
1. Manually set MAR value
2. Click Load+
3. Memory panel shows content at that address

---

## File Locations

**Important Files:**
```
csci-6461/
├── csci-6461.jar          # Simulator executable
├── program1.txt           # Program 1 source
├── program1_labels.txt    # Labeled version
├── program1_machine_code.txt  # Assembled binary
├── test1.txt              # Basic test
├── test3.txt              # Prototype test
├── README.md              # Quick reference
└── com/                   # Source code
    └── project/
        ├── cpu/
        ├── memory/
        ├── gui/
        └── util/
```

---

## Contact & Support

For questions or issues:
- Check GitHub: https://github.com/mihnea-popescu/csci-6461
- Review design notes
- Check test results documentation

---

## Appendix: Quick Reference

### Common Commands
```bash
# Launch simulator
java -jar csci-6461.jar

# Check Java version
java -version

# View program
cat program1.txt

# Check file exists
ls -lh program1.txt
```

### Keyboard Shortcuts
- **Enter:** Submit input
- **Esc:** Close dialogs
- **Ctrl+C:** (Terminal) Stop Java process

### Memory Map
```
0000-0005: Program storage
0006-0100: Program 1 data storage
0101-2047: Available memory
```

---

**End of User Guide**

**Version:** 1.0 Final  
**Last Updated:** November 1, 2025  
**Status:** ✅ Complete
