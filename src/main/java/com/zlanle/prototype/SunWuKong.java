package com.zlanle.prototype;

import java.io.*;
import java.util.Date;

public class SunWuKong extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public SunWuKong(){
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }
    @Override
    protected Object clone(){
        return this.deepClone();
    }

    /**
     * 深复制
     * @return
     */
    private Object deepClone() {
        try {
            /** 内存中完成操作，写入当前对象的二进制流*/
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            
            /**读出二进制流产生新对象*/
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            SunWuKong sunWuKong = (SunWuKong) ois.readObject();
            sunWuKong.birthday = new Date();
            return sunWuKong;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**浅复制*/
    public SunWuKong shallowClone(SunWuKong target){
        SunWuKong object = new SunWuKong();
        object.height = target.height;
        object.weight = target.weight;
        object.jinGuBang = target.jinGuBang;
        object.birthday = new Date();
        return object;
    }
}
