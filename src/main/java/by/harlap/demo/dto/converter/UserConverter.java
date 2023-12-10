package by.harlap.demo.dto.converter;

import by.harlap.demo.dto.request.CreateUserDTO;
import by.harlap.demo.dto.response.UserResponseDTO;
import by.harlap.demo.model.User;
import org.springframework.stereotype.Component;

@Component
@Deprecated
public class UserConverter {

    public User createModel(CreateUserDTO dto) {
        final User model = new User();

        model.setEmail(dto.getEmail());
        model.setUsername(dto.getUsername());
        model.setName(dto.getName());

        return model;
    }

    public UserResponseDTO createDTO(User user) {
        final UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());

        return dto;
    }
}
