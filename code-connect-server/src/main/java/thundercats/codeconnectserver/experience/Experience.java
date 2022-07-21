package thundercats.codeconnectserver.experience;

public class Experience {
    private String jobTitle;
    private String company;
    private String location;
    private String startDate;
    private String endDate;
    private Enum EmploymentType;

    public Experience(String jobTitle, String company, String location, String startDate, String endDate, Enum employmentType) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        EmploymentType = employmentType;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Enum getEmploymentType() {
        return EmploymentType;
    }

    public void setEmploymentType(Enum employmentType) {
        EmploymentType = employmentType;
    }
}
