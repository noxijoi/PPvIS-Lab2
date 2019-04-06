package tools;

import models.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import tools.adapters.OpenAdapter;
import tools.adapters.SaveAdapter;
import tools.adapters.todialog.AddInfoDialogAdapter;
import tools.adapters.todialog.DelInfoDialogAdapter;
import tools.adapters.todialog.SearchInfoDialogAdapter;

import java.util.List;

public class FormCreator {
    public static Group createFIOInput(Composite parent){
        Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
        GridLayout gridLayout = new GridLayout(2, false);
        group.setLayout(gridLayout);
        Label fName = new Label(group, SWT.NONE);
        fName.setText("First Name: ");
        Text fNameText = new Text(group, SWT.BORDER);
        GridData textGridData = new GridData();
        textGridData.widthHint = 200;
        fNameText.setLayoutData(textGridData);

        Label lName = new Label(group, SWT.NONE);
        lName.setText("Last Name: ");
        Text lNameText = new Text(group, SWT.BORDER);
        lNameText.setLayoutData(textGridData);

        Label pName = new Label(group, SWT.NONE);
        pName.setText("Patronymic: ");
        Text pNameText = new Text(group, SWT.BORDER);
        pNameText.setLayoutData(textGridData);
        return group;
    }
    public static Group createComboInputProgLang(Composite parent, Controller controller){
        Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
        RowLayout rowLayout = new RowLayout();
        group.setLayout(rowLayout);
        new Label(group, SWT.NONE).setText("programing language: " );
        Combo combo = new Combo(group, SWT.DROP_DOWN);
        List<String> progLangs = controller.getAllProgrammingLanguages();
        for (int i = 0; i < progLangs.size(); i++) {
            combo.add(progLangs.get(i));
        }
        int i = combo.getItemCount();
        return group;
    }
    public static Group createInput(Composite parent, String type){
        Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
        group.setLayout(new RowLayout());
        Label course = new Label(group, SWT.NONE);
        course.setText(type + ": ");
        Text text = new Text(group, SWT.BORDER);
        return group;
    }

    public static Button createButton(Composite parent, String text){
        Button button = new Button(parent, SWT.PUSH);
        button.setText(text);
        return button;
    }

    public static Table createTable(Composite parent, int rows){
        Color GRAY = new Color(parent.getDisplay(), 189, 189, 189);
        Table table = new Table(parent, SWT.MULTI| SWT.BORDER|SWT.FULL_SELECTION);
        String[] titles = {"ФИО", "Курс", "Группа", "Кол-во работ",
                "Готовых работ", "Язык программирования"};
        table.setHeaderVisible(true);
        table.setHeaderBackground(GRAY);
        table.setLinesVisible(true);
        for (int i = 0; i < titles.length ; i++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[i]);
        }
        table.getColumn(0).setWidth(400);
        table.getColumn(1).setWidth(80);
        table.getColumn(2).setWidth(80);
        table.getColumn(3).setWidth(120);
        table.getColumn(4).setWidth(120);
        table.getColumn(5).setWidth(200);
        TableItem tableItem = new TableItem(table, SWT.NONE);
        int tableItemSize = tableItem.getBounds().height;
        table.remove(0);
        table.setSize(table.computeSize(0,0).y, tableItemSize * (rows + 1));
        return table;
    }

    public static ToolBar createToolBar(Shell parent, Controller controller){
        ToolBar toolBar = new ToolBar(parent, SWT.VERTICAL);

        ToolItem  addInfoItem = new ToolItem(toolBar, SWT.PUSH);
        addInfoItem.setText("Add info");
        addInfoItem.addSelectionListener( new AddInfoDialogAdapter(parent, controller));
        ToolItem searchInfoItem = new ToolItem(toolBar, SWT.PUSH);
        searchInfoItem.setText("Search");
        searchInfoItem.addSelectionListener( new SearchInfoDialogAdapter(parent, controller));
        ToolItem deleteInfoItem = new ToolItem(toolBar, SWT.PUSH);
        deleteInfoItem.setText("Delete");
        deleteInfoItem.addSelectionListener( new DelInfoDialogAdapter(parent, controller));
        ToolItem saveItem = new ToolItem(toolBar, SWT.PUSH);
        saveItem.setText("Save");
        saveItem.addSelectionListener(new SaveAdapter(controller.getContent()));
        ToolItem openItem = new ToolItem(toolBar, SWT.PUSH);
        openItem.setText("Open");
        openItem.addSelectionListener(new OpenAdapter(controller));
        toolBar.pack();
        return toolBar;
    }

    public static void addToTable(Table table, List<Student> listForPage) {
        for (int i = 0; i < listForPage.size(); i++) {
            Student student = listForPage.get(i);
            TableItem item = new TableItem(table,SWT.NONE);
            item.setText(student.toStringArr());
        }
        table.setSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    }
    public static void updateTable(Table table, List<Student> newContent)
    {
        table.remove(0, table.getItemCount() - 1);
        addToTable(table, newContent);
    }
}

