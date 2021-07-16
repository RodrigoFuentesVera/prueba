package cl.tareas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import cl.tareas.dto.TareaDTO;
import cl.tareas.model.Tarea;
import cl.tareas.repository.TareaRepository;
import cl.tareas.request.TareaRequest;
import cl.tareas.response.TareaResponse;
import cl.tareas.services.TareaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService{

	private final TareaRepository tareaRepo;
	
	@Override
	public TareaResponse findAll() {
		TareaResponse response = new TareaResponse();
		List<Tarea> tareas = tareaRepo.findAll();
		List<TareaDTO> tareasDTO = new ArrayList<TareaDTO>();
		if(!tareas.isEmpty()) {
			response.setMessage("Tareas encontradas");
			for(Tarea tarea : tareas) {
				TareaDTO tareaDTO = new TareaDTO();
				tareaDTO.setIdentificador(tarea.getIdentificador());
				tareaDTO.setDescripcion(tarea.getDescripcion());
				tareaDTO.setFechaCreacion(tarea.getFechaCreacion());
				if(tarea.getVigente().compareTo(1) == 0) {
					tareaDTO.setVigente(true);	
				}else {
					tareaDTO.setVigente(false);	
				}
				tareasDTO.add(tareaDTO);
			}
			response.setData(tareasDTO);
		}else {
			response.setMessage("No se encontraron tareas");
		}
		response.setStatus(true);
		return response;
	}

	@Override
	public TareaResponse addTarea(TareaRequest request) {
		TareaResponse response = new TareaResponse();
		try {
			Tarea tarea = new Tarea();
			tarea.setDescripcion(request.getDescripcion());
			tarea.setFechaCreacion(new Date());
			if(request.getVigente()) {
				tarea.setVigente(1);
			}else {
				tarea.setVigente(0);
			}
			Tarea tareaAdded = tareaRepo.save(tarea);
			if(tareaAdded != null) {
				response.setMessage("Tarea creada");
				response.setData(tareaAdded);
			}
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage("Error de sistema al intentar agregar la tarea");
			response.setData(e.getMessage());
			return response;
		}
		
		response.setStatus(true);
		return response;
	}

	@Override
	public TareaResponse editTarea(TareaRequest request) {
		TareaResponse response = new TareaResponse();
		try {
			Tarea tarea = tareaRepo.getById(request.getIdentificador());
			tarea.setDescripcion(request.getDescripcion());
			if(request.getVigente()) {
				tarea.setVigente(1);
			}else {
				tarea.setVigente(0);
			}
			Tarea tareaEdited = tareaRepo.save(tarea);
			if(tareaEdited != null) {
				response.setMessage("Tarea editada");
				response.setData(tareaEdited);
			}
		}catch(EntityNotFoundException e) {
			response.setMessage("No se encuentra la Tarea");
			response.setStatus(true);
			return response;
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage("Error de sistema al intentar editar la tarea");
			response.setData(e.getMessage());
			return response;
		}
		response.setStatus(true);
		return response;
	}

	@Override
	public TareaResponse deleteTarea(Long idTarea) {
		TareaResponse response = new TareaResponse();
		try {
			tareaRepo.deleteById(idTarea);
		}catch(EmptyResultDataAccessException e) {
			response.setMessage("No se encuentra la Tarea");
			response.setStatus(true);
			return response;
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage("Error de sistema al intentar eliminar la tarea");
			response.setData(e.getMessage());
			return response;
		}
		response.setMessage("Tarea eliminada");
		response.setStatus(true);
		return response;
	}
	
	

}
