package com.etoak.java.dao;

import com.etoak.java.bean.BookInformation;
import com.etoak.java.bean.StuInfo;

import java.util.List;

public interface Studao {
    int addStu(StuInfo s);
    StuInfo getpsw(String name);
}
