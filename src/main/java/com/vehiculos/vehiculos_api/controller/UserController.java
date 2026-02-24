package com.vehiculos.vehiculos_api.controller;

import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.dto.user.UserUpdateRequestDTO;
import com.vehiculos.vehiculos_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/my-profile")
    public ResponseEntity<UserResponseDTO> getUserById (){
        return ResponseEntity.ok(userService.getUserById());
    }


    @PutMapping("/my-profile")
    public ResponseEntity<UserResponseDTO> updateUser (
            @PathVariable Long userId, @Valid @RequestBody UserUpdateRequestDTO dto){

        return ResponseEntity.ok(userService.updateUser(dto));
    }
}
