package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.EmployeeTypes;
import a3.makarenko.enums.FamilyStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.InputStreamReader;

public class EmployeeList {

    private ArrayList<Employee> employeeList;

    private Scanner scanner;

    public EmployeeList(){
        this.employeeList = new ArrayList<>();
        scanner = new Scanner(new InputStreamReader(System.in));
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }


    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public boolean add() {
        try {
            EmployeeFactory factory = new EmployeeFactory();
            return employeeList.add(factory.getEmployee(employeeTypeDialog(),
                    nameDialog(),
                    positionDialog(),
                    familyStatusDialog(),
                    ageDialog(),
                    experienceDialog()));
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return false;

    }
    private EmployeeTypes employeeTypeDialog() throws IllegalArgumentException{
        System.out.println("Select Employee type");
        for (EmployeeTypes type : EmployeeTypes.values()) {
            System.out.println((type.ordinal() + 1) + ". " + type);
        }
        System.out.print("Your choose: ");
        EmployeeTypes employeeType = EmployeeTypes.getType(scanner.nextInt() - 1);
        scanner.nextLine();
        return employeeType;
    }

    private String nameDialog() throws IllegalArgumentException{
        System.out.print("Enter name: ");
        return scanner.nextLine();
    }
    private String positionDialog() throws IllegalArgumentException{
        System.out.print("Enter position: ");
        return scanner.nextLine();
    }

    private FamilyStatus familyStatusDialog() throws IllegalArgumentException{
        System.out.println("Select family status");
        for (FamilyStatus status : FamilyStatus.values()) {
            System.out.println((status.ordinal() + 1) + ". " + status);
        }
        System.out.print("Your choose: ");
        return FamilyStatus.getType(scanner.nextInt() - 1);
    }

    public Employee remove() {
        System.out.print("Enter target number to delete ");
        int t = scanner.nextInt();
        return employeeList.remove(t-1);
    }

    private double ageDialog() throws IllegalArgumentException{
        System.out.print("Enter age: ");
        return scanner.nextDouble();
    }
    private double experienceDialog() throws IllegalArgumentException{
        System.out.print("Enter experience: ");
        return scanner.nextDouble();
    }

    public void showList() throws ArrayStoreException{
        if(employeeList.size() == 0) throw new ArrayStoreException("Array is empty!");
        for(int i = 0; i < employeeList.size(); i++) {
            System.out.println("№ " + (i + 1));
            employeeList.get(i).show();
        }
    }

}
