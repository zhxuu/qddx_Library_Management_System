package com.etoak.java.service;

import com.etoak.java.bean.BookInformation;
import com.etoak.java.bean.BorrowRecord;
import com.etoak.java.dao.BookAndBorrowDao;
import com.etoak.java.utils.MybatisUtil;

import java.util.List;

public class BookAndBorrowService {
    private BookAndBorrowDao dao =
            MybatisUtil.getSqlSession().getMapper(BookAndBorrowDao.class);
    public int addBook(BookInformation b){
        return dao.addBook(b);
    }
    public List<BookInformation> getAllBooks(){
        return dao.getAllBooks();
    }
    public BookInformation getBooksById(Integer id){
        return dao.getBooksById(id);
    }
    public Integer getIDByName(String bookName){return dao.getIDByName(bookName);}
    public List<BookInformation> getBookList(BookInformation book){
        return dao.getBookList(book);
    }
    public int deleteById(Integer id){
        return dao.deleteById(id);
    }
    public int updateById(BookInformation book){
        return dao.updateById(book);
    }
    public int addRecord(BorrowRecord b){
        return dao.addRecord(b);
    }
    public List<BorrowRecord> getAllRecords(){
        return dao.getAllRecords();
    }
    public BorrowRecord getRecordsById(Integer id){
        return dao.getRecordsById(id);
    }
    public List<BorrowRecord> getRecordsByBookId(Integer id){
        return dao.getRecordsByBookId(id);
    }
    public List<BorrowRecord> getRecordsList(BorrowRecord br){
        return dao.getRecordsList(br);
    }
    public int updateRecordById(BorrowRecord br){
        return dao.updateRecordById(br);
    }
    public List<BorrowRecord> getRecordByBookName(String name){
        return dao.getRecordByBookName(name);
    }
}
