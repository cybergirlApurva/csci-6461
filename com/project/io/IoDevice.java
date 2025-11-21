package com.project.io;

import com.project.cpu.Cpu;

// basic class for IoDevice
// ready flag
// read from keyboard
// write to console
public abstract class IoDevice {
    protected boolean ready = false;

    public String read(Cpu cpu) {
        return cpu.waitForInput();
    }

    public void write(String value) {
        System.out.println("WRITTEN VALUE TO DEVICE: " + value);
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}