package org.rabbitmqtestdriver;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Settings {

    private String brokerIPAddress;
    private String vHostName;
    private String username;
    private String password;
    private final PropertyChangeSupport changeSupport = 
            new PropertyChangeSupport(this);

    public Settings(String brokerIPAddress, String vHostname, String username,
            String password) {
        this.brokerIPAddress = brokerIPAddress;
        this.vHostName = vHostname;
        this.username = username;
        this.password = password;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getBrokerIPAddress() {
        return brokerIPAddress;
    }

    public void setBrokerIPAddress(String brokerIPAddress) {
        String old = this.brokerIPAddress;
        this.brokerIPAddress = brokerIPAddress;
        changeSupport.firePropertyChange("brokerIPAddress", old, brokerIPAddress);
    }

    public String getvHostName() {
        return vHostName;
    }

    public void setvHostName(String vHostName) {
        String old = this.vHostName;
        this.vHostName = vHostName;
        changeSupport.firePropertyChange("vHostName", old, vHostName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String old = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", old, vHostName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String old = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", old, vHostName);
    }
}
