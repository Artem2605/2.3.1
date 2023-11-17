package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @Pattern(regexp = "[a-zA-ZА-Яа-яЁё]+", message = "Неверно указано имя")
    private String firstName;

    @Column(name = "last_name")
    @Pattern(regexp = "[a-zA-ZА-Яа-яЁё]+", message = "Неверно указана фамилия")
    private String lastName;

    @Column(name = "year")
    @Min(value = 0, message = "Неверно указан год")
    @Max(value = 2023, message = "Неверно указан год")
    @NotNull(message = "Неверно указан год")
    private Long year;

    public User() {
    }

    public User(String firstName, String lastName, Long year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            User user = (User) o;
            return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) &&
                    Objects.equals(lastName, user.lastName) && Objects.equals(year, user.year);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, year);
    }
}