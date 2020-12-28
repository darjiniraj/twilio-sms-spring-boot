package in.niraj.service.impl;

import in.niraj.model.MessageBody;
import in.niraj.service.SMSService;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
@Service
public class SMSServiceTwilio implements SMSService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.account.authtoken}")
    private String authToken;

    @Value("${twilio.sender.number}")
    private String senderNumber;

    @Override
    public Message sendSMS(MessageBody messageBody) {
        Twilio.init(accountSid, authToken);
        return Message.creator(
                new PhoneNumber(messageBody.getToNumber()),//The phone number you are sending text to. verified only for test account
                new PhoneNumber(senderNumber),//The Twilio phone number, generate this number in twilio.com
                messageBody.getMsg())
           .create();

    }
}