package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import tools.adapters.AddInfoAdapter;
import tools.adapters.DelInfoAdapter;
import tools.adapters.SearchInfoAdapter;


public class MainWindow {
    private final Display display = new Display();
    private Label pageIndicatorLabel;
    private Label totalRecordsNum;
    private Table table;
    private final Shell shell;
    private final int startNumOfFields = 15;
    private final Color GRAY = new Color(display, 189, 189, 189);


    public MainWindow() {

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

        ToolBar toolBar = createToolBar(shell);
        GridData toolBarGridData = new GridData();
        toolBarGridData.verticalSpan = 4;
        toolBar.setLayoutData(toolBarGridData);

        table = createTable(shell);
        GridData tableGridData = new GridData();
        tableGridData.horizontalSpan = 5;
        tableGridData.grabExcessVerticalSpace = true;
        tableGridData.grabExcessHorizontalSpace = true;
        tableGridData.horizontalAlignment = GridData.FILL;
        table.setLayoutData(tableGridData);

        GridData buttonsGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        Button firstPage = new Button(shell, SWT.PUSH);
        firstPage.setText("<<");
        firstPage.setLayoutData(buttonsGridData);
        Button prevPage = new Button(shell, SWT.PUSH);
        prevPage.setText("<");
        prevPage.setLayoutData(buttonsGridData);
        pageIndicatorLabel = new Label(shell, SWT.NONE);
        pageIndicatorLabel.setText("1 of 1");
        pageIndicatorLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
        Button nextPage = new Button(shell, SWT.PUSH);
        nextPage.setText(">");
        nextPage.setLayoutData(buttonsGridData);
        Button lastPage = new Button(shell, SWT.PUSH);
        lastPage.setText(">>");
        lastPage.setLayoutData(buttonsGridData);

        totalRecordsNum = new Label(shell, SWT.NONE);
        totalRecordsNum.setText("total number of records : 0");
        GridData totalLabelGridData = new GridData();
        totalLabelGridData.horizontalSpan = 5;
        totalLabelGridData.horizontalAlignment = GridData.FILL;
        totalRecordsNum.setLayoutData(totalLabelGridData);

        Label chooseNumOfLines = new Label(shell, SWT.NONE);
        chooseNumOfLines.setText("Fields\n per page:");

        Combo linesChoose = new Combo(shell, SWT.READ_ONLY);
        String[] items ={"10", "20", "30", "40"};
        linesChoose.setItems(items);

        shell.setLayout(gridLayout);

        return shell;
    }

    private Table createTable(Shell shell) {
        Table table = new Table(shell, SWT.MULTI| SWT.BORDER|SWT.FULL_SELECTION);
        String[] titles = {"ФИО", "Курс", "Группа", "Общее кол-\nво работ",
                "Количество\n выполненных\n работ", "Язык программирования"};
        table.setHeaderVisible(true);
        table.setHeaderBackground(GRAY);
        table.setLinesVisible(true);
        for (int i = 0; i < titles.length ; i++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[i]);
        }
        table.getColumn(0).setWidth(100);
        table.getColumn(1).setWidth(20);
        table.getColumn(2).setWidth(30);
        table.getColumn(3).setWidth(20);
        table.getColumn(4).setWidth(20);
        table.getColumn(5).setWidth(40);

        for (int loopIndex = 0; loopIndex < titles.length ; loopIndex++) {
            table.getColumn(loopIndex).pack();
        }

        for (int i = 0; i < startNumOfFields; i++) {


        }
        table.setSize(table.computeSize(SWT.DEFAULT, 200));
        return table;
    }

    private ToolBar createToolBar(Shell shell) {
        ToolBar toolBar = new ToolBar(shell, SWT.VERTICAL);

        ToolItem  addInfoItem = new ToolItem(toolBar, SWT.PUSH);
        addInfoItem.setText("Add info");
        addInfoItem.addSelectionListener( new AddInfoAdapter(shell));
        ToolItem searchInfoItem = new ToolItem(toolBar, SWT.PUSH);
        searchInfoItem.setText("Search");
        searchInfoItem.addSelectionListener( new SearchInfoAdapter(shell));
        ToolItem deleteInfoItem = new ToolItem(toolBar, SWT.PUSH);
        deleteInfoItem.setText("Delete");
        deleteInfoItem.addSelectionListener( new DelInfoAdapter(shell));
        ToolItem saveItem = new ToolItem(toolBar, SWT.PUSH);
        saveItem.setText("Save");
        ToolItem openItem = new ToolItem(toolBar, SWT.PUSH);
        openItem.setText("Open");
        toolBar.pack();
        return toolBar;
    }

}
