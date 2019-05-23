package application.model;

import java.time.LocalDate;
import java.util.Date;

public class Holiday {

    private LocalDate startDate;

    private LocalDate endDate;

    private int idEmployee;

    public Holiday() {
    }

    public Holiday(Date start_date, Date end_date, int idEmployee) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.idEmployee = idEmployee;
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
