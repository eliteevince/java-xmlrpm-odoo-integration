package com.eliteevince;

import com.eliteevince.Utils.Constants;
import com.eliteevince.proxy.SessionProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 *
 * @author Meet
 */
public class OdooServerManager {

    private static final Logger LOGGER = Logger.getLogger(OdooServerManager.class.getName());

    XmlRpcClient client = new XmlRpcClient();
    XmlRpcClientConfigImpl xmlrpcConfigDb = new XmlRpcClientConfigImpl();

    {
        xmlrpcConfigDb.setEnabledForExtensions(true);
        client.setConfig(xmlrpcConfigDb);
    }

    public void login(SessionProxy proxy) throws XmlRpcException, MalformedURLException {
        xmlrpcConfigDb.setServerURL(new URL(proxy.getUrl() + Constants.COMMON_URL));
        Object[] params = new Object[]{proxy.getDatabase(), proxy.getUsername(), proxy.getPassword()}; // Ok & simple
        Object uid = client.execute("login", params);
        if (uid instanceof Integer) {
            proxy.setUserId((int) uid);
        }
    }

    public void saveProductToOdoo(SessionProxy proxy) throws XmlRpcException, MalformedURLException {
        System.out.println("USer ID: - " + proxy.getUserId());
       
        xmlrpcConfigDb.setServerURL(new URL(proxy.getUrl() + Constants.OBJECT_URL));
        
//        client.execute("execute_kw ", Arrays.asList(new Object[]{proxy.getDatabase(), proxy.getUserId(),
//            proxy.getPassword(), "res.partner", "create", Arrays.asList(new Object[]{"Test", "Meet Test", "en", true})}));
    }

    public List<String> getDatabaseList(SessionProxy proxy) throws MalformedURLException, XmlRpcException {

        if (null == proxy.getUserId()) {
            LOGGER.log(Level.SEVERE, "You are not authenticated");
            return Collections.emptyList();
        }

        xmlrpcConfigDb.setServerURL(new URL(proxy.getUrl() + "/xmlrpc/db"));
        client.setConfig(xmlrpcConfigDb);

        try {
            //Retrieve databases
            List<Object> params = new ArrayList<>();
            Object result = client.execute("list", params);
            Object[] a = (Object[]) result;

            List<String> res = Arrays.asList(a).stream().map(obj -> (String) obj).collect(Collectors.toList());
            return res;
        } catch (XmlRpcException e) {
            LOGGER.log(Level.SEVERE, "XmlException Error while retrieving OpenERP Databases: {0}", e);
            return Collections.emptyList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while retrieving OpenERP Databases: {0}", e);
            return Collections.emptyList();
        }
    }
}
