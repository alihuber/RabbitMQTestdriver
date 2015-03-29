package org.rabbitmqtestdriver;

public class Topic {

    private final BrokerConnection connection;
    private String topicNamespace;
    private String topicMessage;

    public Topic(BrokerConnection connection, String topicNamespace,
            String topicMessage) {
        if (connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
        this.topicNamespace = topicNamespace;
        this.topicMessage = topicMessage;
    }

    public String sendTopicMessage() throws Exception {
        String returnMessage = null;
        try {
            returnMessage = connection.sendTopicMessage(this.topicNamespace,
                    this.topicMessage);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return returnMessage;
    }
}
