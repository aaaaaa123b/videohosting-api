package by.harlap.demo.service.impl;

import by.harlap.demo.exception.SubscriptionException;
import by.harlap.demo.model.Channel;
import by.harlap.demo.model.User;
import by.harlap.demo.service.ChannelService;
import by.harlap.demo.service.SubscriptionService;
import by.harlap.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final UserService userService;
    private final ChannelService channelService;

    @Override
    public void subscribeChannel(long userId, long channelId) {
        User user = userService.find(userId);
        Channel channel = channelService.findById(channelId);

        if (isSubscriber(user, channel)) {
            throw new SubscriptionException("User with id " + userId + " is already subscribed to channel with id " + channelId);
        }
        user.getChannels().add(channel);
        userService.save(user);
    }

    @Override
    public void unSubscribeChannel(long userId, long channelId) {
        User user = userService.find(userId);
        Channel channel = channelService.findById(channelId);
        if (!isSubscriber(user, channel)) {
            throw new SubscriptionException("User with id " + userId + " not subscribed to channel with id " + channelId);
        }
        user.getChannels().remove(channel);
        userService.save(user);
    }

    private boolean isSubscriber(User user, Channel channel) {
        return user.getChannels().contains(channel);
    }
}
