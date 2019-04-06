package view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.FormCreator;
import tools.adapters.AddInfoAdapter;

import java.util.HashMap;
import java.util.Map;

public class AddDialog {
    private final int NUM_OF_FIELDS = 8;
    Text fNameText;
    Text lNameText;
    Text pNameText;
    Text courseText;
    Text groupText;
    Text numTasksTest;
    Text numDoneTasksText;
    Text progLangText;

    Controller controller;
    public AddDialog(Shell parent, Controller controller){
        this.controller = controller;
        Shell dialog = new Shell(parent);
        GridLayout gridLayout = new GridLayout(2, true);
        dialog.setText("Add student");
        dialog.setLayout(gridLayout);

        Label fName = new Label(dialog, SWT.NONE);
        fName.setText("First Name: ");
        fNameText = new Text(dialog, SWT.BORDER);

        Label lName = new Label(dialog, SWT.NONE);
        lName.setText("Last Name: ");
        lNameText = new Text(dialog, SWT.BORDER);

        Label pName = new Label(dialog, SWT.NONE);
        pName.setText("Patronymic: ");
        pNameText = new Text(dialog, SWT.BORDER);

        Label course = new Label(dialog, SWT.NONE);
        course.setText("Course: ");
        courseText = new Text(dialog, SWT.BORDER);

        Label group = new Label(dialog, SWT.NONE);
        group.setText("Group: ");
        groupText = new Text(dialog, SWT.BORDER);

        Label numWorks = new Label(dialog, SWT.NONE);
        numWorks.setText("Number of works: ");
        numTasksTest = new Text(dialog, SWT.BORDER);

        Label numDoneWorks = new Label(dialog, SWT.NONE);
        numDoneWorks.setText("Done works: ");
        numDoneTasksText = new Text(dialog, SWT.BORDER);

        Label progLang = new Label(dialog, SWT.NONE);
        progLang.setText("Programming language: ");
        progLangText = new Text(dialog, SWT.BORDER);

        Button submit = new Button(dialog, SWT.PUSH);
        submit.setText("Add");
        submit.addSelectionListener(new AddInfoAdapter(controller,this));

        dialog.pack();
        dialog.open();
    }

    public Map<String, String> getAllInfo() {
        Map<String, String> result = new HashMap<>();
        result.put("fName",fNameText.getText());
        result.put("lName",lNameText.getText());
        result.put("patronymic",pNameText.getText());
        result.put("progLang",progLangText.getText());
        result.put("course",courseText.getText());
        result.put("group",groupText.getText());
        result.put("numOfTasks", numTasksTest.getText());
        result.put("numOfDoneTasks", numDoneTasksText.getText());

        return result;
    }
}
