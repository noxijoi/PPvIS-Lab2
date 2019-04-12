package tools.adapters;

import view.TableComponent;
import view.dialogs.AddDialog;
import models.Student;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import tools.Controller;
import tools.StudentBuilder;

import java.util.Map;

public class AddInfoAdapter extends SelectionAdapter {
    private Controller controller;
    private AddDialog addDialog;
    private TableComponent tableComponent;
    public AddInfoAdapter(Controller controller, AddDialog addDialog, TableComponent tableComponent) {
        this.addDialog = addDialog;
        this.controller = controller;
        this.tableComponent = tableComponent;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        Student student = addDialog.getStudent();
        if(student != null) {
            controller.addStudent(student);
            tableComponent.addStudent(student);
        }
    }
}
