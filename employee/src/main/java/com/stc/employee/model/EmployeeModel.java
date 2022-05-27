package com.stc.employee.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class EmployeeModel extends BasicModel {

    private String firstName;
    private String lastName;
    private Double salary;
    private Boolean isCurrent;
    private List<?> leaveModelList;

    public EmployeeModel() {
    }

    public EmployeeModel(String id, String firstName, String lastName, Double salary, Boolean isCurrent, List<?> leaveModelList) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.isCurrent = isCurrent;
        this.leaveModelList = leaveModelList;
    }
}
