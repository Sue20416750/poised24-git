import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProjectManager {

    private static List<Project> projects = new ArrayList<Project>();
    //Method to get project details from the user and add them to the list of projects
    public static void captureProject(){
        Scanner inputScanner = new Scanner(System.in);
        Project project = new Project();
        Architect architect = new Architect();
        Contractor contractor = new Contractor();
        Customer customer = new Customer();

        try{
            System.out.println("Capture project details");
            System.out.println("Please enter project number: ");
            project.setProjectNumber(inputScanner.nextLine());
            System.out.println("Please enter project name: ");
            project.setProjectName(inputScanner.nextLine());
            System.out.println("Please enter building type: ");
            project.setBuildingType(inputScanner.nextLine());
            System.out.println("Please enter physical address of the project: ");
            project.setPhysicalAddress(inputScanner.nextLine());
            System.out.println("Please enter project erf number: ");
            project.setErfNumber(Integer.parseInt(inputScanner.nextLine()));
            System.out.println("Please enter project total fees charged: ");
            project.setTotalFeeCharged(Float.parseFloat(inputScanner.nextLine()));
            System.out.println("Please enter project total amount paid: ");
            project.setTotalAmountPaid(Float.parseFloat(inputScanner.nextLine()));
            System.out.println("Please enter project deadline, format (dd/mm/yyyy): ");
            project.setDeadline(inputScanner.nextLine());

            System.out.println("\nCapture architect details");
            System.out.println("Please enter architect name: ");
            architect.setName(inputScanner.nextLine());
            System.out.println("Please enter architect physical address: ");
            architect.setPhysicalAddress(inputScanner.nextLine());
            System.out.println("Please enter architect email address: ");
            architect.setEmailAddress(inputScanner.nextLine());
            System.out.println("Please enter architect telephone number: ");
            architect.setTelephoneNumber(inputScanner.nextLine());

            System.out.println("\nCapture contractor details");
            System.out.println("Please enter contractor name: ");
            contractor.setName(inputScanner.nextLine());
            System.out.println("Please enter contractor physical address: ");
            contractor.setPhysicalAddress(inputScanner.nextLine());
            System.out.println("Please enter contractor email address: ");
            contractor.setEmailAddress(inputScanner.nextLine());
            System.out.println("Please enter contractor telephone number: ");
            contractor.setTelephoneNumber(inputScanner.nextLine());

            System.out.println("\nCapture customer details");
            System.out.println("Please enter customer name: ");
            customer.setName(inputScanner.nextLine());
            System.out.println("Please enter customer physical address: ");
            customer.setPhysicalAddress(inputScanner.nextLine());
            System.out.println("Please enter customer email address: ");
            customer.setEmailAddress(inputScanner.nextLine());
            System.out.println("Please enter customer telephone number: ");
            customer.setTelephoneNumber(inputScanner.nextLine());
            project.setArchitect(architect);
            project.setContractor(contractor);
            project.setCustomer(customer);
        }catch(NumberFormatException ex){
            System.out.println("Can not convert given input to number");
        }

        saveProject(project);
    }

    //Add a project object to a list and display projects from the list
    private static void saveProject(Project project) {
        if (project != null) {
            if (project.getProjectName() == "" || project.getProjectName() == null) {
                project.setProjectName(project.getCustomer().getName());
            }
            projects.add(project);
        }

        System.out.println("\n============= Project Captured =============\n");
        System.out.println(project);
        System.out.println("\n============================================\n");

    }

    //Method to update project due date
    public static void updateProjectDueDate() {
        try {
            displayProjects();

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Please enter project number");
            String projectNumber = inputScanner.nextLine();
            System.out.println("Please enter due date format:dd/MM/yyyy");
            String dueDate = inputScanner.next();
            var isProjectFound = false;
            for(Project project : projects){
                if (project.getProjectNumber().equals(projectNumber)) {
                    isProjectFound = true;
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    project.setDeadline(dueDate);
                    System.out.println("\n"+ project);
                }
            }
            if(!isProjectFound){
                System.out.println("No project found with this project number: "+ projectNumber + "\n");
            }
        }catch (NumberFormatException ex){
            System.out.println("Invalid project number");
        }
    }

    //Method to update amount fee paid
    public static void updateProjectAmountFeePaid() {
        displayProjects();

        Scanner inputScanner = new Scanner(System.in);
        try{
            System.out.println("Please enter project number");
            String projectNumber = inputScanner.nextLine();
            System.out.println("Please enter amount paid");
            float amountPaid = (Float.parseFloat(inputScanner.nextLine()));
            Project projectToBeUpdated = null;
            for (Project project: projects){
                if (project.getProjectNumber().equals(projectNumber)) {
                    project.setTotalAmountPaid(amountPaid);
                    if (project.getTotalFeeCharged() - project.getTotalAmountPaid() <= 0) {
                        project.setStatus("finalised");
                        project.setCompletionDate(String.valueOf(java.time.LocalDate.now()));
                    }
                    projectToBeUpdated  = project;
                    System.out.println("\n"+ project);
                    break;
                }
            }

            if (projectToBeUpdated == null) {
                System.out.println("No project found with this project number: "+ projectNumber + "\n");
            }
        }catch (NumberFormatException ex){
            System.out.println("Invalid amount");
        }

    }

    //Method to update amount fee paid
    public static void findAProjectByNameOrProjectNumber() {
        displayProjects();

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter project number/name");
        String projectNumberOrName = inputScanner.nextLine();
        Project projectToBeUpdated = null;
        for (Project project: projects){
            if (project.getProjectNumber().equals(projectNumberOrName)
                    || project.getProjectName().toLowerCase(Locale.ROOT).equals(projectNumberOrName.toLowerCase())) {
                projectToBeUpdated = project;
                System.out.println(project + "\n");
                break;
            }
        }

        if (projectToBeUpdated == null) {
            System.out.println("No project found with this project number/name: "+ projectNumberOrName + "\n");
        }

    }

    //Method to update project contractor's contact details
    public static void updateProjectContractorsContactDetails() {
        try {
            displayProjects();

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Please enter project number");
            String projectNumber = inputScanner.nextLine();
            System.out.println("Please enter contractor's email");
            String email = inputScanner.nextLine();
            System.out.println("Please enter contractor's telephone number");
            String telephoneNumber = inputScanner.nextLine();
            boolean isProjectFound = false;
            for(Project project: projects){
                if (project.getProjectNumber().equals(projectNumber)) {
                    isProjectFound = true;
                    project.getContractor().setEmailAddress(email);
                    project.getContractor().setTelephoneNumber(telephoneNumber);
                    System.out.println("\n"+ project);
                    break;
                }
            }
            if(!isProjectFound){
                System.out.println("No project found with this project number: "+ projectNumber + "\n");
            }
        }catch(NumberFormatException ex){
            System.out.println("Invalid project number");
        }
    }

    //List projects summary on the projects list.
    public static void listAllProjects() {
        if (projects.size() == 0) {
            System.out.println("No project yet, please capture a project using option 1");
        }else{
            displayProjects();
        }

    }

    //method to list all projects that still need to be completed
    public static void listAllProjectsThatStillNeedToBeCompleted() {
        if (projects.size() == 0) {
            System.out.println("No project yet, please capture a project using option 1");
        }else{
            System.out.println("\n================= List of projects =================\n");
            projects.forEach(project -> {
                if ((!project.getStatus().equals("finalised")) && (project.getTotalFeeCharged() - project.getTotalAmountPaid() > 0)) {
                    System.out.println("================= Project =====================");
                    System.out.println(
                            "Project Name: " + project.getProjectName()
                                    + "\nProject Number: "+ project.getProjectNumber()
                                    + "\nDue Date: " + project.getDeadline()
                                    + "\nProject Address: "+ project.getPhysicalAddress()
                                    + "\nAmount paid: " + project.getTotalAmountPaid()
                                    + "\nAmount charged: " + project.getTotalFeeCharged()
                                    + "\nAmount due: " + (project.getTotalFeeCharged() - project.getTotalAmountPaid())
                                    + "\nProject status: " + project.getStatus()
                    );
                    System.out.println("============ End of project ===============\n");
                }
            });
            System.out.println("========= End of the project list =============\n");
        }

    }

    //method to ist of projects that are past the due date.
    public static void listAllProjectsThatPastDueDate() {
        if (projects.size() == 0) {
            System.out.println("No project yet, please capture a project using option 1");
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("\n================= List of projects =================\n");
            projects.forEach(project -> {
                LocalDate dueDate = LocalDate.parse(project.getDeadline(), formatter);
                if (dueDate.isBefore(java.time.LocalDate.now())) {
                    System.out.println("================= Project =====================");
                    System.out.println(
                            "Project Name: " + project.getProjectName()
                                    + "\nProject Number: "+ project.getProjectNumber()
                                    + "\nDue Date: " + project.getDeadline()
                                    + "\nProject Address: "+ project.getPhysicalAddress()
                                    + "\nAmount paid: " + project.getTotalAmountPaid()
                                    + "\nAmount charged: " + project.getTotalFeeCharged()
                                    + "\nAmount due: " + (project.getTotalFeeCharged() - project.getTotalAmountPaid())
                                    + "\nProject status: " + project.getStatus()
                    );
                    System.out.println("============ End of project ===============\n");
                }
            });
            System.out.println("========= End of the project list =============\n");
        }

    }

    //Method to check if project exist to prevent duplicates when we load from the file
    public static boolean checkProjectExists(String projectNumber) {
        for (Project project: projects){
            if (project.getProjectNumber().equals(projectNumber)) {
                return true;
            }
        }
        return false;
    }

    //Generate project invoice for project that is not paid fully
    public static void generateProjectInvoiceAndFinalizeTheProject() {
        try {
            displayProjects();
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Please enter project number");
            String projectNumber = inputScanner.nextLine();
            boolean isProjectFound = false;
            for(Project project: projects){
                if (project.getProjectNumber().equals(projectNumber)) {
                    isProjectFound = true;
                    if (!project.getStatus().equals("finalised")) {
                        String invoiceStatement = "\nInvoice for " + project.getProjectNumber() + ":\n" +
                                project.getCustomer().toString() +
                                "\nOutstanding amount: " + (project.getTotalFeeCharged() - project.getTotalAmountPaid()
                                + "\nProject due date: " + project.getDeadline()
                        );
                        System.out.println(invoiceStatement + "\n");

                        System.out.println("Please enter outstanding amount");
                        float outstandingAmount = (Float.parseFloat(inputScanner.nextLine()));

                        project.setTotalAmountPaid(outstandingAmount + project.getTotalAmountPaid());
                        if (project.getTotalFeeCharged() - project.getTotalAmountPaid() <= 0) {
                            project.setStatus("finalised");
                            project.setCompletionDate(String.valueOf(java.time.LocalDate.now()));

                            System.out.println("project is finalised successfully");
                        }else{
                            System.out.println("project is not finalised, try again to add remaining balance of " + (project.getTotalFeeCharged() - project.getTotalAmountPaid()) + "\n");
                        }
                    }else{
                        saveCompletedProjectToTheFile(project);
                    }
                }
            }
            if(!isProjectFound){
                System.out.println("No project found with this project number: "+ projectNumber + "\n");
            }
        }catch (NumberFormatException ex){
            System.out.println("Invalid project number");
        }
    }

    //method to save completed project to a file
    public static void saveCompletedProjectToTheFile(Project project) {
        try {
            if (project != null) {
                FileWriter myWriter = new FileWriter("completed_project.txt");
                String projectInfo =
                        "Project Name: " + project.getProjectName()
                        + "\nProject Number: "+ project.getProjectNumber()
                        + "\nCustomer Name: "+ project.getCustomer().getName()
                        + "\nCustomer email: "+ project.getCustomer().getEmailAddress()
                        + "\nCustomer contact number: "+ project.getCustomer().getTelephoneNumber()
                        + "\nDue Date: "+ project.getDeadline()
                        + "\nProject Address: "+ project.getPhysicalAddress()
                        + "\nAmount paid: " + project.getTotalAmountPaid()
                        + "\nAmount charged: " + project.getTotalFeeCharged()
                        + "\nCompletion date: " + project.getCompletionDate()
                        + "\nProject status: " + project.getStatus();
                myWriter.write(projectInfo);
                myWriter.close();
                System.out.println("project is finalised and saved to completed_project.txt file\n");
            }else{
                System.out.println("No project found");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //load projects from the file
    public static void loadProjectsFormFile(){
        try {
            File myObj = new File("existing_projects.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] projectDetails = data.split(",");
                if (!checkProjectExists(projectDetails[0])) {
                    addProject(projectDetails);
                }
            }
            System.out.println("projects loaded from existing_projects.txt, select option 5 to view them\n");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //method for to load project from file project details
    public static void addProject(String[] projectDetails){
        Project project = new Project();
        Customer customer = new Customer();
        Contractor contractor = new Contractor();
        Architect architect = new Architect();

        try{
            project.setProjectNumber(projectDetails[0]);
            project.setProjectName(projectDetails[1]);
            project.setBuildingType(projectDetails[2]);
            project.setPhysicalAddress(projectDetails[3]);
            project.setErfNumber(Integer.parseInt(projectDetails[4]));
            project.setTotalFeeCharged(Float.parseFloat(projectDetails[5]));
            project.setTotalAmountPaid(Float.parseFloat(projectDetails[6]));
            project.setDeadline(projectDetails[7]);

            architect.setName(projectDetails[8]);
            architect.setPhysicalAddress(projectDetails[9]);
            architect.setEmailAddress(projectDetails[10]);
            architect.setTelephoneNumber(projectDetails[11]);

            contractor.setName(projectDetails[12]);
            contractor.setPhysicalAddress(projectDetails[13]);
            contractor.setEmailAddress(projectDetails[14]);
            contractor.setTelephoneNumber(projectDetails[15]);

            customer.setName(projectDetails[16]);
            customer.setPhysicalAddress(projectDetails[17]);
            customer.setEmailAddress(projectDetails[18]);
            customer.setTelephoneNumber(projectDetails[19]);

            project.setStatus(projectDetails[20]);
            project.setCompletionDate(projectDetails[21]);

            project.setArchitect(architect);
            project.setContractor(contractor);
            project.setCustomer(customer);

            projects.add(project);
        }catch (NumberFormatException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //method to save projects when exiting the app
    public static void saveProjectsOnExit() {
        try {
            if (projects.size() > 0) {
                FileWriter myWriter = new FileWriter("existing_projects.txt");
                for(Project project : projects){
                    myWriter.write(project.toFile() + "\n");
                }
                myWriter.close();
                System.out.println("projects are updated and saved to existing_projects.txt file\n");
            }else{
                System.out.println("No projects to be updated");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void displayProjects(){
        System.out.println("\n================= List of projects =================\n");
        projects.forEach(project -> {
            System.out.println("================= Project =====================");
            System.out.println(
                    "Project Name: " + project.getProjectName()
                            + "\nProject Number: "+ project.getProjectNumber()
                            + "\nDue Date: " + project.getDeadline()
                            + "\nProject Address: "+ project.getPhysicalAddress()
                            + "\nAmount paid: " + project.getTotalAmountPaid()
                            + "\nAmount charged: " + project.getTotalFeeCharged()
                            + "\nAmount due: " + (project.getTotalFeeCharged() - project.getTotalAmountPaid())
                            + "\nProject status: " + project.getStatus()
            );
            System.out.println("============ End of project ===============\n");
        });
        System.out.println("========= End of the project list =============\n");
    }
}
