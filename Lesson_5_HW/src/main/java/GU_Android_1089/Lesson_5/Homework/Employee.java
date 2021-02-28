package GU_Android_1089.Lesson_5.homework;

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    public Employee(){
        fullName = "Ivanov Ivan";
        position = "Engineer";
        email = "example@mail.com";
        phone = 89000000000L;
        salary = 30000;
        age = 30;
    }

    public Employee(String fullName, String position, String email, long phone, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo(){
        System.out.printf("ФИО: %s%nДолжность: %s%nemail: %s%nТелефон: %d%nЗарплата: %d%nВозраст: %d%n",
                this.fullName, this.position, this.email, this.phone, this.salary, this.age);
        System.out.println();
    }

    public boolean isAgeMoreThan40(){

        if (this.age > 40){
            return true;
        }

        return false;
    }
}
