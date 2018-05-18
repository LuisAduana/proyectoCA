create database controlasistencia;
use controlasistencia;

create table alumno(
	matricula varchar(9) not null,
	nombreAlumno varchar(70) not null,
    apeAlumnoPat varchar(50) not null,
    apeAlumnoMat varchar(50) not null,
    repite boolean not null,
	asistencia int not null,
    nrc int not null
);

create table experienciaEducativa(
	nrc int primary key not null,
    nombreExperiencia varchar(300) not null,
    noClases int not null
);

alter table alumno add foreign key (nrc) references experienciaeducativa(nrc);