package com.stc.leave.repo;

import com.stc.leave.entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepo extends JpaRepository<EmployeeLeave, String> {

    List<EmployeeLeave> findAllByEmployeeID(String employeeID);
}
