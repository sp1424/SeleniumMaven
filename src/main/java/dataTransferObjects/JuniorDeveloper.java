package dataTransferObjects;

public class JuniorDeveloper {

    private static final String JOB_POSITION = "Junior Software Developer";

    private static final String AUTOMATED_MESSAGE = "Test Message from java and selenium";

    private static final String UNWANTED_REGEX = " x";

    private String name;

    private Company company;

    private String phone;

    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPosition(){
        return JOB_POSITION;
    }

    public String getAutomatedMessage(){
        return AUTOMATED_MESSAGE;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public String getPhone() {
        return phone.replace(UNWANTED_REGEX, "-");
    }

    public String getEmail() {
        return email;
    }

}
