package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyRecipeBook;

public interface RecipeBookStorage {

    Path getRecipeBookFilePath();

    Optional<ReadOnlyRecipeBook> readRecipeBook() throws DataLoadingException;

    Optional<ReadOnlyRecipeBook> readRecipeBook(Path path) throws DataLoadingException;

    void saveRecipeBook(ReadOnlyRecipeBook recipeBook) throws IOException;

    void saveRecipeBook(ReadOnlyRecipeBook recipeBook, Path path) throws IOException;

}
