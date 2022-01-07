package com.knoldus.kup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
    /**
     * Represents a Student  in the ClassRoom.
     */
    public class StudentTest {
    /**
     * student associated with each new student in ClassRoom.
     */
    Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student("Udit",101, Optional.of("Python"));
    }

    @Test
    public void testGetName() {
        String expectedName = "Udit";
        String actualName = student.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetName() {
        String expectedName = "Raj";
        student.setName("Raj");
        String actualName = student.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetRollNumber() {
        int expectedRollNo = 101;
        int actualRollNo = student.getRollNumber();
        Assert.assertEquals(expectedRollNo, actualRollNo);
    }

    @Test
    public void testSetRollNumber() {
        student.setRollNumber(102);
        int expectedRollNo = 102;
        int actualRollNo = student.getRollNumber();
        Assert.assertEquals(expectedRollNo, actualRollNo);
    }

    @Test
    public void testGetSubject() {
        Optional<String> expectedSubject = Optional.of("Python");
        Optional<String> actualSubject = student.getSubject();
        Assert.assertEquals(expectedSubject, actualSubject);
    }

    @Test
    public void testSetSubject() {
        student.setSubject(Optional.of("Python"));
        Optional<String> expectedSubject = Optional.of("Python");
        Optional<String> actualSubject = student.getSubject();
        Assert.assertEquals(expectedSubject, actualSubject);
    }

    @Test
    public void testToString() {
        String expected = "Student{" +
                "name='" + student.getName() + '\'' +
                ", rollNumber=" + student.getRollNumber() +
                ", subject=" + student.getSubject() +
                '}';
        String actual = student.toString();
        Assert.assertEquals(expected, actual);
    }
}