package app.services.interfaces;

import app.model.CustomJmsMessage;

public interface MqProducerService {
    void simpleTextProducer(String msg);
    void customJmsMessageProducer(CustomJmsMessage msg);
}
