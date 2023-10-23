package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeList;
import seedu.address.model.recipe.UniqueId;
import seedu.address.model.recipe.exceptions.RecipeNotFoundException;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class RecipeBook implements ReadOnlyRecipeBook {
    private final RecipeList recipeList;

    {
        recipeList = new RecipeList();
    }

    public RecipeBook() {

    }

    public RecipeBook(ReadOnlyRecipeBook recipeBook) {
        this();
        resetData(recipeBook);
    }

    /**
     * Replaces the contents of the ingredient list with {@code ingredients}.
     * {@code ingredients} must not contain duplicate ingredients.
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipeList.setRecipes(recipes);
    }

    /**
     * Resets the existing data of this {@code Inventory} with {@code newData}.
     */
    public void resetData(ReadOnlyRecipeBook newData) {
        requireNonNull(newData);
        setRecipes(newData.getRecipeList());
    }

    public boolean hasRecipe(Name recipeName) {
        requireNonNull(recipeName);
        for (Recipe recipe : this.recipeList) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    public void addRecipe(Recipe toAdd) {
        recipeList.add(toAdd);
    }

    public void removeRecipe(int recipeId) {
        for (Recipe recipe : this.recipeList) {
            if (recipe.getId() == recipeId) {
                this.recipeList.remove(recipe);
                break;
            }
        }
        throw new RecipeNotFoundException();
    }

    public void clear() {
        this.recipeList.clear();
    }

    public String getFullRecipe(int recipeId) {
        return this.recipeList.getFullRecipe(recipeId);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("recipe", this.recipeList)
                .toString();
    }

    @Override
    public ObservableList<Recipe> getRecipeList() {
        return recipeList.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Inventory)) {
            return false;
        }

        RecipeBook otherRecipeBook = (RecipeBook) other;
        return recipeList.equals(otherRecipeBook.recipeList);
    }

    @Override
    public int hashCode() {
        return recipeList.hashCode();
    }

}
