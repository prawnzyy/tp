package seedu.address.model.recipe;

import seedu.address.model.Name;
import seedu.address.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private final UniqueId uuid;
    private final Name name;
    private final List<Ingredient> ingredientList;
    private final List<RecipeStep> recipeSteps;

    public Recipe(Name name, List<Ingredient> ingredientList, List<RecipeStep> recipeSteps) {
        this.uuid = new UniqueId();
        this.name = name;
        this.ingredientList = ingredientList;
        this.recipeSteps = recipeSteps;
    }

    public Recipe(int id, Name name, List<Ingredient> ingredientList, List<RecipeStep> recipeSteps) {
        this.uuid = new UniqueId(id);
        this.name = name;
        this.ingredientList = ingredientList;
        this.recipeSteps = recipeSteps;
    }

    public Name getName() {
        return this.name;
    }

    public int getId() {
        return this.uuid.getId();
    }

    public boolean containsIngredient(Ingredient otherIngredient) {
        return ingredientList.contains(otherIngredient);
    }

    public Recipe modifyRecipeStep(int stepNumber, String newStep) {
        List<RecipeStep> stepCopy = new ArrayList<>();
        stepCopy.addAll(this.recipeSteps);
        stepCopy.set(stepNumber - 1, stepCopy.get(stepNumber - 1).modifyStep(newStep));
        return new Recipe(this.uuid.getId(), this.name, this.ingredientList, stepCopy);
    }

    public Recipe modifyRecipeStep(int stepNumber, int newStepNumber) {
        List<RecipeStep> stepCopy = new ArrayList<>();
        stepCopy.addAll(this.recipeSteps);
        stepCopy.set(stepNumber - 1, stepCopy.get(stepNumber - 1).modifyStep(newStepNumber));
        return new Recipe(this.uuid.getId(), this.name, this.ingredientList, stepCopy);
    }

    public String getFullRecipe() {
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : ingredientList) {
            ingredients.append(ingredient).append("\n");
        }
        StringBuilder steps = new StringBuilder();
        for (RecipeStep recipeStep : recipeSteps) {
            steps.append(recipeStep).append("\n");
        }
        return this.name + "\n" + ingredients + steps;
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

}
