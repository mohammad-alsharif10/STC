package com.stc.employee.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gateway")
public interface LeaveApiRestClient {

    @GetMapping("/leave-api/leave/getEmployeeLeaves/{employeeID}")
    String getEmployeeLeaves(@PathVariable String employeeID);
}
