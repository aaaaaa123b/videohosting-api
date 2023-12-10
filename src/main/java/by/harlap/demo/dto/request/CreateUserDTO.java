package by.harlap.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}
