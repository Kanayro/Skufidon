package org.example.dataaccess.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;

import java.util.List;


public class ClientDTO {

    private long id;

    @Size(max= 100, message = "Login must be shorter 100 characters")
    @NotNull(message = "Login must not be empty")
    private String login;

    @Size(max = 100, message = "Password must be shorter 100 characters")
    @NotNull(message = "Password must not be empty")
    private String password;

    @Email(message = "Email is not valid")
    @NotNull(message = "Email must not be empty")
    private String email;

    @Size(max = 12, message = "Phone number must be shorter 12 characters")
    @NotNull(message = "Phone number must not be empty")
//    @Pattern(regexp = "\\W[+]\\d[7]\\d{10}",message = "Phone number format is:+7**********")
    private String phoneNumber;

//    @JsonManagedReference
    private AppearanceDTO appearance;


//    @JsonManagedReference
    private RequirementDTO requirement;


    private List<BlockedListDTO> blockedList;


    private List<PairUsersDTO> pairUsers;

    public ClientDTO() {
    }

    public ClientDTO(long id,String login, String password, String email, String phoneNumber,
                     AppearanceDTO appearance, RequirementDTO requirement, List<BlockedListDTO> blockedList, List<PairUsersDTO> pairUsers) {
        this.id=id;
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

    public AppearanceDTO getAppearance() {
        return appearance;
    }

    public void setAppearance(AppearanceDTO appearance) {
        this.appearance = appearance;
    }

    public RequirementDTO getRequirement() {
        return requirement;
    }

    public void setRequirement(RequirementDTO requirement) {
        this.requirement = requirement;
    }

    public List<BlockedListDTO> getBlockedList() {
        return blockedList;
    }

    public void setBlockedList(List<BlockedListDTO> blockedList) {
        this.blockedList = blockedList;
    }

    public List<PairUsersDTO> getPairUsers() {
        return pairUsers;
    }

    public void setPairUsers(List<PairUsersDTO> pairUsers) {
        this.pairUsers = pairUsers;
    }
}
