package com.knoldus.kup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ClassRoom test cases.
 */
public class ClassRoomTest {
    
    /**
     * List for testing.
     */
    List<Student> studentList1;
    List<Student> studentList2;
    ClassRoom firstClassRoom;
    ClassRoom secondClassRoom;

    /**
     * it's associated to set up a ClassRoom
     * @throws Exception it will throw an Exception class
     */
    @Before
    public void setUpClassRoom() throws Exception {
        Student student1 = new Student("A", 1, Optional.of("PHP"));
        Student student2 = new Student("B", 2, Optional.empty());
        Student student3 = new Student("C", 3, Optional.empty());
        Student student4 = new Student("D", 4, Optional.of("JAVA"));

        Student student5 = new Student("E", 5, Optional.of("C++"));
        Student student6 = new Student("F", 6, Optional.of("ANGULAR"));
        Student student7 = new Student("G", 7, Optional.of("HTML"));
        Student student8 = new Student("H", 10, Optional.of("REACT"));
        Student student9 = new Student("I", 11, Optional.of("C"));

        studentList1 = Arrays.asList(student1, student2, student3, student4);
        studentList2 = Arrays.asList(student5, student6, student7, student8,student9);

        firstClassRoom = new ClassRoom("Btech", Optional.of(studentList1));
        secondClassRoom = new ClassRoom("Mca", Optional.of(studentList2));

    }

    /**
     * It associated to Get Students Having No Subject And Return Correct List
     */
    @Test
    public void GetStudentsHavingNoSubject_AndReturnCorrectList() {
        List<Student> anticipatedStudents = Arrays.asList(new Student("Shivam", 2, Optional.empty()), new Student("Deepak", 3, Optional.empty()));
        List<Student> actualStudents = firstClassRoom.toGetStudentsWithoutSubject();
        Assert.assertTrue(actualStudents.size() > 1);
        Assert.assertEquals(anticipatedStudents.get(0).getRollNumber(), actualStudents.get(0).getRollNumber());
    }

    /**
     * to Get Different Subjects Through RoomId And Correct If any Subjects Found By RoomId
     */
    @Test
    public void GetDifferentSubjectsThroughRoomId_AndCorrectIfSubjectsFoundByRoomId() {
        List<Optional<String>> anticipatedSubjects = Arrays.asList(Optional.of("C++"), Optional.of("ANGULAR"), Optional.of("HTML"),Optional.of("REACT"), Optional.of("C"));
        List<Optional<String>> realSubjects = secondClassRoom.toGetDistinctSubjectsThroughRoomId("Mca");
        Assert.assertTrue(realSubjects.size() > 1);
        Assert.assertEquals(anticipatedSubjects,realSubjects);
    }
    /**
     * It's used to Get Different Subjects Through RoomId And To Return Null If no Subjects Found
     */
    @Test
    public void GetDifferentSubjectsThroughRoomId_AndToReturnNullIfSubjectsNotFoundByRoomId() {
        List<Optional<String>> finalSubjects = secondClassRoom.toGetDistinctSubjectsThroughRoomId("JV01");
        Assert.assertNull(finalSubjects);
    }
    /**
     * Its test Students And Return a String Message If you Have any Students
     */
    @Test
    public void testStudents_AndReturnStringMessageIfHaveStudents() {
        String anticipatedResult = "Hello Students";
        String finalResult = firstClassRoom.hasStudents();
        Assert.assertEquals(anticipatedResult, finalResult);
    }
    /**
     * Its test the Students And Return Empty String If Not Have Any Students
     */
    @Test
    public void testStudents_AndReturnEmptyStringIfNotHaveAnyStudents() {
        String anticipatedResult = "";
        firstClassRoom.setStudentList(Optional.empty());
        String finalResult = firstClassRoom.hasStudents();
        Assert.assertEquals(anticipatedResult, finalResult);
    }
    /**
     *  this is associated to Get a RoomId_ And Return Correct RoomId
     */
    @Test
    public void GetRoomId_AndReturnCorrectRoomId(){
        String anticipatedRoomId = "Btech";
        String exactRoomId = firstClassRoom.getClassRoomId();
        Assert.assertEquals(anticipatedRoomId, exactRoomId);
    }
    /**
     * this is for Set a RoomId And Return Correct RoomId
     */
    @Test
    public void SetRoomId_AndReturnCorrectRoomId(){
        firstClassRoom.setClassRoomId("J1004");
        String predictedRoomId = "J1004";
        String exactRoomId = firstClassRoom.getClassRoomId();
        Assert.assertEquals(predictedRoomId, exactRoomId);
    }
    /**
     * this is to get StudentList And Return Correct StudentsList
     */
    @Test
    public void getStudentList_AndReturnCorrectStudentsList(){
        Optional<List<Student>> actualList = firstClassRoom.getStudentList();
        Assert.assertTrue(actualList.get().size() > 2);
    }
    /**
     *  this is used to set a StudentList And Return Correct SetStudents List
     */
    @Test
    public void setStudentList_AndReturnCorrectSetStudentsList(){
        firstClassRoom.setStudentList(Optional.ofNullable(studentList2));
        Optional<List<Student>> expectedList = Optional.ofNullable(studentList2);
        Optional<List<Student>> actualList = firstClassRoom.getStudentList();
        Assert.assertTrue(actualList.get().size() > 2);
        Assert.assertEquals(expectedList.get().get(0).getRollNumber(), actualList.get().get(0).getRollNumber());
    }
    /**
     * testToString() is associated to return actual/predicted String
     */
    @Test
    public void testToString() {
        String predicted = "ClassRoom{" +
                "roomId='" + firstClassRoom.getClassRoomId() + '\'' +
                ", studentList=" + firstClassRoom.getStudentList() +
                '}';
        String actual = firstClassRoom.toString();
        Assert.assertEquals(predicted, actual);
    }
}