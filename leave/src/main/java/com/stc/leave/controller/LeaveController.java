package com.stc.leave.controller;

import com.stc.leave.service.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/leave")
public class LeaveController {

    private final LeaveService leaveService;


    @GetMapping("/getEmployeeLeaves/{employeeID}")
    public String getEmployeeLeaves(@PathVariable String employeeID) {
        return leaveService.getEmployeeLeaves(employeeID);
    }

}
