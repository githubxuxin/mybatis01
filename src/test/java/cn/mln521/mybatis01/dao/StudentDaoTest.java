package cn.mln521.mybatis01.dao;

import cn.mln521.mybatis01.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    StudentDao studentDao = new StudentDao();

    @Test
    public void selectStudentById() {
        Student student = studentDao.selectStudentById(3);
        Assert.assertEquals("lili", student.getName());
    }
    @Test
    public void testSelectStudnetsByName() {
        List<Student> stuList = studentDao.selectStudnetsByName("a");
        System.out.println(stuList);
        Assert.assertNotNull(stuList);
    }
    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("玛丽");
        student.setSex("girl");
        int i = studentDao.insertStudent(student);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }
    @Test
    public void testUpdateStudent() {
        Student student = studentDao.selectStudentById(9);
        student.setName("玛丽");
        student.setSex("boy");
        int i = studentDao.updateStudent(student);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }
    @Test
    public void testDeleteStudent() {
        int i = studentDao.deleteStudent(9);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }
}