package a3.makarenko;

import a3.makarenko.EmployeeModel.Employee;
import a3.makarenko.EmployeeModel.EmployeeFactory;
import a3.makarenko.EmployeeModel.EmployeeList;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONWorker {

    public static void read(String path){

        String temp = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

        } catch(IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EmployeeFactory factory = new EmployeeFactory();
        //Employee e = factory.getEmployee(...);
        //target.add(e);
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("type");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("name");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("position");
        System.out.println(website);
    }

    /*public static void write(String path, List<Employee> target){

        try{
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(path, false);

        ObjectMapper objectMapper = new ObjectMapper();
        SequenceWriter sequenceWriter = objectMapper.writer().writeValuesAsArray(fileWriter);

            for(Employee employee: target) {
                sequenceWriter.write(employee);
            }

        sequenceWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void write(String path, List<Employee> target){

        JSONArray employeeList = new JSONArray();
        for(Employee e: target){
            employeeList.add(e);
        }
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(path, false);

            fileWriter.write(employeeList.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
