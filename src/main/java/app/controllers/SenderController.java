package app.controllers;

import app.model.CustomJmsMessage;
import app.model.CustomJmsMessageDetails;
import app.services.interfaces.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sender")
public class SenderController {

    @Autowired
    private MqProducerService mqProducerService;

    @RequestMapping("/sendTextToQueue")
    public String sendTextToActiveMqQueue(){
        mqProducerService.simpleTextProducer("sendTextToQueue controller message");
        return "Sukcess simple text";
    }

    @RequestMapping("/sendCustomMessageToQueue")
    public String sendCustomMessageToActiveMqQueue(){
        CustomJmsMessageDetails customJmsMessageDetails = new CustomJmsMessageDetails();
        customJmsMessageDetails.setId(1);
        customJmsMessageDetails.setMsgDetails("datails about message");
        customJmsMessageDetails.setControlSum("control sum");
        CustomJmsMessage customJmsMessage = new CustomJmsMessage();
        customJmsMessage.setId(1);
        customJmsMessage.setDetails(customJmsMessageDetails);
        customJmsMessage.setMsg("main message from custom message");
        mqProducerService.customJmsMessageProducer(customJmsMessage);
        return "Sukcess custom message";
    }
}
