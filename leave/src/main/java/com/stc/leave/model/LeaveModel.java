package com.stc.leave.model;

import lombok.Getter;
import lombok.Setter;

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
