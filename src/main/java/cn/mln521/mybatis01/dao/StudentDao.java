package cn.mln521.mybatis01.dao;

import cn.mln521.mybatis01.entity.Student;
import cn.mln521.mybatis01.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        SqlSession session = SqlSessionFactoryUtils.getSession(true);
        Student student = session.selectOne("cn.mln521.mybatis01.dao.studentMapper.selectStudentById", id);
        return student;

    }

    /**
     * 根据学生姓名模糊查询
     * @param name
     * @return
     */
    public List<Student> selectStudnetsByName(String name) {
        SqlSession session = SqlSessionFactoryUtils.getSession(true);
        List<Student> stuList = session.selectList("cn.mln521.mybatis01.dao.studentMapper.selectStudnetsByName", name);
        return stuList;
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    public int insertStudent(Student student) {
        SqlSession session = SqlSessionFactoryUtils.getSession(true);
        int rows = session.insert("cn.mln521.mybatis01.dao.studentMapper.insertStudent", student);
        return rows;
    }
    /**
     * 更改学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student) {
        SqlSession session = SqlSessionFactoryUtils.getSession(true);
        int rows = session.insert("cn.mln521.mybatis01.dao.studentMapper.updateStudent", student);
        return rows;
    }

    /**
     * 删除学生信息
     * @param i
     * @return
     */
    public int deleteStudent(int i) {
        SqlSession session = SqlSessionFactoryUtils.getSession(true);
        int rows = session.insert("cn.mln521.mybatis01.dao.studentMapper.deleteStudent", i);
        return rows;
    }
}
