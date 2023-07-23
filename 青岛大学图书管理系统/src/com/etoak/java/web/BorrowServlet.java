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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="BorrowServlet",urlPatterns = "/record")
public class BorrowServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookAndBorrowService service = new BookAndBorrowService();
        // 设置返回类型格式
        resp.setContentType("application/json;charset=utf-8");
        // 取参数
        String method = req.getParameter("method");
        if("getList".equals(method)){///////////getlist
            String borrowerName = req.getParameter("borrowerName");
            String borrowerSno = req.getParameter("borrowerSno");
            BorrowRecord borrowRecord = new BorrowRecord();
            borrowRecord.setBorrowerName(borrowerName);
            borrowRecord.setBorrowerSno(borrowerSno);

            // 获取所有的符合条件的记录
            List<BorrowRecord> resultList = service.getRecordsList(borrowRecord);
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

        /////////////////////////////////
        if("info".equals(method)){
            // 查询指定id的记录
            String id = req.getParameter("id");
            BorrowRecord info =
                    service.getRecordsById(Integer.parseInt(id));
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
            Integer bookId = Integer.parseInt(req.getParameter("bookId"));
            String borrowerName = req.getParameter("borrowerName");
            String borrowerSno = req.getParameter("borrowerSno");
            String phone = req.getParameter("phone");
            String borrowTime = req.getParameter("borrowTime");
            String returnTime = req.getParameter("returnTime");
            String returnState = req.getParameter("returnState");
            String remarks = req.getParameter("remarks");
            Integer id = Integer.parseInt(req.getParameter("id"));
            // 组装更新借阅记录对象
            BorrowRecord borrowRecord =
                    new BorrowRecord();
            borrowRecord.setId(id);
            borrowRecord.setBookId(bookId);
            borrowRecord.setBorrowerName(borrowerName);
            borrowRecord.setBorrowerSno(borrowerSno);
            borrowRecord.setPhone(phone);
            borrowRecord.setBorrowTime(borrowTime);
            borrowRecord.setReturnTime(returnTime);
            borrowRecord.setReturnState(returnState);
            borrowRecord.setRemarks(remarks);

            int result = service.updateRecordById(borrowRecord);
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
