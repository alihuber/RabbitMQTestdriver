package org.rabbitmqtestdriver;

public class SmokeTest {

    private final String queueName;
    private String message;
    private final BrokerConnection connection;

    public SmokeTest(BrokerConnection connection, String queueName,
            String message) {
        if (connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
        this.queueName = queueName;
        this.message = message;
    }

    public SmokeTest(BrokerConnection connection, String queueName) {
        if (connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
        this.queueName = queueName;
    }

    public boolean sendBulkMessages(int amount) throws Exception {
        try {
            return this.connection.sendBulkSmokeTestMessages(this.queueName,
                    amount);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return false;
    }

    public String sendSingleMessage() throws Exception {
        String returnMessage = null;
        try {
            returnMessage = connection.sendSingleSmokeTestMessage(this.queueName,
                    this.message);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return returnMessage;
    }
}
