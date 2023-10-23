package seedu.address.testutil;

import seedu.address.model.Name;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeStep;

import java.util.ArrayList;
import java.util.List;

public class RecipeBuilder {
    public static final String DEFAULT_RECIPE_NAME = "Cookies";
    private int id;
    private Name name;
    private List<Ingredient> ingredientList;
    private List<RecipeStep> recipeSteps;
    public RecipeBuilder() {
        this.name = new Name(DEFAULT_RECIPE_NAME);
        this.ingredientList = new ArrayList<>();
        this.recipeSteps = new ArrayList<>();
    }

    public RecipeBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public RecipeBuilder withIngredient(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
        return this;
    }

    public RecipeBuilder withSteps(String stepInstruction, int stepNumber) {
        this.recipeSteps.add(new RecipeStep(stepInstruction, stepNumber));
        return this;
    }
    public RecipeBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public Recipe build() {
        return new Recipe(this.id, this.name, this.ingredientList, this.recipeSteps);
    }
}
