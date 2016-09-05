package h2020.mhealth4afrika.models;

import com.google.gson.GsonBuilder;

import java.io.Serializable;


public class User implements Serializable {

    private int userId;
    private String emailAddress;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int organizationId;
    private int role;

    public User() {

    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the organisationId
     */
    public int getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organisationId the organisationId to set
     */
    public void setOrganizationId(int organisationId) {
        this.organizationId = organisationId;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    public String serialize() {
        return new GsonBuilder().create().toJson(this);
    }

}
