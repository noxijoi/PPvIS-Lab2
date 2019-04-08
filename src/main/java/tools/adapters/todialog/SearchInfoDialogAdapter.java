package tools.adapters.todialog;

import tools.Controller;
import view.dialogs.SearchDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class SearchInfoDialogAdapter extends SelectionAdapter {
    private Controller controller;
    public SearchInfoDialogAdapter(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        ToolItem source = (ToolItem) e.getSource();
        Shell shell = source.getParent().getShell();
        new SearchDialog(shell, controller);
    }
}
