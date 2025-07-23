package com.example.back_end.controller;

import com.example.back_end.dto.request.PermissionRequest;
import com.example.back_end.dto.request.RoleRequest;
import com.example.back_end.dto.response.ApiResponse;
import com.example.back_end.dto.response.PermissionResponse;
import com.example.back_end.dto.response.RoleResponse;
import com.example.back_end.service.PermissionService;
import com.example.back_end.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> findAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.findAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.deleteById(role);
        return ApiResponse.<Void>builder().build();    }
}
