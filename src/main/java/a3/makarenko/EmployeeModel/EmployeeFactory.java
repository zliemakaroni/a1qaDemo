package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;

public class EmployeeFactory {
public Employee getEmployee(EmployeeTypes type,
                            String name,
                            String position,
                            FamilyStatus familyStatus,
                            double age,
                            double experience) throws IllegalArgumentException{
        if (age < experience) throw new IllegalArgumentException("Age cant be lesser than experience");
        if (age < 0) throw new IllegalArgumentException("Age must be positive");
        if (age < 16) throw new IllegalArgumentException("Too yong to work here");
        if (experience < 0) throw new IllegalArgumentException("Experience must be positive");
        switch (type) {
            case Manager:
                return new Manager(name, position, familyStatus, age, experience);
            case Engineer:
                return new Engineer(name, position, familyStatus, age, experience);
            default:
                throw new IllegalArgumentException("Wrong employee type:" + type);
        }
}
}
