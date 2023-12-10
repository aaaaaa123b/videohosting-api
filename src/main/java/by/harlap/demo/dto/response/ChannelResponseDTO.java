package by.harlap.demo.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ChannelResponseDTO {

    private Long id;
    private String name;
    private String description;
    private UserResponseDTO owner;
    private Date creationDate;
    private String language;
    private String avatar;
    private String category;
}
