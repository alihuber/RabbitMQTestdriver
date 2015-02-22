package org.rabbitmqtestdriver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;

public class SmokeTest {

    public SmokeTest(String hostName, String vhostName, String username,
            String password, String queueName, String message)
            throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setConnectionTimeout(2000);
        factory.setHost(hostName);
        factory.setVirtualHost(vhostName);
        factory.setUsername(username);
        factory.setPassword(password);
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            }
        }
        try {
            channel.queueDeclare(queueName, false, false, false, null);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            }
        }
        try {
            channel.basicPublish("", queueName, null, message.getBytes());
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            }
        }

        if (channel != null) {
            System.out.println("Sent '" + message + "'");
            channel.close();
            connection.close();
        }
    }
}