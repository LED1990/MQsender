package app.controllers;

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
        return "Sukcess";
    }
}
