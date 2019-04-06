package tools.adapters;

import org.eclipse.swt.layout.RowLayout;
import tools.Controller;
import tools.FormCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import tools.TypeOfSelection;
import tools.adapters.todialog.SearchInfoDialogAdapter;

public class ComboTypeAdapter extends SelectionAdapter {

    Group paramsGroup;
    Controller controller;
    String mode;
    public ComboTypeAdapter(Group deletionParams, Controller controller, String mode) {
        paramsGroup = deletionParams;
        this.controller = controller;
        this.mode = mode;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        Combo combo = (Combo)e.getSource();
        Composite parent = combo.getParent();
        int index = combo.getSelectionIndex();
        TypeOfSelection type = TypeOfSelection.getTypeByNumber(index);
        paramsGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
        RowLayout rowLayout = new RowLayout();
        paramsGroup.setLayout(rowLayout);
        switch (type){
            case FIO_AND_GROUP:
                Group fioGroup = FormCreator.createFIOInput(paramsGroup);
                Group groupGroup = FormCreator.createInput(paramsGroup,"Group");
                break;
            case COURSE_AND_PL:
                Group courseGroup = FormCreator.createInput(paramsGroup, "Course");
                Group proglangGroup = FormCreator.createComboInputProgLang(paramsGroup, controller);
                break;
            case NUM_OF_TASKS:
                Group taskNumGroup = FormCreator.createInput(paramsGroup, "Number of tasks");
                Group doneTaskNumGroup = FormCreator.createInput(paramsGroup,"Number of done tasks");
                break;
            case NUM_OF_UNDONE_TASKS:
                Group undoneTaskNumGroup = FormCreator.createInput(paramsGroup,"Number of undone tasks");
                break;
        }
        Button submit = new Button(parent, SWT.PUSH);
        switch (mode){
            case "search":
                submit.addSelectionListener(new SearchInfoAdapter(paramsGroup, type, controller));
                submit.setText(mode);
                break;
            case  "delete":
                submit.addSelectionListener(new DelInfoAdapter(paramsGroup, type, controller));
                submit.setText(mode);
                break;
        }

        combo.setEnabled(false);
        parent.pack();
    }
}
