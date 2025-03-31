package com.example.student_management;

import com.example.student_management.Classes.Student;
import com.example.student_management.Repository.StudentRepository;
import com.example.student_management.Service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        student1 = new Student(1L, "Олег", 22);
        student2 = new Student(2L, "Анна", 24);
    }

    @Test
    void testGetAllStudents() {
        when(studentRepository.getAllStudents()).thenReturn(Arrays.asList(student1, student2));

        List<Student> students = studentService.getAllStudents();

        assertEquals(2, students.size());
        assertEquals("Олег", students.get(0).getName());
        assertEquals("Анна", students.get(1).getName());

        verify(studentRepository, times(1)).getAllStudents();
    }

    @Test
    void testGetStudentById() {
        when(studentRepository.getAllStudents()).thenReturn(List.of(student1));

        Optional<Student> student = studentService.getStudentById(1L);

        assertTrue(student.isPresent());
        assertEquals("Олег", student.get().getName());

        verify(studentRepository, times(1)).getAllStudents();
    }

    @Test
    void testAddStudent() {
        when(studentRepository.addStudent(any(Student.class))).thenAnswer(invocation -> {
            Student s = invocation.getArgument(0);
            return s;
        });

        Student newStudent = new Student(3L, "Іван", 20);
        Student savedStudent = studentService.addStudent(newStudent);

        assertNotNull(savedStudent);
        assertEquals("Іван", savedStudent.getName());

        verify(studentRepository, times(1)).addStudent(any(Student.class));
    }
}
