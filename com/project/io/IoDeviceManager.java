package com.project.io;

public class IoDeviceManager {
    private final IoDevice[] devices = new IoDevice[32];

    public IoDeviceManager() {}

    public void saveDevice(int devid, IoDevice device) {
        devices[devid] = device;
    }

    public IoDevice getDevice(int devid) {
        IoDevice dev = devices[devid];
        if (dev == null) {
            throw new IllegalArgumentException("device " + devid + " is not registered!!");
        }
        return dev;
    }
}
