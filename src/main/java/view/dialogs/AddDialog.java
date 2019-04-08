package view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.FormCreator;
import tools.adapters.AddInfoAdapter;

import java.util.HashMap;
import java.util.Map;

public class AddDialog {

    private Text fNameText;
    private Text lNameText;
    private Text pNameText;
    private Text courseText;
    private Text groupText;
    private Text numTasksTest;
    private Text numDoneTasksText;
    private Text progLangText;


    public AddDialog(Shell parent, Controller controller){
        Shell dialog = new Shell(parent);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        dialog.setText("Add student");
        dialog.setLayout(rowLayout);

        Group fioGroup = FormCreator.createFIOInput(dialog);
        fNameText = FormCreator.textfieldsFromInputGroup(fioGroup)[0];
        lNameText = FormCreator.textfieldsFromInputGroup(fioGroup)[1];
        pNameText = FormCreator.textfieldsFromInputGroup(fioGroup)[2];

        Group courseGroup = FormCreator.createNumericInput(dialog, "Course");
        courseText = FormCreator.textfieldsFromInputGroup(courseGroup)[0];

        Group groupGroup = FormCreator.createNumericInput(dialog, "Group");
        groupText = FormCreator.textfieldsFromInputGroup(groupGroup)[0];

        Group numberOfTaskGroup = FormCreator.createNumericInput(dialog, "Number of tasks");
        numTasksTest = FormCreator.textfieldsFromInputGroup(numberOfTaskGroup)[0];

        Group numberOfDoneTaskGroup = FormCreator.createNumericInput(dialog, "Done tasks");
        numDoneTasksText = FormCreator.textfieldsFromInputGroup(numberOfDoneTaskGroup)[0];

        Group programmingLanguageGroup = FormCreator.createWordInput(dialog, "Programming language");
        progLangText = FormCreator.textfieldsFromInputGroup(programmingLanguageGroup)[0];

        Button submit =FormCreator.createButton(dialog, "Add");
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
