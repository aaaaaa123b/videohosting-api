package by.harlap.demo.facade;

import by.harlap.demo.dto.filter.ChannelFilterDTO;
import by.harlap.demo.dto.response.ChannelInfoResponseDTO;
import by.harlap.demo.dto.response.FilteredChannelResponseDTO;
import by.harlap.demo.dto.request.CreateChannelDTO;
import by.harlap.demo.dto.request.UpdateChannelDTO;
import by.harlap.demo.dto.response.ChannelResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChannelFacade {
    ChannelResponseDTO createChannel(CreateChannelDTO dto);

    ChannelResponseDTO updateChannel(Long id, UpdateChannelDTO dto);

    ChannelInfoResponseDTO findChannel(Long channelId);

    Page<FilteredChannelResponseDTO> findAll(ChannelFilterDTO filter, Pageable pageable);


}
