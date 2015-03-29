package org.rabbitmqtestdriver;

public class Worker {

    private String message;
    private String workTime;
    private final BrokerConnection connection;

    public Worker(BrokerConnection connection, String message, String workTime) {
        if(connection == null) {
            throw new IllegalArgumentException("No connection set");
        }
        this.connection = connection;
        this.message = message;
        this.workTime = workTime;
    }
    
    public String sendWorkerMessage() throws Exception {
        String returnMessage = null;
        try {
            returnMessage = 
                    connection.sendWorkerMessage(this.message, this.workTime);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw e;
            }
        }
        return returnMessage;
    }
}