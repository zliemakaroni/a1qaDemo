package a3.makarenko.EmployeeModel;

import a3.makarenko.enums.FamilyStatus;

public abstract class Employee{
       protected String name;
       protected String position;
       protected FamilyStatus familyStatus;
       protected double age;
       protected double experience;

       protected Employee(String name, String position, FamilyStatus familyStatus, double age, double experience){
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

       public void setAge(double age) {
              this.age = age;
       }

       public void setExperience(double experience) {
              this.experience = experience;
       }

       public void setFamilyStatus(FamilyStatus familyStatus) {
              this.familyStatus = familyStatus;
       }

       public void setName(String name) {
              this.name = name;
       }

       public void setPosition(String position) {
              this.position = position;
       }

       public abstract void show();

       @Override
       public boolean equals(Object o){
              if(this == o) return true;
              if(o == null || getClass() != o.getClass()) return false;
              Employee e = (Employee) o;
              return this.name.equals(e.getName()) &&
                      this.position.equals(e.getPosition()) &&
                      this.familyStatus.toString().equals(e.getFamilyStatus()) &&
                      this.age == e.getAge() &&
                      this.experience == e.getExperience();
       }
}
