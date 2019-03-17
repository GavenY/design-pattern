package com.gaven.pattern.DelegateTest.simple;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class Leader implements IEmployee {


    private Map<String,IEmployee> targets = new HashMap<String,IEmployee>();

    public Leader() {
        targets.put("加密",new EmployeeA());
        targets.put("登录",new EmployeeB());
    }

    //项目经理自己不干活
    public void doing(String command){
        targets.get(command).doing(command);
    }

}
