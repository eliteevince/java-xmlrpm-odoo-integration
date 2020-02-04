package com.eliteevince;

import com.eliteevince.proxy.SessionProxy;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;

public class LargeJSON extends OdooServerManager {

    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        LargeJSON ljson = new LargeJSON();
        SessionProxy sessionProxy = new SessionProxy();
        System.out.println("Login");
        System.out.println("--------------");
        ljson.login(sessionProxy);
        if (null != sessionProxy.getUserId() && sessionProxy.getUserId() > 0) {
            System.out.println("Login Ok");
        } else {
            System.out.println("Login Fail");
        }
        
        ljson.saveProductToOdoo(sessionProxy);
        List<String> databaseList = ljson.getDatabaseList(sessionProxy);
        databaseList.forEach(res -> System.out.println(res));
    }

}
