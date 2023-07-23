package com.etoak.java.bean;

public class BorrowRecord {
    Integer id;
    Integer bookId;
    String borrowerName;
    String borrowerSno;
    String phone;
    String borrowTime;
    String returnTime;
    String returnState;
    String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerSno() {
        return borrowerSno;
    }

    public void setBorrowerSno(String borrowerSno) {
        this.borrowerSno = borrowerSno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BorrowRecord(Integer id, Integer bookId, String borrowerName, String borrowerSno, String phone, String borrowTime, String returnTime, String returnState, String remarks) {
        this.id = id;
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.borrowerSno = borrowerSno;
        this.phone = phone;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.returnState = returnState;
        this.remarks = remarks;
    }
    public BorrowRecord(){

    }
}
