package tools.adapters.todialog;

import org.eclipse.swt.widgets.ToolItem;
import view.dialogs.AddDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import tools.Controller;

public class AddInfoDialogAdapter extends SelectionAdapter {

    private Controller controller;

    public AddInfoDialogAdapter(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        ToolItem source = (ToolItem) e.getSource();
        Shell shell = source.getParent().getShell();
        new AddDialog(shell, controller);
    }
}
