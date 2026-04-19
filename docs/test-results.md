# Test Results – Front End
4/5/2026  

---

## Current System Status

The application currently supports the main task management features. These include:

- Adding a task through a dialog  
- Editing an existing task  
- Deleting a task with confirmation  
- Marking a task as complete  
- Showing warnings when no task is selected  
- Automatically saving and loading tasks using JSON  
- Loading tasks on startup  
- Saving tasks after any add, edit, delete, or complete action  

The current structure of the project is:

- Main.java handles the UI  
- TaskRow.java represents the task data  
- TaskStorage.java handles saving and loading  
- TaskService.java is still being worked on  

---

## Functional Testing

I tested all of the main features, and everything worked as expected.

- Adding a task opens the dialog and correctly adds it to the list  
- Editing a task updates the selected task properly  
- Deleting a task removes it after confirmation  
- Marking a task as complete updates its status  
- The table updates immediately after any change  
- The application launches and displays tasks without issues  

---

## Validation and Edge Cases

I also tested how the app behaves in situations where the user might make mistakes.

- Trying to edit without selecting a task shows a warning  
- Trying to delete without selecting a task shows a warning  
- Trying to mark complete without selecting a task shows a warning  
- A task cannot be saved with a blank title  
- Canceling a dialog does not change any data  

---

## Persistence Testing

I checked that data is saved and loaded correctly between runs.

- Tasks added are still there after restarting the app  
- Edited tasks keep their changes after restart  
- Deleted tasks stay deleted after restart  
- Completed status is saved and restored correctly  

---

## Reliability Testing

I tested how the app handles different file situations.

- Missing file: Passed  
  When `tasks.json` is deleted, the app recreates it and still runs normally  

- Empty file (`[]`): Passed  
  The app loads without crashing and shows placeholder tasks  

- Corrupt file: Failed  
  If the JSON file is malformed, the app crashes on startup instead of handling the error  

---

## Summary

Overall, the front-end functionality is working as intended. All core features behave correctly, and the app handles normal user interactions well.

The only issue found during testing is that corrupt JSON files are not handled gracefully, which causes the application to crash. This would need to be addressed to fully meet the reliability requirements.



---

## Backend / File Storage Testing

I tested the updated file-based storage system that uses `tasks.txt` instead of `tasks.JSON.`

- Tasks are saved correctly to the file and remain after restarting the application  
- When `tasks.txt` is deleted, the application still launches normally and the file is recreated after a task is added or modified  
- When the file is empty, the application loads without errors and displays default or no tasks  
- When the file contains invalid or malformed data, those lines are ignored and the application continues running without crashing  
- Tasks containing punctuation and special characters were saved and loaded correctly  

---

## Updated Summary

The application continues to meet all functional requirements. The updated file-based storage system works correctly and improves reliability by handling missing, empty, and malformed data without crashing.
