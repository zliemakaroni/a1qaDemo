package a3.makarenko;

import a3.makarenko.EmployeeModel.Employee;
import a3.makarenko.EmployeeModel.EmployeeFactory;
import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static final String DELIMITER = "========================================";


    public static void main( String[] args ) {
        List<Employee> employeeList = new ArrayList<>();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int sw;
        boolean ex = true;

        while(ex){
            System.out.println("1. Show Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Delete Employee");
            System.out.println("Enter 0 to exit");
            System.out.print("Your choose: ");
            sw = scanner.nextInt();
            System.out.println(DELIMITER);

            switch(sw){
                case 1: for(int i = 0; i < employeeList.size(); i++){
                    System.out.println("№ " + i);
                    employeeList.get(i).show();
                }
                break;

                case 2: System.out.println("Select Employee type");
                for(EmployeeTypes type: EmployeeTypes.values()){
                    System.out.println((type.ordinal() + 1) + ". " + type);
                }
                System.out.print("Your choose: ");
                EmployeeTypes employeeType = EmployeeTypes.getType(scanner.nextInt() - 1);
                scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter position: ");
                String position = scanner.nextLine();
                System.out.println("Select family status");
                for(FamilyStatus status: FamilyStatus.values()){
                    System.out.println((status.ordinal() + 1) + ". " + status);
                }
                System.out.print("Your choose: ");
                FamilyStatus familyStatus = FamilyStatus.getType(scanner.nextInt() - 1);
                System.out.print("Enter age: ");
                Double age = scanner.nextDouble();
                System.out.print("Enter experience: ");
                double experience = scanner.nextDouble();

                EmployeeFactory factory = new EmployeeFactory();
                Employee e = factory.getEmployee(employeeType, name, position, familyStatus, age, experience);
                employeeList.add(e);
                break;

                case 3: System.out.print("Enter target number to delete");
                int t = scanner.nextInt();
                employeeList.remove(t);
                break;

                case 0: ex = false;
                System.out.println("Bye!");
                break;

                default: System.out.println("Unknown command");
            }

        }


    }

}
