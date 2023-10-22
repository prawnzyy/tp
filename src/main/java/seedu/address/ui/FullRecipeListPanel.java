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
public class FullRecipeListPanel extends UiPart<Region> {
    private static final String FXML = "FullRecipeListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(RecipeListPanel.class);

    // To be updated
    @FXML
    private ListView<String> fullRecipeListView;

    /**
     * Creates a {@code IngredientListPanel} with the given {@code ObservableList}.
     */
    public FullRecipeListPanel(ObservableList<String> recipeList) {
        super(FXML);
        System.out.println(recipeList);
        fullRecipeListView.setItems(recipeList);
        fullRecipeListView.setCellFactory(listView -> new FullRecipeListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Recipe} using an {@code RecipeCard}.
     */
    class FullRecipeListViewCell extends ListCell<String> { // To be updated
        @Override
        protected void updateItem(String string, boolean empty) {
            super.updateItem(string, empty);

            if (empty || string == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new FullRecipeCard(string, getIndex() + 1).getRoot());
            }
        }
    }
}
