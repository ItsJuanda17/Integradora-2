/**

This class represents the ControllerPro that manages the creation and retrieval of projects.
*/
package model;

import model.ControllerPro;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.text.ParseException;

public class ControllerPro {
    public static final int SIZE_PROJECTS = 10;
    private Project[] projects;
    private int counterDates;
    private int createdProjects;
    private int monthsQuantity;
/**
 * This constructor initializes a new instance of the ControllerPro class and initializes its projects array with size SIZE_PROJECTS.
 */
    public ControllerPro() {
        projects = new Project[SIZE_PROJECTS];
        createdProjects = 0;
        counterDates=0;
        initProjects();
    }
/**
 * This method creates a new project and adds it to the projects array.
 * @param projectName the name of the project to be created
 * @param clientManagerName the name of the client manager for the project
 * @param clientManagerPhone the phone number of the client manager for the project
 * @param budget the budget for the project
 * @param managerName the name of the manager for the project
 * @param managerCellPhone the phone number of the manager for the project
 * @param startDate the start date of the project
 * @param endDate the end date of the project
 * @param monthsStage an array of integers representing the duration of each stage in months
 */
    public void createProject(String projectName, Calendar startDate , Calendar endDate , double budget , String clientManagerName , String clientManagerPhone, String managerName, String managerCellPhone, int [] monthsStage ) {
        if (createdProjects < SIZE_PROJECTS) {
            Calendar calendarDate = Calendar.getInstance();
            calendarDate.setTime(startDate.getTime());
            calendarDate.add(Calendar.MONTH, monthsStage[counterDates]);
            counterDates++;

            Project newProject = new Project(projectName, startDate, endDate, budget, clientManagerName, clientManagerPhone, managerName , managerCellPhone, monthsStage );
            newProject.setStartDate(startDate);
            newProject.setEndDate(endDate);
            newProject.setNameProject(projectName);
            newProject.setMonthsStage(monthsStage);
            newProject.addManagers(clientManagerName, clientManagerPhone, managerName, managerCellPhone);
            newProject.addStage(startDate, calendarDate);
            projects[createdProjects] = newProject;
            createdProjects++;
        }
    }
/**
 * 
 * 
 * This method initializes the projects array with empty Project objects.
 */
    public void initProjects(){
        for (int i = 0; i < SIZE_PROJECTS; i++) {
            projects[i] = new Project(null, null, null, 0, null, null, null, null, null);;
        }
    }


/**
 * This method retrieves a project from the projects array.
 * @param project the index of the project to retrieve
 * @return the Project object at the specified index in the projects array
 */
    public Project getProject(int project) {
        return projects[project];
    }


    
/**
 * This method converts a string representation of a date in the format "dd-MM-yyyy" to a Calendar object.
 * @param date a string representation of the date to convert
 * @return the converted Calendar object
 */

    public Calendar dateCalendar(String date) throws ParseException{
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Calendar calendar = GregorianCalendar.from(zonedDateTime);
        return calendar;
    }


/**
 * Returns a String with information about the project at the specified index.
 * @param index the index of the project to retrieve information about
 * @return a String with information about the project
 */
    public String consultInformationProject(int index) {
        String msg = "The project " + projects[index].getProjectName()  + ", has a budget of: " +
                String.valueOf(projects[index].getBudget()) + "\n";
        msg += "starts on the date: " + projects[index].getStartDate().getTime() + " and ends on the date: " +
                projects[index].getEndDate().getTime();
        return msg;
    }
/**
 * Calculates the end date of a project stage and adds it to the project.
 * @param project the index of the project to add the stage to
 * @param startStage the start date of the stage
 * @return the end date of the stage
 */
    public Calendar finishStage(int project, Calendar startStage ){
        Calendar endStage = Calendar.getInstance();
        endStage.setTime(startStage.getTime());
        endStage.add(Calendar.MONTH, projects[project].getMonthsStage(counterDates));
        counterDates++;
        projects[project].addStage(startStage, endStage);
        return endStage;
    }


/**
 * Adds a capsule of stage to the project at the specified index.
 * @param capsuleType the type of capsule
 * @param authorName the name of the author of the capsule
 * @param authorPosition the position of the author of the capsule
 * @param lessonLearned the lesson learned during the stage
 * @param situationDescription the description of the situation during the stage
 * @param findProject the index of the project to add the capsule to
 */
    public void capsuleConsult(String situationDescription, int capsuleType , String authorName, String authorPosition, String lessonLearned, int findProject) {
        projects[findProject].createCapsuleOfStage(situationDescription, capsuleType, authorName, authorPosition, lessonLearned);
    }

    public int getCreatedProyects(){
        return createdProjects -1;
    }
}
