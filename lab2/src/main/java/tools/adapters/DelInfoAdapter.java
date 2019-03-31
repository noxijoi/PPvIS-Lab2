package tools.adapters;

import gui.AddDialog;
import gui.DeleteDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

public class DelInfoAdapter  extends SelectionAdapter {
    Shell parent;

    public DelInfoAdapter(Shell parent) {
        this.parent = parent;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        DeleteDialog deleteDialog = new DeleteDialog(parent);
    }
}
