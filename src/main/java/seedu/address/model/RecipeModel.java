package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.UniqueId;

public interface RecipeModel {
    Predicate<Ingredient> PREDICATE_SHOW_ALL_RECIPES = unused -> true;

    /**
     * Replaces recipe data with the data in {@code recipe}.
     */
    void setRecipeBook(ReadOnlyRecipeBook recipeBook);

    /** Returns the RecipeBook */
    ReadOnlyRecipeBook getRecipeBook();

    boolean hasRecipe(Name recipeName);

    void deleteRecipe(int recipeId);

    void addRecipe(Recipe recipe);

    String getFullRecipe(int recipeId);

    /** Returns an unmodifiable view of the filtered recipe list */
    ObservableList<Recipe> getFilteredRecipeList();

    /**
     * Updates the filter of the filtered recipe list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredRecipeList(Predicate<Recipe> predicate);

}
