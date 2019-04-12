package view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.TypeOfSelection;
import tools.adapters.ComboTypeAdapter;
import tools.adapters.DelInfoAdapter;
import view.TableComponent;

public class DeleteDialog {
    private Group deletionParams;
    private TypeOfSelection type;
    public DeleteDialog(Shell parent, Controller controller, TableComponent tableComponent) {
        Shell dialog = new Shell(parent);
        dialog.setText("Delete");
        dialog.setModified(true);
        GridLayout gridLayout = new GridLayout();
        dialog.setLayout(gridLayout);
        Label chooseLbl = new Label(dialog, SWT.NONE);
        chooseLbl.setText("Choose type of deletion");
        Combo typeOfDel = new Combo(dialog, SWT.READ_ONLY);
        String[] types = {"by NAME or GROUP", "by COURSE or PROGRAMMING LANGUAGE",
        "by NUMofTASK or NUMofDONE TASKS","by NUM of UNDONE TASKS"};
        typeOfDel.setItems(types);

        Button deleteButton = new Button(dialog, SWT.PUSH);
        deleteButton.setEnabled(false);

        deletionParams = new Group(dialog, SWT.SHADOW_ETCHED_IN);
        deletionParams.setVisible(false);
        TableComponent resultTable = new TableComponent(dialog);
        typeOfDel.addSelectionListener(new ComboTypeAdapter(deletionParams, controller, deleteButton));
        deleteButton. addSelectionListener(new DelInfoAdapter(deletionParams, typeOfDel, controller, resultTable, tableComponent));
        dialog.pack();
        dialog.open();
    }
}
