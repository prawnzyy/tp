package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.Name;
import seedu.address.model.ingredient.Ingredient;

/**
 * Represents a recipe in the recipe book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Recipe {

    private final UniqueId uuid;
    private final Name name;
    private final List<Ingredient> ingredientList;
    private final List<RecipeStep> recipeSteps;

    /**
     * Creates a new Recipe.
     */
    public Recipe(Name name, List<Ingredient> ingredientList, List<RecipeStep> recipeSteps) {
        requireAllNonNull(name, ingredientList, recipeSteps);
        this.uuid = new UniqueId();
        this.name = name;
        this.ingredientList = ingredientList;
        this.recipeSteps = recipeSteps;
    }

    /** Creates a new Recipe with the specified {@code id}. */
    public Recipe(int id, Name name, List<Ingredient> ingredientList, List<RecipeStep> recipeSteps) {
        requireAllNonNull(id, name, ingredientList, recipeSteps);
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

    /** Check if the current recipe contains the specified ingredient name. */
    public boolean containsIngredient(Name ingredientName) {
        requireNonNull(ingredientName);
        return ingredientList.stream().anyMatch(x -> x.getName().equals(ingredientName));
    }

    /**
     * Changes the specified recipe step with the new instructions.
     */
    public Recipe modifyRecipeStep(int stepNumber, String newStep) {
        requireNonNull(newStep);
        if (stepNumber > recipeSteps.size()) {
            throw new IllegalArgumentException("Specified step number cannot exceed the current steps of recipe");
        }
        List<RecipeStep> stepCopy = new ArrayList<>();
        stepCopy.addAll(this.recipeSteps);
        stepCopy.set(stepNumber - 1, stepCopy.get(stepNumber - 1).modifyStep(newStep));
        return new Recipe(this.uuid.getId(), this.name, this.ingredientList, stepCopy);
    }

    /**
     * Changes the specified recipe step with a new step number.
     */
    public Recipe modifyRecipeStep(int stepNumber, int newStepNumber) {
        if (stepNumber > recipeSteps.size()) {
            throw new IllegalArgumentException("Specified step number cannot exceed the current steps of recipe");
        }
        List<RecipeStep> stepCopy = new ArrayList<>();
        stepCopy.addAll(this.recipeSteps);
        stepCopy.set(stepNumber - 1, stepCopy.get(stepNumber - 1).modifyStep(newStepNumber));
        return new Recipe(this.uuid.getId(), this.name, this.ingredientList, stepCopy);
    }

    /**
     * Returns the full recipe.
     */
    public String getFullRecipe() {
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : ingredientList) {
            ingredients.append(ingredient.getName()).append(" ").append(ingredient.getQuantity()).append("\n");
        }
        StringBuilder steps = new StringBuilder();
        for (RecipeStep recipeStep : recipeSteps) {
            steps.append(recipeStep.toString()).append("\n");
        }
        return String.format("%d. %s\n%s%s", this.getId(), this.name, ingredients, steps.toString().stripTrailing());
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

}
