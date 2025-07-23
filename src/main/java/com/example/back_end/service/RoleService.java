package com.example.back_end.service;

import com.example.back_end.dto.request.RoleRequest;
import com.example.back_end.dto.response.RoleResponse;
import com.example.back_end.mapper.RoleMapper;
import com.example.back_end.repository.PermissionRepository;
import com.example.back_end.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> findAll() {
        var roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    public void deleteById(String role) {
        roleRepository.deleteById(role);
    }
}
