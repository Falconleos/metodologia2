package controller;

import model.UserEntity;
import model.VacationRequest;
import service.VacationRequestService;

import java.time.LocalDate;

public class VacationController {

    private final VacationRequestService vacationRequestService;

    // Inyección por constructor (Bajo acoplamiento)
    public VacationController(VacationRequestService vacationRequestService) {
        this.vacationRequestService = vacationRequestService;
    }

    public void createVacationRequestEndpoint(UserEntity empleado, String startDateStr, String endDateStr, UserEntity supervisor) {
        try {
            LocalDate start = LocalDate.parse(startDateStr);
            LocalDate end = LocalDate.parse(endDateStr);

            VacationRequest request = vacationRequestService.createRequest(empleado, start, end, supervisor);

            System.out.println("HTTP 201 Created: Solicitud de vacaciones generada exitosamente para " + empleado.getEmail());

        } catch (IllegalArgumentException e) {
            System.out.println("HTTP 400 Bad Request: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("HTTP 403 Forbidden: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("HTTP 500 Internal Error: " + e.getMessage());
        }
    }
}