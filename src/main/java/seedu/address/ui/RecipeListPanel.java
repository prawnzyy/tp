package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;

/**
 * Panel containing the list of recipes.
 */
public class RecipeListPanel extends UiPart<Region> {
    private static final String FXML = "RecipeListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(RecipeListPanel.class);

    // To be updated
    @FXML
    private ListView<String> recipeListView;

    /**
     * Creates a {@code IngredientListPanel} with the given {@code ObservableList}.
     */
    public RecipeListPanel(ObservableList<String> recipeList) {
        super(FXML);
        System.out.println(recipeList);
        recipeListView.setItems(recipeList);
        recipeListView.setCellFactory(listView -> new RecipeListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Recipe} using an {@code RecipeCard}.
     */
    class RecipeListViewCell extends ListCell<String> { // To be updated
        @Override
        protected void updateItem(String string, boolean empty) {
            super.updateItem(string, empty);

            if (empty || string == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new RecipeCard(string, getIndex() + 1).getRoot());
            }
        }
    }
}
