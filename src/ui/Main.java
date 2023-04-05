package ui; 

import model.ControllerPro;
import java.util.Scanner;

import java.util.Scanner;

//Constructor de la clase 

public class Main{

    private Scanner reader;
    private Controller Controller;

    public Main(){
        this.reader = new Scanner(System.in);
        this.controller = new ControllerPro();

        
    }
    public static void main(String[] args){

        Main vew = new Main();

        int option=0;

        do{
			view.menu();
			option = view.reader.nextInt();
			switch (option) {
				case 0:
					System.out.println("Thanks for using this system.");
					break;

                case 1:
                    view.RegisterProject();
                    break;

				case 2:
					view.consultProject();
					break;

				case 3:
					view.addManagers();
					break;

				case 4:
					view.registerStages();
					break;
				
				case 5:
					view.finishStage();
					break;

				case 6:
					view.createCapsule();
					break;

				case 7:
					view.acceptCapsule();
					break;

				default:
					System.out.println("No valido");
					break;
			}
		}while(option!=0);
	}

    public void menu(){
        System.out.println("0. Exit");
        System.out.println("1. Create proyect");
		System.out.println("2. Complete the stage of a project ");
		System.out.println("3. Register Capsule");
        Sysstem.out.println("4. Approve Capsule");
		System.out.println("5. Publish Capsule");
		;
    }

}



   

