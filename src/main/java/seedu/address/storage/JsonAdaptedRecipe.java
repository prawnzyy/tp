package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.Name;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeStep;

import java.util.List;
import java.util.stream.Collectors;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class JsonAdaptedRecipe {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Recipe's %s field is missing!";

    private final int id;
    private final String name;
    private final List<JsonAdaptedIngredient> ingredientsList;
    private final List<String> recipeSteps;

    public JsonAdaptedRecipe(@JsonProperty("id") int id, @JsonProperty("name") String name,
                             @JsonProperty("ingredients") List<Ingredient> ingredients,
                             @JsonProperty("steps") List<String> steps) {

        requireAllNonNull(id, name, ingredients, steps);
        this.id = id;
        this.name = name;
        this.ingredientsList = ingredients.stream().map(JsonAdaptedIngredient::new).collect(Collectors.toList());
        this.recipeSteps = steps;
    }

    public JsonAdaptedRecipe(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName().fullName;
        this.ingredientsList = recipe.getIngredients().stream().map(JsonAdaptedIngredient::new)
                .collect(Collectors.toList());
        this.recipeSteps = recipe.getRecipeSteps();
    }

    public Recipe toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);
        final List<Ingredient> modelIngredients = ingredientsList.stream().map(x -> {
            try {
                return x.toModelType();
            } catch (IllegalValueException e) {
                return null;
            }
        }).collect(Collectors.toList());

        final List<RecipeStep> modelSteps = recipeSteps.stream().map(RecipeStep::parseRecipeStep)
                .collect(Collectors.toList());

        return new Recipe(id, modelName, modelIngredients, modelSteps);
    }
}
