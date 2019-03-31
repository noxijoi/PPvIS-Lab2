package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class FormCreator {
    public static Group createFIOInput(Composite parent){
        Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
        GridLayout gridLayout = new GridLayout(2, true);
        group.setLayout(gridLayout);
        Label fName = new Label(group, SWT.NONE);
        fName.setText("First Name: ");
        Text fNameText = new Text(group, SWT.BORDER);

        Label lName = new Label(group, SWT.NONE);
        lName.setText("Last Name: ");
        Text lNameText = new Text(group, SWT.BORDER);

        Label pName = new Label(group, SWT.NONE);
        pName.setText("Patronymic: ");
        Text pNameText = new Text(group, SWT.BORDER);
        return group;
    }
    public static Group createInput(Composite parent, String type){
        Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
        group.setLayout(new RowLayout());
        Label course = new Label(group, SWT.NONE);
        course.setText(type + ": ");
        Text  text = new Text(group, SWT.BORDER);
        return group;
    }
}
