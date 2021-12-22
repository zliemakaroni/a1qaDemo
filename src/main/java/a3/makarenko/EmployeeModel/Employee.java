package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.FamilyStatus;

public abstract class Employee{
       protected double age;
       protected FamilyStatus familyStatus;
       protected double experience;
       protected String name;
       protected String position;

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

       public abstract void show();
}
