package com.stc.employee.model;

import lombok.*;

@Getter
@Setter
public class LeaveModel extends BasicModel {

    private String employeeID;
    private Short days;
    private String leaveType;

    public LeaveModel(String id, String employeeID, Short days, String leaveType) {
        super(id);
        this.employeeID = employeeID;
        this.days = days;
        this.leaveType = leaveType;
    }
}

