package tools.adapters;

import models.Content;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import tools.xml.dom.DOMWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaveAdapter extends SelectionAdapter {
    private Content content;
    public SaveAdapter(Content content) {
        this.content = content;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        FileDialog fileDialog = new FileDialog(new Shell(), SWT.SAVE);
        fileDialog.setText("Select file to save");

        fileDialog.setFilterNames(new String[]{"XML files"});
        fileDialog.setFilterExtensions(new String[]{"*.xml"});

        String fn = fileDialog.open();
        if (fn != null) {
            DOMWriter domWriter = new DOMWriter();
            domWriter.writeToFile(fn, content.getStudents());
        }
    }
}
