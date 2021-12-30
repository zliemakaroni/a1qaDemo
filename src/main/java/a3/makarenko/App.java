package a3.makarenko;

import a3.makarenko.EmployeeModel.EmployeeList;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    public static final String DELIMITER = "========================================";
    public static final String FILE_PATH = "employees.json";


    public static void main( String[] args ) throws InterruptedException {
        EmployeeList employeeList = new EmployeeList();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int sw;
        boolean ex = true;

        while(ex){
            Thread.sleep(500);
            System.out.println("1. Show Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Read from file");
            System.out.println("5. Write in file");
            System.out.println("Enter 0 to exit");
            System.out.print("Your choose: ");
            sw = scanner.nextInt();
            System.out.println(DELIMITER);

            switch(sw){
                case 1: try{
                    employeeList.showList();
                } catch (ArrayStoreException e){
                    e.printStackTrace();
                }
                break;

                case 2: employeeList.add();
                break;

                case 3: employeeList.remove();
                break;

                case 4: employeeList = JSONWorker.read(FILE_PATH);
                break;

                case 5: JSONWorker.write(FILE_PATH, employeeList);
                break;

                case 0: ex = false;
                System.out.println("Bye!");
                break;

                default: System.out.println("Unknown command");
            }

        }


    }

}
