package thundercats.codeconnectserver.domain.education;

import lombok.*;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String schoolName;

    @NonNull
    private String location;
    @NonNull
    private String startDate;
    @NonNull
    private String endDate;
    @NonNull
    private String fieldOfStudy;
    @NonNull
    private Boolean isGraduated;
    @NonNull
    private Double gradePointAvg;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_profile_id", referencedColumnName = "id")
    @NonNull
    private UserProfile userProfile;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %b, %1.2f", schoolName, location, startDate, endDate, fieldOfStudy, isGraduated, gradePointAvg);

    }
}
