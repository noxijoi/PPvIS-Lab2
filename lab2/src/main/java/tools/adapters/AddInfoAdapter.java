package tools.adapters;

import gui.AddDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

public class AddInfoAdapter extends SelectionAdapter {
    Shell parent;

    public AddInfoAdapter(Shell parent) {
        this.parent = parent;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        AddDialog addDialod = new AddDialog(parent);
    }
}
