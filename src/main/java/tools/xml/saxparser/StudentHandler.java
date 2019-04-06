package tools.xml.saxparser;

import models.FIO;
import models.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentHandler extends DefaultHandler {
    private List<Student> students;

    public List<Student> getStudentList(){
        return students;
    }

    private final String STUDENTS = "students";
    private final String FIO = "fio";
    private final String STUDENT = "student";
    private final String FIRST_NAME = "first-name";
    private final String LAST_NAME = "last-name";
    private final String PATRONYMIC = "patronymic";
    private final String COURSE = "course";
    private final String GROUP_NUMBER = "group-number";
    private final String TOTAL_NUM_OF_TASK = "total-num-of-tasks";
    private final String NUM_OF_DONE_TASKS = "num-of-done-tasks";
    private final String PROGRAMMING_LANGUAGE = "programming-language";

    String data;

    Student student;
    FIO fio;
    String fName;
    String lName;
    String patronymic;
    int course;
    int groupNumber;
    int totalNumOfTasks;
    int numOfDoneTasks;
    String programmingLanguage;

    public StudentHandler() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        students = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case STUDENT:
                student = new Student();
                break;
            case FIO:
                fio = new FIO();
                break;
                default:
                    break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case STUDENT:
                student.setCourse(course);
                student.setFio(fio);
                student.setGroupNumber(groupNumber);
                student.setNumOfDoneTasks(numOfDoneTasks);
                student.setProgrammingLanguage(programmingLanguage);
                student.setTotalNumOfTask(totalNumOfTasks);
                students.add(student);
                break;
            case FIO:
                fio.firstName = fName;
                fio.lastName = lName;
                fio.patronymic = patronymic;
                break;
            case FIRST_NAME:
                fName = data;
                break;
            case LAST_NAME:
                lName = data;
                break;
            case PATRONYMIC:
                patronymic = data;
                break;
            case COURSE:
                course = Integer.parseInt(data);
                break;
            case GROUP_NUMBER:
                groupNumber = Integer.parseInt(data);
                break;
            case TOTAL_NUM_OF_TASK:
                totalNumOfTasks = Integer.parseInt(data);
                break;
            case NUM_OF_DONE_TASKS:
                numOfDoneTasks = Integer.parseInt(data);
                break;
            case PROGRAMMING_LANGUAGE:
                programmingLanguage = data;

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data = new String(ch, start, length);
    }
}