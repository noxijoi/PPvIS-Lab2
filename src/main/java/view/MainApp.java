package view;

import models.Content;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.FormCreator;


public class MainApp {
    private final Display display = new Display();

    private Controller controller;
    private Content content;
    private TableComponent tableComponent;
    private final Shell shell;

    public MainApp() {
        content = new Content();
        controller = new Controller(content);
        shell = createShell(display);
        shell.pack();
        shell.open();
        while(!shell.isDisposed()){
            if(!display.readAndDispatch())
                display.sleep();
        }
    }

    private Shell createShell(Display display) {
        Shell shell = new Shell(display);
        shell.setText("Second lab");
        shell.setRedraw(true);

        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 6;
        gridLayout.makeColumnsEqualWidth = false;

        shell.setLayout(gridLayout);

        ToolBar toolBar = FormCreator.createToolBar(shell, controller);
        GridData toolBarGridData = new GridData();
        toolBarGridData.verticalSpan = 4;
        toolBar.setLayoutData(toolBarGridData);


        GridData tableComponentGridData = new GridData();
        tableComponentGridData.horizontalSpan = 5;
        tableComponentGridData.verticalSpan = 4;
        tableComponentGridData.grabExcessHorizontalSpace = true;
        tableComponentGridData.grabExcessVerticalSpace = true;
        tableComponentGridData.horizontalAlignment = GridData.FILL;
        tableComponentGridData.verticalAlignment = GridData.FILL;
        tableComponent = new TableComponent(shell);
        tableComponent.getGroup().setLayoutData(tableComponentGridData);
        controller.setTableComponent(tableComponent);
        return shell;
    }


}
