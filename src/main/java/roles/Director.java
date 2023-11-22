package main.java.roles;

public class Director extends Manager {
    double departmentBudget;

    public Director(String name, String lastName, double salary, int teamSize, double departmentBudget) {
        super(name, lastName, salary, teamSize);
        this.departmentBudget = departmentBudget;
    }

    @Override
    public String toString() {
        return "Director{" +
                "departmentBudget=" + departmentBudget +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", salary=" + salary +
                ", teamSize=" + teamSize +
                '}';
    }

    public double getSalary() {
        //4% bonus for employee
        return teamSize * 0.04;
    }
}
