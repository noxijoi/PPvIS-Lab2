package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class AddDialog {
    Text fNameText;
    Text lNameText;
    Text pNameText;
    Text courseText;
    Text groupText;
    Text numWorksText;
    Text numDoneWorksText;
    Text progLangText;
    public AddDialog(Shell parent){
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
        numWorksText = new Text(dialog, SWT.BORDER);

        Label numDoneWorks = new Label(dialog, SWT.NONE);
        numDoneWorks.setText("Done works: ");
        numDoneWorksText = new Text(dialog, SWT.BORDER);

        Label progLang = new Label(dialog, SWT.NONE);
        progLang.setText("Programming language: ");
        progLangText = new Text(dialog, SWT.BORDER);

        Button submit = new Button(dialog, SWT.PUSH);
        submit.setText("Add");

        dialog.pack();
        dialog.open();
    }
}
