package tools.xml.saxparser;

import models.Name;
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
    private final String FIO = "name";
    private final String STUDENT = "student";
    private final String FIRST_NAME = "first-name";
    private final String LAST_NAME = "last-name";
    private final String PATRONYMIC = "patronymic";
    private final String COURSE = "course";
    private final String GROUP_NUMBER = "group-number";
    private final String TOTAL_NUM_OF_TASK = "total-num-of-tasks";
    private final String NUM_OF_DONE_TASKS = "num-of-done-tasks";
    private final String PROGRAMMING_LANGUAGE = "programming-language";

    private String data;

    private Student student;
    private Name name;
    private String fName;
    private String lName;
    private String patronymic;
    private int course;
    private int groupNumber;
    private int totalNumOfTasks;
    private int numOfDoneTasks;
    private String programmingLanguage;

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
                name = new Name();
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
                student.setName(name);
                student.setGroupNumber(groupNumber);
                student.setNumOfDoneTasks(numOfDoneTasks);
                student.setProgrammingLanguage(programmingLanguage);
                student.setTotalNumOfTask(totalNumOfTasks);
                students.add(student);
                break;
            case FIO:
                name.firstName = fName;
                name.lastName = lName;
                name.patronymic = patronymic;
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
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data = new String(ch, start, length);
    }
}
