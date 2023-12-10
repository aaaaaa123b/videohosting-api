package by.harlap.demo.service.impl;

import by.harlap.demo.model.Channel;
import by.harlap.demo.repository.ChannelRepository;
import by.harlap.demo.repository.UserRepository;
import by.harlap.demo.service.ChannelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;

    @Override
    public Channel saveChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel findById(Long channelId) {
        return channelRepository.findById(channelId)
                .orElseThrow(() -> new EntityNotFoundException("Channel with id " + channelId + " does not exist"));
    }

    @Override
    public Page<Channel> findAll(Specification<Channel> specification, Pageable pageable) {
        return channelRepository.findAll(specification, pageable);
    }

    @Override
    public long countSubscribers(Channel channel) {
        return userRepository.countByChannelsContaining(channel);
    }

}
