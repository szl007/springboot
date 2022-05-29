package com.szl.springboot.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author songzhenliang
 * @Date 2022-05-27 下午1:10
 */
public abstract class Pool {
    public String propertiesName = "connection-IND.properties";

    //唯一实例
    private static Pool instance = null;

    //最大连接数
    protected  int maxConnect = 100;

    //保持连接数
    protected  int normalConnect = 10;

    //驱动字符串
    protected  String driverName = "";

    //驱动变量
    protected Driver driver = null;

    //构造函数
    protected Pool(){
        try {
            init();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 初始化配置文件，读取成员变量
     * @throws IOException
     */
    private void init() throws IOException {
        InputStream is =Pool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }


    protected void loadDrivers(String dri) {
        String driverClassName = dri;
        try{
            Class.forName(driverClassName).newInstance();

        }catch (Exception e){

        }

    }

}
