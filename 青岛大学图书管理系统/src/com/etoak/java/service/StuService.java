package com.etoak.java.service;

import com.etoak.java.bean.StuInfo;
import com.etoak.java.dao.BookAndBorrowDao;
import com.etoak.java.dao.Studao;
import com.etoak.java.utils.MybatisUtil;

public class StuService {
    private Studao dao =
            MybatisUtil.getSqlSession().getMapper(Studao.class);
    public int addStu(StuInfo s){
        return dao.addStu(s);
    }
    public StuInfo getpsw(String name){
        return dao.getpsw(name);
    }
}
