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

public class ComboTypeAdapter extends SelectionAdapter {

    private Group paramsGroup;
    private Controller controller;
    private Button actionButton;

    public ComboTypeAdapter(Group paramsGroup, Controller controller, Button actionButton) {
        this.paramsGroup = paramsGroup;
        this.controller = controller;
        this.actionButton = actionButton;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        Combo combo = (Combo)e.getSource();
        Composite parent = combo.getParent();
        int index = combo.getSelectionIndex();
        TypeOfSelection type = TypeOfSelection.getTypeByNumber(index);
        RowLayout rowLayout = new RowLayout();
        paramsGroup.setLayout(rowLayout);
        switch (type){
            case FIO_AND_GROUP:
                FormCreator.createFIOInput(paramsGroup);
                FormCreator.createNumericInput(paramsGroup,"Group");
                break;
            case COURSE_AND_PL:
                FormCreator.createNumericInput(paramsGroup, "Course");
                FormCreator.createComboInputProgLang(paramsGroup, controller);
                break;
            case NUM_OF_TASKS:
                FormCreator.createNumericInput(paramsGroup, "Number of tasks");
                FormCreator.createNumericInput(paramsGroup,"Number of done tasks");
                break;
            case NUM_OF_UNDONE_TASKS:
                FormCreator.createNumericInput(paramsGroup,"Number of undone tasks");
                break;
        }
        combo.setEnabled(false);
        paramsGroup.setVisible(true);
        actionButton.setEnabled(true);
        parent.pack();
    }
}
