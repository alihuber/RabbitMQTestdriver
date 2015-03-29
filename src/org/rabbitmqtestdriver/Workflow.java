package org.rabbitmqtestdriver;

public class Workflow {

    private String message;
    private final BrokerConnection connection;

    public Workflow(BrokerConnection connection, String message) {
        if (connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
        this.message = message;
    }

    public Workflow(BrokerConnection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
    }

    public boolean sendBulkMessages(int amount) throws Exception {
        try {
            return this.connection.sendBulkWorkflowMessages(amount);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return false;
    }

    public String sendWorkflowMessage() throws Exception {
        String returnMessage = null;
        try {
            returnMessage
                    = connection.sendSingleWorkflowMessage(this.message);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return returnMessage;
    }
}
