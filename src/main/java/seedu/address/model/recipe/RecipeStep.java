package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * An abstraction class for a recipe step.
 * Wraps a step number and a string instruction
 */
public class RecipeStep {
    private final String instruction;
    private final int stepNumber;

    /** Creates a new recipe step with the specified {@code stepNumber} and {@code instruction}. */
    public RecipeStep(String instruction, int stepNumber) {
        requireAllNonNull(instruction, stepNumber);
        this.instruction = instruction;
        this.stepNumber = stepNumber;
    }

    /** Modifies the current recipe step with the specified {@code newInstruction} */
    public RecipeStep modifyStep(String newInstruction) {
        requireNonNull(newInstruction);
        return new RecipeStep(newInstruction, this.stepNumber);
    }

    /** Modifies the current recipe step with the specified {@code newStepNumber} */
    public RecipeStep modifyStep(int newStepNumber) {
        return new RecipeStep(this.instruction, newStepNumber);
    }

    @Override
    public String toString() {
        return String.format("%d. %s", this.stepNumber, this.instruction);
    }

}
