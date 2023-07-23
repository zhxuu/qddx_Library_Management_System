package com.etoak.java.dao;

import com.etoak.java.bean.BookInformation;
import com.etoak.java.bean.BorrowRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookAndBorrowDao {
    //书的功能

    // 添加图书信息
    int addBook(BookInformation b);

    // 查询全部图书信息
    List<BookInformation> getAllBooks();

    // 查询指定id的书籍
    BookInformation getBooksById(Integer id);
    //查询指定书籍名的书籍id
    Integer getIDByName(String bookName);

    List<BookInformation> getBookList(BookInformation book);
    // 删除指定id的书籍
    int deleteById(Integer id);
    //更新书籍
    int updateById(BookInformation book);

    //借阅记录

    // 添加借阅记录
    int addRecord(BorrowRecord b);

    // 查询全部借阅记录信息
    List<BorrowRecord> getAllRecords();
    // 查询指定id的借阅记录
    BorrowRecord getRecordsById(Integer id);
//    //查询指定书籍id的借阅记录
//    List<BorrowRecord> getRecordsByBookId(Integer id);
    // 查询指定书籍id的借阅记录
    List<BorrowRecord> getRecordsByBookId(Integer id);
    //查询指定人的借阅记录 传类
    List<BorrowRecord> getRecordsList(BorrowRecord br);


//    // 删除指定id的书籍
//    int deleteById(Integer id);
    //更新借阅记录
    int updateRecordById(BorrowRecord br);

    List<BorrowRecord> getRecordByBookName(String name);

}
