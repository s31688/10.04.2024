import java.util.ArrayList;
import java.time.*;

public abstract class Employee {
    public String name;
    public String surname;
    public String address;
    public String email;
    public String id;
    public int employmentYear;
    public int salary;

    public Employee(String name, String surname, String address, String email, String id, int employmentYear) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.id = id;
        this.employmentYear = employmentYear;
    }

    public int calculateSalary() {
        this.salary = 3000;
        salary += (LocalDate.now().getYear() - this.employmentYear);
        return salary;
    }
}

class Developer extends Employee {
    public ArrayList<Technology> technologies = new ArrayList<>();

    public Developer(String name, String surname, String address, String email, String id, int employmentYear) {
        super(name, surname, address, email, id, employmentYear);
    }

    public void addTechnology(Technology t) {
        this.technologies.add(t);
    }

    @Override
    public int calculateSalary() {
        super.salary = super.calculateSalary();
        for (Technology technology : this.technologies) {
            super.salary += technology.bonus;
        }
        return salary;
    }
}

class Tester extends Employee {
    public ArrayList<String> tests = new ArrayList<>();

    public Tester(String name, String surname, String address, String email, String id, int employmentYear) {
        super(name, surname, address, email, id, employmentYear);
    }

    public void addTestType(String name) {
        this.tests.add(name);
    }

    @Override
    public int calculateSalary() {
        super.salary = super.calculateSalary();
        for (String test : this.tests) {
            super.salary += test.length() * 300;
        }
        return salary;
    }
}

class Manager extends Employee {
    public ArrayList<Goal> goals = new ArrayList<>();

    public Manager(String name, String surname, String address, String email, String id, int employmentYear) {
        super(name, surname, address, email, id, employmentYear);
    }

    public void addGoals(Goal g) {
        this.goals.add(g);
        if (g.month == LocalDate.now().getMonthValue()) {
            super.salary += g.bonus;
        }
    }

    @Override
    public int calculateSalary() {
        super.salary = super.calculateSalary();
        for (Goal g : this.goals) {
            if (g.month == LocalDate.now().getMonthValue()) {
                super.salary += g.bonus;
            }
        }
        return salary;
    }
}