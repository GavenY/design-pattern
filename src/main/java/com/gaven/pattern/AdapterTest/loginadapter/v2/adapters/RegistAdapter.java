package com.gaven.pattern.AdapterTest.loginadapter.v2.adapters;

import com.gaven.pattern.AdapterTest.loginadapter.ResultMsg;

/**
 * Created by Tom on 2019/3/16.
 */
public interface RegistAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}
