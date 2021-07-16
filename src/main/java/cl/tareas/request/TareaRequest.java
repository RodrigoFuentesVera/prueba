package cl.tareas.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TareaRequest {
	
	private Long identificador;
	
	@NotNull(message = "El campo descripcion es obligatorio.")
	private String descripcion;
	
	@NotNull(message = "El campo vigente es obligatorio.")
	private Boolean vigente;

}
