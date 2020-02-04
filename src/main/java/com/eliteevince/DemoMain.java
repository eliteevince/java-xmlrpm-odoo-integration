package com.eliteevince;

import com.eliteevince.proxy.SessionProxy;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;

public class DemoMain extends OdooServerManager {

    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        DemoMain ljson = new DemoMain();
        SessionProxy sessionProxy = new SessionProxy();
        System.out.println("Login");
        System.out.println("--------------");
        ljson.login(sessionProxy);
        if (null != sessionProxy.getUserId() && sessionProxy.getUserId() > 0) {
            System.out.println("Login Successed, With user id: " + sessionProxy.getUserId() + "\n\n"
                    + "Fetch all databases\n--------------");
            List<String> databaseList = ljson.getDatabaseList(sessionProxy);
            databaseList.forEach(res -> System.out.println(res));
        } else {
            System.out.println("Login Failed");
            return;
        }
    }

}
