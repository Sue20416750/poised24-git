import java.util.Date;

public class Project {
    //Project attributes line 5 - 15
    private String projectNumber;
    private String projectName;
    private String buildingType;
    private String physicalAddress;
    private int erfNumber;
    private float totalFeeCharged;
    private float totalAmountPaid;
    private String deadline;
    private Architect architect;
    private Contractor contractor;
    private Customer customer;

    private String completionDate = "none applicable";
    private String status = "not complete";

    //Getters and Setters up to line 103
    public String getProjectNumber() {
        return this.projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBuildingType() {
        return this.buildingType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getCompletionDate() {
        return this.completionDate;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getPhysicalAddress() {
        return this.physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getErfNumber() {
        return this.erfNumber;
    }

    public void setErfNumber(int erfNumber) {
        this.erfNumber = erfNumber;
    }

    public float getTotalFeeCharged() {
        return this.totalFeeCharged;
    }

    public void setTotalFeeCharged(float totalFeeCharged) {
        this.totalFeeCharged = totalFeeCharged;
    }

    public float getTotalAmountPaid() {
        return this.totalAmountPaid;
    }

    public void setTotalAmountPaid(float totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Architect getArchitect() {
        return this.architect;
    }

    public void setArchitect(Architect architect) {
        this.architect = architect;
    }

    public Contractor getContractor() {
        return this.contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //To string to display object attributes

    @Override
    public String toString() {
        return "projectNumber: " + projectNumber + "\n" +
                "projectName: " + projectName + "\n" +
                "buildingType: " + buildingType + "\n" +
                "physicalAddress: " + physicalAddress + "\n" +
                "erfNumber: " + erfNumber + "\n" +
                "totalFeeCharged: " + totalFeeCharged + "\n" +
                "totalAmountPaid: " + totalAmountPaid + "\n" +
                "deadline: " + deadline + "\n" +
                "architect: " + architect + "\n" +
                "contractor: " + contractor + "\n" +
                "customer: " + customer + "\n" +
                "completionDate: " + completionDate + "\n" +
                "status: " + status +  "\n";
    }

    public String toFile(){
        return projectNumber + "," +
            projectName + "," +
            buildingType + "," +
            physicalAddress + "," +
            erfNumber + "," +
            totalFeeCharged + "," +
            totalAmountPaid + "," +
            deadline + "," +
            architect.getName() + "," +
            architect.getPhysicalAddress() + "," +
            architect.getEmailAddress() + "," +
            architect.getTelephoneNumber() + "," +
            contractor.getName() + "," +
            contractor.getPhysicalAddress() + "," +
            contractor.getEmailAddress() + "," +
            contractor.getTelephoneNumber() + "," +
            customer.getName() + "," +
            customer.getPhysicalAddress() + "," +
            customer.getEmailAddress() + "," +
            customer.getTelephoneNumber() + "," +
            status + "," +
            completionDate;
    }
}