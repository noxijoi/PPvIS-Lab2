package tools;

import models.FIO;
import models.Student;

import java.util.Map;

public class StudentBuilder {
    private final String F_NAME_KEY = "fName";
    private final String L_NAME_KEY = "lName";
    private final String P_NAME_KEY = "patronymic";
    private final String PROG_LANG_KEY = "progLang";
    private final String COURSE_KEY = "course";
    private final String GROUP_KEY = "group";
    private final String NUM_OF_TASKS_KEY = "numOfTasks";
    private final String NUM_OF_DONE_TASKS_KEY = "numOfDoneTasks";
    public Student buildStudent(Map<String,String> info){
        String[] fioStrings = new String[3];
        fioStrings[0] = info.get(F_NAME_KEY);
        fioStrings[1] = info.get(L_NAME_KEY);
        fioStrings[2] = info.get(P_NAME_KEY);
        FIO fio = new FIO(fioStrings);
        int course = Integer.parseInt(info.get(COURSE_KEY));
        int group = Integer.parseInt(info.get(GROUP_KEY));
        int numOfTasks = Integer.parseInt(info.get(NUM_OF_TASKS_KEY));
        int numOfDoneTasks = Integer.parseInt(info.get(NUM_OF_DONE_TASKS_KEY));
        String progLang = info.get(PROG_LANG_KEY);

        Student student = new Student(fio, course, group, numOfTasks, numOfDoneTasks, progLang);
        return student;

    }
}
