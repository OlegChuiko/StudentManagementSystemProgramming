package com.example.student_management.Service;

import com.example.student_management.Classes.Student;
import com.example.student_management.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.getAllStudents()
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public Student addStudent(Student student) {
        studentRepository.addStudent(student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = getStudentById(id);
        existingStudent.ifPresent(s -> {
            s.setName(student.getName());
            s.setAge(student.getAge());
        });
        return existingStudent.orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.getAllStudents()
                .removeIf(student -> student.getId().equals(id));
    }
}