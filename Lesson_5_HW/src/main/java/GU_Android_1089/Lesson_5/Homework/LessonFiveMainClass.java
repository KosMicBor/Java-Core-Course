package GU_Android_1089.Lesson_5.homework;

public class LessonFiveMainClass {

    private static final int ZERO = 0;

    public static void main(String[] args) {
        int arrSize = 5;

        Employee employeeFirst = new Employee();
        employeeFirst.getInfo();

        Employee[] empArray = new Employee[arrSize];
        empArray[0] = new Employee("Sidorov Sergey", "Engineer",
                "sidorov@mail.com", 895421354654L, 30000, 32);

        empArray[1] = new Employee("Smith John", "Senior Engineer",
                "smith@mail.com", 89465584647L, 130000, 41);

        empArray[2] = new Employee("Kraev Victor", "Designer",
                "kraev@mail.com", 89545642314L, 50000, 28);

        empArray[3] = new Employee("Tuletti Franchesco", "CFO",
                "tuletti@mail.com", 89654231451L, 200000, 48);

        empArray[4] = new Employee("Lopez Isabella", "Marketing director",
                "lopez@mail.com", 89549994531L, 150000, 25);

        for (int i = ZERO; i < empArray.length; i++) {

            if (empArray[i].isAgeMoreThan40()) {
                empArray[i].getInfo();
            }
        }
    }
}
