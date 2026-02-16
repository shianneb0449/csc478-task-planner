# Project Plan  
CSC 478 Personal Task Planner  

## 1. Overview

This document outlines the structured development plan for the Personal Task Planner project. The plan is aligned directly with the four official project deliverables:

1. Deliverable #1 – Project Plan  
2. Deliverable #2 – Programmer’s Manual  
3. Deliverable #3 – User Documentation  
4. Deliverable #4 – Final Product
   
---

# PHASE 1 – DELIVERABLE #1: PROJECT PLAN  
**Target Completion: Feb 22**

This phase establishes the formal planning foundation required by our rubric.

## Planning Components
- Gantt Chart
- Weekly Status Report template
- Repository setup and workflow policy
- Organization Chart
- Tools and Standards
- Configuration Management Plan
- Scope Statement

Deliverable #1 will be fully completed before major implementation begins.

---

# PHASE 2 – DELIVERABLE #2 (PART 1): REQUIREMENTS  
**Feb 16 – Mar 1**

This phase establishes complete and traceable requirements documentation.

## Requirements Documentation
- Introduction
- Product Perspective
- Product Functions
- User Characteristics
- Constraints
- Assumptions and Dependencies

## Specific Requirements
Each requirement will be assigned a unique identifier 

### Core Functional Requirements
- Add Task
- Edit Task
- Delete Task
- Mark Task Complete
- View Task List

### Validation Requirements
- Title cannot be blank
- Due date must be valid

### Non-Functional Requirements
- Must run on Windows 10
- Standalone desktop application
- No network dependencies

## Use Cases
- UC-1: Add Task
- UC-2: Edit Task
- UC-3: Delete Task
- UC-4: Mark Complete
- UC-5: View Task List

## Acceptance Criteria
Acceptance criteria will be defined for each requirement.

By Mar 1, the Requirements section of the Programmer’s Manual will be complete.

---

# PHASE 3 – DELIVERABLE #2 (PART 2): DESIGN DOCUMENTATION  
**Mar 2 – Mar 15**

This phase documents how requirements will be implemented.

## Architecture Design
- UI Layer (JavaFX Controllers)
- Service Layer (TaskService)
- Persistence Layer (TaskRepository / FileStorage)

## Architecture Diagram
A formal architecture diagram will be created and stored in:

## Detailed Design
- Class list and responsibilities
- UML-style class diagram
- Pseudocode for key methods
- Data flow documentation
- Error handling strategy

Each design component will reference the requirement IDs it satisfies to ensure traceability.

By Mar 15, Design Documentation will be complete.

---

# PHASE 4 – INCREMENTAL DEVELOPMENT  
**Mar 9 – Mar 29**

Development will proceed in three versions.

---

## Version 1 – Core CRUD (In-Memory)
**Mar 9 – Mar 15**
- Java project structure
- JavaFX main window
- Task table
- Add/Edit/Delete (in memory only)
- Basic logging

---

## Version 2 – Persistence & Validation
**Mar 16 – Mar 22**
- JSON file storage
- Save on change
- Load on startup
- UUID generation
- Field validation

---

## Version 3 – Full Feature Completion
**Mar 23 – Mar 29**
- Mark Complete
- Edge case handling
- Error messages
- Unit tests
- Reliability improvements

Traceability will be maintained by referencing requirement IDs in source code comments.

---

# PHASE 5 – TESTING DOCUMENTATION  
**Mar 30 – Apr 5**

This phase completes the Test Plan portion of Deliverable #2.

## Test Plan
- Black box test cases
- White box test cases
- Traceability to requirements
- Inputs
- Expected outputs
- Rationale
- Pass/Fail status

## Additional Documentation
- Regression testing results
- Known bugs and issues list
- test-results.md

By Apr 5, Testing Documentation will be complete.

---

# PHASE 6 – DELIVERABLE #3: USER DOCUMENTATION  
**Apr 6 – Apr 12**

This phase produces documentation for end users.

## User Manual
- Application overview
- Feature instructions
- Screenshots
- Troubleshooting section

## Installation Instructions
- System requirements
- Installation steps
- Known installation issues

---

# PHASE 7 – DELIVERABLE #4: FINAL PRODUCT  
**Apr 13 – Apr 20**

This phase finalizes the executable and submission materials.

## Finalization Tasks
- Code cleanup
- Complete commenting
- Verify requirement traceability
- Final regression testing
- Tag GitHub release (v1.0)

## Packaging
- Create executable package
- Ensure installation works on a clean Windows machine
- Zip final submission

Final verification checklist will confirm:
- Meets scope statement
- All requirements implemented
- All documentation complete

---

# Incremental Development Strategy

The project will prioritize:

1. Working functionality early
2. Documented design before coding
3. Continuous traceability
4. Thorough testing before release
