package obstacles;

public interface Obstacle {

    /**
     * This method prints into the console main obstacle parameters
     */
    void getInfo();

    /**
     * The method returns type of obstacle
     * @return int value which corresponds to the type of current obstacle object
     */
    int typeOfObstacle();

    /**
     * The method returns the distance value of obstacle (if it has this field)
     * @return int value of obstacle's distance
     */
    int getObstacleDistance();

    /**
     * The method returns the height value of obstacle (if it has this field)
     * @return float value of obstacle's height
     */
    float getObstacleHeight();
}
