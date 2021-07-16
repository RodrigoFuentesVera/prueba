package cl.tareas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import cl.tareas.model.Tarea;
import cl.tareas.repository.TareaRepository;
import cl.tareas.request.TareaRequest;
import cl.tareas.response.TareaResponse;
import cl.tareas.services.TareaService;
import cl.tareas.services.impl.TareaServiceImpl;

@SpringBootTest
public class TareasServicesTest {
	
	@Mock
	private TareaService tareaService;
	
	@Mock
	private TareaRepository tareaRepository;
	
	TareaResponse response;
	List<Tarea> listaTareas;
	TareaRequest tareaAgregarRequest;
	Tarea tareaAgregar;
	TareaRequest tareaEditarRequest;
	Tarea tareaEditar;
	
	@BeforeEach
	public void setUp() {
		Tarea tarea = new Tarea();
		tarea.setIdentificador(1L);
		tarea.setDescripcion("Tarea Test 1");
		tarea.setFechaCreacion(new Date());
		tarea.setVigente(1);
		
		listaTareas = new ArrayList<Tarea>();
		listaTareas.add(tarea);
		
		tareaService = new TareaServiceImpl(tareaRepository);
		
		tareaAgregarRequest = new TareaRequest();
		tareaAgregarRequest.setDescripcion("Tarea Test agregar");
		tareaAgregarRequest.setVigente(true);
		tareaAgregar = new Tarea();
		tareaAgregar.setDescripcion("Tarea Test agregar");
		tareaAgregar.setVigente(1);
		
		tareaEditarRequest = new TareaRequest();
		tareaEditarRequest.setDescripcion("Tarea Test editar");
		tareaEditarRequest.setVigente(true);
		tareaEditar = new Tarea();
		tareaEditar.setDescripcion("Tarea Test editar");
		tareaEditar.setVigente(1);
		
	}
	
	@Test
	void finAll_ok() {
		Mockito.when(tareaRepository.findAll()).thenReturn(listaTareas);
		TareaResponse response_ = tareaService.findAll();
		assertThat(response_.getData()).isNotNull();
		
	}
	
	@Test
	void finAll_no_data() {
		Mockito.when(tareaRepository.findAll()).thenReturn(new ArrayList<>());
		TareaResponse response_ = tareaService.findAll();
		assertThat(response_.getData()).isNull();
		
	}
	
	@Test
	void addTarea_ok() {
		Mockito.when(tareaRepository.save(tareaAgregar)).thenReturn(tareaAgregar);
		TareaResponse response_ = tareaService.addTarea(tareaAgregarRequest);
		assertThat(response_).isNotNull();
	}
	
	@Test
	void editTarea_ok() {
		Mockito.when(tareaRepository.save(tareaEditar)).thenReturn(tareaEditar);
		TareaResponse response_ = tareaService.editTarea(tareaEditarRequest);
		assertThat(response_).isNotNull();
	}
	

}
