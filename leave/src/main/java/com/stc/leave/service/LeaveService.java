package com.stc.leave.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.leave.entity.EmployeeLeave;
import com.stc.leave.model.LeaveModel;
import com.stc.leave.model.Response;
import com.stc.leave.repo.LeaveRepo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaveService {

    private final LeaveRepo leaveRepo;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public String getEmployeeLeaves(@PathVariable String employeeID) {
        Response<LeaveModel> leaveModelResponse = new Response<>(200, "Success",
                leaveRepo.findAllByEmployeeID(employeeID).stream().map(this::constructLeaveModel).collect(Collectors.toList()), null);
        return objectMapper.writeValueAsString(leaveModelResponse);
    }

    private LeaveModel constructLeaveModel(EmployeeLeave employeeLeave) {
        return new LeaveModel(employeeLeave.getId(), employeeLeave.getEmployeeID(), employeeLeave.getDays(), employeeLeave.getLeaveType());
    }

    private EmployeeLeave constructEmployeeLeave(LeaveModel leaveModel) {
        return EmployeeLeave.builder()
                .id(leaveModel.getId())
                .employeeID(leaveModel.getEmployeeID())
                .days(leaveModel.getDays())
                .leaveType(leaveModel.getLeaveType())
                .build();
    }
}
