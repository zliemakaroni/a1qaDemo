package a3.makarenko.enums;

public enum FamilyStatus{
    Single, Married;

    public static FamilyStatus getType(int index){
        for(FamilyStatus status: FamilyStatus.values()){
            if(status.ordinal() == index)  return status;
        }
        throw new IllegalArgumentException("Index not found");
    }
}
