package by.harlap.demo.controller;

import by.harlap.demo.dto.filter.ChannelFilterDTO;
import by.harlap.demo.dto.request.CreateChannelDTO;
import by.harlap.demo.dto.request.UpdateChannelDTO;
import by.harlap.demo.dto.response.ChannelInfoResponseDTO;
import by.harlap.demo.dto.response.ChannelResponseDTO;
import by.harlap.demo.dto.response.FilteredChannelResponseDTO;
import by.harlap.demo.facade.ChannelFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelFacade channelFacade;

    @PostMapping("/channel")
    @Operation(method = "POST", summary = "Создание канала")
    public ChannelResponseDTO saveChannel(@Valid @RequestBody CreateChannelDTO channelDTO) {
        return channelFacade.createChannel(channelDTO);
    }

    @PatchMapping("/channel/{id}")
    @Operation(method = "PATCH", summary = "Редактирование информации о канале")
    public ChannelResponseDTO updateChannel(@RequestBody UpdateChannelDTO channelDTO, @PathVariable("id") Long channelId) {
        return channelFacade.updateChannel(channelId, channelDTO);
    }

    @GetMapping("/channel/{id}")
    @Operation(method = "GET", summary = "Получение подробной информации по каналу")
    public ChannelInfoResponseDTO findChannelInfo(@PathVariable("id") Long channelId) {
        return channelFacade.findChannel(channelId);
    }

    @GetMapping("/channels")
    @Operation(method = "GET", summary = "Отображение списка всех каналов с пагинацией и фильтрацией по названию, языку и категории")
    public Page<FilteredChannelResponseDTO> allChannels(@ParameterObject ChannelFilterDTO filter, @ParameterObject Pageable pageable) {
        return channelFacade.findAll(filter, pageable);
    }

}

