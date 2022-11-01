public class Architect {
    //Architect attributes line 3 - 6
    private String name;
    private String telephoneNumber;
    private String emailAddress;
    private String physicalAddress;

    //Getters and Setters up to line 39
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhysicalAddress() {
        return this. physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    //To string to display attributes of this class
    @Override
    public String toString() {
        return "Architect{" +
                "name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                '}';
    }
}