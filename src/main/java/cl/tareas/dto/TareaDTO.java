package cl.tareas.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TareaDTO {
	
	private Long identificador;
	private String descripcion;
	private Date fechaCreacion;
	private boolean vigente;

}
