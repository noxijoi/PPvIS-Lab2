package view.dialogs;

import models.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import tools.FormCreator;

import java.util.List;

public class InfoDialog {
    public InfoDialog(List<Student> studentList, String info, Shell parent ) {
        Shell shell = new Shell(parent);
        shell.setText(info);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        shell.setLayout(rowLayout);
        Label label = new Label(shell, SWT.NONE);
        label.setText(info);
        if(studentList.isEmpty()){
            new Label(shell, SWT.NONE).setText("No such students found");
        } else {
            new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
            new Label(shell, SWT.NONE).setText("Found "+ studentList.size() + "  students");
            Table table = FormCreator.createTable(shell, studentList.size());
            FormCreator.addToTable(table, studentList);
        }
        shell.pack();
        shell.open();
    }
}
