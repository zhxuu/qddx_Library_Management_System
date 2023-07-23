package com.etoak.java.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory factory;

    static {
        try{
            // 使用输入流读取mybatis配置
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 创建SqlSessionFactory对象
            factory =
                    new SqlSessionFactoryBuilder().build(is);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("加载mybatis配置失败！");
        }
    }

    /**
     * 提供一个公共的方法 用来获取SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        // 参数 true   开启自动提交
        return factory.openSession(true);
    }
}
