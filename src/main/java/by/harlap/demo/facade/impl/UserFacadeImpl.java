package by.harlap.demo.facade.impl;

import by.harlap.demo.dto.mapper.UserMapper;
import by.harlap.demo.dto.request.CreateUserDTO;
import by.harlap.demo.dto.request.UpdateUserDTO;
import by.harlap.demo.dto.response.UserResponseDTO;
import by.harlap.demo.facade.UserFacade;
import by.harlap.demo.model.Channel;
import by.harlap.demo.model.User;
import by.harlap.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(CreateUserDTO dto) {
        final User user = userMapper.createModel(dto);

        userService.save(user);

        return userMapper.createDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UpdateUserDTO dto) {
        final User user = userService.find(id);

        Optional.ofNullable(dto.getName()).ifPresent(user::setName);
        Optional.ofNullable(dto.getUsername()).ifPresent(user::setUsername);
        Optional.ofNullable(dto.getEmail()).ifPresent(user::setEmail);

        userService.save(user);

        return userMapper.createDTO(user);
    }

    @Override
    public UserResponseDTO findUser(Long userId) {
        return userMapper.createDTO(userService.find(userId));
    }

    @Override
    public Set<String> findUserChannels(Long userId) {
        return userService.findUserChannels(userId).stream()
                .map(Channel::getName)
                .collect(Collectors.toSet());
    }
}
