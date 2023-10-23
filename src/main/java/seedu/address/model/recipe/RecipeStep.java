package seedu.address.model.recipe;

public class RecipeStep {
    private final String instruction;
    private final int stepNumber;

    public RecipeStep(String instruction, int stepNumber) {
        this.instruction = instruction;
        this.stepNumber = stepNumber;
    }

    public RecipeStep modifyStep(String newInstruction) {
        return new RecipeStep(newInstruction, this.stepNumber);
    }

    public RecipeStep modifyStep(int newStepNumber) {
        return new RecipeStep(this.instruction, newStepNumber);
    }

    @Override
    public String toString() {
        return String.format("%d. %s", this.stepNumber, this.instruction);
    }

}
