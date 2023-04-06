package ui;



import model.ControllerPro;
import java.util.Scanner;
import java.util.Calendar;

public class Main {

    private Scanner reader;
    private ControllerPro controller;
    public static final int SIZE_MONTHS = 10;

    public Main() {
        reader = new Scanner(System.in);
        controller = new ControllerPro();
    }

    public static void main(String[] args) {
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
                    System.out.println("Not implemented yet.");
                    break;
                case 3:
                    System.out.println("Not implemented yet:");
                    break;
                case 4:
                    System.out.println("Not implemented yet.");
                    break;
                case 5:
                    System.out.println("Not implemented yet.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("0. Exit");
        System.out.println("1. Create project");
        System.out.println("2. Complete project stage");
        System.out.println("3. Register capsule");
        System.out.println("4. Approve capsule");
        System.out.println("5. Publish capsule");
    }

    public void createProject() {
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
        projectName = reader.nextLine();

        System.out.println("Type the name of the manager:");
        managerName = reader.nextLine();

        System.out.println("Type the cellphone of the manager:");
        managerCellPhone = reader.nextLine();

        System.out.println("Type the manager client name:");
        clientManagerName = reader.nextLine();

        System.out.println("Type the manager client phone:");
        clientManagerPhone = reader.nextLine();

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
        System.out.println("The stage " + controller.getProject(controller.getCreatedProyects()).getCounterStages()+ "were created successfully");

    }

 
 
    public void completeProjectStage() {
       
    }
    


/
    public void registerCapsule() {

        String situationDescription;
        int capsuleType;
        String authorName;
        String authorPosition;
        String lessonLearned;
        int consultProjet;

        System.out.println("Type the numbreof the proyect");

        consultProjet=reader.nextInt();

        System.out.println("Enter the type of the capsule , there are 4 types os capsules (1.tecnic , 2.management , 3.dominion , 4. experience)");
         
        capsuleType= reader.nextInt();

        System.out.println("Type the author name of the capsule");

        authorName = reader.next();

        System.out.println("Type the status on the industry ");
        authorPosition= reader.nextLine();
       
    }
 
    public void approveCapsule() {
      
    }

    public void publishCapsule() {

 }
*/

}


