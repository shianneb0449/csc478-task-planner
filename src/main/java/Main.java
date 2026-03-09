import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
            javafx.scene.control.TextInputDialog dialog = new javafx.scene.control.TextInputDialog();
            dialog.setTitle("Add Task");
            dialog.setHeaderText("Enter task title");
            dialog.setContentText("Title:");

            dialog.showAndWait().ifPresent(title -> {
                if (!title.trim().isEmpty()) {
                    tableView.getItems().add(new TaskRow(title, "", "Medium", false));
                }
            });
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