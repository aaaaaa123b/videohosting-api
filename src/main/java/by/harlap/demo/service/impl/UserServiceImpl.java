package by.harlap.demo.service.impl;

import by.harlap.demo.model.Channel;
import by.harlap.demo.model.User;
import by.harlap.demo.repository.UserRepository;
import by.harlap.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User find(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " does not exist"));
    }

    @Override
    public Set<Channel> findUserChannels(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(User::getChannels).orElse(Collections.emptySet());
    }

}
