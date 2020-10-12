package edu.neu.coe.info6205;

public class GetCurrentTime {
    private long startTime = 0l;
    private long endTime = 0l;

    public long start(){

        startTime = System.currentTimeMillis();
        return startTime;
    }

    public long end(){

        endTime = System.currentTimeMillis();
        return endTime;
    }

    public long getRunningTime(){

        long runningTime = endTime - startTime;
        return runningTime;
    }
}
