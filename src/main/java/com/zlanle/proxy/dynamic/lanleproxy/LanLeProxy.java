package com.zlanle.proxy.dynamic.lanleproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LanLeProxy {

    public final static String ln = "\r\n";

    private static Map<Class,Class> mappings = new HashMap<>();

    public static Object newProxyInstance(LanLeClassLoader loader, Class<?>[] interfaces, LanLeInvocationHandler h){

        try {
            //1、动态生成源代码.java文件
            String src = generateSrc(interfaces);
            //System.out.println(src);

            //2、Java文件输出到磁盘
            String filePath = LanLeProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4、编译生成的.class文件加载到jvm中来
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(LanLeInvocationHandler.class);
            file.delete();

            //5、返回字节码重组以后的新的代理对象
            return constructor.newInstance(h);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.zlanle.proxy.dynamic.lanleproxy;" + ln);
        sb.append("import com.zlanle.proxy.statical.demo1.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
            sb.append("private LanLeInvocationHandler h;" + ln);
            sb.append("public $Proxy0(LanLeInvocationHandler h) {" + ln);
                sb.append("this.h = h;" + ln);
            sb.append("}" + ln);
            for (Method method : interfaces[0].getMethods()){
                Class<?>[] params = method.getParameterTypes();
                StringBuffer paramNames = new StringBuffer();
                StringBuffer paramValues = new StringBuffer();
                StringBuffer paramClasses = new StringBuffer();
                for (int i = 0; i < params.length; i++){
                    Class<?> clazz = params[i];
                    String type = clazz.getName();
                    String paramName = LanLeProxy.toLowerFirstCase(clazz.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramValues.append(paramName);
                    paramClasses.append(clazz.getName() + ".class");
                    if(i > 0 && i < params.length-1){
                        paramNames.append(",");
                        paramValues.append(",");
                        paramClasses.append(",");
                    }
                }
                sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "("+ paramNames.toString() +") {" + ln);
                    sb.append("try {" + ln);
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\""+ method.getName() + "\",new Class[]{"+ paramClasses.toString() +"});" + ln);
                        sb.append((hasReturnValue(method.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{"+ paramValues +"})",method.getReturnType()) + ";" + ln);
                    sb.append("} catch (Error _ex) {");
                    sb.append("} catch(Throwable e){" + ln);
                    sb.append("throw new UndeclaredThrowableException(e);" +ln);
                    sb.append("}" + ln);
                    sb.append(getReturnEmptyCode(method.getReturnType()));
                sb.append("}" +ln);
            }
        sb.append("}" + ln);
        return sb.toString();
    }

    static{
        mappings.put(int.class,Integer.class);
    }

    /**
     * 处理返回结果
     * @param returnClass
     * @return
     */
    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0";
        }else if(returnClass == void.class){
            return "";
        }else{
            return "return null";
        }
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(!mappings.containsKey(returnClass)) return code;
        return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
    }

    /**
     * 判断参数类型是否为空
     * @param clazz
     * @return
     */
    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    /**
     * 参数首字母转大写
     * @param param
     * @return
     */
    public static String toLowerFirstCase(String param){
        char[] chars = param.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
