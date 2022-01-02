package a3.makarenko.EmployeeModel;

import a3.makarenko.RandomGenerator;
import a3.makarenko.enums.FamilyStatus;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static a3.makarenko.App.DELIMITER;
import static org.junit.Assert.*;

public class EmployeeListTest {

    @Test
    public void add() {
        EmployeeList employeeList = new EmployeeList();
        InputStream stdIn = System.in;
        PrintStream stdout = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        employeeList.setScanner(new Scanner(new ByteArrayInputStream("1\nAlexey\nFuture AQA\n1\n20\n1\n".getBytes())));
        employeeList.add();

        System.setIn(stdIn);
        System.setOut(stdout);

        Engineer expected = new Engineer("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        assertEquals(expected, employeeList.getEmployeeList().get(0));
    }

    @Test
    public void remove() {
        EmployeeList employeeList = new EmployeeList();
        InputStream stdIn = System.in;
        PrintStream stdout = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        int rSize = RandomGenerator.getRandomNumber(2, 10);

        for(int i = 0; i < rSize; i++){
            employeeList.add(RandomGenerator.getRandomEmployee());
        }

        ArrayList<Employee> expected = employeeList.getEmployeeList();

        int rIndex = RandomGenerator.getRandomNumber(1,rSize);
        expected.remove(rIndex - 1);


        employeeList.setScanner(new Scanner(new ByteArrayInputStream(Integer.toString(rIndex).getBytes())));
        employeeList.remove();

        System.setIn(stdIn);
        System.setOut(stdout);
        assertEquals(expected, employeeList.getEmployeeList());
    }

    @Test
    public void showList() {
        EmployeeList employeeList = new EmployeeList();
        InputStream stdIn = System.in;
        PrintStream stdout = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        int rSize = RandomGenerator.getRandomNumber(2, 10);

        StringBuffer expected = new StringBuffer();

        for(int i = 0; i < rSize; i++){
            employeeList.add(RandomGenerator.getRandomEmployee());
            expected.append("№ " + (i + 1) +
                    "\r\nName - " + employeeList.getEmployeeList().get(i).getName() +
                    "\r\nType - " + employeeList.getEmployeeList().get(i).getClass().getSimpleName() +
                    "\r\nPosition - " + employeeList.getEmployeeList().get(i).getPosition() +
                    "\r\nFamily Status - " + employeeList.getEmployeeList().get(i).getFamilyStatus() +
                    "\r\nAge - " + employeeList.getEmployeeList().get(i).getAge() +
                    "\r\nExperience - " + employeeList.getEmployeeList().get(i).getExperience() +
                    "\r\n" + DELIMITER + "\r\n");
        }


        employeeList.showList();
        String actual = byteArrayOutputStream.toString();

        System.setIn(stdIn);
        System.setOut(stdout);

        assertEquals(expected.toString(), actual);
    }
}