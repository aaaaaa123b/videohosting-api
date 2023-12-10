package by.harlap.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubscribeChannelDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long channelId;
}
