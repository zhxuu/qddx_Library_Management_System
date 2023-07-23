package com.etoak.java.web;

import com.alibaba.fastjson.JSONObject;
import com.etoak.java.bean.BorrowRecord;
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

@WebServlet(urlPatterns = "/addRecord",name="AddRecordServlet")
public class AddRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        req.setCharacterEncoding("UTF-8");
        //获取请求参数

        Integer bookId = Integer.parseInt(req.getParameter("bookId"));
        String borrowerName = req.getParameter("borrowerName");
        String borrowerSno = req.getParameter("borrowerSno");
        String phone = req.getParameter("phone");
        String borrowTime = req.getParameter("borrowTime");
        String returnTime = req.getParameter("returnTime");
        String returnState = req.getParameter("returnState");
        String remarks = req.getParameter("remarks");
        //Integer id = Integer.parseInt(req.getParameter("id"));
        BorrowRecord borrowRecord =
                new BorrowRecord();
        //borrowRecord.setId(id);
        borrowRecord.setBookId(bookId);
        borrowRecord.setBorrowerName(borrowerName);
        borrowRecord.setBorrowerSno(borrowerSno);
        borrowRecord.setPhone(phone);
        borrowRecord.setBorrowTime(borrowTime);
        borrowRecord.setReturnTime(returnTime);
        borrowRecord.setReturnState(returnState);
        borrowRecord.setRemarks(remarks);



        BookAndBorrowService service=
                new BookAndBorrowService();
        int result=service.addRecord(borrowRecord);
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
