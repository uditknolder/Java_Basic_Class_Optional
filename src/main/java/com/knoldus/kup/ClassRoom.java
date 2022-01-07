package com.knoldus.kup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

 /**
 *Represents a ClassRoom  in the school.
 */
public class ClassRoom {
    /**
     *  ClassRoom Id.
     */
    private String roomId;
    /**
     *  To associate the students.
     */
    private Optional<List<Student>> studentList;
    /**
     *  ClassRoom constructor to initialize the member variables.
     * @param classRoomId associate with unique classRoom Id
     * @param classStudents associate with student's classRoom
     */
    public ClassRoom(final String classRoomId,
                     final Optional<List<Student>> classStudents) {
        this.roomId = classRoomId;
        this.studentList = classStudents;
    }
    /**
     * Method to find the students associated
     * with a room that have no subjects associated.
     * @return students list
     */
    public List<Student> toGetStudentsWithoutSubject() {
        List<Student> withoutSubject;
        withoutSubject = studentList.get().stream()
                .filter(student -> student
                        .getSubject().equals(Optional.empty()))
                .collect(Collectors.toList());
        return withoutSubject;
    }

     /**
      * Method to find subject list of students
      * @param classRoomId associate with classroom Id
      * @return optional list of distinct subjects.
      */
    public List<Optional<String>> toGetDistinctSubjectsThroughRoomId(
            final String classRoomId) {
        if (!classRoomId.equals(roomId)) {
            return null;
        }
        List<Optional<String>> distinctSubject;
        distinctSubject = studentList.get()
                .stream()
                .map(Student::getSubject)
                .filter(Optional::isPresent).distinct()
                .collect(Collectors.toList());
        return distinctSubject;
    }
    /**
     * Method to print "Hello Students" if a room has students associated.
     * @return a string.
     */
    public String hasStudents() {
        if (studentList.isPresent()) {
            return "Hello Students";
        }
        return "";
    }
    /**
     * @return roomId
     */
    public String getClassRoomId() {
        return roomId;
    }
    /**
     * @param classRoomId associate with unique classRoom Id
     */
    public void setClassRoomId(final String classRoomId) {
        this.roomId = classRoomId;
    }
    /**
     * @return studentList
     */
    public Optional<List<Student>> getStudentList() {
        return studentList;
    }
    /**
     * @param classStudentList associate with students List in a class
     */
    public void setStudentList(final Optional<List<Student>> classStudentList) {
        this.studentList = classStudentList;
    }
    /**
     * @return Class Room details
     */
    @Override
    public String toString() {
        return "ClassRoom{"
                + "roomId='" + roomId + '\''
                + ", studentList=" + studentList
                + '}';
    }
}

