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

    public EmployeeList(){
        this.employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public boolean add() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            System.out.println("Select Employee type");
            for (EmployeeTypes type : EmployeeTypes.values()) {
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
            for (FamilyStatus status : FamilyStatus.values()) {
                System.out.println((status.ordinal() + 1) + ". " + status);
            }
            System.out.print("Your choose: ");
            FamilyStatus familyStatus = FamilyStatus.getType(scanner.nextInt() - 1);
            System.out.print("Enter age: ");
            double age = scanner.nextDouble();
            System.out.print("Enter experience: ");
            double experience = scanner.nextDouble();

            EmployeeFactory factory = new EmployeeFactory();
            return employeeList.add(factory.getEmployee(employeeType, name, position, familyStatus, age, experience));
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return false;

    }

    public Employee remove() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Enter target number to delete ");
        int t = scanner.nextInt();
        return employeeList.remove(t-1);
    }

    public void showList() {
        if(employeeList.size() == 0) throw new ArrayStoreException("Array is empty!");
        for(int i = 0; i < employeeList.size(); i++) {
            System.out.println("№ " + (i + 1));
            employeeList.get(i).show();
        }
    }

}
