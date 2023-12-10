package by.harlap.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateChannelDTO {

    private String name;

    private String description;

    private String language;

    private String avatar;

    private String category;
}
