package tools.adapters.todialog;

import tools.Controller;
import view.dialogs.SearchDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class SearchInfoDialogAdapter extends SelectionAdapter {
    private Shell parent;
    private Controller controller;

    public SearchInfoDialogAdapter(Shell shell, Controller controller) {
        this.parent = shell;
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        ToolItem source = (ToolItem) e.getSource();
        Shell shell = source.getParent().getShell();
        SearchDialog searchDialog = new SearchDialog(shell, controller);
    }
}
