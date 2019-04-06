package tools.adapters.todialog;

import tools.Controller;
import view.dialogs.DeleteDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

public class DelInfoDialogAdapter extends SelectionAdapter {
    Shell parent;
    Controller controller;

    public DelInfoDialogAdapter(Shell parent, Controller controller) {
        this.parent = parent;
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        DeleteDialog deleteDialog = new DeleteDialog(parent, controller);
    }
}
