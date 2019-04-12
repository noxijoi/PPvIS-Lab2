package tools.adapters;

import models.Student;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.xml.sax.SAXException;
import tools.Controller;
import tools.xml.saxparser.ReadParser;
import view.TableComponent;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class OpenAdapter extends SelectionAdapter {
    private Controller controller;
    private TableComponent tableComponent;
    public OpenAdapter(Controller controller, TableComponent tableComponent) {
        this.controller = controller;
        this.tableComponent = tableComponent;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        try {
            String[] names = {"XML-файлы (*.xml)"};
            String[] extensions = {"*.xml"};
            FileDialog fileDialog =new FileDialog(new Shell());
            fileDialog.setText("Open file");
            fileDialog.setFilterNames(names);
            fileDialog.setFilterExtensions(extensions);
            String selected = fileDialog.open();
            if(selected != null){
                ReadParser readParser = new ReadParser();
                List<Student> studentList = readParser.parse(selected);
                controller.clear();
                controller.addAllStudents(studentList);
                tableComponent.clear();
                tableComponent.addAllStudents(studentList);
            }
        } catch (ParserConfigurationException | SAXException | IOException e1) {
            e1.printStackTrace();
        }
    }
}
