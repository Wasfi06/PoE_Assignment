public abstract class Fine implements iFine {
    int speedLimit = 120;
    int fine;
    String name;
    int speed;
    public int getFine(int fine) {
        return fine;
    }

    public String getName(String name) {
        return name;
    }

    public int getSpeed(int speed) {
        return speed;
    }
}
