package seedu.address.model.recipe;

public class UniqueId {
    private final int id;
    private static int lastId = 0;
    public UniqueId() {
        this.id = ++lastId;
    }

    public UniqueId(int id) {
        this.id = id;
        lastId = lastId >= id ? lastId : id;
    }

    public int getId() {
        return this.id;
    }
}
