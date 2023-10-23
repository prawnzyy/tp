package seedu.address.model;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.recipe.Recipe;

import java.util.function.Predicate;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class RecipeManager implements RecipeModel {

    private static final Logger logger = LogsCenter.getLogger(RecipeModel.class);
    private final RecipeBook recipeBook;
    private final FilteredList<Recipe> filteredRecipe;

    /**
     * Initializes a ModelManager with the given inventory and userPrefs.
     */
    public RecipeManager(ReadOnlyRecipeBook recipeBook) {
        requireAllNonNull(recipeBook);

        logger.fine("Initializing with recipe book: " + recipeBook);

        this.recipeBook = new RecipeBook(recipeBook);
        filteredRecipe = new FilteredList<>(this.recipeBook.getRecipeList());
    }

    public RecipeManager() {
        this(new RecipeBook());
    }

    @Override
    public void setRecipeBook(ReadOnlyRecipeBook recipeBook) {
        requireNonNull(recipeBook);
        this.recipeBook.resetData(recipeBook);
    }

    @Override
    public ReadOnlyRecipeBook getRecipeBook() {
        return this.recipeBook;
    }

    @Override
    public boolean hasRecipe(Name recipeName) {
        requireNonNull(recipeName);
        return this.recipeBook.hasRecipe(recipeName);
    }

    @Override
    public void deleteRecipe(int recipeId) {
        this.recipeBook.removeRecipe(recipeId);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        requireNonNull(recipe);
        this.recipeBook.addRecipe(recipe);
    }

    @Override
    public String getFullRecipe(int recipeId) {
        return this.recipeBook.getFullRecipe(recipeId);
    }

    @Override
    public ObservableList<Recipe> getFilteredRecipeList() {
        return filteredRecipe;
    }

    @Override
    public void updateFilteredRecipeList(Predicate<Recipe> predicate) {
        requireNonNull(predicate);
        this.filteredRecipe.setPredicate(predicate);
    }
}
