package tools.adapters.todialog;

import view.dialogs.AddDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import tools.Controller;

public class AddInfoDialogAdapter extends SelectionAdapter {
    Shell parent;
    Controller controller;

    public AddInfoDialogAdapter(Shell parent,Controller controller) {
        this.parent = parent;
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        AddDialog addDialod = new AddDialog(parent, controller);
    }
}
