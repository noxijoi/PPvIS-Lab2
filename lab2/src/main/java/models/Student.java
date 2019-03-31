package models;

public class Student {
    private FIO fio;
    private int curse;
    private int groupNumber;
    private int totalNumbOfWork;
    private int numbOfWork;
    private String programmingLanguage;

    public Student(FIO fio, int curse, int groupNumber,
                   int totalNumbOfWork, int numbOfWork, String programmingLanguage) {
        this.fio = fio;
        this.curse = curse;
        this.groupNumber = groupNumber;
        this.totalNumbOfWork = totalNumbOfWork;
        this.numbOfWork = numbOfWork;
        this.programmingLanguage = programmingLanguage;
    }
}
