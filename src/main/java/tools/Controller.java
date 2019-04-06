package tools;

import models.Content;
import models.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private Content content;
    private Table table;
    private Label pageIndicatorLabel;
    private int currentPage;
    private int recordsPerPage = 10;
    private Label totalRecordsNum;

    public Controller(Content content) {
        this.content = content;
    }

    public void addStudent(Student student){
        content.add(student);
        if(table.getItemCount() >= recordsPerPage){
        } else {
            FormCreator.addToTable(table, Collections.singletonList(student));
            updateTotalRecordsNumLabel();
        }
    }
    public void addAllStudents(List<Student> studentList){
        content.addAll(studentList);
        FormCreator.addToTable(table,studentList);
        updateTotalRecordsNumLabel();
        updatePageIndicatorLabel();
        updateTable();
    }

    public void resizeTable(int numOfRecords) {
        int rows = table.getItemCount();
        if(numOfRecords > rows) {
            for (int i = rows; i < numOfRecords; i++) {
                new TableItem(table, SWT.NONE);
            }
        } else{
            for (int i = rows - 1; i > numOfRecords ; i--) {
                table.remove(i);
            }
        }
        table.setSize(table.computeSize(SWT.DEFAULT, 300));
        recordsPerPage = numOfRecords;
        updateCurrentPageNumber();
        updatePageIndicatorLabel();
        updateTable();
    }

    public void setTable(Table table) {
        this.table = table;
    }
    public void setPageIndicatorLabel(Label pageIndicatorLabel) {
        this.pageIndicatorLabel = pageIndicatorLabel;
    }
    public void setTotalRecordsNum(Label totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }

    public void toNextPage(){
        if(currentPage <= getNumOfPages() ){
            currentPage++;
            updateTable();
            updatePageIndicatorLabel();
        }
    }
    public void toPrevPage(){
        if(currentPage > 0){
            currentPage--;
            updateTable();
            updatePageIndicatorLabel();
        }

    }
    public void toLastPage(){
        currentPage = getNumOfPages() - 1;
        updateTable();
        updatePageIndicatorLabel();
    }
    public void toFirstPage(){
        currentPage = 0;
        updateTable();
        updatePageIndicatorLabel();
    }

    public List<Student> delStudentsByParam(Object firstParam, Object secondParam, TypeOfSelection type) {
        List<Student> students = content.getStudents();
        List<Student> removedStudents = findStudentByParam(firstParam, secondParam, type);
        for (int i = 0; i < removedStudents.size() ; i++) {
            students.remove(removedStudents.get(i));
        }
        updateTotalRecordsNumLabel();
        updateTable();
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
    private List<Student> getPage(int pageNum) {
        List<Student> students = content.getStudents();
        List<Student> resultPage = new ArrayList<>();
        int pages = students.size() / recordsPerPage;
        if(pageNum < pages){
            currentPage = pageNum;
            resultPage = students.subList(pageNum * recordsPerPage,
                    pageNum * recordsPerPage + recordsPerPage);
        } else if(pageNum == pages){
            currentPage = pages;
            resultPage = students.subList(pageNum * recordsPerPage, students.size());
        }
        return resultPage;
    }

    private void updateTotalRecordsNumLabel() {
        int n = content.getSize();
        totalRecordsNum.setText("total number of records : " + n);
    }
    private void updatePageIndicatorLabel(){
        pageIndicatorLabel.setText(currentPage + 1 + " of " + getNumOfPages());
    }
    private void updateCurrentPageNumber() {
        if(currentPage > getNumOfPages()){
            currentPage = getNumOfPages() - 1;
        }
    }
    private void updateTable() {
        List<Student> page = getPage(currentPage);
        FormCreator.updateTable(table, page);
    }

    public void clear(){
        content.clear();
        table.removeAll();
        updatePageIndicatorLabel();
        updateTotalRecordsNumLabel();
    }
    private int getNumOfPages() {
        int students = content.getStudents().size();
        if(students % recordsPerPage == 0){
            return students / recordsPerPage;
        } else {
            return students / recordsPerPage + 1;
        }
    }
}
