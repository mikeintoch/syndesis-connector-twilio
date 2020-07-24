package io.syndesis.connector.twilio;

import java.io.Serializable;

public class TwilioSmsModel implements Serializable {

	private static final long serialVersionUID = 280189554509505021L;
	
	private String from;
	private String to;
	private String body;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "[ { " + from + " }, { " + to + " }," + " { " + body + " } ]";
	}

}
