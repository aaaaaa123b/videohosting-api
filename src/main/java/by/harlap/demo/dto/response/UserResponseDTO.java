package by.harlap.demo.dto.response;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String username;
    @Email
    private String name;
    private String email;
}
