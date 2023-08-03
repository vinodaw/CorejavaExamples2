package com.org.examples.jms;

import javax.naming.InitialContext;
import javax.naming.NamingException;                                                             
                                                                            
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

public class MsgSender {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ctx = new InitialContext();
		
		 Queue queue = (Queue) ctx.lookup("queue/queue0");
		 
		 QueueConnectionFactory conFactory = (QueueConnectionFactory)  ctx.lookup("queue/connectionFactory");
		 
		 QueueConnection queConn = conFactory.createQueueConnection();
		 
		 QueueSession queSession = queConn.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
         
	       // create a queue sender
	       QueueSender queueSender = queSession.createSender(queue);
	       queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	                                                                           
	       // create a simple message to say "Hello World"
	       TextMessage message = queSession.createTextMessage("Hello World");
	                                                     
	       // send the message
	       queueSender.send(message);
	                                                                          
	       // print what we did
	       System.out.println("Message Sent: " + message.getText());
	                                                                           
	       // close the queue connection
	       queConn.close();

	}

}
