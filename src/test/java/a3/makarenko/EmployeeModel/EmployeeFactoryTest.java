package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmployeePositive() {
        Engineer expected = new Engineer("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegativeDiffClass(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegativeDiffName(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Misha", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegativeDiffPosition(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "PM",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegativeDiffFamilyStatus(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Married, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegativeDiffAge(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Single, 20.01, 1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegativeDiffExperience(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Manager, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1.01);
        Assert.assertNotEquals(expected, actual);
    }
}