package a3.makarenko.EmployeeModel;

import a3.makarenko.RandomGenerator;
import a3.makarenko.enums.FamilyStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static a3.makarenko.App.DELIMITER;

public class EmployeeListTest {

    private final InputStream stdIn = System.in;
    private final PrintStream stdout = System.out;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void initIOStreams(){
        byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    @AfterEach
    public void returnIOStreams(){
        System.setIn(stdIn);
        System.setOut(stdout);
    }

    @Test
    public void add() {
        EmployeeList employeeList = new EmployeeList();

        employeeList.setScanner(new Scanner(new ByteArrayInputStream("1\nAlexey\nFuture AQA\n1\n20\n1\n".getBytes())));
        employeeList.add();

        Engineer expected = new Engineer("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        Employee actual = employeeList.getEmployeeList().get(0);

        Assertions.assertEquals(expected, actual,
                "Constructed employee differs form created by add dialog");
    }

    @Test
    public void addIllegalType(){
        EmployeeList employeeList = new EmployeeList();

        employeeList.setScanner(new Scanner(new ByteArrayInputStream("Oops!\nAlexey\nFuture AQA\n1\n20\n1\n".getBytes())));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {}, "");
        employeeList.add();

        Engineer expected = new Engineer("Alexey", "Future AQA",
                FamilyStatus.Single, 20,1);

        Employee actual = employeeList.getEmployeeList().get(0);

        Assertions.assertEquals(expected, actual,
                "Constructed employee differs form created by add dialog");
    }

    @Test
    public void remove() {
        EmployeeList employeeList = new EmployeeList();

        int rSize = RandomGenerator.getRandomNumber(2, 10);

        for(int i = 0; i < rSize; i++){
            employeeList.add(RandomGenerator.getRandomEmployee());
        }

        ArrayList<Employee> expected = new ArrayList<>(employeeList.getEmployeeList());

        int rIndex = RandomGenerator.getRandomNumber(1,rSize);
        expected.remove(rIndex - 1);


        employeeList.setScanner(new Scanner(new ByteArrayInputStream(Integer.toString(rIndex).getBytes())));
        employeeList.remove();


        ArrayList<Employee> actual = employeeList.getEmployeeList();
        Assertions.assertEquals(expected, actual,
                "List with directly remove differs from list with remove by dialog");
    }

    @Test
    public void showList() {
        EmployeeList employeeList = new EmployeeList();

        int rSize = RandomGenerator.getRandomNumber(2, 10);

        StringBuffer expectedBuffer = new StringBuffer();

        for(int i = 0; i < rSize; i++){
            employeeList.add(RandomGenerator.getRandomEmployee());
            expectedBuffer.append("№ " + (i + 1) +
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
        String expected = expectedBuffer.toString();

        Assertions.assertEquals(expected, actual,
                "Showed by function list differs from showed directly");
    }
}