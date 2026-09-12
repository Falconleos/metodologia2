package model;

import enums.VacationRequestStatus;

import java.time.LocalDate;

public class VacationRequest {

    private UserEntity empleado;
    private LocalDate start;
    private LocalDate end;
    private VacationRequestStatus status;
    private UserEntity supervisor;

    public VacationRequest() {
    }

    public VacationRequest(UserEntity empleado, LocalDate start, LocalDate end,UserEntity supervisor) {
        this.empleado = empleado;
        this.start = start;
        this.end = end;
        this.status = status;
        this.supervisor = supervisor;
    }

    public UserEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(UserEntity empleado) {
        this.empleado = empleado;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public VacationRequestStatus getStatus() {
        return status;
    }

    public void setStatus(VacationRequestStatus status) {
        this.status = status;
    }

    public UserEntity getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(UserEntity supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "VacationRequest{" +
                "empleado=" + empleado +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                ", supervisor=" + supervisor +
                '}';
    }
}
