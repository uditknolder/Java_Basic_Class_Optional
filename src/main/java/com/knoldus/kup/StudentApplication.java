package com.knoldus.kup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

     /**
     * Represents a Main Application Implementation class.
     */
public final class StudentApplication {
    private StudentApplication() {
    }
     /**
     * main() method for the application.
     * @param argument associated to accept arguments.
     */
    public static void main(final String[] argument) {
        final int rollNumberOfStd1 = 1;
        final int rollNumberOfStd2 = 2;
        final int rollNumberOfStd3 = 3;
        final int rollNumberOfStd4 = 4;
        final int rollNumberOfStd5 = 5;
        final int rollNumberOfStd6 = 6;
        final int rollNumberOfStd7 = 7;
        final int rollNumberOfStd8 = 8;
        final int rollNumberOfStd9 = 9;
        final int rollNumberOfStd10 = 10;

        Student student1 = new Student(
                "Shashi", rollNumberOfStd1, Optional.of("PHP"));
        Student student2 = new Student(
                "Krishna", rollNumberOfStd2, Optional.empty());
        Student student3 = new Student(
                "Aasif", rollNumberOfStd3, Optional.empty());
        Student student4 = new Student(
                "Rohit", rollNumberOfStd4, Optional.of("Java"));
        Student student5 = new Student(
                "Udit", rollNumberOfStd5, Optional.of("C++"));
        Student student6 = new Student(
                "Bhavya", rollNumberOfStd6, Optional.of("ANGULAR"));
        Student student7 = new Student(
                "Prakhar", rollNumberOfStd7, Optional.of("HTML"));
        Student student8 = new Student(
                "Amit", rollNumberOfStd8, Optional.of("REACT"));
        Student student9 = new Student(
                "Ravi", rollNumberOfStd9, Optional.of("C"));
        Student student10 = new Student(
                "Mohit", rollNumberOfStd10, Optional.of("C#"));
        //   * It's used to Creating student list.
        Optional<List<Student>> studentList = Optional
                .of(Arrays.asList(student1, student2, student3, student1));
    //   * It's used to Creating a student list.
        Optional<List<Student>> studentList2 = Optional
                .of(Arrays.asList(student4, student5, student6,
                        student7, student9, student10, student8));
    //   * It's used to Creating classroom list.
        List<ClassRoom> classRooms = new ArrayList<>();
        classRooms.add(new ClassRoom("J1001", studentList));
        classRooms.add(new ClassRoom("xyz", studentList2));
        classRooms.add(new ClassRoom("J1004", Optional.empty()));
    //  It's used to  Printing hello students if given room having students.
        String finalString = classRooms.get(1).hasStudents();
        out.println(finalString);
    //  * It's used to Finding students without subjects.
        List<Student> studentsWithoutSubject = classRooms
                .get(0).toGetStudentsWithoutSubject();
        out.println("\nStudent List Without subject: ");
        studentsWithoutSubject.forEach(out::println);
    //   * Finding distinct subjects of students associated with room id "xyz".
        List<Optional<String>> subjectsList = classRooms.get(1)
                .toGetDistinctSubjectsThroughRoomId("xyz");
        out.println("\nDistinct Subject List of ClassRoom xyz: ");
        subjectsList.forEach(out::println);
    }
}
