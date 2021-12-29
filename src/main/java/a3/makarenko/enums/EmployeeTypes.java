package a3.makarenko.enums;

public enum EmployeeTypes {
    Engineer, Manager;

    public static EmployeeTypes getType(int index) {
            for (EmployeeTypes types : EmployeeTypes.values()) {
                if (types.ordinal() == index) return types;
            }
            throw new IllegalArgumentException("Index not found");
    }
}
