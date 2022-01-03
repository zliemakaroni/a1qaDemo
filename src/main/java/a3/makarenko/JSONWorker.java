package a3.makarenko;

import a3.makarenko.EmployeeModel.EmployeeList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.io.File;
import java.io.IOException;


public class JSONWorker {

    public static ObjectMapper mapper = new ObjectMapper();

    public static EmployeeList read(String path){

        File file = new File(path);
        EmployeeList result = new EmployeeList();
        try{
            PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                    .allowIfSubType("a3.makarenko.EmployeeModel")
                    .allowIfSubType("java.util.ArrayList")
                    .build();
            mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);


             result = mapper.readValue(file, EmployeeList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void write(String path, EmployeeList target){

        File file = new File(path);
        try{
            PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                    .allowIfSubType("a3.makarenko.EmployeeModel")
                    .allowIfSubType("java.util.ArrayList")
                    .build();
            mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

            mapper.writeValue(file, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
