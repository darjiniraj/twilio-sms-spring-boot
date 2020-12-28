package in.niraj.service;

import in.niraj.model.MessageBody;
import com.twilio.rest.api.v2010.account.Message;

public interface SMSService {
	Message sendSMS(MessageBody messageBody);

}