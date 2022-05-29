package com.szl.springboot.test;

import com.szl.springboot.util.SeriablesSingleton;

import java.io.*;

/**
 * @Author songzhenliang
 * @Date 2022-05-29 下午4:43
 */
public class SeriablesSingletonTest {


    public static void main(String[] args) {
        SeriablesSingleton s1 = null;
        SeriablesSingleton s2 = SeriablesSingleton.getInstance();

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("SeriablesSingleton.io");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("SeriablesSingleton.io");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriablesSingleton)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);

            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
