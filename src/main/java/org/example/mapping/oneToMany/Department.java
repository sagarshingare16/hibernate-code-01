package org.example.mapping.oneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department_info")
public class Department {
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    @JoinColumn(referencedColumnName = "employee_id")
    private List<Employee> employee;

    public Department() {
        System.out.println("Department Constructor called");
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employee;
    }

    public void setEmployees(List<Employee> employees) {
        this.employee = employees;
    }
}
