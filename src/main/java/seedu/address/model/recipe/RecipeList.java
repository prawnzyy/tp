package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.UniqueIngredientList;
import seedu.address.model.ingredient.exceptions.DuplicateIngredientException;
import seedu.address.model.recipe.exceptions.RecipeNotFoundException;

public class RecipeList implements Iterable<Recipe> {
    private final ObservableList<Recipe> internalList = FXCollections.observableArrayList();
    private final ObservableList<Recipe> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public void add(Recipe toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    public void remove(Recipe toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new RecipeNotFoundException();
        }
    }

    public void replace(Recipe toReplace, Recipe toAdd) {
        requireAllNonNull(toReplace, toAdd);
        int index = internalList.indexOf(toReplace);
        internalList.remove(toReplace);
        internalList.add(index, toAdd);
    }

    /**
     * Empties the list.
     */
    public void clear() {
        internalList.clear();
    }

    public ObservableList<Recipe> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    public void setRecipes(RecipeList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code ingredients}.
     * {@code ingredients} must not contain duplicate ingredients.
     */
    public void setRecipes(List<Recipe> recipeList) {
        requireAllNonNull(recipeList);
        internalList.setAll(recipeList);
    }

    public String getFullRecipe(int recipeId) {
        return this.internalList.stream().filter(x -> x.getId() == recipeId).findFirst()
                .orElseThrow(RecipeNotFoundException::new).getFullRecipe();
    }

    @Override
    public Iterator<Recipe> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RecipeList)) {
            return false;
        }

        RecipeList otherRecipeList = (RecipeList) other;
        return internalList.equals(otherRecipeList.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}
