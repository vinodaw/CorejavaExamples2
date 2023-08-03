package com.org.examples.jms;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSession;
import javax.jms.QueueReceiver;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

public class MsgReciever {

	public static void main(String[] args) throws NamingException, JMSException {
		
		// get the initial context
	       InitialContext context = new InitialContext();
	                                                                           
	      // lookup the queue object
	       Queue queue = (Queue) context.lookup("queue/queue0");
	                                                                           
	       // lookup the queue connection factory
	       QueueConnectionFactory conFactory = (QueueConnectionFactory) context.lookup ("queue/connectionFactory");
	                                                                           
	       // create a queue connection
	       QueueConnection queConn = conFactory.createQueueConnection();
	                                                                           
	       // create a queue session
	       QueueSession queSession = queConn.createQueueSession(false,   
	       Session.AUTO_ACKNOWLEDGE);
	 
	       // create a queue receiver
	       QueueReceiver queReceiver = queSession.createReceiver(queue);
	                                                                           
	       // start the connection
	       queConn.start();
	                                                                           
	       // receive a message
	       TextMessage message = (TextMessage) queReceiver.receive();
	                                                                           
	       // print the message
	       System.out.println("Message Received: " + message.getText());
	                                                                           
	       // close the queue connection
	       queConn.close();

	}

}
