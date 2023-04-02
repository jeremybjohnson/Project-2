package com.example.project2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<Student> students() throws IOException {
        return readData();
    }

    @GetMapping("/student/{name}")
    public Student student(@PathVariable String name) throws IOException {
        List<Student> students = readData();
        for (Student student : students){
            if(student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/student")
    public Student student(@RequestParam String gpa, @RequestParam String gender) throws IOException {
        List<Student> students = readData();
        double double_gpa = Double.parseDouble(gpa);
        for(Student student : students) {
            if(student.getGpa() == double_gpa & student.getGender().equalsIgnoreCase(gender)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/gpa")
    public double avgGpa() throws IOException {
        List<Student> students = readData();
        double total_gpa = 0;
        for (Student student : students) {
            total_gpa += student.getGpa();
        }
        return total_gpa/students.size();
    }

    public List<Student> readData() throws IOException {
        FileReader fileReader = new FileReader("/Users/jeremyjohnson-mini/Documents/Classes" +
                "/Programming/Advanced Java/Project-2/student.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Student> students = new ArrayList<>();

        String header = bufferedReader.readLine();
        String line = bufferedReader.readLine();

        while(line != null){
            String[] data = line.split(",");
            Student student = new Student(data[1], Double.parseDouble(data[2]), data[3], data[4]);
            students.add(student);
            line = bufferedReader.readLine();
        }
        return students;
    }

}
