package ui;

import model.ControllerPro;
import java.util.Scanner;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * The Main class provides the main menu for the user interface of the program.
 */
public class Main {

    private Scanner reader;
    private ControllerPro controller;
   
   /**
 * The number of months in a project duration.
 */
    public static final int SIZE_MONTHS = 7;


/**
     * Constructs a Main object with a new Scanner for user input and a new ControllerPro object for managing program data.
     */
    public Main() {
        reader = new Scanner(System.in);
        controller = new ControllerPro();
    }

/**
     * The main method of the program. Creates a new Main object and presents the main menu to the user.
     *
     * @param args Command line arguments (unused)
     * @throws ParseException if an error occurs while parsing user input
     */
    public static void main(String[] args)throws ParseException {
        Main view = new Main();
        int option = 0;

        do {
            view.menu();
            option = view.reader.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Thanks for using this system.");
                    break;
                case 1:
                    view.createProject();
                    break;
                case 2:
                    view.completeProjectStage();
                    break;
                case 3:
                    view.registerCapsule();
                    break;
                case 4:
                    view.approveCapsule();
                    break;
                case 5:
                    view.publishCapsule();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (option != 0);
    }


 /**
     * Displays the main menu to the user.
     *
     * @throws ParseException if an error occurs while parsing user input
     */
    public void menu() throws ParseException {
        System.out.println("0. Exit");
        System.out.println("1. Create project");
        System.out.println("2. Complete project stage");
        System.out.println("3. Register capsule");
        System.out.println("4. Approve capsule");
        System.out.println("5. Publish capsule");
    }


/**
 * Allows the user to create a new project with the following parameters: projectName, startDate, endDate,
 * budget, clientManagerName, clientManagerPhone, managerName, managerCellPhone, and monthsStage.
 * 
 * @throws ParseException if there is an error in the date format
 */
    public void createProject() throws ParseException {
        String projectName;
        Calendar startDate;
        Calendar endDate;
        String flagDate;
        double budget;
        String clientManagerName;
        String clientManagerPhone;
        String managerName;
        String managerCellPhone;
        int[] monthsStage ;


        System.out.println("Type the name of the project:");
        projectName = reader.next();

        System.out.println("Type the name of the manager:");
        reader.nextLine();
        managerName = reader.nextLine();

        System.out.println("Type the cellphone of the manager:");
        managerCellPhone = reader.next();

        System.out.println("Type the manager client name:");
        clientManagerName = reader.next();

        System.out.println("Type the manager client phone:");
        clientManagerPhone = reader.next();

        System.out.println("Type the budget of the project:");
        budget = reader.nextDouble();
        reader.nextLine();

        System.out.println("Type the date to start the project (yyyy-mm-dd):");
        flagDate = reader.nextLine();
        startDate = controller.dateCalendar(flagDate);

        System.out.println("Type the date to end the project (yyyy-mm-dd):");
        flagDate = reader.nextLine();
        endDate = controller.dateCalendar(flagDate);

        monthsStage = new int[SIZE_MONTHS];

        System.out.println("Select the months of the stages: (1.init , 2. analysis , 3.execute , 4. closure , 5.monitoring , 6.control)");
        for (int i = 0; i < 6; i++) {
            System.out.println("months for the "+(i)+ " stage.");
            monthsStage[i] = reader.nextInt();
        }


        controller.createProject(projectName, startDate, endDate, budget, clientManagerName, clientManagerPhone, managerName , managerCellPhone, monthsStage);
        System.out.println("The proyect has been successfully created ");
        System.out.println("The stage " + controller.getProject(controller.getCreatedProyects()).getCounterStages() + " swere created successfully");

    }

 
 /**
 * Allows the user to complete a project stage with the following parameters: projectN and stageReal.
 * 
 * @throws ParseException if there is an error in the date format
 */
    public void completeProjectStage() throws ParseException {
   
    
    System.out.println("Type the number of the proyect : ");
    int projectN = reader.nextInt();
    
    System.out.println("Type the real date on wich the new stage begins , in format date (dd-MM-yyyy)"); 
    String startStageN = reader.next();
    Calendar stageReal = null;
    try {
        stageReal = controller.dateCalendar(startStageN);
    } catch (ParseException e) {
        System.out.println("Invalid date format. Please enter the date in the format dd-MM-yyyy");
        return; // Terminates the method prematurely
    }

    Calendar aux = controller.finishStage(projectN, stageReal);
    System.out.println("The Stage " + controller.getProject(projectN).getCounterStages() + "has been created.");
    String endStageN = new SimpleDateFormat("dd-MM-yyyy").format(aux.getTime());
    System.out.println("the stage will end in " + endStageN );
}


/**

This method registers a capsule for a project with the given information.
*/

    public void registerCapsule() {

        System.out.println("Type the name of the author capsule");
        String authorName= reader.nextLine();
        System.out.println("Type the status of the autor");
        String authorPosition= reader.nextLine();
        System.out.println("Select the type of the capsule (0. tecnic , 1. management , 2. domain . 3. experiences)");
        int capsuleType=reader.nextInt();
        System.out.println("type the number of the project");
        int findProject = reader.nextInt();

        String lessonLearned= "";
        String situationDescription= "";

        do{
            
        System.out.println("write the lesson learned (Ejemplo #Pruebas Funcionales#)");
         lessonLearned=reader.nextLine();
        }while(!lessonLearned.matches("(?<=#)(\\w+)(?=#)"));

        do {
            System.out.println("write the situation description (Ejemplo #Pruebas Funcionales#) ");
         situationDescription = reader.nextLine();
        } while (!situationDescription.matches("(?<=#)(\\w+)(?=#)"));

        controller.capsuleConsult(situationDescription, capsuleType, authorName , authorPosition, lessonLearned, findProject);
        System.out.println("The capsule in " + controller.getProject(findProject).getStages(controller.getProject(findProject).getCounterStages()).getCounterCapsule() + "in the project" +controller.getCreatedProyects()+ "in the stage" + controller.getProject(findProject).getCounterStages() + "has been created"   );

    }

/**
 * Approves a capsule for a specific project and stage.
 * Prompts the user for the project number, capsule number, and stage number.
 * Sets the approved flag of the capsule to true.
 */
    public void approveCapsule() {

        System.out.println("Type the number of the proyect that you want to search: ");
        int searchProyect = reader.nextInt();
        
        
        System.out.println("Type the id of the capsule: ");
        int capsuleNumber= reader.nextInt();

        System.out.println("Select the stage: (1.init , 2. analysis , 3.execute , 4. closure , 5.monitoring , 6.control) ");
        int stage = reader.nextInt();

        controller.getProject(searchProyect).getStages(stage).getCapsules(capsuleNumber).setApproved(true);
        System.out.println("The capsule has been approved");

        
      
    }

/**
 * Publishes a capsule of a specific project and stage, and sets its status to published.
 * Also generates a URL for the published capsule.
 * 
 */
    public void publishCapsule() {

        System.out.println("Type the capsule id: ");
        int capsuleId = reader.nextInt();

        System.out.println("Type the number of the proyect: ");
        int findProject = reader.nextInt();

        System.out.println("Select the stage: 1.init , 2. analysis , 3.execute , 4. closure , 5.monitoring , 6.control");
        int stage= reader.nextInt();

        controller.getProject(findProject).getStages(stage).getCapsules(capsuleId).isApproved();
        System.out.println("the capsule is going to be published , wait for the URL");
        String urlBase= "https://www.example.com/capsulas-de-conocimiento" + controller.getProject(findProject).getStages(stage).getCapsules(capsuleId).getUrl();
        System.out.println("HTML CONVERTED: "+ urlBase);
        controller.getProject(findProject).getStages(stage).getCapsules(capsuleId).setPublished(true);

    }

    public void projectWithMaxCapsules() {
        int maxCapsules = 0;
        String projectName = "";
        for (int i = 0; i < 10; i++) {
            int projectCapsules = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 50; k++) {
                    if (controller.getProject(i).getStages(j).getCapsules(k).getCapsuleType() != -1) {
                        projectCapsules++;
                    }
                }
            }
            if (projectCapsules > maxCapsules) {
                maxCapsules = projectCapsules;
                projectName = controller.getProject(i).getProjectName();
            }
        }
        System.out.println("The project " + projectName + " has the greatest number of capsules with " + maxCapsules + " capsules.");
    }


}


