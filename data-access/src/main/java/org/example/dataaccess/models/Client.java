package org.example.dataaccess.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Size(max= 100, message = "Login must be shorter 100 characters")
    @NotNull(message = "Login must not be empty")
    @Column(name = "login")
    private String login;

    @Size(max = 100, message = "Password must be shorter 100 characters")
    @NotNull(message = "Password must not be empty")
    @Column(name = "password")
    private String password;

    @Email(message = "Email is not valid")
    @NotNull(message = "Email must not be empty")
    @Column(name = "email")
    private String email;

    @Size(max = 12, message = "Phone number must be shorter 12 characters")
    @NotNull(message = "Phone number must not be empty")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "client")
    @JsonManagedReference
    private Appearance appearance;

    @OneToOne(mappedBy = "client")
    @JsonManagedReference
    private Requirement requirement;

    @OneToMany(mappedBy = "clientBlockedClientPK.client",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BlockedList> blockedList;

    @OneToMany(mappedBy = "clientPairClientPK.client",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<PairUsers> pairUsers;



    public Client() {

    }


    public Client(long id, String login, String password, String email, String phoneNumber, Appearance appearance,
                  Requirement requirement, List<BlockedList> blockedList, List<PairUsers> pairUsers) {

        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appearance = appearance;
        this.requirement = requirement;
        this.blockedList = blockedList;
        this.pairUsers = pairUsers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public List<BlockedList> getBlockedList() {
        return blockedList;
    }

    public void setBlockedList(List<BlockedList> blockedList) {
        this.blockedList = blockedList;
    }

    public List<PairUsers> getPairUsers() {
        return pairUsers;
    }

    public void setPairUsers(List<PairUsers> pairUsers) {
        this.pairUsers = pairUsers;
    }
}
