package tools.adapters;

import gui.FormCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import tools.TypeOfSelection;

public class ComboTypeAdapter extends SelectionAdapter {
    @Override
    public void widgetSelected(SelectionEvent e) {
        Combo combo = (Combo)e.getSource();
        Composite parent = combo.getParent();
        int index = combo.getSelectionIndex();
        TypeOfSelection type = TypeOfSelection.getTypeByNumber(index);

        switch (type){
            case FIO_AND_GROUP:
                Group fioGroup = FormCreator.createFIOInput(parent);
                Group gropGroup = FormCreator.createInput(parent,"Group");
                break;
            case COURSE_AND_PL:
                Group courseGroup = FormCreator.createInput(parent, "Course");
                Group proglangGroup = FormCreator.createInput(parent,"Programming Language");
                break;
            case NUM_OF_TASKS:
                Group taskNumGroup = FormCreator.createInput(parent, "Number of tasks");
                Group doneTaskNumGroup = FormCreator.createInput(parent,"Number of done tasks");
                break;
            case NUM_OF_UNDONE_TASKS:
                Group undoneTaskNumGroup = FormCreator.createInput(parent,"Number of undone tasks");
                break;
        }
        Button submit = new Button(parent, SWT.PUSH);
        submit.setText("Delete");
        parent.pack();
    }
}
