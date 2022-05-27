package com.stc.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.employee.entity.Employee;
import com.stc.employee.model.EmployeeModel;
import com.stc.employee.model.Response;
import com.stc.employee.repo.EmployeeRepo;
import com.stc.employee.restclient.LeaveApiRestClient;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final LeaveApiRestClient leaveApiRestClient;

    private final ObjectMapper objectMapper;

    public Response<EmployeeModel> saveEmployee(EmployeeModel employeeModel) {
        return new Response<>(200, "Saved", null,
                constructEmployeeModel(employeeRepo.save(constructEmployee(employeeModel)), new ArrayList<>()));
    }

    public Response<EmployeeModel> getEmployee(String employeeID) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeID);
        if (optionalEmployee.isEmpty()) {
            return new Response<>(404, "Not Found", null, null);
        } else {
            return new Response<>(200, "Success", null, constructEmployeeModel(optionalEmployee.get(), getEmployeeLeaves(employeeID)));
        }
    }

    @SneakyThrows
    private List<?> getEmployeeLeaves(String employeeID) {
        return objectMapper.readValue(leaveApiRestClient.getEmployeeLeaves(employeeID), Response.class).getMultipleEntries();
    }

    private EmployeeModel constructEmployeeModel(Employee employee, List<?> leaveModelList) {
        return new EmployeeModel(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getIsCurrent(), leaveModelList);
    }

    private Employee constructEmployee(EmployeeModel employeeModel) {
        return Employee.builder()
                .firstName(employeeModel.getFirstName())
                .lastName(employeeModel.getLastName())
                .isCurrent(employeeModel.getIsCurrent())
                .salary(employeeModel.getSalary())
                .build();
    }


}
