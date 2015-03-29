package org.rabbitmqtestdriver;

import com.rabbitmq.client.AMQP;
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

    public String sendWorkerMessage(String message, String workTime)
            throws Exception {
        Channel channel = openWorkerConnection();
        // Insert workTime-info as message "type" property.
        // deliveryMode(2) = persistent
        try {
            // (java.lang.String exchange, java.lang.String routingKey, 
            // AMQP.BasicProperties props, byte[] body)
            channel.basicPublish("", "task_queue",
                    new AMQP.BasicProperties.Builder()
                    .contentType("text/plain").deliveryMode(2)
                    .type(workTime)
                    .build(),
                    message.getBytes());
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        if (channel != null) {
            channel.close();
            connection.close();
        }
        return ("Sent '" + message + "' with delay: " + workTime);
    }

    public String sendSingleWorkflowMessage(String message)
            throws Exception {
        Channel channel = openWorkflowConnection();
        // deliveryMode(2) = persistent
        try {
            // (java.lang.String exchange, java.lang.String routingKey, 
            // AMQP.BasicProperties props, byte[] body)
            channel.basicPublish("sneakers", "workflow_in",
                    new AMQP.BasicProperties.Builder()
                    .contentType("text/plain").deliveryMode(2)
                    .build(),
                    message.getBytes());
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

    public String sendSingleSmokeTestMessage(String queueName,
            String message) throws Exception {
        if (queueName == null || queueName.equals("")) {
            throw new IllegalArgumentException("No queue name set");
        }
        Channel channel = openSmokeTestConnection(queueName);
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

    public boolean sendBulkSmokeTestMessages(String queueName, int amount)
            throws Exception {
        if (queueName == null || queueName.equals("")) {
            throw new IllegalArgumentException("No queue name set");
        }
        Channel channel = openSmokeTestConnection(queueName);
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

    public boolean sendBulkWorkflowMessages(int amount) throws Exception {
        Channel channel = openWorkflowConnection();
        for (int i = 0; i < amount; i++) {
            RandomString random = new RandomString(20);
            String message = random.nextString() + "_" + String.valueOf(i);
            try {
                channel.basicPublish("sneakers", "workflow_in",
                        new AMQP.BasicProperties.Builder()
                        .contentType("text/plain").deliveryMode(2)
                        .build(),
                        message.getBytes());
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

    public String sendTopicMessage(String topicNamespace,
            String topicMessage) throws Exception {
        Channel channel = null;
        try {
            channel = openTopicConnection();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        if (topicNamespace == null || topicNamespace.isEmpty()) {
            throw new IllegalArgumentException("Topic namespace is empty");
        } else {
            try {
                channel.basicPublish("log", topicNamespace, null,
                        topicMessage.getBytes());
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    throw e;
                }
            }
        }
        return "Sent topic message";
    }

    private Channel openTopicConnection() throws Exception {
        Channel channel = null;
        try {
            channel = createChannel();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        try {
            channel.exchangeDeclare("log", "topic");
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return channel;
    }

    private Channel openSmokeTestConnection(String queueName)
            throws Exception {
        Channel channel = null;
        try {
            channel = createChannel();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        try {
            // (java.lang.String queue, boolean durable, boolean exclusive, 
            // boolean autoDelete, 
            // java.util.Map<java.lang.String,java.lang.Object> arguments)
            channel.queueDeclare(queueName, false, false, false, null);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return channel;
    }

    private Channel openWorkerConnection() throws Exception {
        Channel channel = null;
        try {
            channel = createChannel();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        try {
            channel.queueDeclare("task_queue", true, false, false, null);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return channel;
    }

    private Channel openWorkflowConnection() throws Exception {
        Channel channel = null;
        try {
            channel = createChannel();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        // no re-declaring of durable workflow_in-channel for sneakers.io
        return channel;
    }

    private Channel createChannel() throws Exception {
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
        return channel;
    }
}
