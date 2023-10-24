package seedu.address.testutil;

import seedu.address.model.RecipeBook;
import seedu.address.model.recipe.Recipe;

public class RecipeBookBuilder {

    private RecipeBook recipeBook;

    public RecipeBookBuilder() {
        this.recipeBook = new RecipeBook();
    }

    public RecipeBookBuilder(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    public RecipeBookBuilder withRecipe(Recipe recipe) {
        this.recipeBook.addRecipe(recipe);
        return this;
    }

    public RecipeBook build() {
        return this.recipeBook;
    }

}
