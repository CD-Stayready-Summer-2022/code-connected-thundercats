package thundercats.codeconnectserver.domain.followers.models;

import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "first_user_id", referencedColumnName = "id")
    UserProfile firstUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "second_user_id", referencedColumnName = "id")
    UserProfile secondUser;

    public Follower(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserProfile getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(UserProfile firstUser) {
        this.firstUser = firstUser;
    }

    public UserProfile getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(UserProfile secondUser) {
        this.secondUser = secondUser;
    }
}

