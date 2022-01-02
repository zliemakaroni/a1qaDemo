package a3.makarenko.EmployeeModel;

import a3.makarenko.RandomGenerator;
import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeDiffClass(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeDiffName(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Misha", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeDiffPosition(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "PM",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeDiffFamilyStatus(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Married, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeDiffAge(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Single, 20.01, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeDiffExperience(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1.01);
        Assert.assertNotEquals(expected, actual);
    }
}