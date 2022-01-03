package a3.makarenko.EmployeeModel;

import a3.makarenko.RandomGenerator;
import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee() {
        String rName = RandomGenerator.getRandomAlphabeticString(RandomGenerator.getRandomNumber(1, 255));
        String rPosition = RandomGenerator.getRandomAlphabeticString(RandomGenerator.getRandomNumber(1, 255));
        FamilyStatus rFamilyStatus = FamilyStatus.getType(RandomGenerator.getRandomNumber(0, FamilyStatus.values().length - 1));
        int rAge = RandomGenerator.getRandomNumber(16, 100);
        int rExperience = RandomGenerator.getRandomNumber(0, rAge - 1);
        Engineer expected = new Engineer(rName, rPosition,
                rFamilyStatus, rAge,rExperience);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, rName, rPosition,
                rFamilyStatus, rAge,rExperience);
        Assertions.assertEquals(expected, actual, "Constructed employee differs form created by factory");
    }

    @Test
    public void getEmployeeDiffClass(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assertions.assertNotEquals(expected, actual, "Employees with different type are equals");
    }

    @Test
    public void getEmployeeDiffName(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Misha", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assertions.assertNotEquals(expected, actual, "Employees with different name are equals");
    }

    @Test
    public void getEmployeeDiffPosition(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "PM",
                FamilyStatus.Single, 20, 1);
        Assertions.assertNotEquals(expected, actual, "Employees with different position are equals");
    }

    @Test
    public void getEmployeeDiffFamilyStatus(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Married, 20, 1);
        Assertions.assertNotEquals(expected, actual, "Employees with different family status are equals");
    }

    @Test
    public void getEmployeeDiffAge(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Single, 20.01, 1);
        Assertions.assertNotEquals(expected, actual, "Employees with different age are equals");
    }

    @Test
    public void getEmployeeDiffExperience(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1.01);
        Assertions.assertNotEquals(expected, actual, "Employees with different experience are equals");
    }
}