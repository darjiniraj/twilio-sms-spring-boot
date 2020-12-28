package in.niraj.controller;

import in.niraj.model.MessageBody;
import in.niraj.service.SMSService;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SMSController {

    private final SMSService smsService;

    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public Message sendSMS(@RequestBody MessageBody messageBody) {
        return smsService.sendSMS(messageBody);
    }

}