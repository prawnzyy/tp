package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeList;
import seedu.address.model.recipe.exceptions.RecipeNotFoundException;

/**
 * Wraps all recipe data at the recipe book level
 */
public class RecipeBook implements ReadOnlyRecipeBook {
    private final RecipeList recipeList;

    {
        recipeList = new RecipeList();
    }

    public RecipeBook() {

    }

    /**
     * Creates a new recipe book with the specified {@code recipeBook}
     */
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

    /**
     * Checks if the recipe name exists in the recipe book.
     */
    public boolean hasRecipe(Name recipeName) {
        requireNonNull(recipeName);
        for (Recipe recipe : this.recipeList) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new {@code recipe} to the recipe book.
     */
    public void addRecipe(Recipe toAdd) {
        recipeList.add(toAdd);
    }

    /**
     * Removes a recipe from the recipe book with its {@code recipeId}
     */
    public void removeRecipe(int recipeId) {
        for (Recipe recipe : this.recipeList) {
            if (recipe.getId() == recipeId) {
                this.recipeList.remove(recipe);
                break;
            }
        }
        throw new RecipeNotFoundException();
    }

    /**
     * Clears the recipe list
     */
    public void clear() {
        this.recipeList.clear();
    }

    /**
     * Gets the full recipe of the specified {@code recipeId}
     */
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
