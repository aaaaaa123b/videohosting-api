package by.harlap.demo.facade;

import by.harlap.demo.dto.request.CreateUserDTO;
import by.harlap.demo.dto.request.UpdateUserDTO;
import by.harlap.demo.dto.response.UserResponseDTO;
import by.harlap.demo.model.Channel;

import java.util.Set;

public interface UserFacade {

    UserResponseDTO createUser(CreateUserDTO dto);

    UserResponseDTO updateUser(Long id, UpdateUserDTO dto);

    UserResponseDTO findUser(Long userId);

    Set<String> findUserChannels(Long userId);
}
