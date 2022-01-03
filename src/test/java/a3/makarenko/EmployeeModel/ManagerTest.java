package a3.makarenko.EmployeeModel;

import a3.makarenko.RandomGenerator;
import a3.makarenko.enums.EmployeeTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static a3.makarenko.App.DELIMITER;

public class ManagerTest {

    @Test
    public void show() {
        Employee manager = RandomGenerator.getRandomEmployee(EmployeeTypes.Manager);
        PrintStream stdout = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        manager.show();

        String actual = byteArrayOutputStream.toString();
        System.setOut(stdout);

        String expected = "Name - " + manager.getName() +
                "\r\nType - " + manager.getClass().getSimpleName() +
                "\r\nPosition - " + manager.getPosition() +
                "\r\nFamily Status - " + manager.getFamilyStatus() +
                "\r\nAge - " + manager.getAge() +
                "\r\nExperience - " + manager.getExperience() +
                "\r\n" + DELIMITER + "\r\n";

        Assertions.assertEquals(expected, actual,
                "Showed by function Manager differs from showed directly");
    }
}