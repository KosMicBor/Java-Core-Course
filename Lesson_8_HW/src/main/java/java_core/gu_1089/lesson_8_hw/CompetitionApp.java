package java_core.gu_1089.lesson_8_hw;

import obstacles.Obstacle;
import obstacles.Treadmill;
import obstacles.Wall;
import participants.Cat;
import participants.Human;
import participants.PhysicalActions;
import participants.Robot;

public class CompetitionApp {
    public static void main(String[] args) {
        int runDistance;
        float jumpHeight;

        PhysicalActions[] participantsArray = new PhysicalActions[3];
        participantsArray[0] = new Human("Nick", 28, 90, 500, 1.5f);
        participantsArray[1] = new Robot("NC-82TA", 120, 1000, 3);
        participantsArray[2] = new Cat("Simon", "Black", 7, 6, 100, 0.5f);

        participantsArray[0].info();
        participantsArray[1].info();
        participantsArray[2].info();

        Obstacle[] obstacleCourse = {new Treadmill(500),
                                     new Wall(1),
                                     new Treadmill(400),
                                     new Wall(1.5f),
                                     new Treadmill(900)
        };


        for (int i = 0; i < participantsArray.length; i++){
            for (int j = 0; j < obstacleCourse.length; j++){
                runDistance = obstacleCourse[j].getObstacleDistance();
                jumpHeight =  obstacleCourse[j].getObstacleHeight();
                if (obstacleCourse[j].typeOfObstacle() == 0){
                    participantsArray[i].run(runDistance);
                   if (!participantsArray[i].getIsObstacleOvercome()){
                       System.out.println("Участник выбыл с дистанции");
                       break;
                   }
                } else if (obstacleCourse[j].typeOfObstacle() == 1){
                    participantsArray[i].jump(jumpHeight);
                    if (!participantsArray[i].getIsObstacleOvercome()){
                        System.out.println("Участник выбыл с дистанции");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
