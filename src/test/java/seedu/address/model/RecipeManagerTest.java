package seedu.address.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import seedu.address.model.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalRecipe.COOKIES;
import static seedu.address.testutil.TypicalRecipe.SPONGECAKE;

public class RecipeManagerTest {
    private RecipeManager recipeManager = new RecipeManager();

    @Test
    public void constructor() {
        assertEquals(new RecipeBook(), new RecipeBook(recipeManager.getRecipeBook()));
    }

    @Test
    public void hasRecipe_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> recipeManager.hasRecipe(null));
    }

    @Test
    public void hasRecipe_recipeNotInList_returnsFalse() {
        assertFalse(recipeManager.hasRecipe(COOKIES.getName()));
    }

    @Test
    public void hasRecipe_recipeInList_returnTrue() {
        recipeManager.addRecipe(COOKIES);
        assertTrue(recipeManager.hasRecipe(COOKIES.getName()));
    }

    @Test
    public void getFilteredRecipeList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> recipeManager.getFilteredRecipeList().remove(0));
    }

    @Test
    public void getFilteredRecipeList_recipeInList_success() {
        recipeManager.addRecipe(COOKIES);
        recipeManager.addRecipe(SPONGECAKE);
        recipeManager.updateFilteredRecipeList(x -> x.containsIngredient(new Name("Eggs")));
        assertEquals(1, recipeManager.getFilteredRecipeList().size());

        List<Recipe> expectedList = new ArrayList<>();
        expectedList.add(SPONGECAKE);

        assertEquals(expectedList, new ArrayList<>(recipeManager.getFilteredRecipeList()));
    }

}
