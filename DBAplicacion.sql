drop database if exists aplicacion;
create database aplicacion;
use aplicacion;

SET SQL_SAFE_UPDATES = 0;

create table Estudiante(
	idEstudiante int not null auto_increment,
    nombre varchar(100) not null, 
    usuario varchar(50) not null,
    contrasena varchar(50) not null,
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
    usuario varchar(50) not null,
    contrasena varchar(50) not null,
    telefono varchar(20), 
    direccion varchar(100) not null, 
    edad int default 0, 
	sexo varchar(15),
    cantidad_cursos int default 0, 
    ensenanza_especializada tinyint,
    codigoTipoUsuario int not null, 
    Primary Key PK_idProfesor(idProfesor)
);

Create table Usuario(
	idUsuario int default 1,
    idUsuarioActual int,
    primary key PK_idUsuario(idUsuario)
);


Create table videos(
	idVideo int not null auto_increment,
    idProfesor int not null,
    url varchar(100) not null, 
    usuario varchar(50) not null,
    titulo varchar(50) not null,
    descripcion varchar(20), 
    Primary Key PK_idVideo(idVideo)
);
alter table videos add foreign key (idProfesor) references Profesor(idProfesor);


Create table curso(
	idCurso int not null auto_increment,
    idProfesor int not null,
    nombre varchar(50) not null,
    descripcion varchar(100), 
    dificultad varchar(50) not null,
    duracion int(20) not null, 
    Primary Key PK_idCurso(idCurso)
);

alter table curso add foreign key (idProfesor) references Profesor(idProfesor);

Create table actividades(
	idActividad int not null auto_increment,
    idCurso int not null,
    nombre varchar(40) not null,
    descripcion varchar(100) not null,
    archivo varchar(100) not null, 
    Primary Key PK_idActividad(idActividad)
);
alter table actividades add foreign key (idCurso) references curso(idCurso);

Create table Estudiante_Curso(
	codigoEstudianteCurso int not null auto_increment, 
    idEstudiante int not null, 
    idCurso int not null, 
    Primary Key PK_codigoEstudianteCurso(codigoEstudianteCurso),
    CONSTRAINT FK_Estudiante_Curso_Estudiantes Foreign Key (idEstudiante) REFERENCES Estudiante(idEstudiante), 
    CONSTRAINT FK_Estudiante_Curso_Curso Foreign Key (idCurso) REFERENCES curso(idCurso)
);


Delimiter $$
Create procedure sp_EditarUsuario(IN idUsuario int)
    Begin
		Update Usuario set idUsuarioActual = idUsuario
			Where idUsuario = 1; 
	End$$
Delimiter ; 


-- -----------------PROCEDIMIENTO DE ESTUDIANTE
Delimiter $$
Create procedure sp_AgregarEstudiante(nombre_estudiante varchar(100), usuario_estudiante varchar(50), contrasena_estudiante varchar(50),
telefono_estudiante varchar(20), direccion_estudiante varchar(100), edad_estudiante int, sexo_estudiante varchar(15), 
discapacidad_visual_estudiante tinyint, codigoTipoUsuario_estudiante int)
Begin 	
    Insert into Estudiante(nombre, usuario, contrasena, telefono, direccion, edad, sexo, cantidad_cursos, discapacidad_visual, codigoTipoUsuario)
		values(nombre_estudiante, usuario_estudiante, contrasena_estudiante, telefono_estudiante, direccion_estudiante, edad_estudiante, 
        sexo_estudiante, 0, discapacidad_visual_estudiante, codigoTipoUsuario_estudiante);
End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarEstudiante()
Begin
	Select 
		Estudiante.idEstudiante, 
		Estudiante.nombre,
        Estudiante.usuario,
        Estudiante.contrasena,
		Estudiante.telefono,
		Estudiante.direccion,
		Estudiante.edad,
		Estudiante.sexo,
        Estudiante.discapacidad_visual, 
        Estudiante.cantidad_cursos,
        Estudiante.codigoTipoUsuario
        from Estudiante; 
End$$
Delimiter;

-- -----------------PROCEDIMIENTO DE PROFESOR
Delimiter $$
Create procedure sp_AgregarProfesor(nombre_profesor varchar(100), usuario_profesor varchar(50), contrasena_profesor varchar(50),
telefono_profesor varchar(20), direccion_profesor varchar(100), edad_profesor int, sexo_profesor varchar(15), 
ensenanza_especializada_profesor tinyint, codigoTipoUsuario_profesor int)
Begin 	
    Insert into Profesor(nombre, usuario, contrasena, telefono, direccion, edad, sexo, ensenanza_especializada, codigoTipoUsuario)
		values(nombre_profesor, usuario_profesor, contrasena_profesor, telefono_profesor, direccion_profesor, edad_profesor, sexo_profesor, ensenanza_especializada_profesor, codigoTipoUsuario_profesor);
End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarProfesor()
Begin
	Select 
		Profesor.idProfesor, 
		Profesor.nombre,
        Profesor.usuario,
        Profesor.contrasena,
		Profesor.telefono,
		Profesor.direccion,
		Profesor.edad,
		Profesor.sexo,
        Profesor.ensenanza_especializada, 
        Profesor.cantidad_cursos, 
        Profesor.codigoTipoUsuario
        from Profesor; 
End$$
Delimiter ;

-- -----------------PROCEDIMIENTO DE CURSOS
Delimiter $$
Create procedure sp_AgregarCurso(idProfesorCurso int, nombreCurso varchar(50), descripcionCurso varchar(100), dificultadCurso varchar(50), duracionCurso int)
Begin 	
    Insert into curso(idProfesor, nombre, descripcion, dificultad, duracion)
		values(idProfesorCurso, nombre, descripcionCurso, dificultadCurso, duracionCurso);
End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarCurso()
Begin
	Select 
		Curso.idCurso, 
		Curso.idProfesor,
        Curso.nombre,
        Curso.descripcion,
        Curso.dificultad,
		Curso.duracion
        from Curso; 
End$$
Delimiter ;

call sp_AgregarEstudiante("Brandon", "bsicay", "admin", "48859611", "11 Calle D 5-40 Z9", 16, "M", 1, 0);
call sp_AgregarProfesor("Jose", "jose", "123" ,"48859611", "11 Calle D 5-40 Z9", 26, "M", 0, 1);
call sp_AgregarCurso(1, "Algebra", "Curso de matematicas basicas", "Principiante", 7);
call sp_ListarEstudiante;
call sp_ListarProfesor;
call sp_ListarCurso;

insert into usuario(idUsuario, idUsuarioActual) values(1, 0);
select *from usuario;


