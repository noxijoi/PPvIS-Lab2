package tools.xml.saxparser;

import models.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadParser {
    public List<Student> parse(String path) throws ParserConfigurationException,
            SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        StudentHandler handler = new StudentHandler();
        parser.parse(new File(path), handler);

        return handler.getStudentList();
    }
}

