package by.harlap.demo.service;

import by.harlap.demo.model.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ChannelService {
    Channel saveChannel(Channel channel);

    Channel findById(Long channelId);

    Page<Channel> findAll(Specification<Channel> specification, Pageable pageable);

    long countSubscribers(Channel channel);

}
