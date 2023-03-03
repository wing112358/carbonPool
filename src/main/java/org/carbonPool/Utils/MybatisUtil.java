package org.carbonPool.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSession sqlSession = null;
    public static SqlSession getSqlSession(){
        //访问mybatis读取数据
        //1、定义mybatis主配置文件的名称，从类路径下开始
        String config = "mapper/mybatis.xml";
        //2、读取这个配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3、创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5、获取SqlSession对象
        sqlSession = factory.openSession();
        return sqlSession;
    }
}

