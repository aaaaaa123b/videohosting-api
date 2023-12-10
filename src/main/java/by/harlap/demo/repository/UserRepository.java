package by.harlap.demo.repository;

import by.harlap.demo.model.Channel;
import by.harlap.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    long countByChannelsContaining(Channel channel);
}
