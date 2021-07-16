package cl.tareas.services;

import cl.tareas.request.TareaRequest;
import cl.tareas.response.TareaResponse;

public interface TareaService {
	
	TareaResponse findAll();
	TareaResponse addTarea(TareaRequest request);
	TareaResponse editTarea(TareaRequest request);
	TareaResponse deleteTarea(Long idTarea);

}
