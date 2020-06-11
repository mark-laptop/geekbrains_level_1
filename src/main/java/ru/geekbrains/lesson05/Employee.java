package ru.geekbrains.lesson05;

public class Employee {

    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String firstName, String lastName, String middleName, String position, String email, String phone, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Василий", "Пупкин","Васильевич",
                "программист","1@mail.ru","1234567890",1000, 30);
        employees[1] = new Employee("Петр", "Петров","Петрович",
                "системный администратор","2@mail.ru","0987654321",2000, 45);
        employees[2] = new Employee("Иван", "Иванов","Иванович",
                "директор","3@mail.ru","1234509876",3000, 40);
        employees[3] = new Employee("Федор", "Федоров","Федорович",
                "бухгалтер","4@mail.ru","6789054321",4000, 46);
        employees[4] = new Employee("Анатолий", "Деловой","Анатольевич",
                "менеджер","5@mail.ru","1234554321",5000, 34);

        for (Employee employee : employees) {
            if (employee.getAge() > 40)
                System.out.println(employee);
        }
    }
}
