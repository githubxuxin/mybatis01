package cn.mln521.mybatis01.dao;

import cn.mln521.mybatis01.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Descripton TODO
 * Created by xl
 * @Date 2019/1/12 0:35
 */
public class StudentDao {

    /**
     * 根据学生编号获取学生对象
     * @param id
     * @return
     */
    public Student selectStudentById(int id) {

        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;
        Student student = null;
        try {
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            inputStream = StudentDao.class.getClassLoader().getResourceAsStream("conf.xml");
            //构建sqlSession的工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
            //Reader reader = Resources.getResourceAsReader(resource);
            //构建sqlSession的工厂
            //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            //创建能执行映射文件中sql的sqlSession
            session = sqlSessionFactory.openSession();
            /**
             * 映射sql的标识字符串，
             * com.zhangguo.mybatis01.dao.studentMapper是studentMapper.xml文件中mapper标签的namespace属性的值，
             * selectStudentById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            student = session.selectOne("cn.mln521.mybatis01.dao.studentMapper.selectStudentById", id);

        }
        finally {
            if (session != null) {
                // 关闭会话
                session.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return student;

    }

}
