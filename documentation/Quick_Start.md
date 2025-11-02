# Quick Start Guide - CSCI 6461 Part 2

**For Graders and Users**  
**Last Updated:** November 1, 2025

---

## Running the Simulator (60 seconds)

### Step 1: Launch (10 seconds)
```bash
cd ~/Documents/GitHub/csci-6461
java -jar csci-6461.jar
```

**Expected:** GUI window opens with all panels visible

---

### Step 2: Load Program 1 (15 seconds)

**In the GUI:**
1. Find "Program File" text field at top
2. Type (or paste) the full path to program1.txt:
```
   /Users/apurvatiwari/Documents/GitHub/csci-6461/program1.txt
```
   *(Adjust path to your actual location)*

3. Click **IPL** button
4. Wait for console message: "Program loaded successfully"

**Troubleshooting:** If file not found, use absolute path:
```bash
# Get absolute path:
cd ~/Documents/GitHub/csci-6461
pwd
# Copy the output and add /program1.txt to it
```

---

### Step 3: Run Program 1 (35 seconds + input time)

1. Click **RUN** button

2. **Input Phase** - Enter 20 numbers (one at a time):
```
   Type: 100 [press Enter]
   Type: 200 [press Enter]
   Type: 300 [press Enter]
   ...
   Type: 2000 [press Enter]
```
   
   **Quick Test Data:**
```
   100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,
   1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000
```

3. **Echo Phase** - Program automatically prints all 20 numbers:
```
   Output: 100
   Output: 200
   ...
   Output: 2000
```

4. **Target Input** - Enter target number:
```
   Type: 850 [press Enter]
```

5. **View Results** - Console shows:
```
   Target: 850
   Closest: 800
   Difference: 50
```

**Done!** ✅ Program halts automatically.

---

## Alternative: Test with Smaller Program

### Using test3.txt (5 numbers instead of 20)

**Good for quick testing:**
```bash
# In Program File field:
/Users/apurvatiwari/Documents/GitHub/csci-6461/test3.txt

# Click IPL
# Click RUN
# Enter 5 numbers
# Enter target
# See result
```

**Faster for demos!**

---

## Viewing Cache Performance

### During Execution

**Watch the Cache Panel (bottom right):**
- 16 cache lines displayed
- Each shows: Address | Data | Valid | Time
- Statistics update in real-time:
  - Hits: XXX
  - Misses: XXX
  - Hit Rate: XX.X%

**Expected for Program 1:**
- Hit Rate: 70-80%
- Total Accesses: ~500
- Evictions visible when cache fills

---

## Using Single Step Mode

### For Debugging/Demo

**Instead of RUN:**
1. Load program with IPL
2. Click **STEP** button repeatedly
3. Watch each instruction execute
4. Observe register changes
5. See cache updates one at a time

**Good for demonstrations!**

---

## Manual Instruction Testing

### Test Individual Instructions

**In Console Field at top:**

**Test Arithmetic:**
```
AIR 0,10        [click Load]  → R0 = R0 + 10
SIR 1,5         [click Load]  → R1 = R1 - 5
```

**Test Logical:**
```
AND 0,1         [click Load]  → R0 = R0 & R1
ORR 0,1         [click Load]  → R0 = R0 | R1
NOT 0           [click Load]  → R0 = ~R0
```

**Test I/O:**
```
IN 0,0          [click Load]  → Input to R0
OUT 0,0         [click Load]  → Output from R0
```

---

## Common Issues & Quick Fixes

### Issue: "Program file not found"
**Fix:** Use absolute path, not relative:
```bash
# WRONG:
program1.txt

# RIGHT:
/Users/apurvatiwari/Documents/GitHub/csci-6461/program1.txt
```

---

### Issue: GUI freezes during input
**Fix:** Make sure you pressed **Enter** after typing number

---

### Issue: No output visible
**Fix:** Scroll down in console panel (output may be below visible area)

---

### Issue: Wrong results
**Fix:** 
1. Click Halt
2. Click IPL (reload program)
3. Click Run (start fresh)

---

## Performance Benchmarks

**Expected Execution Times:**
- IPL: <1 second
- Program 1 complete: ~3 seconds (excluding user input)
- Cache hit rate: 70-80%
- No errors or crashes

---

## Files Included

**Essential:**
- `csci-6461.jar` - Simulator (run this)
- `program1.txt` - Program 1 source (20 numbers)
- `program1_machine_code.txt` - Assembled binary

**Optional:**
- `program1_labels.txt` - Readable version with labels
- `test1.txt` - Basic load/store test
- `test3.txt` - Quick 5-number test
- `README.md` - Basic usage info

**Documentation:**
- `documentation/User_Guide.md` - Complete manual
- `documentation/Design_Notes.md` - Technical details
- `documentation/Test_Results.md` - Test report

**Source Code:**
- `com/project/` - All Java source files

---

## For Graders

### Verification Checklist

**Part 2 Requirements:**

✅ **Cache implemented**
- Check: Cache panel visible in GUI
- Check: Hit/Miss statistics displayed
- Check: 16 cache lines shown

✅ **All instructions work**
- Check: Run test1.txt successfully
- Check: Run test3.txt successfully
- Check: Run program1.txt successfully

✅ **Program 1 complete**
- Check: Reads 20 numbers ✅
- Check: Echoes all to console ✅
- Check: Accepts target ✅
- Check: Finds closest ✅
- Check: Displays results ✅

✅ **GUI functional**
- Check: All panels visible
- Check: Registers update
- Check: Cache displays
- Check: Console I/O works

✅ **Documentation complete**
- Check: User guide exists
- Check: Design notes exist
- Check: Test results exist
- Check: Source well-commented

---

## Quick Test Script

**Complete verification in 2 minutes:**
```bash
# 1. Launch
java -jar csci-6461.jar

# 2. Load test3.txt (quick test)
# Type in Program File: [path]/test3.txt
# Click IPL

# 3. Run
# Click RUN
# Enter: 10, 20, 30, 40, 50
# Enter target: 25
# Expected: Closest = 20 or 30

# 4. Verify cache
# Check cache panel shows activity
# Check hit rate > 0%

# 5. Load program1.txt
# Type in Program File: [path]/program1.txt
# Click IPL

# 6. Step through first few instructions
# Click STEP 5 times
# Watch registers change

# Done! ✅
```

---

## Contact

**GitHub:** https://github.com/mihnea-popescu/csci-6461

**Team:**
- Apurva Tiwari
- Mihnea Popescu
- James Xu
- Sinchana

---

## Version Info

**Simulator Version:** Part 2 Final  
**Java Version Required:** JDK 1.8+  
**Last Updated:** November 1, 2025  
**Status:** ✅ Complete

---

**End of Quick Start Guide**
