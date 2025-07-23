package com.example.back_end.mapper;

import com.example.back_end.dto.request.PermissionRequest;
import com.example.back_end.dto.request.UserCreationRequest;
import com.example.back_end.dto.request.UserUpdateRequest;
import com.example.back_end.dto.response.PermissionResponse;
import com.example.back_end.dto.response.UserResponse;
import com.example.back_end.entity.Permission;
import com.example.back_end.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
