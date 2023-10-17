//package seedu.address.logic.commands;
//
//import static java.util.Objects.requireNonNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.testutil.Assert.assertThrows;
//import static seedu.address.testutil.TypicalIngredients.FLOUR;
//
//import org.junit.jupiter.api.Test;
//
//public class AddCommandTest {
//
//    @Test
//    public void constructor_nullIngredient_throwsNullPointerException() {
//        assertThrows(NullPointerException.class, () -> new AddCommand(null));
//    }
//
//    @Test
//    public void execute_ingredientAcceptedByModel_addSuccessful() throws Exception {
//        ModelStubAcceptingIngredientAdded modelStub = new ModelStubAcceptingIngredientAdded();
//        Ingredient validIngredient = new IngredientBuilder().build();
//
//        CommandResult commandResult = new AddCommand(validIngredient).execute(modelStub);
//
//        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(validIngredient)),
//                commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(validIngredient), modelStub.ingredientsAdded);
//    }
//
//    @Test
//    public void execute_duplicateIngredient_throwsCommandException() {
//        Ingredient validIngredient = new IngredientBuilder().build();
//        AddCommand addCommand = new AddCommand(validIngredient);
//        ModelStub modelStub = new ModelStubWithIngredient(validIngredient);
//
//        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_INGREDIENT,
//          () -> addCommand.execute(modelStub));
//    }
//
//    @Test
//    public void equals() {
//        Ingredient alice = new IngredientBuilder().withName("Alice").build();
//        Ingredient bob = new IngredientBuilder().withName("Bob").build();
//        AddCommand addAliceCommand = new AddCommand(alice);
//        AddCommand addBobCommand = new AddCommand(bob);
//
//        // same object -> returns true
//        assertTrue(addAliceCommand.equals(addAliceCommand));
//
//        // same values -> returns true
//        AddCommand addAliceCommandCopy = new AddCommand(alice);
//        assertTrue(addAliceCommand.equals(addAliceCommandCopy));
//
//        // different types -> returns false
//        assertFalse(addAliceCommand.equals(1));
//
//        // null -> returns false
//        assertFalse(addAliceCommand.equals(null));
//
//        // different ingredient -> returns false
//        assertFalse(addAliceCommand.equals(addBobCommand));
//    }
//
//    @Test
//    public void toStringMethod() {
//        AddCommand addCommand = new AddCommand(FLOUR);
//        String expected = AddCommand.class.getCanonicalName() + "{toAdd=" + FLOUR + "}";
//        assertEquals(expected, addCommand.toString());
//    }
//
//    /**
//     * A default model stub that have all of the methods failing.
//     */
//    private class ModelStub implements Model {
//        @Override
//        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyUserPrefs getUserPrefs() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public GuiSettings getGuiSettings() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setGuiSettings(GuiSettings guiSettings) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public Path getInventoryFilePath() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setInventoryFilePath(Path inventoryFilePath) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addIngredient(Ingredient ingredient) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setInventory(ReadOnlyInventory newData) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyInventory getInventory() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasIngredient(Ingredient ingredient) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteIngredient(Ingredient target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setIngredient(Ingredient target, Ingredient editedIngredient) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Ingredient> getFilteredIngredientList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredIngredientList(Predicate<Ingredient> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//    }
//
//    /**
//     * A Model stub that contains a single ingredient.
//     */
//    private class ModelStubWithIngredient extends ModelStub {
//        private final Ingredient ingredient;
//
//        ModelStubWithIngredient(Ingredient ingredient) {
//            requireNonNull(ingredient);
//            this.ingredient = ingredient;
//        }
//
//        @Override
//        public boolean hasIngredient(Ingredient ingredient) {
//            requireNonNull(ingredient);
//            return this.ingredient.isSameIngredient(ingredient);
//        }
//    }
//
//    /**
//     * A Model stub that always accept the ingredient being added.
//     */
//    private class ModelStubAcceptingIngredientAdded extends ModelStub {
//        final ArrayList<Ingredient> ingredientsAdded = new ArrayList<>();
//
//        @Override
//        public boolean hasIngredient(Ingredient ingredient) {
//            requireNonNull(ingredient);
//            return ingredientsAdded.stream().anyMatch(ingredient::isSameIngredient);
//        }
//
//        @Override
//        public void addIngredient(Ingredient ingredient) {
//            requireNonNull(ingredient);
//            ingredientsAdded.add(ingredient);
//        }
//
//        @Override
//        public ReadOnlyInventory getInventory() {
//            return new Inventory();
//        }
//    }
//
//}
