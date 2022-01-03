package a3.makarenko.EmployeeModel;

import a3.makarenko.RandomGenerator;
import a3.makarenko.enums.EmployeeTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static a3.makarenko.App.DELIMITER;

public class EngineerTest {

    @Test
    public void show() {
        Employee engineer = RandomGenerator.getRandomEmployee(EmployeeTypes.Engineer);
        PrintStream stdout = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        engineer.show();

        String actual = byteArrayOutputStream.toString();
        System.setOut(stdout);

        String expected = "Name - " + engineer.getName() +
                "\r\nType - " + engineer.getClass().getSimpleName() +
                "\r\nPosition - " + engineer.getPosition() +
                "\r\nFamily Status - " + engineer.getFamilyStatus() +
                "\r\nAge - " + engineer.getAge() +
                "\r\nExperience - " + engineer.getExperience() +
                "\r\n" + DELIMITER + "\r\n";

        Assertions.assertEquals(expected, actual,
                "Showed by function Engineer differs from showed directly");

    }
}