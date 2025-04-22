package com.example.student_management.service;

import com.example.student_management.classes.Student;
import com.example.student_management.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Отримання списку всіх студентів");
        return studentRepository.getAllStudents();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        log.info("Отримання студента за ID: {}", id);
        return studentRepository.getAllStudents()
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public Student addStudent(Student student) {
        log.info("Додавання нового студента: {}", student);
        try {
            studentRepository.addStudent(student);
            return student;
        } catch (Exception e) {
            log.error("Помилка при додаванні студента: {}", student, e);
            throw e;
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        log.info("Оновлення студента з ID {}: {}", id, student);
        try {
            Optional<Student> existingStudent = getStudentById(id);
            existingStudent.ifPresent(s -> {
                s.setName(student.getName());
                s.setAge(student.getAge());
                log.info("Студент з ID {} оновлений успішно", id);
            });
            if (existingStudent.isEmpty()) {
                log.warn("Студента з ID {} не знайдено для оновлення", id);
            }
            return existingStudent.orElse(null);
        } catch (Exception e) {
            log.error("Помилка при оновленні студента з ID {}: {}", id, student, e);
            throw e;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        log.info("Видалення студента з ID {}", id);
        try {
            boolean removed = studentRepository.getAllStudents()
                    .removeIf(student -> student.getId().equals(id));
            if (removed) {
                log.info("Студента з ID {} успішно видалено", id);
            } else {
                log.warn("Студента з ID {} не знайдено для видалення", id);
            }
        } catch (Exception e) {
            log.error("Помилка при видаленні студента з ID {}", id, e);
            throw e;
        }
    }
}
