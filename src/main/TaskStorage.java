import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    private static final String FILE_NAME = "tasks.txt";

    // Save tasks to file
    public static void saveTasks(List<TaskRow> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (TaskRow task : tasks) {
                String line = String.join(",",
                        escape(task.getTitle()),
                        escape(task.getDueDate()),
                        escape(task.getPriority()),
                        String.valueOf(task.isCompleted())
                );
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load tasks from file
    public static List<TaskRow> loadTasks() {
        List<TaskRow> tasks = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = split(line);

                if (parts.length == 4) {
                    String title = parts[0];
                    String dueDate = parts[1];
                    String priority = parts[2];
                    boolean completed = Boolean.parseBoolean(parts[3]);

                    tasks.add(new TaskRow(title, dueDate, priority, completed));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    // Handle commas safely
    private static String escape(String text) {
        return text.replace(",", "\\,");
    }

    private static String[] split(String line) {
        return line.split("(?<!\\\\),");
    }
}
