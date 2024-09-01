package backend;

import java.util.ArrayList;

public class ReservedTime extends Timeblock {
    private static ArrayList<Timeblock> reservedTimes = new ArrayList<>();

    public ReservedTime() {
        super();
    }

    public static void addReservedTime(Timeblock activity) {
        reservedTimes.add(activity);
    }

    public static ArrayList<Timeblock> getReservedTimes() {
        return reservedTimes;
    }
}
