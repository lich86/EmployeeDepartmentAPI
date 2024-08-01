package com.chervonnaya.employeedepartmentapi.service.mappers;

import com.chervonnaya.employeedepartmentapi.dto.LoginDTO;
import com.chervonnaya.employeedepartmentapi.dto.UserDTO;
import com.chervonnaya.employeedepartmentapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class LoginMapper implements BaseMapper<User, LoginDTO> {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(dto.getPassword()))")
    public abstract User map(UserDTO dto);


}