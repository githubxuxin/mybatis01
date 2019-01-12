package cn.mln521.mybatis01.dao;

import cn.mln521.mybatis01.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream stream=StudentDao.class.getClassLoader().getResourceAsStream("conf.xml");
        //构建sqlSession的工厂
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件中sql的sqlSession
        SqlSession session = ssf.openSession();
        /**
         * 映射sql的标识字符串，
         * com.zhangguo.mybatis01.dao.studentMapper是studentMapper.xml文件中mapper标签的namespace属性的值，
         * selectStudentById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        Student student = session.selectOne("cn.mln521.mybatis01.dao.studentMapper.selectStudentById", id);

        // 关闭会话
        session.close();
        return student;

    }

//    public static void main(String[] args) {
//        StudentDao studentDao = new StudentDao();
//        Student student = studentDao.selectStudentById(1);
//        System.out.println(student);
//    }
}
