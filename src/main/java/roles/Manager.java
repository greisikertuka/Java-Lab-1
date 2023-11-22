package main.java.roles;

public class Manager extends Employee {
    double salary;
    int teamSize;

    public double getSalary() {
        //2% bonus for employee
        return 0.02 * teamSize;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", salary=" + salary +
                ", teamSize=" + teamSize +
                '}';
    }

    public Manager(String name, String lastName, double salary, int teamSize) {
        super(name, lastName, salary);
        this.teamSize = teamSize;
    }
}
