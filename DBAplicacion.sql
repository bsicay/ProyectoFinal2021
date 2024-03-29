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

Create table curso(
	idCurso int not null auto_increment,
    idProfesor int not null,
    nombre varchar(50) not null,
    descripcion varchar(100), 
    dificultad varchar(50) not null,
    duracion int(20) not null, 
    especial tinyint,
    imageCurso longtext,
    Primary Key PK_idCurso(idCurso)
);

Create table videos(
	idVideo int not null auto_increment,
    idProfesor int not null,
    idCurso int not null,
    url longtext not null, 
    titulo varchar(50) not null,
    descripcion longtext, 
    Primary Key PK_idVideo(idVideo)
);
alter table videos add foreign key (idProfesor) references Profesor(idProfesor);
alter table videos add foreign key (idCurso) references Curso(idCurso);

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

Create table videos_estudiante(
	idVideosEstudiante int not null default 1, 
    url longtext,
    Primary Key PK_idVideosEstudiante(idVideosEstudiante)
);

Delimiter $$
Create procedure sp_EditarUsuario(IN idUsuario int)
    Begin
		Update usuario set idUsuarioActual = idUsuario
			Where usuario.idUsuario = 1; 
	End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarUsuario()
Begin
	Select 
		Usuario.idUsuario, 
		Usuario.idUsuarioActual
        from Usuario; 
End$$
Delimiter ;

Delimiter $$
Create procedure sp_EditarVideoEstudiante(IN urlVideo longtext)
    Begin
		Update videos_estudiante set url = urlVideo
			Where videos_estudiante.idVideosEstudiante = 1; 
	End$$
Delimiter ; 

Delimiter $$
Create procedure sp_ListarUrl()
Begin
	Select 
		videos_estudiante.idVideosEstudiante, 
		videos_estudiante.url
        from videos_estudiante; 
End$$
Delimiter ;


Delimiter $$
Create procedure sp_AgregarVideo(codigoProfesor int, nombreVideo varchar(50), descripcionVideo longtext, urlVideo longtext, codigoCurso int)
Begin 	
    Insert into videos(idProfesor, url, titulo, descripcion, idCurso)
		values(codigoProfesor, urlVideo, nombreVideo, descripcionVideo, codigoCurso);
End$$
Delimiter; 

Delimiter $$
Create procedure sp_ListarVideo()
Begin
	Select 
		Videos.idVideo, 
		Videos.idProfesor,
        Videos.titulo,
        Videos.url,
		Videos.descripcion,
        Videos.idCurso
        from Videos; 
End$$
Delimiter;


Delimiter $$
Create procedure sp_AgregarEstudianteCurso(codigoEstudiante int, codigoCurso int)
Begin 	
    Insert into Estudiante_Curso(idEstudiante, idCurso)
		values(codigoEstudiante, codigoCurso);
End$$
Delimiter; 

Delimiter $$
Create procedure sp_ListarEstudianteCurso(in codigoEstudiante int) 
Begin
	Select 
		Curso.nombre, 
		Curso.descripcion,
        Curso.dificultad,
        Videos.url,
        Profesor.nombre as nombreProfesor
        
        from Curso INNER JOIN profesor INNER JOIN Estudiante_Curso INNER JOIN videos ON curso.idCurso = Estudiante_Curso.idCurso and Curso.idProfesor = profesor.idProfesor
        and Estudiante_Curso.idEstudiante = codigoEstudiante and videos.idCurso = Estudiante_Curso.idCurso; 
End$$
Delimiter;


call sp_ListarEstudianteCurso(1);

select *from Estudiante_Curso;
select *from videos;


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
Create procedure sp_AgregarCurso(idProfesorCurso int, nombreCurso varchar(50), descripcionCurso varchar(100), dificultadCurso varchar(50), 
duracionCurso int, especialCurso tinyint, imagenCurso longtext)
Begin 	
    Insert into curso(idProfesor, nombre, descripcion, dificultad, duracion, especial, imageCurso)
		values(idProfesorCurso, nombreCurso, descripcionCurso, dificultadCurso, duracionCurso, especialCurso, imagenCurso);
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
		Curso.duracion,
        Curso.especial,
        Curso.imageCurso
        from Curso INNER JOIN usuario ON curso.idProfesor = usuario.idUsuarioActual; 
End$$
Delimiter ;

Delimiter $$
Create procedure sp_ListarCursoTotales()
Begin
	Select 
		Curso.idCurso, 
		Curso.idProfesor,
        Curso.nombre,
        Curso.descripcion,
        Curso.dificultad,
		Curso.duracion,
        Curso.especial,
        Curso.imageCurso
        from Curso; 
End$$
Delimiter ;

call sp_AgregarEstudiante("Brandon", "bsicay", "admin", "48859611", "11 Calle D 5-40 Z9", 16, "M", 1, 0);
call sp_AgregarProfesor("Jose", "jose", "123" ,"48859611", "11 Calle D 5-40 Z9", 26, "M", 0, 1);
call sp_AgregarProfesor("Juan", "juan", "admin" ,"48859611", "11 Calle D 5-40 Z9", 26, "M", 0, 1);
call sp_AgregarCurso(1, "Algebra", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn-icons-png.flaticon.com/512/2231/2231431.png");
call sp_AgregarCurso(1, "Fisica", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn-icons-png.flaticon.com/512/887/887862.png");
call sp_AgregarCurso(1, "Literatura", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn-icons-png.flaticon.com/512/2534/2534076.png");
call sp_AgregarCurso(1, "Programacion", "Curso de matematicas basicas", "Principiante", 7, 0, "https://avatars.githubusercontent.com/u/51731966?v=4");
call sp_AgregarCurso(1, "Calculo", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn-icons-png.flaticon.com/512/1902/1902648.png");
call sp_AgregarCurso(2, "Ciencias", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn0.iconfinder.com/data/icons/ecology-63/64/lab-biology-science-research-chemistry-512.png");
call sp_AgregarCurso(2, "Algebra", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn-icons-png.flaticon.com/512/2231/2231431.png");
call sp_AgregarCurso(2, "Fisica", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn-icons-png.flaticon.com/512/887/887862.png");
call sp_AgregarCurso(2, "Musica", "Curso de matematicas basicas", "Principiante", 7, 0, "https://cdn0.iconfinder.com/data/icons/audio-icons-rounded/110/Cloud-Music-Download-512.png");
call sp_ListarEstudiante;
call sp_ListarProfesor;
call sp_ListarCurso;
call sp_ListarVideo;
call sp_ListarCursoTotales;

insert into usuario(idUsuario, idUsuarioActual) values(1, 0);
insert into videos_estudiante(idVideosEstudiante, url) values(1, null);
select *from usuario;