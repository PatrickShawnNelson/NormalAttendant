package disc.discbot.Util;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class AMQUtil {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	private static String queueName = "Message_Queue";
	
	public void produceMessage() throws JMSException {
		System.out.println("url - " + url);
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
	}
	
	//Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	Destination destination;// = session.createQueue(queueName);
	
	MessageProducer producer;// = session.createProducer(destination);
	TextMessage message;// = session.createTextMessage("Hi Peter, How are you?");

	/*
	 * Here we are sending our message!
	 */
	//producer.send(message);

	//System.out.println("Message '" + message.getText() + ", Sent Successfully to the Queue");
	//connection.close();
}
