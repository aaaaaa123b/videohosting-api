package by.harlap.demo.controller;

import by.harlap.demo.dto.request.SubscribeChannelDTO;
import by.harlap.demo.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/subscribe")
    @Operation(method = "POST", summary = "Подписка пользователя на канал")
    public void subscribeUser(@Valid @RequestBody SubscribeChannelDTO channelDTO) {
        subscriptionService.subscribeChannel(channelDTO.getUserId(), channelDTO.getChannelId());
    }

    @PostMapping("/unsubscribe")
    @Operation(method = "POST", summary = "Отписка пользователя с канала")
    public void unSubscribeUser(@Valid @RequestBody SubscribeChannelDTO channelDTO) {
        subscriptionService.unSubscribeChannel(channelDTO.getUserId(), channelDTO.getChannelId());
    }
}
