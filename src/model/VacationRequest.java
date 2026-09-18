package model;

import enums.VacationRequestStatus;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class VacationRequest {
    private Long id;
    private UserEntity empleado;
    private LocalDate start;
    private LocalDate end;
    private VacationRequestStatus status;
    private UserEntity supervisor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public VacationRequest(UserEntity empleado, LocalDate start, LocalDate end, UserEntity supervisor) {
        this.empleado = empleado;
        this.start = start;
        this.end = end;
        this.status = VacationRequestStatus.PENDING;
        this.supervisor = supervisor;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDate getStart() { return start; }
    public LocalDate getEnd() { return end; }
    public VacationRequestStatus getStatus() { return status; }
    public void setStatus(VacationRequestStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now(); // Actualiza el timestamp de modificación
    }
    public UserEntity getEmpleado() { return empleado; }
    public UserEntity getSupervisor() { return supervisor; }
}