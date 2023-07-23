package com.etoak.java.bean;

public class BookInformation {
        Integer id;
        String bookName;
        String author;
        String pubDate;
        Integer wordNumber;
        Integer price;
        String enterTime;
        String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(Integer wordNumber) {
        this.wordNumber = wordNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookInformation(Integer id, String bookName, String author, String pubDate, Integer wordNumber, Integer price, String enterTime, String status) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pubDate = pubDate;
        this.wordNumber = wordNumber;
        this.price = price;
        this.enterTime = enterTime;
        this.status = status;
    }
    public BookInformation(){

    }
}
