package by.harlap.demo.dto.mapper;

import by.harlap.demo.dto.request.CreateUserDTO;
import by.harlap.demo.dto.response.UserResponseDTO;
import by.harlap.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User createModel(CreateUserDTO dto);

    UserResponseDTO createDTO(User user);
}
