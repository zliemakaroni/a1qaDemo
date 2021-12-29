package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee() {
        Engineer expected = new Engineer("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeNegative(){
        Manager expected = new Manager("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee actual = employeeFactory.getEmployee(EmployeeTypes.Engineer, "Alexey", "Future AQA",
                FamilyStatus.Single, 20, 1);
        Assert.assertNotEquals(expected, actual);
    }
}