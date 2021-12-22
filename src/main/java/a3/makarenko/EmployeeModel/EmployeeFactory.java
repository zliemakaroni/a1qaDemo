package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;

public class EmployeeFactory {
public Employee getEmployee(EmployeeTypes type, String name,
                            String position, FamilyStatus familyStatus, double age, double experience){
    switch(type){
        case Manager:
            return new Manager(name, position, familyStatus, age, experience);
        case Engineer:
            return new Engineer(name, position, familyStatus, age, experience);
        default:
            throw new IllegalArgumentException("Wrong employee type:" + type);
    }
}
}
