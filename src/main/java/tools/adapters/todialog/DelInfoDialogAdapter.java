package tools.adapters.todialog;

import org.eclipse.swt.widgets.ToolItem;
import tools.Controller;
import view.dialogs.DeleteDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

public class DelInfoDialogAdapter extends SelectionAdapter {
    private Controller controller;

    public DelInfoDialogAdapter(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        ToolItem source = (ToolItem) e.getSource();
        Shell shell = source.getParent().getShell();
        new DeleteDialog(shell, controller);
    }
}
