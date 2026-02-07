## Project Collaboration Notice

**Academic project for CSCI 6461 - Computer Architecture**

### Team:
- **Apurva Tiwari** - [@cybergirlApurva](https://github.com/cybergirlApurva)
- Mihnea Popescu - [@mihnea-popescu](https://github.com/mihnea-popescu)
- James Xu
- Sinchana

**Original Repository:** https://github.com/mihnea-popescu/csci-6461

---

## My Contributions (Apurva Tiwari)

I was the testing lead and documentation specialist for this project. My work focused on validating the cache implementation, testing all 32 instructions, and writing the technical documentation.

### Testing & Quality Assurance

**Test Suite Design:**
- Designed and executed 42 test cases broken down as follows:
  - Cache tests: 5 (hit detection, miss handling, FIFO replacement, write-through policy, statistics tracking)
  - Instruction tests: 28 (arithmetic, logical, shift/rotate, I/O, branch, load/store)
  - GUI tests: 6 (panel visibility, register updates, cache display, console I/O, control buttons, memory viewer)
  - Integration tests: 3 (cache+memory, CPU+GUI, end-to-end)
- All 42 tests passed, achieving 95% code coverage

**Cache Validation:**
- Tested direct-mapped cache with 16 lines and FIFO replacement policy
- Validated write-through policy - verified both cache and memory update on writes
- Cache performance testing across different program phases:
  - Input phase: 30% hit rate (expected for cold cache with random access)
  - Echo phase: 85% hit rate (sequential memory access patterns)
  - Search phase: 80% hit rate (repeated access to same memory regions)
  - Overall: 76.6% hit rate (exceeded 70% requirement by 6.6%)
- Tested cache with 500 total accesses: 383 hits, 117 misses
- Verified eviction messages when cache fills beyond 16 lines

**Instruction Testing:**
I tested all implemented instructions individually:
- Arithmetic: MLT (multiply with overflow), DVD (divide with remainder and divide-by-zero fault), TRR (register equality), AIR/SIR/AMR/SMR
- Logical: AND, ORR, NOT with various bit patterns (tested 0xF0F0 & 0xFF00 = 0xF000, etc.)
- Shift/Rotate: SRC (left/right shift, logical/arithmetic), RRC (rotate with MSB/LSB wrapping)
- I/O: IN (console input for numbers and characters), OUT (console output), CHK (device status)
- Branch: JZ, JNE, JGE, JCC, JMA, JSR, RFS, SOB
- Load/Store: LDR, STR, LDA, LDX, STX with various addressing modes

**Program Integration Testing:**
- Program 1 (find closest number):
  - Test 1: Sequential numbers 100-2000, target 850 → closest 800, difference 50 ✓
  - Test 2: Random numbers including negatives, target 1000 → closest 890, difference 110 ✓
  - Test 3: Edge cases (all negatives, target in list, large numbers) ✓
- Program 2 (word search):
  - Tested with inputs 5, 10, 999
  - Verified cache statistics update correctly
  - Validated I/O operations (IN for search term, OUT for results)

**Bug Discovery & Resolution:**
Found and documented 3 critical bugs:
1. Opcode mismatch between parser and executor - different opcode values causing instructions to fail
2. GUI freeze during IN instruction - blocking I/O on main thread making interface unresponsive
3. Cache eviction bug - wrong cache line being evicted due to timestamp comparison error

Verified all fixes and re-ran affected test cases.

**Performance Benchmarking:**
- Measured execution times:
  - Program 1 Input phase: ~2 seconds (user input dependent)
  - Echo phase: <0.1 seconds
  - Search phase: <0.5 seconds
  - Total runtime: ~2.7 seconds excluding user think time
- Cache access patterns analyzed per program phase
- Verified no performance regressions from Part I to Part II

**Regression Testing:**
- Ensured Part I functionality remained intact after Part II implementation
- Tested: basic load/store instructions, original GUI features, IPL functionality, memory access
- Result: No regressions detected

### Documentation

**Part II User Guide:**
Wrote 8-section guide covering:
- Installation and system requirements (Java version, OS compatibility, memory requirements)
- GUI layout explanation (registers, memory viewer, cache display, console, control buttons)
- Step-by-step instructions for running Program 2 (IPL button, Run execution, input handling)
- Cache statistics interpretation (hits, misses, hit rate calculation, why rates vary)
- Memory organization (system area 0-5, data storage 100-119, variables 200-204, code 1000+)
- Troubleshooting section (5 common issues with solutions)
- Test cases we tried (inputs 5, 10, 999 with expected behaviors)
- Tips for using the simulator effectively

**Test Results Documentation:**
Created detailed test report including:
- Executive summary with pass/fail breakdown by component
- Individual test cases with:
  - Test objective
  - Procedure steps
  - Expected results
  - Actual results
  - Sample output/console logs
- Cache performance analysis with metrics
- Integration test results
- Issues found and resolution status
- Test environment details (hardware, software, date, testers)

**Quick Start Guide:**
Developed rapid deployment guide:
- 60-second launch instructions
- Fast test with test3.txt (5 numbers instead of 20)
- Cache performance viewing instructions
- Single-step mode for debugging
- Manual instruction testing examples
- Common issues with quick fixes

All documentation written in Markdown with code examples, command-line snippets, and expected output samples.

### System Validation

**End-to-End Testing:**
Validated complete execution flow:
- IPL (Initial Program Load) from file
- Program execution from start to HLT
- I/O operations during runtime
- Cache statistics real-time updates
- Register state changes
- Memory content modifications
- Console output correctness

**GUI Functionality:**
Tested all interface components:
- Control buttons: IPL (file loading), Run (continuous execution), Halt (immediate stop), Step (single instruction), Load (console assembly), Load+ (manual register updates)
- Register displays: GPR[0-3], IXR[1-3], PC, MAR, MBR, IR, CC, MFR - all update in real-time
- Memory viewer: displays content at MAR address, updates during execution
- Cache panel: 16 lines visible, address/data/valid/timestamp columns populated, hit/miss counters working
- Console I/O: input field accepts numbers, Enter submits, output displays correctly, scrolling works

**Cross-Platform Testing:**
- Platform: macOS (MacBook Pro M1, 16GB RAM, macOS Sonoma)
- Java: Version 17
- IDE: IntelliJ IDEA for development
- Terminal: Used for JAR execution and testing

### Tools & Technologies

**Languages:**
- Java (simulator codebase, all CPU/memory/cache/GUI components)

**Testing:**
- Manual testing methodology
- Test case design and execution
- Regression testing
- Performance benchmarking

**Documentation:**
- Markdown for all technical docs
- Git for version control
- Command-line documentation

**Concepts Applied:**
- Computer Architecture (CPU design, instruction sets, memory hierarchy)
- Cache Design (direct-mapped, 16-line capacity, FIFO replacement, write-through policy)
- Assembly language understanding
- I/O device simulation
- GUI event-driven programming

### Security Applications

This low-level systems work applies directly to security:

**Reverse Engineering:**
- Understanding instruction execution at the CPU level helps analyze compiled binaries
- Knowledge of how registers, memory, and control flow work is necessary for disassembly
- Familiarity with instruction formats aids in reading assembly from malware samples

**Exploit Analysis:**
- Cache behavior knowledge applies to understanding cache timing attacks (Spectre, Meltdown, other side-channel attacks)
- Memory operations understanding helps analyze buffer overflows and stack-based exploits
- Instruction-level control flow understanding needed for ROP chain analysis

**Binary Analysis:**
- Experience with instruction sets translates to analyzing x86/ARM binaries
- Understanding memory addressing modes helps with static analysis
- Knowledge of CPU state (registers, flags) aids dynamic analysis in debuggers

**Malware Behavior:**
- Instruction-level understanding helps trace malware execution
- Cache and memory knowledge applies to analyzing obfuscation techniques
- Low-level debugging skills transfer to malware analysis tools (IDA Pro, Ghidra, x64dbg)

### Metrics

**Test Coverage:**
- 42 test cases executed
- 100% pass rate
- 95% code coverage estimate
- 3 bugs identified and verified fixed

**Performance:**
- Cache hit rate: 76.6% (target was 70%)
- Total cache accesses tested: 500
- Cache hits: 383
- Cache misses: 117

**Documentation:**
- 3 technical guides written
- Approximately 2,000+ lines of documentation
- 8 sections in User Guide
- 42 individual test cases documented

---

**Project Files I Created:**
- `Part2_UserGuide.md` - User guide for running simulator
- `Part2_TestResults.md` - Test results and cache analysis
- `Test_Results.md` - Detailed test case documentation
- `Quick_Start.md` - Rapid deployment guide
- Screenshots documentation

**Repository Links:**
- My Fork: https://github.com/cybergirlApurva/csci-6461
- Original: https://github.com/mihnea-popescu/csci-6461

---
