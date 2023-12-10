package by.harlap.demo.dto.converter;

import by.harlap.demo.dto.response.ChannelInfoResponseDTO;
import by.harlap.demo.dto.response.FilteredChannelResponseDTO;
import by.harlap.demo.dto.request.CreateChannelDTO;
import by.harlap.demo.dto.response.ChannelResponseDTO;
import by.harlap.demo.dto.response.UserResponseDTO;
import by.harlap.demo.model.Channel;
import by.harlap.demo.model.User;
import by.harlap.demo.service.ChannelService;
import by.harlap.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class ChannelConverter {

    private final UserService userService;
    private final UserConverter userConverter;
    private final ChannelService channelService;

    public Channel createModel(CreateChannelDTO dto) {
        final Channel model = new Channel();
        Date creationDate = new Date();

        model.setName(dto.getName());
        model.setCategory(dto.getCategory());
        model.setCreationDate(creationDate);
        model.setAvatar(dto.getAvatar());
        model.setLanguage(dto.getLanguage());
        model.setDescription(dto.getDescription());

        final User owner = userService.find(dto.getOwnerId());
        model.setOwner(owner);

        return model;
    }

    public ChannelResponseDTO createDTO(Channel channel) {
        final ChannelResponseDTO dto = new ChannelResponseDTO();

        dto.setId(channel.getId());
        dto.setAvatar(channel.getAvatar());
        dto.setCreationDate(channel.getCreationDate());
        dto.setLanguage(channel.getLanguage());
        dto.setDescription(channel.getDescription());
        dto.setCategory(channel.getCategory());
        dto.setName(channel.getName());

        final UserResponseDTO userResponseDTO = userConverter.createDTO(channel.getOwner());
        dto.setOwner(userResponseDTO);

        return dto;
    }

    public FilteredChannelResponseDTO createFilteredDTO(Channel channel) {
        final FilteredChannelResponseDTO dto = new FilteredChannelResponseDTO();

        dto.setAvatar(channel.getAvatar());
        dto.setLanguage(channel.getLanguage());
        dto.setCategory(channel.getCategory());
        dto.setName(channel.getName());

        final long subscribersCount = channelService.countSubscribers(channel);
        dto.setSubscribers(subscribersCount);

        return dto;
    }

    public ChannelInfoResponseDTO createInfoDTO(Channel channel) {
        final ChannelInfoResponseDTO dto = new ChannelInfoResponseDTO();

        dto.setAvatar(channel.getAvatar());
        dto.setCreationDate(channel.getCreationDate());
        dto.setLanguage(channel.getLanguage());
        dto.setDescription(channel.getDescription());
        dto.setCategory(channel.getCategory());
        dto.setName(channel.getName());

        final long subscribersCount = channelService.countSubscribers(channel);
        dto.setSubscribers(subscribersCount);

        final UserResponseDTO userResponseDTO = userConverter.createDTO(channel.getOwner());
        dto.setOwner(userResponseDTO);

        return dto;
    }

}
