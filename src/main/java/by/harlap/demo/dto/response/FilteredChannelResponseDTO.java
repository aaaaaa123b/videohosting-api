package by.harlap.demo.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilteredChannelResponseDTO {

    private String name;
    private Long subscribers;
    private String language;
    private String avatar;
    private String category;
}
