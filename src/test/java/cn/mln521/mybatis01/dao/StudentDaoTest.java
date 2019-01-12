package cn.mln521.mybatis01.dao;

import cn.mln521.mybatis01.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoTest {

    StudentDao studentDao = new StudentDao();

    @Test
    public void selectStudentById() {
        Student student = studentDao.selectStudentById(3);
        Assert.assertEquals("lili", student.getName());
    }
}