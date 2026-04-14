import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

public class TaskRow {

    private final StringProperty title;
    private final StringProperty dueDate;
    private final StringProperty priority;
    private final BooleanProperty completed;

    public TaskRow(String title, String dueDate, String priority, boolean completed) {
        this.title = new SimpleStringProperty(title);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.priority = new SimpleStringProperty(priority);
        this.completed = new SimpleBooleanProperty(completed);
    }

    // Title
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String value) {
        title.set(value);
    }

    public StringProperty titleProperty() {
        return title;
    }

    // Due Date
    public String getDueDate() {
        return dueDate.get();
    }

    public void setDueDate(String value) {
        dueDate.set(value);
    }

    public StringProperty dueDateProperty() {
        return dueDate;
    }

    // Priority
    public String getPriority() {
        return priority.get();
    }

    public void setPriority(String value) {
        priority.set(value);
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    // Completed
    public boolean isCompleted() {
        return completed.get();
    }

    public void setCompleted(boolean value) {
        completed.set(value);
    }

    public BooleanProperty completedProperty() {
        return completed;
    }
}
