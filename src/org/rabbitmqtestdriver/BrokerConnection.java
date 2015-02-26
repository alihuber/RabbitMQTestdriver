package org.rabbitmqtestdriver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class BrokerConnection {

    private Connection connection = null;
    private ConnectionFactory factory = null;
    private String hostName;
    private String vhostName;
    private String username;
    private char[] password;

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setVhostName(String vhostName) {
        this.vhostName = vhostName;
    }

    public String getVhostName() {
        return vhostName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public BrokerConnection(String hostName, String vhostName,
            String username, char[] password) {
        factory = new ConnectionFactory();
        factory.setConnectionTimeout(2000);
        factory.setHost(hostName);
        factory.setVirtualHost(vhostName);
        factory.setUsername(username);
        factory.setPassword(String.valueOf(password));
    }

    public String sendSingleSmokeTestMessage(String queueName,
            String message) throws Exception {
        if(queueName == null || queueName.equals("")) {
            throw new IllegalArgumentException("No queue name set");
        }
        Channel channel = openConnection(queueName);
        try {
            channel.basicPublish("", queueName, null, message.getBytes());
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        if (channel != null) {
            channel.close();
            connection.close();
        }
        return ("Sent '" + message + "'");
    }

    public boolean sendBulkSmokeTestMessages(String queueName, int amount) throws Exception {
        if(queueName == null || queueName.equals("")) {
            throw new IllegalArgumentException("No queue name set");
        }
        Channel channel = openConnection(queueName);
        for (int i = 0; i < amount; i++) {
            RandomString random = new RandomString(20);
            String message = random.nextString() + "_" + String.valueOf(i);
            try {
                channel.basicPublish("", queueName, null, message.getBytes());
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    throw e;
                }
            }
        }
        if (channel != null) {
            channel.close();
            connection.close();
        }
        return true;
    }

    private Channel openConnection(String queueName) throws Exception {
        try {
            connection = factory.newConnection();
        } catch (Exception e) {
            throw e;
        }
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        try {
            channel.queueDeclare(queueName, false, false, false, null);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return channel;
    }
}
