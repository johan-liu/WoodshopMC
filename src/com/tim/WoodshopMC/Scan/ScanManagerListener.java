package com.tim.WoodshopMC.Scan;

import java.util.HashMap;

/**
 * Created by donald on 5/15/14.
 */
public interface ScanManagerListener {
    public void didFindSensor(ScanManager scanManager, HashMap<String, Object> sensorData);
    public void didFindThirdPackage(ScanManager scanManager);
    public void scanManagerDidStartScanning(ScanManager scanManager);
}
