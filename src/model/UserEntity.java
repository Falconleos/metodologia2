package model;

public class UserEntity {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Long vacationsDays;
    private Long vacationDaysAvailbles;
    private Role role;

    public UserEntity(Long id, String email, String password, String name, String surname, Long vacationsDays, Long vacationDaysAvailbles, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.vacationsDays = vacationsDays;
        this.vacationDaysAvailbles = vacationDaysAvailbles;
        this.role = role;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getVacationsDays() {
        return vacationsDays;
    }

    public void setVacationsDays(Long vacationsDays) {
        this.vacationsDays = vacationsDays;
    }

    public Long getVacationDaysAvailbles() {
        return vacationDaysAvailbles;
    }

    public void setVacationDaysAvailbles(Long vacationDaysAvailbles) {
        this.vacationDaysAvailbles = vacationDaysAvailbles;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", vacationsDays=" + vacationsDays +
                ", vacationDaysAvailbles=" + vacationDaysAvailbles +
                ", role=" + role +
                '}';
    }
}
