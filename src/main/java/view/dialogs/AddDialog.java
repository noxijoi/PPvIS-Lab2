package view.dialogs;

import models.Name;
import models.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import tools.Controller;
import tools.FormCreator;
import tools.adapters.AddInfoAdapter;
import view.TableComponent;

import java.util.*;

public class AddDialog {

    private List<Text> inputFields = new ArrayList<>();


    public AddDialog(Shell parent, Controller controller, TableComponent tableComponent){
        Shell dialog = new Shell(parent);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        dialog.setText("Add student");
        dialog.setLayout(rowLayout);

        Group fioGroup = FormCreator.createFIOInput(dialog);
        for (Text text : FormCreator.textfieldsFromInputGroup(fioGroup)) {
            inputFields.add(text);
        }


        Group courseGroup = FormCreator.createNumericInput(dialog, "Course");
        inputFields.add(FormCreator.textfieldsFromInputGroup(courseGroup)[0]);

        Group groupGroup = FormCreator.createNumericInput(dialog, "Group");
        inputFields.add(FormCreator.textfieldsFromInputGroup(groupGroup)[0]);

        Group numberOfTaskGroup = FormCreator.createNumericInput(dialog, "Number of tasks");
        inputFields.add(FormCreator.textfieldsFromInputGroup(numberOfTaskGroup)[0]);

        Group numberOfDoneTaskGroup = FormCreator.createNumericInput(dialog, "Done tasks");
        inputFields.add(FormCreator.textfieldsFromInputGroup(numberOfDoneTaskGroup)[0]);

        Group programmingLanguageGroup = FormCreator.createInput(dialog, "Programming language");
        inputFields.add(FormCreator.textfieldsFromInputGroup(programmingLanguageGroup)[0]);

        Button submit = FormCreator.createButton(dialog, "Add");
        submit.addSelectionListener(new AddInfoAdapter(controller,this, tableComponent));

        dialog.pack();
        dialog.open();
    }
    public Student getStudent() {
        long filledfields = inputFields.stream()
                .filter(x -> !x.getText().isEmpty())
                .count();
        if(filledfields == inputFields.size()) {
            Iterator<Text> fieldsIterator = inputFields.iterator();
            String[] fioStrings = new String[3];
            for (int i = 0; i < 3; i++) {
                fioStrings[i] = fieldsIterator.next().getText();
            }
            Name name = new Name(fioStrings);
            int course = Integer.parseInt(fieldsIterator.next().getText());
            int group = Integer.parseInt(fieldsIterator.next().getText());
            int numOfTasks = Integer.parseInt(fieldsIterator.next().getText());
            int numOfDoneTasks = Integer.parseInt(fieldsIterator.next().getText());
            String progLang = fieldsIterator.next().getText();

            return new Student(name, course, group, numOfTasks, numOfDoneTasks, progLang);
        } else {
            return null;
        }
    }
}
