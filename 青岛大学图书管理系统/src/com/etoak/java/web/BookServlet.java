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
import java.util.List;
import java.util.Map;

@WebServlet(name="BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookAndBorrowService service = new BookAndBorrowService();
        // 设置返回类型格式
        resp.setContentType("application/json;charset=utf-8");
        // 取参数
        String method = req.getParameter("method");
        if("getList".equals(method)){///////////getlist
            String bookName = req.getParameter("bookName");
            String author = req.getParameter("author");
            BookInformation book = new BookInformation();
            book.setBookName(bookName);
            book.setAuthor(author);

            // 获取所有的符合条件的书
            List<BookInformation> resultList = service.getBookList(book);
            //List<EtEmployeeInfo> resultList = service.getAllEmployees();
            // 组装返回数据
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",resultList);

            // 将resultMap -> json类型
            String resultJson = JSONObject.toJSONString(resultMap);

            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();
        }
        /////////////////////////////////////
        if("delete".equals(method)){//不用改
            // 删除功能
            String id = req.getParameter("id");
            int result = service.deleteById(Integer.parseInt(id));
            Map<String,Object> resultMap = new HashMap<>();
            if(result > 0){
                resultMap.put("code",200);
                resultMap.put("msg","删除成功");
            }else{
                resultMap.put("code",500);
                resultMap.put("msg","删除失败");
            }
            String resultJson = JSONObject.toJSONString(resultMap);
            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();
        }
        /////////////////////////////////
        if("info".equals(method)){
            // 查询指定id的书籍
            String id = req.getParameter("id");
            BookInformation info =
                    service.getBooksById(Integer.parseInt(id));
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
        if("edit".equals(method)){
            String bookName = req.getParameter("bookName");
            String author = req.getParameter("author");
            String pubDate = req.getParameter("pubDate");
            Integer wordNumber = Integer.parseInt(req.getParameter("wordNumber"));
            Integer price = Integer.parseInt(req.getParameter("price"));
            String enterTime = req.getParameter("enterTime");
            Integer id = Integer.parseInt(req.getParameter("id"));
            String status = req.getParameter("status");
            // 组装更新图书对象
            BookInformation bookInfo =
                    new BookInformation();
            bookInfo.setId(id);
            bookInfo.setBookName(bookName);
            bookInfo.setAuthor(author);
            bookInfo.setPubDate(pubDate);
            bookInfo.setWordNumber(wordNumber);
            bookInfo.setPrice(price);
            bookInfo.setEnterTime(enterTime);
            bookInfo.setStatus(status);

            int result = service.updateById(bookInfo);
            Map<String,Object> resultMap = new HashMap<>();
            if(result > 0){
                resultMap.put("code",200);
                resultMap.put("msg","更新成功");
            }else{
                resultMap.put("code",500);
                resultMap.put("msg","更新失败");
            }
            String resultJson = JSONObject.toJSONString(resultMap);
            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();
        }
    }
}
