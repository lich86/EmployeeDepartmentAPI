package com.chervonnaya.employeedepartmentapi.service.mappers;

import com.chervonnaya.employeedepartmentapi.dto.EmployeeDTO;
import com.chervonnaya.employeedepartmentapi.model.Department;
import com.chervonnaya.employeedepartmentapi.model.Employee;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDTO> {

    @Mapping(source = "departmentId", target = "department", qualifiedByName = "mapDepartment")
    Employee map(EmployeeDTO dto);

    @Named("mapDepartment")
    static Department mapDepartment(Long departmentId) {
        Department department = new Department();
        department.setId(departmentId);
        return department;
    }
}