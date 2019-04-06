package tools.adapters;

import models.Student;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.xml.sax.SAXException;
import tools.Controller;
import tools.xml.saxparser.ReadParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class OpenAdapter extends SelectionAdapter {
    Controller controller;
    public OpenAdapter(Controller controller) {
        this.controller = controller;
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
                controller.addAllStudents(studentList);
            }
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
