package org.rabbitmqtestdriver;

import java.io.IOException;

public class SmokeTest {

    private final String queueName;
    private String message;
    private final BrokerConnection connection;

    public SmokeTest(BrokerConnection connection, String queueName,
            String message)
            throws IOException {
        this.connection = connection;
        this.queueName = queueName;
        this.message = message;
    }
    
    public SmokeTest(BrokerConnection connection, String queueName) {
        this.connection = connection;
        this.queueName = queueName;
    }
    
    public boolean sendBulkMessages(int amount) {
        return this.connection.sendBulkSmokeTestMessages(this.queueName, amount);
    }

    public String sendSingleMessage() throws Exception {
        String returnMessage;
        returnMessage = connection.sendSingleSmokeTestMessage(this.queueName,
                this.message);
        return returnMessage;
    }
}
