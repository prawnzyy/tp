package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.exceptions.RecipeNotFoundException;

/**
 * The API of the recipe book model component.
 */
public interface RecipeModel {
    Predicate<Ingredient> PREDICATE_SHOW_ALL_RECIPES = unused -> true;

    /**
     * Replaces recipe data with the data in {@code recipeBook}.
     */
    void setRecipeBook(ReadOnlyRecipeBook recipeBook);

    /** Returns the RecipeBook */
    ReadOnlyRecipeBook getRecipeBook();

    boolean hasRecipe(Name recipeName);

    void deleteRecipe(int recipeId);

    void addRecipe(Recipe recipe);

    /**
     * Gets the full Recipe based on the unique {@code recipeId} of the Recipe.
     * @throws RecipeNotFoundException if {@code recipe} is not found.
     */
    String getFullRecipe(int recipeId);

    /** Returns an unmodifiable view of the filtered recipe list */
    ObservableList<Recipe> getFilteredRecipeList();

    /**
     * Updates the filter of the filtered recipe list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredRecipeList(Predicate<Recipe> predicate);

}
