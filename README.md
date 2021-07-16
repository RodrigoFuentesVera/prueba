# prueba
Prueba Tecnica Postulacion

Microservicio de mantenedor de tareas, en la cual se permite listar, agregar, modificar y eliminar tareas.

------- BASE DE DATOS --------
Se conecta a una base de datos MySQL
- Se debe crear base de datos "prueba"
- Se debe configurar archivo aaplication.properties con los datos de conección que tiene en su base de datos
      
      EJEMPLO
      
      spring.jpa.hibernate.ddl-auto=update
      spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/prueba
      spring.datasource.username=root
      spring.datasource.password=admin
      spring.datasource.driver-class-name =com.mysql.jdbc.Driver

- Se debe ejeciutar el siguiente script en la base de datos

    CREATE TABLE `prueba`.`tarea` (
    `identificador` INT NOT NULL AUTO_INCREMENT,
    `descripcion` VARCHAR(200) NULL,
    `fecha_creacion` DATETIME NULL,
    `vigente` INT NULL,
    PRIMARY KEY (`identificador`));
    
    
