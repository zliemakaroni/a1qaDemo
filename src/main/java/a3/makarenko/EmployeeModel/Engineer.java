package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import static a3.makarenko.App.DELIMITER;

public class Engineer extends Employee{



    public Engineer(@JsonProperty("name") String name,
                    @JsonProperty("position") String position,
                    @JsonProperty("familyStatus")FamilyStatus familyStatus,
                    @JsonProperty("age")double age,
                    @JsonProperty("experience")double experience) {
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
