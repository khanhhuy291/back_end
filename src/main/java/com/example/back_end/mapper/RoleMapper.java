package com.example.back_end.mapper;

import com.example.back_end.dto.request.PermissionRequest;
import com.example.back_end.dto.request.RoleRequest;
import com.example.back_end.dto.response.PermissionResponse;
import com.example.back_end.dto.response.RoleResponse;
import com.example.back_end.entity.Permission;
import com.example.back_end.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
