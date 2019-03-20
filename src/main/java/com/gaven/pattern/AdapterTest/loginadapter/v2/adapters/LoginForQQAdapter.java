package com.gaven.pattern.AdapterTest.loginadapter.v2.adapters;

import com.gaven.pattern.AdapterTest.loginadapter.ResultMsg;

/**
 * Created by Tom on 2019/3/16.
 */
public class LoginForQQAdapter implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return new ResultMsg(200,"登入成功",null);
    }
}
