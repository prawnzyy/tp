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
//    public void constructor_nullPerson_throwsNullPointerException() {
//        assertThrows(NullPointerException.class, () -> new AddCommand(null));
//    }
//
//    @Test
//    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
//        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
//        Person validPerson = new IngredientBuilder().build();
//
//        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);
//
//        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(validPerson)),
//                commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
//    }
//
//    @Test
//    public void execute_duplicatePerson_throwsCommandException() {
//        Person validPerson = new IngredientBuilder().build();
//        AddCommand addCommand = new AddCommand(validPerson);
//        ModelStub modelStub = new ModelStubWithPerson(validPerson);
//
//        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON,
//          () -> addCommand.execute(modelStub));
//    }
//
//    @Test
//    public void equals() {
//        Person alice = new IngredientBuilder().withName("Alice").build();
//        Person bob = new IngredientBuilder().withName("Bob").build();
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
//        public void setInventoryFilePath(Path addressBookFilePath) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addPerson(Person ingredient) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setAddressBook(ReadOnlyAddressBook newData) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyAddressBook getInventory() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasPerson(Person ingredient) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deletePerson(Person target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setPerson(Person target, Person editedPerson) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Person> getFilteredIngredientList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredPersonList(Predicate<Person> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//    }
//
//    /**
//     * A Model stub that contains a single ingredient.
//     */
//    private class ModelStubWithPerson extends ModelStub {
//        private final Person ingredient;
//
//        ModelStubWithPerson(Person ingredient) {
//            requireNonNull(ingredient);
//            this.ingredient = ingredient;
//        }
//
//        @Override
//        public boolean hasPerson(Person ingredient) {
//            requireNonNull(ingredient);
//            return this.ingredient.isSamePerson(ingredient);
//        }
//    }
//
//    /**
//     * A Model stub that always accept the ingredient being added.
//     */
//    private class ModelStubAcceptingPersonAdded extends ModelStub {
//        final ArrayList<Person> personsAdded = new ArrayList<>();
//
//        @Override
//        public boolean hasPerson(Person ingredient) {
//            requireNonNull(ingredient);
//            return personsAdded.stream().anyMatch(ingredient::isSamePerson);
//        }
//
//        @Override
//        public void addPerson(Person ingredient) {
//            requireNonNull(ingredient);
//            personsAdded.add(ingredient);
//        }
//
//        @Override
//        public ReadOnlyAddressBook getInventory() {
//            return new AddressBook();
//        }
//    }
//
//}
