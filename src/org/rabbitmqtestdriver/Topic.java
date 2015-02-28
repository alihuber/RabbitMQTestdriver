package org.rabbitmqtestdriver;


public class Topic {
    
    private final BrokerConnection connection;
    private String debugInfoMessage;
    private String debugWarningMessage;
    private String loggerInfoMessage;

    public Topic(BrokerConnection connection, String debugInfoMessage,
            String debugWarningMessage, String loggerInfoMessage) {
        if(connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
        this.debugInfoMessage = debugInfoMessage;
        this.debugWarningMessage = debugWarningMessage;
        this.loggerInfoMessage = loggerInfoMessage;
    }
    
    public String sendTopicMessages() throws Exception {
        String returnMessage = null;
        try {
            returnMessage = connection.sendTopicMessages(this.debugInfoMessage,
                    this.debugWarningMessage, this.loggerInfoMessage);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return returnMessage;
    }   
}