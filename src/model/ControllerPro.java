import java.util.Calendar;
package model;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.time.format.DateTimeParseException;



public class Controller {
    public static final int SIZE_PROJECTS = 10;
    private Project[] projects;
    private int counter;
    private int createdProjects;
    private int monthsQuantity;

    public ControllerPro() {
        projects = new Project[SIZE_PROJECTS];
        counter = 0;
        createdProjects = 0;
        counterDates=0;
        initProjects();
    }

    public void createProject(String projectName, String clientManagerName, String clientManagerPhone, double budget,
                           String managerName, String managerCellPhone, Calendar startDateProyect, Calendar endDateProyect,    
                           int[] stageMonths) {
        if (createdProjects < SIZE_PROJECTS) {
            Calendar calendarDate = Calendar.getInstance();
            calendarDate.setTime(startDateProyect.getTime());
            calendarDate.add(Calendar.MONTH, stageMonths[counterDates]);
            counterDates++;


            Project newProject = new Project(projectName, clientManagerName, clientManagerPhone, budget, managerName, managerCellPhone, startDateProyect, endDateProyect, stageMonths);
            newProject.setStartDate(startDateProject);
            newProject.setEndDate(endDateProject);
            newProject.setNameProject(projectName)
            newProject.setStageMonths(stageMonths);
            newProject.addManagers(clientManagerName,clientManagerPhone,managerName,managerCellPhone);
            newProject.addStage(startDateProject, calendarDate);
            projects[createdProjects] = newProject;
            createdProjects++;
        }
    }

    public void initProjects(){
        for (int i = 0; i < SIZE_PROYECTS; i++) {
        projects[i] = new Project(null, null, null, 0, null, null, null, null, null);;
      }
    }
    

    public Project getProject(int project) {
        return projects[project];
    }

    public Calendar dateCalendar(String date) {
    LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
    Calendar calendar = GregorianCalendar.from(zonedDateTime);
    return calendar;
}


    public String consultInformationProject(int index) {
        String msg = "The proyect " + projects[index].getProjectName() + " with the client: " +
                projects[index].getClientName() + ", has a budget of  : " +
                String.valueOf(projects[index].getBudget()) + "\n";
        msg += "starts on the date: " + projects[index].getStartDate().getTime() + " and ends on the date: " +
                projects[index].getEndDate().getTime();
        return msg;
    }

    public Calendar finishStage(int project, Calendar startStage ){
        
      Calendar endStage = Calendar.getInstance();
        endStage.setTime( startStage.getTime());
        endStage.add(Calendar.MONTH, projects[project].getMonthsStage(counterDates));
        auxCalendar++;
        
        projects[project].addStage(startStage, endStage);
        
        return endStage;

    }

    public void capsuleConsult(int capsuleType , String authorName , String authorPosition, String lessonLearned, String situationDescription, int findProject  ){

        projects[findProject].capsule_Of_Stage(capsuleType, authorName, authorPosition, lessonLearned, situationDescription);
    }

}  
   
