package tools.adapters;

import org.eclipse.swt.widgets.*;
import models.FIO;
import models.Student;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import tools.Controller;
import tools.TypeOfSelection;
import view.dialogs.InfoDialog;

import java.util.List;

public class DelInfoAdapter extends SelectionAdapter {
    private Group paramsGroup;
    private TypeOfSelection type;
    private Controller controller;


    public DelInfoAdapter(Group paramsGroup, TypeOfSelection type, Controller controller) {
        this.paramsGroup = paramsGroup;
        this.type = type;
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {

        Group group1;
        Control[] children1 ;
        Group group2;
        Control[] children2 = null;

        group1 = (Group) paramsGroup.getChildren()[0];
        children1 = group1.getChildren();

        if(paramsGroup.getChildren().length > 1) {
            group2 = (Group) paramsGroup.getChildren()[1];
            children2 = group2.getChildren();
        }


        Object firstParam = "";
        Object secondParam = "";

        switch (type){
            case FIO_AND_GROUP:
                //как то некрасиво
                Text fName = (Text) children1[1];
                Text lName = (Text) children1[3];
                Text pName = (Text) children1[5];
                firstParam = new FIO(fName.getText(), lName.getText(), pName.getText());

                Text groupText = (Text) children2[1];
                if(!groupText.getText().isEmpty()) {
                    secondParam = Integer.parseInt(groupText.getText());
                }
                break;
            case COURSE_AND_PL:
                Text courseText = (Text) children1[1];
                if(!courseText.getText().isEmpty()) {
                    firstParam = Integer.parseInt(courseText.getText());
                }
                Combo progLangCombo = (Combo) children2[1];
                secondParam  = progLangCombo.getText();
                break;
            case NUM_OF_TASKS:
                Text numTaskText = (Text) children1[1];
                if(!numTaskText.getText().isEmpty()) {
                    firstParam = Integer.parseInt(numTaskText.getText());
                }
                Text numDoneTaskText = (Text) children2[1];
                if(!numDoneTaskText.getText().isEmpty()) {
                    secondParam = Integer.parseInt(numDoneTaskText.getText());
                }
                break;
            case NUM_OF_UNDONE_TASKS:
                Text numUndoneTaskText = (Text) children1[1];
                if(!numUndoneTaskText.getText().isEmpty()) {
                    firstParam = Integer.parseInt(numUndoneTaskText.getText());
                }
                break;
        }
        List<Student> removedStudents = controller.delStudentsByParam(firstParam, secondParam, type);
        new InfoDialog(removedStudents,"Removed students", paramsGroup.getShell());
    }
}
