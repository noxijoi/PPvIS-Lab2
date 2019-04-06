package models;

import java.util.ArrayList;
import java.util.List;

public class Content {
    private List<Student> students;

    public Content(){
        students = new ArrayList<>();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void remove(Student student) {
        students.remove(student);
    }

    public void addAll(List<Student> studentList) {
        students.addAll(studentList);
    }

    public List<Student> getSublist(int i, int data) {
        return students.subList(i,data);
    }

    public int getSize() {
        return students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void clear() {
        students.clear();
    }
}
