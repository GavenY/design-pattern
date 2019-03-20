package com.gaven.pattern.AdapterTest.loginadapter.v2;

import com.gaven.pattern.AdapterTest.loginadapter.ResultMsg;
import org.springframework.aop.framework.adapter.AdvisorAdapter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;

/**
 * Created by Tom.
 */
public class PassportTest {

    public static void main(String[] args) {

        IPassportForThird passportForThird = new PassportForThirdAdapter();

        ResultMsg resultMsg = passportForThird.loginForQQ("");

        System.out.println(resultMsg.getMsg());

    }

}
