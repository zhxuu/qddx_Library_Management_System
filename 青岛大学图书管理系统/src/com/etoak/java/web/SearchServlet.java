package com.etoak.java.web;

import com.alibaba.fastjson.JSONObject;
import com.etoak.java.bean.BookInformation;
import com.etoak.java.bean.BorrowRecord;
import com.etoak.java.service.BookAndBorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="SearchServlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookAndBorrowService service = new BookAndBorrowService();
        // 设置返回类型格式
        resp.setContentType("application/json;charset=utf-8");
        // 取参数
        String method = req.getParameter("method");
//        if("getList".equals(method)){///////////getlist
//
//            //System.out.println(bookName);
//            // 获取所有的符合条件的jilu
//           // Integer bookid = service.getIDByName(bookName);
//            //System.out.println(bookid);
//            Integer bookid=Integer.parseInt(req.getParameter("bookId"));
//            List<BorrowRecord> resultList2 = service.getRecordsByBookId(bookid);
//            // 组装返回数据
//            Map<String,Object> resultMap = new HashMap<>();
//            resultMap.put("code",200);
//            resultMap.put("msg","查询成功");
//            resultMap.put("data",resultList2);
//
//            // 将resultMap -> json类型
//            String resultJson = JSONObject.toJSONString(resultMap);
//
//            PrintWriter pw = resp.getWriter();
//            pw.write(resultJson);
//            pw.flush();
//            pw.close();
//        }

        /////////////////////////////////
        if("info".equals(method)){
            // 查询指定名字的书籍id
            String bookName = req.getParameter("bookName");
            // 根据书名查询书ID
//            Integer i =service.getIDByName(bookName);
            //根据id查询记录
            List<BorrowRecord> records = service.getRecordByBookName(bookName);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",records);

            String resultJson = JSONObject.toJSONString(resultMap);
            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();

        }
    }
}
