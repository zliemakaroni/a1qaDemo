package a3.makarenko;

import a3.makarenko.EmployeeModel.Employee;
import a3.makarenko.EmployeeModel.EmployeeFactory;
import a3.makarenko.enums.EmployeeTypes;

import java.util.ArrayList;

public class XMLWorker {
    public static boolean read(String path, ArrayList<Employee> target){
        //Some XML magic with iterator incoming
        EmployeeFactory factory = new EmployeeFactory();
        //Employee e = factory.getEmployee(...);
        //target.add(e);
        return true;
    }
    public static boolean write(String path, ArrayList<Employee> target){
        return true;
    }
}
