package cl.tareas.response;

import lombok.Data;

@Data
public class TareaResponse {
	
	private boolean status;
	private String message;
	private Object data;

}
