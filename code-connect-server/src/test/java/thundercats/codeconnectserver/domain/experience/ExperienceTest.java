package thundercats.codeconnectserver.domain.experience;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import thundercats.codeconnectserver.domain.employmenttype.EmploymentType;

public class ExperienceTest {
    Experience experience = new Experience("SWE", "CodeDifferently", "Remote", "1/1/22",
            "12/12/22", EmploymentType.APPRENTICESHIP);

    @Test
    void constructorTest01() {
        String expected = experience.toString();
        String actual = "SWE, CodeDifferently, Remote, 1/1/22, 12/12/22, APPRENTICESHIP";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setterTest01() {
        experience.setJobTitle("SDE");
        experience.setCompany("Google");
        experience.setLocation("Atlanta");
        experience.setStartDate("1/02/22");
        experience.setEndDate("12/01/22");
        experience.setEmploymentType(EmploymentType.FREELANCE);

        String expected = experience.toString();
        String actual = ("SDE, Google, Atlanta, 1/02/22, 12/01/22, FREELANCE");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getterTest01() {
        String expected = experience.getJobTitle();
        String actual = ("SWE");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getterTest02() {
        String expected = experience.getCompany();
        String actual = ("CodeDifferently");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getterTest03() {
        String expected = experience.getLocation();
        String actual = ("Remote");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getterTest04() {
        String expected = experience.getStartDate();
        String actual = ("1/1/22");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getterTest05() {
        String expected = experience.getEndDate();
        String actual = ("12/12/22");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getterTest06() {
        String expected = String.valueOf(experience.getEmploymentType());
        String actual = String.valueOf(EmploymentType.APPRENTICESHIP);
        Assertions.assertEquals(expected, actual);
    }
}
