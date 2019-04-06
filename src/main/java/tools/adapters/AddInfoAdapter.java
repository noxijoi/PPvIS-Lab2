package tools.adapters;

import view.dialogs.AddDialog;
import models.Student;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import tools.Controller;
import tools.StudentBuilder;

import java.util.Map;

public class AddInfoAdapter extends SelectionAdapter {
    Controller controller;
    AddDialog addDialog;
    public AddInfoAdapter(Controller controller, AddDialog addDialog) {
        this.addDialog = addDialog;
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        Map<String, String> info = addDialog.getAllInfo();
        Student student = new StudentBuilder().buildStudent(info);
        controller.addStudent(student);
    }
}
