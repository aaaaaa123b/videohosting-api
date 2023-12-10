package by.harlap.demo.service;

import by.harlap.demo.model.Channel;
import by.harlap.demo.model.User;

import java.util.Set;

public interface UserService {

    User save(User user);

    User find(Long userId);

    Set<Channel> findUserChannels(Long userId);
}
