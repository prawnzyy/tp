package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.UniqueId;

import java.util.function.Predicate;

public class RecipeManager implements RecipeModel {

    @Override
    public void setRecipeBook(ReadOnlyRecipeBook inventory) {

    }

    @Override
    public ReadOnlyRecipeBook getRecipeBook() {
        return null;
    }

    @Override
    public boolean hasRecipe(Name ingredientName) {
        return false;
    }

    @Override
    public void deleteRecipe(UniqueId recipeId) {

    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public ObservableList<Recipe> getFilteredRecipeList() {
        return null;
    }

    @Override
    public void updateFilteredRecipeList(Predicate<Ingredient> predicate) {

    }
}
