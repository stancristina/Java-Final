package application.model;

import java.time.LocalDate;
import java.util.Date;

public class Holiday {

    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private int idEmployee;

    public Holiday() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", employee=" + idEmployee +
                '}';
    }

}
