package com.maersk.eggtimer.utilities;

public class TimerHandler {
    private static int time;

    public TimerHandler() {
    }

    public static int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
