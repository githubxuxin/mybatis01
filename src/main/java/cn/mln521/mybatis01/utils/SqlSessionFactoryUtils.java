package cn.mln521.mybatis01.utils;

import cn.mln521.mybatis01.dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Descripton MyBatis 会话工具类
 * Created by xl
 * @Date 2019/1/12 23:55
 */
public class SqlSessionFactoryUtils {

    /**
     * 获得会话工厂
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            // 加载 mybatis配置文件
            inputStream = StudentDao.class.getClassLoader().getResourceAsStream("conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sqlSessionFactory;
    }


    /**
     *  获得sql会话，是否自动提交
     * @return
     */
    public static SqlSession getSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

    /**
     * 关闭会话
     */
    public static void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}
