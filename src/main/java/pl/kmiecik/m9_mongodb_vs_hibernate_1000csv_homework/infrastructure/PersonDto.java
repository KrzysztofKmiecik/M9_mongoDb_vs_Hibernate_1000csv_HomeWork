package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure;


import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PersonDto extends Person {
    @NotNull
    @Min(0)
    private Long idFile;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    @Email
    private String email;
    @NotBlank
    private String gender;
    @NotBlank
    private String ip_address;

    public Long getIdFile() {
        return idFile;
    }

    public void setIdFile(Long idFile) {
        this.idFile = idFile;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
