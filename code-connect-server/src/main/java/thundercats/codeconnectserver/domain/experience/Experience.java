package thundercats.codeconnectserver.domain.experience;

import thundercats.codeconnectserver.domain.employmenttype.EmploymentType;

import javax.persistence.Entity;

public class Experience {
    private String jobTitle;
    private String company;
    private String location;
    private String startDate;
    private String endDate;
    private EmploymentType employmentType;

    public Experience(String jobTitle, String company, String location, String startDate, String endDate, EmploymentType employmentType) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employmentType = employmentType;
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

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s", jobTitle, company, location, startDate, endDate, employmentType);
    }
}
