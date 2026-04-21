package planner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TaskStorage {

    private static final Path FILE_PATH =
            Path.of(System.getProperty("user.home"), "csc478-task-planner", "tasks.json");
    private static final Gson gson = new Gson();

    public static void saveTasks(List<TaskRow> tasks) {
        List<TaskData> taskDataList = new ArrayList<>();

        for(TaskRow task : tasks) {
            taskDataList.add(new TaskData(
                    task.getTitle(),
                    task.getDueDate(),
                    task.getPriority(),
                    task.isCompleted()
            ));
        }

        FILE_PATH.getParent().toFile().mkdirs();
        try(FileWriter writer = new FileWriter(FILE_PATH.toFile())) {
            gson.toJson(taskDataList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<TaskRow> loadTasks() {
        try(FileReader reader = new FileReader(FILE_PATH.toFile())) {
            List<TaskData> taskDataList = gson.fromJson(reader, new TypeToken<List<TaskData>>() {}.getType());

            List<TaskRow> tasks = new ArrayList<>();
            if(taskDataList != null) {
                for(TaskData taskData : taskDataList) {
                    tasks.add(new TaskRow(
                            taskData.title,
                            taskData.dueDate,
                            taskData.priority,
                            taskData.completed
                    ));
                }
            }
            return tasks;

        } catch(IOException e) {
            return new ArrayList<>();
        }
    }

    private static class TaskData {
        String title;
        String dueDate;
        String priority;
        boolean completed;

        TaskData(String title, String dueDate, String priority, boolean completed) {
            this.title = title;
            this.dueDate = dueDate;
            this.priority = priority;
            this.completed = completed;
        }
    }
}
