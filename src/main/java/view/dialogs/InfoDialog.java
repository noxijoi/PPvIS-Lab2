package view.dialogs;

import models.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import tools.FormCreator;
import view.TableComponent;

import java.util.List;

public class InfoDialog {
    public InfoDialog(List<Student> studentList, String info, Shell parent ) {
        Shell shell = new Shell(parent, SWT.RESIZE|SWT.CLOSE);
        shell.setText(info);
        GridLayout gridLayout = new GridLayout();
        gridLayout.makeColumnsEqualWidth = false;

        shell.setLayout(gridLayout);

        Label label = new Label(shell, SWT.NONE);
        label.setText(info);
        if(studentList.isEmpty()){
            new Label(shell, SWT.NONE).setText("No such students found");
        } else {
            GridData tableComponentGridData = new GridData();
            tableComponentGridData.grabExcessHorizontalSpace = true;
            tableComponentGridData.grabExcessVerticalSpace = true;
            tableComponentGridData.horizontalAlignment = GridData.FILL;
            tableComponentGridData.verticalAlignment = GridData.FILL;
            TableComponent table = new TableComponent(shell);
            table.addAllStudents(studentList);
            table.getGroup().setLayoutData(tableComponentGridData);
        }
        shell.pack();
        shell.open();
    }
}
