package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.FamilyStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Employee.class, name = "Employee"),
        @JsonSubTypes.Type(value = Manager.class, name = "Manager")
})
public abstract class Employee{
       protected String name;
       protected String position;
       protected FamilyStatus familyStatus;
       protected double age;
       protected double experience;

       Employee(String name, String position, FamilyStatus familyStatus, double age, double experience){
              this.age = age;
              this.experience = experience;
              this.familyStatus = familyStatus;
              this.name = name;
              this.position = position;
       }

       public double getAge(){
              return age;
       }

       public String getFamilyStatus(){
              return familyStatus.toString();
       }

       public double getExperience(){
              return experience;
       }

       public String getName() {
              return name;
       }

       public String getPosition() {
              return position;
       }
       public abstract void show();
}
