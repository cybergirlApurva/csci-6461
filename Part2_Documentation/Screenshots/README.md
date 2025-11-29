# Part II Screenshots Documentation

**Date**: November 27, 2025
**Program Tested**: file.txt (Program 2 - Word Search)
**Tester**: Apurva Tiwari

---

## Screenshot Descriptions

### 01_initial_state.png
Shows simulator GUI in initial clean state before loading any program. All registers are zero, cache is empty.

### 02_program_loaded.png
After clicking IPL button, program file.txt successfully loaded into memory. Memory Content section shows program instructions and data loaded at various addresses. Printer displays "Program loaded successfully."

### 03_waiting_for_input.png
Program execution started with Run button. CPU paused waiting for user input as shown in Printer area message "CPU waiting for input...". Console Input field ready for user to type.

### 04_execution_complete_input5.png
**Test Case 1: Input = 5**

Program completed execution with input value 5. Key observations:
- Printer shows: "User input: 5", "Received: 5", "Program execution finished"
- Cache statistics visible: 3 hits, 27 misses, 10.00% hit rate
- Registers updated: GPR 1 shows value 6, GPR 3 shows 5 (search word)
- IXR 1 shows final pointer value

This demonstrates successful program execution with cache tracking all memory operations.

### 05_cache_statistics.png
Close-up view of Cache Content section showing detailed statistics:
- Total Accesses: 30
- Cache Hits: 3
- Cache Misses: 27
- Hit Rate: 10.00%

Also shows individual cache lines with addresses, data values, valid bits, and timestamps. Low hit rate is expected for first execution (cold start).

### 06_memory_content.png
Memory Content after program execution showing:
- Paragraph data at addresses 100-119 (20 words searched)
- Working variables at addresses 200-204
- Search word stored correctly
- Demonstrates memory operations through cache

### 07_execution_complete_input10.png (Optional)
**Test Case 2: Input = 10**

Same program tested with different input value (10) to demonstrate:
- Program handles different inputs correctly
- Different cache access patterns
- Consistent successful execution

---

## Test Results Summary

All screenshots demonstrate:
- Program loads successfully via IPL button
- I/O operations working (IN instruction receives input)
- Program executes to completion without errors
- Cache functioning correctly with hit/miss tracking
- Statistics calculation accurate
- Memory operations going through cache
- GUI displays all information properly

**Conclusion**: Part II implementation complete and fully functional.

---

**Status**: PASSED
**Ready for Submission**: YES
