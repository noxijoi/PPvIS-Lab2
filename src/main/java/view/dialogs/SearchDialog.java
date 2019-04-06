package view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.adapters.ComboTypeAdapter;

public class SearchDialog {
    Group searchParams;
    public SearchDialog(Shell parent, Controller controller) {
        Shell dialog = new Shell(parent);
        dialog.setText("Search");
        dialog.setModified(true);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        dialog.setLayout(rowLayout);
        Label chooseLbl = new Label(dialog, SWT.NONE);
        chooseLbl.setText("Choose type of search");
        Combo typeOfDel = new Combo(dialog, SWT.READ_ONLY);
        String[] types = {"by NAME or GROUP", "by COURSE or PROGRAMMING LANGUAGE",
                "by NUMofTASK or NUMofDONE TASKS","by NUM of UNDONE TASKS"};
        typeOfDel.setItems(types);
        typeOfDel.addSelectionListener(new ComboTypeAdapter(searchParams, controller,"search"));
        dialog.pack();
        dialog.open();
    }
}
