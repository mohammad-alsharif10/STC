package com.stc.employee.controller;

import com.stc.employee.model.EmployeeModel;
import com.stc.employee.model.Response;
import com.stc.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public Response<EmployeeModel> saveEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeService.saveEmployee(employeeModel);
    }

    @GetMapping("/getEmployee/{employeeID}")
    public Response<EmployeeModel> getEmployee(@PathVariable String employeeID) {
        return employeeService.getEmployee(employeeID);
    }
}

