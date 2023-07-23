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
import java.util.List;
import java.util.Map;

@WebServlet(name="LoginServlet",urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StuService service=
                new StuService();
        // 设置返回类型格式
        resp.setContentType("application/json;charset=utf-8");
        // 取参数
        String method = req.getParameter("method");

        /////////////////////////////////
        if("info".equals(method)){
            // 查询指定username的password
            String username = req.getParameter("username");
            StuInfo info =
                    service.getpsw(username);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",info);

            String resultJson = JSONObject.toJSONString(resultMap);
            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();

        }
        ///////////////////////////

    }
}
