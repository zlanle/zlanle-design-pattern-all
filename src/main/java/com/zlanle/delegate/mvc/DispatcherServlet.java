package com.zlanle.delegate.mvc;

import com.zlanle.delegate.mvc.controller.MemberController;
import com.zlanle.delegate.mvc.controller.OrderController;
import com.zlanle.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 相当于项目经理的角色
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerList = new ArrayList<Handler>();

//    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String uri = request.getRequestURI();
//        String id = request.getParameter("id");
//        if("getMemberById".equals(uri)){
//            new MemberController().getMemberById(id);
//        }else if ("getOrderById".equals(uri)){
//            new OrderController().getOrderById(id);
//        }else if("logout".equals(uri)){
//            new SystemController().logout();
//        }else{
//            response.getWriter().println("404 NOT FOUND");
//        }
//    }

    @Override
    public void init() throws ServletException {
        try {
            Class<?> memberControllerClass = MemberController.class;
            handlerList.add(new Handler()
                    .setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、获取用户请求的URL，如果按照J2EE的标准，每个URL对应一个Servlet，URL由浏览器输入
        String uri = request.getRequestURI();
        //2、Servlet拿到URL以后，要做判断要做选择，根据用户请求的URL，去找到这个URL对应的某一个Java类的方法

        //3、通过拿到的URL去handlerList中找
        Handler handler = null;
        for (Handler h : handlerList){
            if(!uri.equals(h.getUrl())) continue;
            handler = h;
            break;
        }

        //4、将具体的任务分发给Method(通过反射去调用其对应的方法)
        try {
            Object object = handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5、获取到Method执行的结果，通过response返回出去
        response.getWriter().write(0);
    }

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
