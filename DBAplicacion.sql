drop database if exists aplicacion;
create database aplicacion;
use aplicacion;

SET SQL_SAFE_UPDATES = 0;

create table Estudiante(
	idEstudiante int not null auto_increment,
    nombre varchar(100) not null, 
    telefono varchar(20), 
    direccion varchar(100) not null, 
    edad int default 0, 
	sexo varchar(15),
    cantidad_cursos int default 0, 
    discapacidad_visual tinyint,
    codigoTipoUsuario int not null, 
    Primary Key PK_idEstudiante(idEstudiante)
);

Create table Profesor(
	idProfesor int not null auto_increment,
    nombre varchar(100) not null, 
    telefono varchar(20), 
    direccion varchar(100) not null, 
    edad int default 0, 
	sexo varchar(15),
    cantidad_cursos int default 0, 
    ensenanza_especializada tinyint,
    codigoTipoUsuario int not null, 
    Primary Key PK_idProfesor(idProfesor)
);

-- -----------------PROCEDIMIENTO DE ESTUDIANTE
Delimiter $$
Create procedure sp_AgregarEstudiante(nombre_estudiante varchar(100), telefono_estudiante varchar(20), direccion_estudiante varchar(100), 
edad_estudiante int, sexo_estudiante varchar(15), discapacidad_visual_estudiante tinyint, codigoTipoUsuario_estudiante int)
Begin 	
    Insert into Estudiante(nombre, telefono, direccion, edad, sexo, cantidad_cursos, discapacidad_visual, codigoTipoUsuario)
		values(nombre_estudiante, telefono_estudiante, direccion_estudiante, edad_estudiante, sexo_estudiante, 0, discapacidad_visual_estudiante, codigoTipoUsuario_estudiante);
End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarEstudiante()
Begin
	Select 
		Estudiante.idEstudiante, 
		Estudiante.nombre,
		Estudiante.telefono,
		Estudiante.direccion,
		Estudiante.edad,
		Estudiante.sexo,
        Estudiante.discapacidad_visual, 
        Estudiante.cantidad_cursos,
        Estudiante.codigoTipoUsuario
        from Estudiante; 
End$$
Delimiter ;

-- -----------------PROCEDIMIENTO DE PROFESOR
Delimiter $$
Create procedure sp_AgregarProfesor(nombre_profesor varchar(100), telefono_profesor varchar(20), direccion_profesor varchar(100), 
edad_profesor int, sexo_profesor varchar(15), ensenanza_especializada_profesor tinyint, codigoTipoUsuario_profesor int)
Begin 	
    Insert into Profesor(nombre, telefono, direccion, edad, sexo, ensenanza_especializada, codigoTipoUsuario)
		values(nombre_profesor, telefono_profesor, direccion_profesor, edad_profesor, sexo_profesor, ensenanza_especializada_profesor, codigoTipoUsuario_profesor);
End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarProfesor()
Begin
	Select 
		Profesor.idProfesor, 
		Profesor.nombre,
		Profesor.telefono,
		Profesor.direccion,
		Profesor.edad,
		Profesor.sexo,
        Profesor.ensenanza_especializada, 
        Profesor.cantidad_cursos, 
        codigoTipoUsuario
        from Profesor; 
End$$
Delimiter ;

call sp_AgregarEstudiante("Brandon", "48859611", "11 Calle D 5-40 Z9", 16, "M", 1, 0);
call sp_AgregarProfesor("Jose", "48859611", "11 Calle D 5-40 Z9", 26, "M", 0, 1);
call sp_ListarEstudiante;
call sp_ListarProfesor;

select *from Estudiante;
select *from Profesor;

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';