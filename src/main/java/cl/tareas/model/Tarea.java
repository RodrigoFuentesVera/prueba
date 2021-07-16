package cl.tareas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tarea", schema = "prueba")
public class Tarea{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "identificador")
	private Long identificador;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "vigente")
	private Integer vigente;

}
