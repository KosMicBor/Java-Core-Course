package participants;

public interface PhysicalActions {
    /**
     * This method makes Object to run distance
     * @param runDistance it is the distance of Obstacle
     */
    void run(int runDistance);

    /**
     * This method makes Object to jump over the wall
     * @param jumpHeight it is the height of the wall
     */
    void jump(float jumpHeight);

    /**
     * This method gets main info about the Object (name, id, weight and so on)
     */
    void info();

    /**
     * This method returns status of overcoming obstacle
     * @return true if obstacle overcame or false if it didn't
     */
    boolean getIsObstacleOvercome();
}
