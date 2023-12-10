package by.harlap.demo.facade.impl;

import by.harlap.demo.dto.converter.ChannelConverter;
import by.harlap.demo.dto.filter.ChannelFilterDTO;
import by.harlap.demo.dto.request.CreateChannelDTO;
import by.harlap.demo.dto.request.UpdateChannelDTO;
import by.harlap.demo.dto.response.ChannelInfoResponseDTO;
import by.harlap.demo.dto.response.ChannelResponseDTO;
import by.harlap.demo.dto.response.FilteredChannelResponseDTO;
import by.harlap.demo.facade.ChannelFacade;
import by.harlap.demo.model.Channel;
import by.harlap.demo.repository.specification.ChannelSpecificationProvider;
import by.harlap.demo.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ChannelFacadeImpl implements ChannelFacade {

    private final ChannelService channelService;
    private final ChannelConverter channelConverter;
    private final ChannelSpecificationProvider channelSpecificationProvider;


    @Override
    public ChannelResponseDTO createChannel(CreateChannelDTO dto) {
        final Channel channel = channelConverter.createModel(dto);

        channelService.saveChannel(channel);

        return channelConverter.createDTO(channel);
    }

    @Override
    public ChannelResponseDTO updateChannel(Long id, UpdateChannelDTO dto) {
        final Channel channel = channelService.findById(id);

        Optional.ofNullable(dto.getName()).ifPresent(channel::setName);
        Optional.ofNullable(dto.getCategory()).ifPresent(channel::setCategory);
        Optional.ofNullable(dto.getAvatar()).ifPresent(channel::setAvatar);
        Optional.ofNullable(dto.getLanguage()).ifPresent(channel::setLanguage);
        Optional.ofNullable(dto.getDescription()).ifPresent(channel::setDescription);

        channelService.saveChannel(channel);

        return channelConverter.createDTO(channel);
    }

    @Override
    public ChannelInfoResponseDTO findChannel(Long channelId) {
        return channelConverter.createInfoDTO(channelService.findById(channelId));
    }

    @Override
    public Page<FilteredChannelResponseDTO> findAll(ChannelFilterDTO filter, Pageable pageable) {
        Specification<Channel> channelSpecification = channelSpecificationProvider.buildSpecification(filter);

        return channelService.findAll(channelSpecification, pageable)
                .map(channelConverter::createFilteredDTO);
    }

}
