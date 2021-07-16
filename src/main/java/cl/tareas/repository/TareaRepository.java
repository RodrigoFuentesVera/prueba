package cl.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.tareas.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{
	
}
