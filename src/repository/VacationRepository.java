package repository;

import model.UserEntity;
import model.VacationRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface VacationRepository {

    //metodo que trae el repositorio de request de vacaciones de la base de datos

    List<VacationRequest> listaRequest = new ArrayList<>();

    default void addToList(VacationRequest request){
        listaRequest.add(request);
    };

    default VacationRequest findByUser(UserEntity userEntity){
        for(VacationRequest request : listaRequest){
            if(request.getEmpleado().equals(userEntity)){
                return request;
            }
        }
        return null;
    }

}
