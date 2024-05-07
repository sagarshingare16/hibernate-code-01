package org.example.mapping.oneToMany;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "employee_info")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_address")
    private String employeeAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){
        System.out.println("Employee Constructor called");
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
