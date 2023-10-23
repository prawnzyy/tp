package seedu.address.model.recipe;

/**
 * A wrapper for a unique immutable id.
 */
public class UniqueId {
    private static int lastId = 0;
    private final int id;

    /** Creates a new unique ID which is 1 increment of the previous id, starts from 1 */
    public UniqueId() {
        this.id = ++lastId;
    }

    /** Imports a unique ID with the given {@code id}, updates the previous id if the imported id is larger */
    public UniqueId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    public int getId() {
        return this.id;
    }
}
