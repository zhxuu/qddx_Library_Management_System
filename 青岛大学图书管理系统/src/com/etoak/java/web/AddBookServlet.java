package com.etoak.java.web;

import com.alibaba.fastjson.JSONObject;
import com.etoak.java.bean.BookInformation;
import com.etoak.java.service.BookAndBorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

    @WebServlet(urlPatterns = "/addBook",name="AddBookServlet")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        req.setCharacterEncoding("UTF-8");
        //获取请求参数

        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        String pubDate = req.getParameter("pubDate");
        Integer wordNumber = Integer.parseInt(req.getParameter("wordNumber"));
        Integer price = Integer.parseInt(req.getParameter("price"));
        String enterTime = req.getParameter("enterTime");
//        Integer id = Integer.parseInt(req.getParameter("id"));
        String status = req.getParameter("status");

        BookInformation bookInfo =
                new BookInformation();
//        bookInfo.setId(id);
        bookInfo.setBookName(bookName);
        bookInfo.setAuthor(author);
        bookInfo.setPubDate(pubDate);
        bookInfo.setWordNumber(wordNumber);
        bookInfo.setPrice(price);
        bookInfo.setEnterTime(enterTime);
        bookInfo.setStatus(status);



        BookAndBorrowService service=
                new BookAndBorrowService();
        int result=service.addBook(bookInfo);
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
