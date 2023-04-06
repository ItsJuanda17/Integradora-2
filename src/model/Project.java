/**

The Project class represents a project that has a name, budget, start and end dates, and several stages.
Each project is assigned a Manager and a client manager.
*/


package model;

import java.util.Calendar;

public class Project {
    // Atributos
    private String projectName;
    private Manager manager;
    private Manager clientManager;
    private String clientManagerName;
    private String clientManagerPhone;
    private String managerName;
    private String managerCellPhone;
    private double budget;
    private int counterStages ;
    private Calendar startDate;
    private Calendar endDate;
    private Stage[] stages;
    private int[] monthsStage;
    public static final int SIZE_STAGES = 6;
    


/**
 * Constructs a Project object with the given projectName, startDateProject, endDateProject, budget,
 * clientManagerName, clientManagerPhone, managerName, and managerCellPhone.
 *
 * @param projectName the name of the project
 * @param startDate the start date of the project
 * @param endDateProject the end date of the project
 * @param budget the budget of the project
 * @param clientManagerName the name of the client manager
 * @param clientManagerPhone the phone number of the client manager
 * @param managerName the name of the manager
 * @param managerCellPhone the phone number of the manager
 */
    public Project(String projectName, Calendar startDate , Calendar endDate , double budget , String clientManagerName , String clientManagerPhone, String managerName, String managerCellPhone, int [] monthsStage ) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.monthsStage = monthsStage;
        initStage();
        counterStages=0;
        manager = new Manager(managerName, managerCellPhone);
        clientManager= new Manager(clientManagerName, clientManagerPhone);
        stages = new Stage[SIZE_STAGES];
   

    }

    public void addManagers( String clientManagerName , String clientManagerPhone, String managerName, String managerCellPhone  ){

        clientManager.setManagerName(clientManagerName);
        clientManager.setManagerCellphone(clientManagerPhone);
        manager.setManagerName(managerName);
        manager.setManagerCellphone(managerCellPhone);
    }

    public void initStage(){
        for (int i = 0; i < stages.length; i ++){
            stages[i] = new Stage(null , null );
        }
    }

    public void addStage(Calendar realStartDate, Calendar realEndDate){

        stages[counterStages].setPlannedStartDate(realStartDate);
        stages[counterStages].setPlannedEndDate(realEndDate);

        if(counterStages == 0){
            stages[counterStages].desactivate(true);
            
        }
        else{ 
            stages[counterStages].desactivate(true);
            stages[counterStages-1].desactivate(false);
           
        }
        counterStages++;

    }

    //  getters
    public String getProjectName() {
        return projectName;
    }


  

    public double getBudget() {
        return budget;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Stage getStages(int stage) {
        return stages[stage];
    }

    public int getCounterStages() {
        return counterStages -1;
    }

    // setters
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    // Others methods
    

    public void createCapsuleOfStage(String situationDescription, int capsuleType , String authorName, String authorPosition, String lessonLearned){

        stages[counterStages-1].addCapsule(situationDescription, capsuleType, authorName, authorPosition, lessonLearned );
    }
    

    public int getMonthsStage(int i ){
        return monthsStage[i];
    }

    public void setMonthsStage(int[] monthsStage ){
        this.monthsStage= monthsStage;
    }

    public void setNameProject(String nameProject){
        this.projectName = projectName;
    }

     public void setBudget(double budget) {
        this.budget = budget;
    }

    public Manager getManager(){
        return manager;
    }

    public Manager getClientManager(){
        return clientManager;
    }

 
   
}


    
