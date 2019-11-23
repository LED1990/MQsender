package app.services.interfaces;

public interface MqProducerService {
    void sendSimpleTextMessage(String msg);
}
