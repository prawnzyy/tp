package seedu.address.model.recipe;

public class RecipeStep {
    private final String instruction;
    private final int stepNumber;

    public RecipeStep(String instruction, int stepNumber) {
        this.instruction = instruction;
        this.stepNumber = stepNumber;
    }

    public RecipeStep modifyInstruction(String newInstruction) {
        return new RecipeStep(newInstruction, this.stepNumber);
    }

    public RecipeStep modifyStepNumber(int newStepNumber) {
        return new RecipeStep(this.instruction, newStepNumber);
    }

    public RecipeStep modifyStep(String newInstruction, int newStepNumber) {
        return new RecipeStep(newInstruction, newStepNumber);
    }

    @Override
    public String toString() {
        return String.format("%d. %s", this.stepNumber, this.instruction);
    }

}
