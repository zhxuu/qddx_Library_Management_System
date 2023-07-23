package com.etoak.java.web;

import com.alibaba.fastjson.JSONObject;
import com.etoak.java.bean.BookInformation;
import com.etoak.java.bean.StuInfo;
import com.etoak.java.service.BookAndBorrowService;
import com.etoak.java.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/Register",name="RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        req.setCharacterEncoding("UTF-8");
        //获取请求参数

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        StuInfo stuInfo =
                new StuInfo();
//        bookInfo.setId(id);
        stuInfo.setUsername(username);
        stuInfo.setPassword(password);

        StuService service=
                new StuService();
        int result=service.addStu(stuInfo);
        //规范返回结果
        Map<String,Object> resultMap=new HashMap<>();
        if(result>0){
            //新增成功
            resultMap.put("code",200);
            resultMap.put("msg","新增成功");
            resultMap.put("data",result);
        }else{
            //新增失败
            resultMap.put("code",500);
            resultMap.put("msg","新增失败");
            resultMap.put("data",result);
        }
        //设计返回结果为JSON格式
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String resultJson = JSONObject.toJSONString(resultMap);
        writer.write(resultJson);
        writer.flush();
        writer.close();
    }
}
