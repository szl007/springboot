package com.szl.springboot.util;

import java.io.Serializable;

/**
 * @Author songzhenliang
 * @Date 2022-05-29 下午4:41
 */
public class SeriablesSingleton implements Serializable {

    public final static SeriablesSingleton INSTANCE = new SeriablesSingleton();

    private  SeriablesSingleton(){}

    public static SeriablesSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
