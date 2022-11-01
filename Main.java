import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //load projects by default from thr file
        ProjectManager.loadProjectsFormFile();
        //open the menu of the app
        menu();
    }

    private static void menu(){
        Scanner inputScanner = new Scanner(System.in);
        //Menu for user to select an option from capturing to update line 14 - 23
        //It loops until the user press -1 to exit
        try{
            while (true) {

                System.out.println("Please select one of the options below" +
                        " \n1 To capture a new project " +
                        "\n2 Update project due date" +
                        "\n3 Update Total amount fee paid" +
                        "\n4 Update a contractor's contact details" +
                        "\n5 List summary of all projects" +
                        "\n6 List of projects that still need to be completed" +
                        "\n7 List of projects that are past the due date" +
                        "\n8 Find a project by project name or number" +
                        "\n9 Finalise the project" +
                        "\n10 Load projects from a file" +
                        "\n-1 to exit\n"
                );
                int selectedOption = Integer.parseInt(inputScanner.nextLine());
                //calling a specific method base on the selection
                if (selectedOption == 1) {
                    ProjectManager.captureProject();
                } else if (selectedOption == 2) {
                    ProjectManager.updateProjectDueDate();
                } else if (selectedOption == 3) {
                    ProjectManager.updateProjectAmountFeePaid();
                } else if (selectedOption == 4) {
                    ProjectManager.updateProjectContractorsContactDetails();
                } else if (selectedOption == 5) {
                    ProjectManager.listAllProjects();
                } else if (selectedOption == -1) {
                    ProjectManager.saveProjectsOnExit();
                    System.out.println("Good bye, thanks for using our project management system\n");
                    break;
                } else if (selectedOption == 6) {
                    ProjectManager.listAllProjectsThatStillNeedToBeCompleted();
                }else if (selectedOption == 7) {
                    ProjectManager.listAllProjectsThatPastDueDate();
                }else if (selectedOption == 8) {
                    ProjectManager.findAProjectByNameOrProjectNumber();
                }else if (selectedOption == 9) {
                    ProjectManager.generateProjectInvoiceAndFinalizeTheProject();
                }else if (selectedOption == 10) {
                    ProjectManager.loadProjectsFormFile();
                }else {
                    System.out.println("Wrong option selected: " + selectedOption);
                }


            }
        } catch (NumberFormatException ex){
            System.out.println("Invalid Option Selected\n");
            menu();//Give the user a chance to re-enter the option. inspired by recursion

        }
    }
}
