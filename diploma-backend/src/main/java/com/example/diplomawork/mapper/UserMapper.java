package com.example.diplomawork.mapper;

import com.example.diplomawork.model.User;
import com.example.models.RegisterRequest;
import com.example.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "group", ignore = true)
    User dto2entity(RegisterRequest request);
    UserDto entity2dto(User user);
}
