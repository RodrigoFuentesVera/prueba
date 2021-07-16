package cl.tareas.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tareas.request.TareaRequest;
import cl.tareas.response.TareaResponse;
import cl.tareas.services.TareaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/tareas")
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping(path = "/")
	@ApiOperation(value = "Obtiene todas las tareas.")
	public ResponseEntity<TareaResponse> findAll(){
		TareaResponse response = tareaService.findAll();
		return new ResponseEntity<TareaResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/")
	@ApiOperation(value = "Crea una tarea nueva.")
	public ResponseEntity<TareaResponse> addTarea(@Valid @RequestBody TareaRequest request){
		TareaResponse response = tareaService.addTarea(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{idTarea}")
	@ApiOperation(value = "Elimina una tarea.")
	public ResponseEntity<TareaResponse> deleteTarea(@PathVariable Long idTarea){
		TareaResponse response = tareaService.deleteTarea(idTarea);
		return new ResponseEntity<TareaResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/")
	@ApiOperation(value = "Modifica una tarea existente.")
	public ResponseEntity<TareaResponse> editTarea(@RequestBody TareaRequest request){
		TareaResponse response = tareaService.editTarea(request);
		return new ResponseEntity<TareaResponse>(response, HttpStatus.OK);
	}
}
