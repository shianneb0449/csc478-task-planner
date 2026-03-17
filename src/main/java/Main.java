import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	TableView<TaskRow> tableView = new TableView<>();

    	TableColumn<TaskRow, String> titleColumn = new TableColumn<>("Title");
    	titleColumn.setCellValueFactory(cell -> cell.getValue().titleProperty());

    	TableColumn<TaskRow, String> dueColumn = new TableColumn<>("Due Date");
    	dueColumn.setCellValueFactory(cell -> cell.getValue().dueDateProperty());

    	TableColumn<TaskRow, String> priorityColumn = new TableColumn<>("Priority");
    	priorityColumn.setCellValueFactory(cell -> cell.getValue().priorityProperty());

    	TableColumn<TaskRow, Boolean> completedColumn = new TableColumn<>("Completed");
    	completedColumn.setCellValueFactory(cell -> cell.getValue().completedProperty());
    	
        tableView.getColumns().addAll(titleColumn, dueColumn, priorityColumn, completedColumn);

        tableView.getItems().addAll(
                new TaskRow("pack lunch", "2026-03-05", "High", false),
                new TaskRow("fold laundry", "2026-03-06", "Medium", true),
                new TaskRow("clean gutters", "", "Low", false)
        );
        
        Button addButton = new Button("Add");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button completeButton = new Button("Mark Complete");
        
        addButton.setOnAction(e -> {
            Dialog<TaskRow> dialog = new Dialog<>();
            dialog.setTitle("Add Task");
            dialog.setHeaderText("Enter task details");

            ButtonType saveButtonType = new ButtonType("Save", javafx.scene.control.ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            javafx.scene.control.TextField titleField = new javafx.scene.control.TextField();
            DatePicker dueDatePicker = new DatePicker();
            ComboBox<String> priorityBox = new ComboBox<>();
            priorityBox.getItems().addAll("Low", "Medium", "High");
            priorityBox.setValue("Medium");

            grid.add(new Label("Title:"), 0, 0);
            grid.add(titleField, 1, 0);
            grid.add(new Label("Due Date:"), 0, 1);
            grid.add(dueDatePicker, 1, 1);
            grid.add(new Label("Priority:"), 0, 2);
            grid.add(priorityBox, 1, 2);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == saveButtonType) {
                    String title = titleField.getText().trim();
                    if (!title.isEmpty()) {
                        LocalDate dueDate = dueDatePicker.getValue();
                        String dueDateText = (dueDate == null) ? "" : dueDate.toString();
                        return new TaskRow(title, dueDateText, priorityBox.getValue(), false);
                    }
                }
                return null;
            });

            dialog.showAndWait().ifPresent(task -> {
                tableView.getItems().add(task);
            });
        });
        
        editButton.setOnAction(e -> {
            TaskRow selectedTask = tableView.getSelectionModel().getSelectedItem();

            if (selectedTask == null) {
                return;
            }

            Dialog<Void> dialog = new Dialog<>();
            dialog.setTitle("Edit Task");
            dialog.setHeaderText("Modify task details");

            ButtonType saveButtonType = new ButtonType("Save", javafx.scene.control.ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            javafx.scene.control.TextField titleField = new javafx.scene.control.TextField(selectedTask.getTitle());

            DatePicker dueDatePicker = new DatePicker(
                selectedTask.getDueDate().isEmpty() ? null : LocalDate.parse(selectedTask.getDueDate())
            );

            ComboBox<String> priorityBox = new ComboBox<>();
            priorityBox.getItems().addAll("Low", "Medium", "High");
            priorityBox.setValue(selectedTask.getPriority());

            grid.add(new Label("Title:"), 0, 0);
            grid.add(titleField, 1, 0);
            grid.add(new Label("Due Date:"), 0, 1);
            grid.add(dueDatePicker, 1, 1);
            grid.add(new Label("Priority:"), 0, 2);
            grid.add(priorityBox, 1, 2);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == saveButtonType) {
                    String title = titleField.getText().trim();

                    if (!title.isEmpty()) {
                        selectedTask.setTitle(title);

                        String dueDateText = (dueDatePicker.getValue() == null)
                                ? ""
                                : dueDatePicker.getValue().toString();
                        selectedTask.setDueDate(dueDateText);

                        selectedTask.setPriority(priorityBox.getValue());

                        tableView.refresh();
                    }
                }
                return null;
            });

            dialog.showAndWait();
        });
        
        deleteButton.setOnAction(e -> {
            TaskRow selectedTask = tableView.getSelectionModel().getSelectedItem();

            if (selectedTask != null) {
                tableView.getItems().remove(selectedTask);
            }
        });
        
        completeButton.setOnAction(e -> {
            TaskRow selectedTask = tableView.getSelectionModel().getSelectedItem();

            if (selectedTask != null) {
                selectedTask.setCompleted(!selectedTask.isCompleted());
                tableView.refresh();
            }
        });
        
        ToolBar toolBar = new ToolBar(addButton, editButton, deleteButton, completeButton);

        BorderPane root = new BorderPane();
        root.setTop(toolBar);
        root.setCenter(tableView);

        Scene scene = new Scene(root, 800, 500);

        primaryStage.setTitle("CSC 478 Task Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}