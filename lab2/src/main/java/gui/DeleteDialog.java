package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import tools.TypeOfSelection;
import tools.adapters.ComboTypeAdapter;

import javax.swing.*;

public class DeleteDialog {
    public DeleteDialog(Shell parent) {
        Shell dialog = new Shell(parent);
        dialog.setText("Delete");
        dialog.setModified(true);
        FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
        dialog.setLayout(fillLayout);
        Label chooseLbl = new Label(dialog, SWT.NONE);
        chooseLbl.setText("Choose type of deletion");
        Combo typeOfDel = new Combo(dialog, SWT.READ_ONLY);
        String[] types = {"by NAME and GROUP", "by COURSE and PROGRAMMING LANGUAGE",
        "by NUMofTASK and NUMofDONE TASKS","by NUM of UNDONE TASKS"};
        typeOfDel.setItems(types);
        typeOfDel.addSelectionListener(new ComboTypeAdapter());
        dialog.pack();
        dialog.open();
    }
}
