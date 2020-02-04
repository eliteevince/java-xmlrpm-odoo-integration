package com.eliteevince.proxy;

import com.eliteevince.Utils.Constants;
import com.eliteevince.Utils.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SessionProxy {

    private static final Logger LOGGER = Logger.getLogger(SessionProxy.class.getName());
    private InputStream stream;
    private static final SessionProxy SESSION_MANAGER = new SessionProxy();
    private Properties PROPERTIES = new Properties();

    private Integer userId;
    private String protocol;
    private String host;
    private String database;
    private String port;
    private String url;
    private String username;
    private String password;

    /**
     * TODO: Configure Properties
     */
    public SessionProxy() {
        try {
            stream = SessionProxy.class.getResourceAsStream("/odoo-config.properties");
            PROPERTIES.load(stream);
            setProtocol(PROPERTIES.getProperty(Constants.PropsName.PROTOCOL.toString()));
            setHost(PROPERTIES.getProperty(Constants.PropsName.HOST.toString()));
            setPort(PROPERTIES.getProperty(Constants.PropsName.PORT.toString()));
            setDatabase(PROPERTIES.getProperty(Constants.PropsName.DB.toString()));
            setUsername(PROPERTIES.getProperty(Constants.PropsName.USERNAME.toString()));
            setPassword(PROPERTIES.getProperty(Constants.PropsName.PASSWORD.toString()));
            setUrl();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Property file not found");
        }
    }

    public static SessionProxy getInstance() {
        return SESSION_MANAGER;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = StringUtils.isNullOrEmpty(protocol)
                ? Constants.PROTOCOL : protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = StringUtils.isNullOrEmpty(host)
                ? Constants.HOST : host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = StringUtils.isNullOrEmpty(port)
                ? Constants.PORT : port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = StringUtils.isNullOrEmpty(username)
                ? Constants.USERNAME : username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.isNullOrEmpty(password)
                ? Constants.PASSWORD : password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDatabase() {

        return database;
    }

    public void setDatabase(String database) {
        this.database = StringUtils.isNullOrEmpty(database)
                ? Constants.DB : database;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl() {
        this.url = this.protocol + "://" + this.host + ":" + this.port;
    }

    @Override
    public String toString() {
        return "SessionManager{" + "stream=" + stream + ", userId=" + userId + ", protocol=" + protocol + ", host=" + host + ", database=" + database + ", port=" + port + ", username=" + username + ", password=" + password + '}';
    }

}
