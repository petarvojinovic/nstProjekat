package nst.springboot.restexample01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDto{
    private Long id;

    @NotNull(message = "Ime je obavezno polje!")
    @Size(min = 2,max = 10, message = "Broj karaktera mora biti izmejdu 2 i 10")
    private String name;

    @NotNull(message = "Skraceno ime je obavezno polje!")
    private String shortName;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}