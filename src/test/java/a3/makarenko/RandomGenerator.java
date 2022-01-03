package a3.makarenko;

import a3.makarenko.EmployeeModel.Employee;
import a3.makarenko.EmployeeModel.EmployeeFactory;
import a3.makarenko.EmployeeModel.EmployeeList;
import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;

import java.util.Random;

public class RandomGenerator {

    private static final String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    private static final String space = " ";
    private static final Random random = new Random();

    public static String getRandomAlphabeticString(int targetStringLength){
        String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase + numbers + space;
        StringBuffer randomString = new StringBuffer();
        for (int i = 0; i < targetStringLength; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            randomString.append(allCharacters.charAt(randomIndex));
        }
        return randomString.toString();

    }

    public static int getRandomNumber(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static Employee getRandomEmployee(){
        return getRandomEmployee(EmployeeTypes.getType(
                RandomGenerator.getRandomNumber(0, EmployeeTypes.values().length - 1)));
    }

    public static Employee getRandomEmployee(EmployeeTypes employeeType){
        String rName = RandomGenerator.getRandomAlphabeticString(RandomGenerator.getRandomNumber(1, 255));
        String rPosition = RandomGenerator.getRandomAlphabeticString(RandomGenerator.getRandomNumber(1, 255));
        FamilyStatus rFamilyStatus = FamilyStatus.getType(RandomGenerator.getRandomNumber(0, FamilyStatus.values().length - 1));
        int rAge = RandomGenerator.getRandomNumber(16, 100);
        int rExperience = RandomGenerator.getRandomNumber(0, rAge - 1);

        EmployeeFactory employeeFactory = new EmployeeFactory();
        return employeeFactory.getEmployee(employeeType, rName, rPosition,
                rFamilyStatus, rAge,rExperience);
    }

    public static EmployeeList getRandomEmployeeList(int listSize){
        EmployeeList employeeList = new EmployeeList();

        for(int i = 0; i < listSize; i++){
            employeeList.add(RandomGenerator.getRandomEmployee());
        }
        return employeeList;
    }

    public static EmployeeList getRandomEmployeeList(int min, int max){
        int rSize = RandomGenerator.getRandomNumber(min, max);
        return getRandomEmployeeList(rSize);
    }
}
