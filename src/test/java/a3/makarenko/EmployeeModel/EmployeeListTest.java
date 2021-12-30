package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.FamilyStatus;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class EmployeeListTest {

    @Test
    public void add() {
        EmployeeList employeeList = new EmployeeList();
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        employeeList.add();

        in = new ByteArrayInputStream("Alex".getBytes());
        System.setIn(in);
        in = new ByteArrayInputStream("Future AQA".getBytes());
        System.setIn(in);
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        in = new ByteArrayInputStream("20".getBytes());
        System.setIn(in);
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        Engineer expected = new Engineer("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        assertEquals(expected, employeeList.getEmployeeList().get(0));
    }

    @Test
    public void remove() {
    }

    @Test
    public void showList() {
    }
}