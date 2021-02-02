package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        addItem(new TodoItem("first", "first detail", LocalDate.now()));
        addItem(new TodoItem("second", "second detail", LocalDate.now()));
        addItem(new TodoItem("third", "third detail", LocalDate.now()));
    }

    public static int getIdValue() {
        return idValue;
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        items.add(toAdd);
        toAdd.setId(idValue);
        idValue++;
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NotNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while (itemListIterator.hasNext()) {

            TodoItem item = itemListIterator.next();

            if (item.equals(toUpdate)) {
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }
}
