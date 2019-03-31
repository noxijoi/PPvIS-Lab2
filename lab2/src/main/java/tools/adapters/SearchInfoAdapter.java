package tools.adapters;

import gui.SearchDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.*;

public class SearchInfoAdapter extends SelectionAdapter {
    Shell parent;

    public SearchInfoAdapter(Shell shell) {
        this.parent = shell;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        ToolItem source = (ToolItem) e.getSource();
        Shell shell = source.getParent().getShell();
        SearchDialog searchDialog = new SearchDialog(shell);
    }
}
