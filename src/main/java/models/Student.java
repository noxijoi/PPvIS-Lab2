package models;

public class Student {
    private FIO fio;
    private Integer course;
    private Integer groupNumber;
    private Integer totalNumOfTask;
    private Integer numOfDoneTasks;
    private String programmingLanguage;

    public Student(FIO fio, int course, int groupNumber,
                   int totalNumOfTask, int numOfDoneTasks, String programmingLanguage) {
        this.fio = fio;
        this.course = course;
        this.groupNumber = groupNumber;
        this.totalNumOfTask = totalNumOfTask;
        this.numOfDoneTasks = numOfDoneTasks;
        this.programmingLanguage = programmingLanguage;
    }

    public Student() {

    }

    public String[] toStringArr(){
        return new String[]{fio.toString(), Integer.toString(course),
                Integer.toString(groupNumber), Integer.toString(totalNumOfTask),
                Integer.toString(numOfDoneTasks), programmingLanguage};
    }

    public FIO getFio() {
        return fio;
    }

    public void setFio(FIO fio) {
        this.fio = fio;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getTotalNumOfTask() {
        return totalNumOfTask;
    }

    public void setTotalNumOfTask(Integer totalNumOfTask) {
        this.totalNumOfTask = totalNumOfTask;
    }

    public Integer getNumOfDoneTasks() {
        return numOfDoneTasks;
    }

    public void setNumOfDoneTasks(Integer numOfDoneTasks) {
        this.numOfDoneTasks = numOfDoneTasks;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
