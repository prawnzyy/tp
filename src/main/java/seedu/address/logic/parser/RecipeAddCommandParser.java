package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_UNIT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import seedu.address.logic.LogicManager;
import seedu.address.logic.Messages;
import seedu.address.logic.RecipeAddInputStage;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.RecipeAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Name;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeStep;

/**
 * Parses input arguments and creates a new AddRecipeCommand object
 */
public class RecipeAddCommandParser implements Parser<RecipeAddCommand> {
    private static String MESSAGE_SUCCESS_NAME = "Name has been set!";

    private static String MESSAGE_SUCCESS_INGREDIENT = "Ingredient added: %1$s";
    private static String MESSAGE_FAIL_INGREDIENT = "Failed to add ingredient";
    private static String MESSAGE_SUCCESS_STEP = "Step added successfully to recipe";
    private static String MESSAGE_FAIL_STEP = "Failed to add step";

    Name name;
    List<Ingredient> ingredients;
    List<RecipeStep> recipeSteps;

    public RecipeAddCommandParser() {
        ingredients = new ArrayList<>();
        recipeSteps = new ArrayList<>();
    }

    public String addName(String name) {
        this.name = new Name(name);
        return MESSAGE_SUCCESS_NAME;
    }

    public String addStep(String step) {
        try {
            RecipeStep toAdd = ParserUtil.parseRecipeStep(step);
            recipeSteps.add(toAdd);
            return MESSAGE_SUCCESS_STEP;
        } catch (ParseException pe) {
            return MESSAGE_FAIL_STEP;
        }
    }

    public String addIngredient(String ingredient) {
        try {
            Ingredient toAdd = ParserUtil.parseRecipeIngredient(ingredient);
            ingredients.add(toAdd);
            return String.format(MESSAGE_SUCCESS_INGREDIENT, Messages.format(toAdd));
        } catch (ParseException pe) {
            return MESSAGE_FAIL_INGREDIENT;
        }
    }

    public RecipeAddCommand generateCommand() {
        Recipe recipe = new Recipe(name, ingredients, recipeSteps);
        return new RecipeAddCommand(recipe);
    }

    @Override
    public RecipeAddCommand parse(String args) throws ParseException {


        String lines[] = args.split("\\r?\\n");


        Name name = new Name(lines[0]);
        List<String> ingredientStrings = new ArrayList<>();
        List<String> stepStrings = new ArrayList<>();

        boolean stepstarted = false;
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].equals("steps start") || lines[i].equals("step start")) {
                stepstarted = true;
            }
            else if (stepstarted) {
                stepStrings.add(lines[i]);
            }
            else {
                ingredientStrings.add(lines[i]);
            }
        }

        System.out.println(args);
        List<Ingredient> ingredientList = new ArrayList<>();
        List<RecipeStep> stepList = new ArrayList<>();
        for (String ingredientString : ingredientStrings) {
            ingredientList.add(ParserUtil.parseRecipeIngredient(ingredientString));
        }
        for (String recipeString : stepStrings) {
            stepList.add(ParserUtil.parseRecipeStep(recipeString));
        }

        Recipe recipe = new Recipe(name, ingredientList, stepList);

        return new RecipeAddCommand(recipe);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
