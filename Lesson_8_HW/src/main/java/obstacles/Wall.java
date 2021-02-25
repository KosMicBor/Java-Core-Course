package obstacles;

public class Wall implements Obstacle{
    private int TYPE_VALUE = 1;

    private float wallHeight; //должна быть в метрах

    public Wall(float wallHeight){
        this.wallHeight = wallHeight;
    }

    public float getWallHeight() {
        return wallHeight;
    }

    public void getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Высота препятствия составляет ");
        builder.append(wallHeight);
        builder.append("м.");
    }

    @Override
    public int typeOfObstacle(){
        return TYPE_VALUE;
    }

    @Override
    public int getObstacleDistance() {
        // nothing to do
        return 0;
    }

    @Override
    public float getObstacleHeight() {

        return wallHeight;
    }
}
