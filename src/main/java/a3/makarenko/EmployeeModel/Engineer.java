package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;

import static a3.makarenko.App.DELIMITER;

public class Engineer extends Employee{


    Engineer(String name, String position, FamilyStatus familyStatus, double age, double experience) {
        super(name, position, familyStatus, age, experience);
    }

    @Override
    public void show() {
        System.out.println("Name - " + name);
        System.out.println("Type - " + EmployeeTypes.Engineer);
        System.out.println("Position - " + position);
        System.out.println("Family Status - " + familyStatus);
        System.out.println("Age - " + age);
        System.out.println("Experience - " + experience);
        System.out.println(DELIMITER);
    }
}
