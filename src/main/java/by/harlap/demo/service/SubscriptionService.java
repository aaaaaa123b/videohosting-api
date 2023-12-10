package by.harlap.demo.service;

public interface SubscriptionService {

    void subscribeChannel(long user_id,long channel_id);

    void unSubscribeChannel(long user_id, long channel_id);
}
