package app.services;

import app.model.CustomJmsMessage;
import app.services.interfaces.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MqProducerServiceImpl implements MqProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public void simpleTextProducer(String msg) {
        jmsTemplate.convertAndSend("simpleTextQueue.q",msg.concat(String.valueOf(count.incrementAndGet())));
    }

    @Override
    public void customJmsMessageProducer(CustomJmsMessage msg) {
        jmsTemplate.convertAndSend("customJmsMessage.q", msg);
    }
}
