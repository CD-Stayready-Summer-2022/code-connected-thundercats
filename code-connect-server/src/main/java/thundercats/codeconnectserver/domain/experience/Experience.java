package thundercats.codeconnectserver.domain.experience;

import lombok.*;
import thundercats.codeconnectserver.domain.employmenttype.EmploymentType;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String jobTitle;
    @NonNull
    private String company;
    @NonNull
    private String location;
    @NonNull
    private String startDate;
    @NonNull
    private String endDate;
    @NonNull
    private EmploymentType employmentType;

    @NonNull
    @OneToOne
    @JoinColumn(name="user_profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s", jobTitle, company, location, startDate, endDate, employmentType);
    }
}
