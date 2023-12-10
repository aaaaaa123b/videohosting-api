package by.harlap.demo.controller;

import by.harlap.demo.dto.request.CreateUserDTO;
import by.harlap.demo.dto.request.UpdateUserDTO;
import by.harlap.demo.dto.response.UserResponseDTO;
import by.harlap.demo.facade.UserFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/users")
    @Operation(method = "POST", summary = "Создание пользователя")
    public UserResponseDTO saveUser(@Valid @RequestBody CreateUserDTO user) {
        return userFacade.createUser(user);
    }

    @GetMapping("/users/{id}")
    @Operation(method = "GET", summary = "Информация о пользователе")
    public UserResponseDTO findUser(@PathVariable("id") Long userId) {
        return userFacade.findUser(userId);
    }

    @PatchMapping("/users/{id}")
    @Operation(method = "PATCH", summary = "Редактирование информации о пользователе")
    public UserResponseDTO updateUser(@Valid @RequestBody UpdateUserDTO userDTO, @PathVariable("id") Long userId) {
        return userFacade.updateUser(userId, userDTO);
    }

    @GetMapping("/users/{id}/channels")
    @Operation(method = "GET", summary = "Список каналов,на которые подписан пользователь")
    public Set<String> findUserChannels(@PathVariable("id") Long userId) {
        return userFacade.findUserChannels(userId);
    }

}
