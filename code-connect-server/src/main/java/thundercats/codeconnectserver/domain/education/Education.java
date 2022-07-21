package thundercats.codeconnectserver.domain.education;

public class Education {
    private String schoolName;
    private String location;
    private String startDate;
    private String endDate;
    private String fieldOfStudy;
    private Boolean isGraduated;
    private Double gradePointAvg;

    public Education(String schoolName, String location, String startDate, String endDate, String fieldOfStudy,
                     Boolean isGraduated, Double gradePointAvg) {
        this.schoolName = schoolName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fieldOfStudy = fieldOfStudy;
        this.isGraduated = isGraduated;
        this.gradePointAvg = gradePointAvg;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Boolean getGraduated() {
        return isGraduated;
    }

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }

    public Double getGradePointAvg() {
        return gradePointAvg;
    }

    public void setGradePointAvg(Double gradePointAvg) {
        this.gradePointAvg = gradePointAvg;
    }

    @Override
    public String toString() {
        return "Education{" +
                "schoolName='" + schoolName + '\'' +
                ", location='" + location + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", isGraduated=" + isGraduated +
                ", gradePointAvg=" + gradePointAvg +
                '}';
    }
}
