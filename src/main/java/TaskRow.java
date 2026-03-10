import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class TaskRow {
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty dueDate = new SimpleStringProperty();
    private final StringProperty priority = new SimpleStringProperty();
    private final BooleanProperty completed = new SimpleBooleanProperty(false);

    public TaskRow(String title, String dueDate, String priority, boolean completed) {
        this.title.set(title);
        this.dueDate.set(dueDate);
        this.priority.set(priority);
        this.completed.set(completed);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty dueDateProperty() {
        return dueDate;
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    public BooleanProperty completedProperty() {
        return completed;
    }
}