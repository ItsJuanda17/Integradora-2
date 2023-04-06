
package model;

import java.util.Calendar;

/**
 * The Project class represents a project with its attributes, including the project name, 
 * start date, end date, budget, client manager, manager, and stages.
 */

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
   /**
 * The number of stages in a project. A project has 6 stages: 
 * 1. Initiation
 * 2. Analysis
 * 3. Execution
 * 4. Closure
 * 5. Monitoring
 * 6. Control.
 */
    public static final int SIZE_STAGES = 6;
    

   /**
     * Constructs a Project object with the given parameters.
     *
     * @param projectName the name of the project.
     * @param startDate the start date of the project.
     * @param endDate the end date of the project.
     * @param budget the budget of the project.
     * @param clientManagerName the name of the client manager of the project.
     * @param clientManagerPhone the phone number of the client manager of the project.
     * @param managerName the name of the manager of the project.
     * @param managerCellPhone the phone number of the manager of the project.
     * @param monthsStage an array of months for each stage of the project.
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
    
     
    /**
     * Sets the client manager and manager of the project to the given parameters.
     *
     * @param clientManagerName the name of the client manager of the project.
     * @param clientManagerPhone the phone number of the client manager of the project.
     * @param managerName the name of the manager of the project.
     * @param managerCellPhone the phone number of the manager of the project.
     */
    public void addManagers( String clientManagerName , String clientManagerPhone, String managerName, String managerCellPhone  ){

        clientManager.setManagerName(clientManagerName);
        clientManager.setManagerCellphone(clientManagerPhone);
        manager.setManagerName(managerName);
        manager.setManagerCellphone(managerCellPhone);
    }

     /**
     * Initializes the stages array with Stage objects.
     */

    public void initStage(){
        for (int i = 0; i < stages.length; i ++){
            stages[i] = new Stage(null , null );
        }
    }

    /**
     * Adds a new stage to the stages array with the given start and end dates.
     *
     * @param realStartDate the start date of the stage.
     * @param realEndDate the end date of the stage.
     */

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
    /**
 * Returns the name of the project.
 *
 * @return the name of the project
 */
    public String getProjectName() {
        return projectName;
    }


    /**
 * Returns the budget allocated for the project.
 *
 * @return the budget allocated for the project
 */
    
    public double getBudget() {
        return budget;
    }


/**
 * Returns the start date of the project.
 *
 * @return the start date of the project
 */

    public Calendar getStartDate() {
        return startDate;
         
    }


/**
 * Returns the end date of the project.
 *
 * @return the end date of the project
 */
    public Calendar getEndDate() {
        return endDate;
    }


/**
 * Returns the stage at the specified index.
 *
 * @param stage the index of the stage to return
 * @return the stage at the specified index
 */
    public Stage getStages(int stage) {
        return stages[stage];
    }


/**
 * Returns the number of stages in the project.
 *
 * @return the number of stages in the project
 */
    public int getCounterStages() {
        return counterStages -1;
    }

    // setters

    /**
 * Sets the start date of the project.
 *
 * @param startDate the new start date of the project
 */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }


/**
 * Sets the end date of the project.
 *
 * @param endDate the new end date of the project
 */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    // Others methods
    
/**
 * Creates a capsule for the current stage with the specified details.
 *
 * @param situationDescription a description of the situation
 * @param capsuleType the type of capsule
 * @param authorName the name of the author
 * @param authorPosition the position of the author
 * @param lessonLearned a lesson learned from the situation
 */
    public void createCapsuleOfStage(String situationDescription, int capsuleType , String authorName, String authorPosition, String lessonLearned){

        stages[counterStages-1].addCapsule(situationDescription, capsuleType, authorName, authorPosition, lessonLearned );
    }
    
/**
 * Returns the number of months for the stage at the specified index.
 *
 * @param i the index of the stage
 * @return the number of months for the stage at the specified index
 */
    public int getMonthsStage(int i ){
        return monthsStage[i];
    }


/**
 * Sets the number of months for each stage.
 *
 * @param monthsStage the array of months for each stage
 */
    public void setMonthsStage(int[] monthsStage ){
        this.monthsStage= monthsStage;
    }


/**
 * Sets the name of the project.
 *
 * @param nameProject the new name of the project
 */
    public void setNameProject(String nameProject){
        this.projectName = projectName;
    }


/**
 * Sets the budget allocated for the project.
 *
 * @param budget the new budget allocated for the project
 */
     public void setBudget(double budget) {
        this.budget = budget;
    }


/**
 * Returns the manager of the project.
 *
 * @return the manager of the project
 */
    public Manager getManager(){
        return manager;
    }


/**
 * Returns the client manager of the project.
 *
 * @return the client manager of the project
 */
    public Manager getClientManager(){
        return clientManager;
    }

 
   
}


    
