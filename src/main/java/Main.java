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
        TableView<String> tableView = new TableView<>();

        TableColumn<String, String> titleColumn = new TableColumn<>("Title");
        TableColumn<String, String> dueColumn = new TableColumn<>("Due Date");
        TableColumn<String, String> priorityColumn = new TableColumn<>("Priority");
        TableColumn<String, String> completedColumn = new TableColumn<>("Completed");

        tableView.getColumns().addAll(titleColumn, dueColumn, priorityColumn, completedColumn);

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
                System.out.println("New task title: " + title);
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