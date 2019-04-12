package view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import tools.Controller;
import tools.FormCreator;
import tools.TypeOfSelection;
import tools.adapters.ComboTypeAdapter;
import tools.adapters.SearchInfoAdapter;
import view.TableComponent;


public class SearchDialog {
    private Group searchParams;
    private TypeOfSelection type;
    public SearchDialog(Shell parent, Controller controller) {
        Shell dialog = new Shell(parent);
        dialog.setText("Search");
        dialog.setModified(true);
        GridLayout gridLayout = new GridLayout();
        dialog.setLayout(gridLayout);
        Label chooseLbl = new Label(dialog, SWT.NONE);
        chooseLbl.setText("Choose type of search");
        Combo typeOfSearch = new Combo(dialog, SWT.READ_ONLY);
        String[] types = {"by NAME or GROUP", "by COURSE or PROGRAMMING LANGUAGE",
                "by NUMofTASK or NUMofDONE TASKS","by NUM of UNDONE TASKS"};
        typeOfSearch.setItems(types);
        Button searchButton = FormCreator.createButton(dialog, "Search");
        searchButton.setEnabled(false);
        searchParams = new Group(dialog, SWT.SHADOW_ETCHED_IN);
        searchParams.setVisible(false);
        TableComponent resultTable = new TableComponent(dialog);
        resultTable.setVisible(false);
        typeOfSearch.addSelectionListener(new ComboTypeAdapter(searchParams, controller, searchButton));
        searchButton.addSelectionListener(new SearchInfoAdapter(searchParams, typeOfSearch, controller, resultTable));
        dialog.pack();
        dialog.open();
    }
}
