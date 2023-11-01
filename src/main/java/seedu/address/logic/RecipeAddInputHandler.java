package seedu.address.logic;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.RecipeAddCommand;
import seedu.address.logic.parser.RecipeAddCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;

public class RecipeAddInputHandler {

    private static String MESSAGE_PROMPT_NAME=  "Input the name of the recipe.";

    private static String MESSAGE_PROMPT_INGREDIENT = "Input an ingredient and it's quantity." + "\n" +
            "When you're done, type \"steps start\"";

    private static String MESSAGE_PROMPT_STEP = "Input the next step in the recipe." + "\n" +
            "When you're done, type \"complete recipe\"";

    private RecipeAddCommandParser recipeAddCommandParser;

    private RecipeAddInputStage stage;

    public RecipeAddInputHandler() {
        recipeAddCommandParser = new RecipeAddCommandParser();
        stage = RecipeAddInputStage.COMPLETE;
    }

    public boolean check(String commandText) {
        if (stage != RecipeAddInputStage.COMPLETE) {
            return true;
        }
        else if (commandText.equals("addrecipe")) {
            return true;
        } else {
            return false;
        }
    }

    public CommandResult handle(String commandText) {
        String parseOutput = "";
        if (commandText.equals("addrecipe")) {
            stage = RecipeAddInputStage.NAME;
        }
        else if (stage == RecipeAddInputStage.NAME) {
            parseOutput = recipeAddCommandParser.addName(commandText);
            stage = RecipeAddInputStage.INGREDIENT;
        }
        else if (commandText.equals("steps start") || commandText.equals("step start")) {
            stage = RecipeAddInputStage.STEPS;
        }
        else if (commandText.equals("complete recipe")) {
            stage = RecipeAddInputStage.COMPLETE;
        }
        else {
            switch (stage) {
            case INGREDIENT:
                parseOutput = recipeAddCommandParser.addIngredient(commandText);
                break;
            case STEPS:
                parseOutput = recipeAddCommandParser.addStep(commandText);
                break;
            }
        }

        switch(stage) {
        case NAME:
            return new CommandResult(parseOutput + "\n" + MESSAGE_PROMPT_NAME);
        case INGREDIENT:
            return new CommandResult(parseOutput + "\n" + MESSAGE_PROMPT_INGREDIENT);
        case STEPS:
            return new CommandResult(parseOutput + "\n" + MESSAGE_PROMPT_STEP);
        default:
            return new CommandResult(MESSAGE_PROMPT_NAME);
        }
    }

    public boolean isComplete() {
        return stage == RecipeAddInputStage.COMPLETE;
    }

    public Command getCommand() {
        return recipeAddCommandParser.generateCommand();
    }
}
