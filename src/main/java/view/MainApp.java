package view;

import models.Content;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.FormCreator;


public class MainApp {
    private final Display display = new Display();

    private Controller controller;
    private Content content;
    private final Shell shell;
    private final int START_NUM_OF_FIELDS = 10;


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

        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 6;
        gridLayout.makeColumnsEqualWidth = true;

        shell.setLayout(gridLayout);

        ToolBar toolBar = FormCreator.createToolBar(shell, controller);
        GridData toolBarGridData = new GridData();
        toolBarGridData.verticalSpan = 4;
        toolBar.setLayoutData(toolBarGridData);


        Table table = FormCreator.createTable(shell, START_NUM_OF_FIELDS);
        table.setRedraw(true);
        controller.setTable(table);
        GridData tableGridData = new GridData();
        tableGridData.horizontalSpan = 5;
        tableGridData.grabExcessVerticalSpace = true;
        tableGridData.grabExcessHorizontalSpace = false;
        tableGridData.horizontalAlignment = GridData.FILL;
        tableGridData.verticalAlignment = GridData.FILL;
        tableGridData.heightHint = 300;
        table.setLayoutData(tableGridData);
        table.setRedraw(true);

        GridData buttonsGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        Button firstPage = FormCreator.createButton(shell,"<<");
        firstPage.setLayoutData(buttonsGridData);
        firstPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                controller.toFirstPage();
            }
        });
        Button prevPage = FormCreator.createButton(shell, "<");
        prevPage.setLayoutData(buttonsGridData);
        prevPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                controller.toPrevPage();
            }
        });
        Label pageIndicatorLabel = new Label(shell, SWT.NONE);
        controller.setPageIndicatorLabel(pageIndicatorLabel);
        pageIndicatorLabel.setText("1 of 1");
        pageIndicatorLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
        Button nextPage = FormCreator.createButton(shell,">");
        nextPage.setLayoutData(buttonsGridData);
        nextPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                controller.toNextPage();
            }
        });
        Button lastPage = FormCreator.createButton(shell,">>");
        lastPage.setLayoutData(buttonsGridData);
        lastPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                controller.toLastPage();
            }
        });


        Label totalRecordsNum = new Label(shell, SWT.NONE);
        totalRecordsNum.setText("total number of records : 0");
        controller.setTotalRecordsNum(totalRecordsNum);
        GridData totalLabelGridData = new GridData();
        totalLabelGridData.horizontalSpan = 5;
        totalLabelGridData.horizontalAlignment = GridData.FILL;
        totalRecordsNum.setLayoutData(totalLabelGridData);

        Label chooseNumOfLines = new Label(shell, SWT.NONE);
        chooseNumOfLines.setText("Fields\n per page:");

        Combo linesChoose = new Combo(shell, SWT.READ_ONLY);
        String[] items ={"10", "20", "30", "40"};
        linesChoose.setText(Integer.toString(START_NUM_OF_FIELDS));
        linesChoose.setItems(items);
        linesChoose.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Combo combo = (Combo) e.getSource();
                int index = combo.getSelectionIndex();
                int data = Integer.parseInt(combo.getItem(index));
                controller.resizeTable(data);
            }
        });

        shell.setLayout(gridLayout);
        return shell;
    }


}
