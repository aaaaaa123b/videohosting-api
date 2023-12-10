package by.harlap.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateChannelDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String language;

    @NotBlank
    private String avatar;

    @NotBlank
    private String category;

    @NotNull
    private Long ownerId;
}
