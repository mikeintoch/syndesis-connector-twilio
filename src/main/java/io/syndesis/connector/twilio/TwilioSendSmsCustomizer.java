package io.syndesis.connector.twilio;

import java.io.IOException;
import java.util.Map;

import org.apache.camel.Exchange;
import com.twilio.type.PhoneNumber;
import org.apache.camel.Message;
import io.syndesis.connector.support.util.ConnectorOptions;
import io.syndesis.integration.component.proxy.ComponentProxyComponent;
import io.syndesis.integration.component.proxy.ComponentProxyCustomizer;


public class TwilioSendSmsCustomizer implements ComponentProxyCustomizer {

    private TwilioSmsModel sms;

    @Override
    public void customize(ComponentProxyComponent component, Map<String, Object> options) {
        component.setBeforeProducer(this::beforeProducer);
    }

    public void beforeProducer(final Exchange exchange) throws IOException {
        final Message in = exchange.getIn();
        sms = (TwilioSmsModel)in.getBody();
        

        if (sms.getFrom() != null) {
            in.setHeader("CamelTwilioFrom", new PhoneNumber(sms.getFrom()));
        }
        
        if (sms.getTo() != null) {
            in.setHeader("CamelTwilioTo", new PhoneNumber(sms.getTo()));
        }
        
        if (sms.getBody() != null) {
            in.setHeader("CamelTwilioBody", sms.getBody());
        }
        
        
        
    }
}
