package tools;

import models.Content;
import models.Student;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import view.TableComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private Content content;
    private TableComponent tableComponent;

    public Controller(Content content, TableComponent tableComponent) {
        this.content = content;
        this.tableComponent = tableComponent;
    }

    public Controller(Content content) {
    this.content = content;
    }

    public void setTableComponent(TableComponent tableComponent) {
        this.tableComponent = tableComponent;
    }

    public void addStudent(Student student){
        content.add(student);
        tableComponent.addStudent(student);
    }
    public void addAllStudents(List<Student> studentList){
        content.addAll(studentList);
        tableComponent.addAllStudents(studentList);
    }
    public List<Student> delStudentsByParam(Object firstParam, Object secondParam, TypeOfSelection type) {
        List<Student> students = content.getStudents();
        List<Student> removedStudents = findStudentByParam(firstParam, secondParam, type);
        for (Student removedStudent : removedStudents) {
            students.remove(removedStudent);
        }
        tableComponent.clear();
        tableComponent.addAllStudents(students);
        return removedStudents;
    }
    public List<Student> findStudentByParam(Object firstParam, Object secondParam, TypeOfSelection type){
        List<Student> students = content.getStudents();
        List<Student> foundStudents = new ArrayList<>();
        switch (type) {
            case FIO_AND_GROUP:
                foundStudents = students.stream()
                        .filter(stud -> stud.getFio().equals(firstParam) || stud.getGroupNumber().equals(secondParam))
                        .collect(Collectors.toList());
                break;
            case NUM_OF_TASKS:
                foundStudents = students.stream()
                        .filter(stud -> stud.getTotalNumOfTask().equals(firstParam) || stud.getNumOfDoneTasks().equals(secondParam))
                        .collect(Collectors.toList());
                break;
            case COURSE_AND_PL:
                foundStudents = students.stream()
                        .filter(stud -> stud.getCourse().equals(firstParam) || stud.getProgrammingLanguage().equals(secondParam))
                        .collect(Collectors.toList());
                break;
            case NUM_OF_UNDONE_TASKS:
                foundStudents = students.stream()
                        .filter(stud -> {
                            Integer numUndoneTasks = (Integer)(stud.getTotalNumOfTask()- stud.getNumOfDoneTasks());
                            return numUndoneTasks.equals(firstParam);
                        })
                        .collect(Collectors.toList());
                break;
        }
        return foundStudents;
    }
    public List<String> getAllProgrammingLanguages(){
        List<String> progLangs = content.getStudents().stream()
                .flatMap(stud -> Stream.of(stud.getProgrammingLanguage()))
                .distinct()
                .collect(Collectors.toList());
        return progLangs;
    }

    public Content getContent() {
        return content;
    }

    public void clear(){
        content.clear();
        tableComponent.clear();
    }
}
