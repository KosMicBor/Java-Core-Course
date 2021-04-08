package obstacles;

public class Treadmill implements Obstacle{
    private final int TYPE_VALUE = 0;

    private int trackLength; //должна быть в метрах

    public Treadmill(int trackLength){
        this.trackLength = trackLength;
    }

    public void getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Длина беговой дорожки составляет ");
        builder.append(trackLength);
        builder.append("м.");
    }

    @Override
    public int typeOfObstacle(){
        return TYPE_VALUE;
    }

    @Override
    public int getObstacleDistance() {
        return trackLength;
    }

    @Override
    public float getObstacleHeight() {
        // nothing to do
        return 0;
    }
}
