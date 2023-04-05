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
    private Calendar startDate;
    private Calendar endDate;
    private Stage[] stages;
    private Stage currentStage;
    public static final int SIZE_STAGES = 6;
    private int counterStage = 0;

    // Constructores
    public Project(String projectName, Calendar startDateProyect , Calendar endDateProyect , double budget , String clientManagerName , String clientManagerPhone, String managerName, String managerCellPhone ) {
        this.projectName = projectName;
        this.startDateProyect = startDateProyect;
        this.endDateProyect = endDateProyect:
        this.budget = budget;
        manager = new Manager(managerName, managerCellPhone);
        clientManager= new Manager(clientManagerName, clientManagerPhone);
    
    
    stages = new Stage[SIZE_STAGES];
    for (int i = 0; i < SIZE_STAGES; i++) {
        switch (i) {
            case 0:
                stages[i] = new Stage("START", true);
                break;
            case 1:
                stages[i] = new Stage("ANALYSIS", false);
                break;
            case 2:
                stages[i] = new Stage("DESIGN", false);
                break;
            case 3:
                stages[i] = new Stage("EXECUTION", false);
                break;
            case 4:
                stages[i] = new Stage("CLOSE AND FOLLOW-UP", false);
                break;
            case 5:
                stages[i] = new Stage("PROJECT CONTROL", false);
                break;
            default:
                break;
        }
    }
    currentStage = stages[counterStage];

    }

    public void addManagers( String clientManagerName , String clientManagerPhone, String managerName, String managerCellPhone  ){

        clientManager.setName(clientManagerName);
        clientManager.setCellphone(clientManagerPhone);
        manager.setName(managerName);
        manager.setCellphone(managerCellPhone);
    }

    // Métodos getters
    public String getProjectName() {
        return projectName;
    }

    public String getClientManagerName() {
        return clientManagerName;
    }

    public String getClientManagerPhone() {
        return clientManagerPhone;
    }

    public Manager getManagerName() {
        return managerName;
    }

    public Manager getManagerCellPhone(){
        return managerCellPhone;
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

    public Stage[] getStages() {
        return stages[stage];
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    // Métodos setters
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    // Otros métodos
    public boolean setCurrentStage() {
        counterStage++;
        boolean statusCurrentStage = false;
        Calendar date = Calendar.getInstance();
        currentStage.setRealEndDate(date);
        currentStage.setIsActive(statusCurrentStage);
        boolean newStage = true;
        try {
            currentStage = stages[counterStage];
            currentStage.setRealStartDate(date);
            currentStage.setIsActive(newStage);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getStageMonths(int i ){
        return stageMonths[i];
    }

    public void setStageMonths(int[] stageMonths ){
        this.stageMonths= stageMonths;
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

    public void setManagerName(String managerName){
        this.managerName= managerName;
    }

    public void setManagerCellphone (String managerCellPhone){
        this.managerCellPhone = managerCellPhone;
    }

    public void setClientManagerName(String clientManagerName){
        this.clientManagerName= clientManagerName;
    }

    public void setClientManagerPhone(String clientManagerPhone){
        this.clientManagerPhone = clientManagerPhone;
    }
   
}


    
