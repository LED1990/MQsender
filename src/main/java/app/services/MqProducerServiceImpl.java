package app.services;

import app.services.interfaces.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MqProducerServiceImpl implements MqProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendSimpleTextMessage(String msg) {
        jmsTemplate.convertAndSend("senderQueue.q",msg);
    }
}
