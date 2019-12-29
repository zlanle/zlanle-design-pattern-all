package com.zlanle.proxy.dynamic.lanleproxy;

import java.io.*;

public class LanLeClassLoader extends ClassLoader {

    private File classPathFile;

    public LanLeClassLoader(){
        String classPath = LanLeClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) {
        String className = LanLeClassLoader.class.getPackage().getName() + "." + name;
        if(classPathFile == null) return null;
        File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
        if(!classFile.exists()) return null;
        try {
            FileInputStream fileInputStream = new FileInputStream(classFile);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            return  defineClass(className,outputStream.toByteArray(),0,outputStream.size());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
