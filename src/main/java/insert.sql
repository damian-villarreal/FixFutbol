/*INSERT INTO `db`.`equipo` (`nombre`) VALUES ('River Plate');
INSERT INTO `db`.`equipo` (`nombre`) VALUES ('Racing');
INSERT INTO `db`.`equipo` (`nombre`) VALUES ('Boca Juniors');
INSERT INTO `db`.`equipo` (`nombre`) VALUES ('San Lorenzo');
INSERT INTO `db`.`equipo` (`nombre`) VALUES ('Huracan');
INSERT INTO `db`.`equipo` (`nombre`) VALUES ('Velez Sarsfield');*/

INSERT INTO Equipo 	(id, nombre) VALUES 
					(1, "Boca Juniors"),
					(2, "River Plate"),
					(3, "Racing Club"),
					(4, "Independiente"),
 					(5, "San Lorenzo"),
					(6, "Rosario Central"),
 					(7, "Newells"),
					(8, "Talleres(CBA)"),
 					(9, "Belgrano"),
					(10, "Estudiantes LP"),
 					(11, "Gimnasia LP"),
 					(12, "Patronato"),
 					(13, "Godoy Cruz"),
 					(14, "Defensa y Justicia"),
 					(15, "Velez Sarfield"), 
 					(16, "San Martin(SJ)"), 
 					(17, "Atletico Tucuman"),
 					(18, "San Martin de Tucuman"), 
 					(19, "Tigre"),
 					(20, "Colon");
 					
 NSERT INTO Torneo (id, nombre) VALUES
 					(1, "Liguilla"),
 					(2, "Copa Libertadores"),
 					(3, "Copa Sudamericana");
				
INSERT INTO Fecha (id, numero, torneo_id) VALUES
 				   (1 , 1, 1),
 				   (2 , 2, 1),
 				   (3 , 3, 1),
 				   (4 , 4, 1),
 				   (5 , 5, 1); 
                    
                    
 					
 INSERT INTO Partido (id, golesLocales, golesVisitantes, equipoLocal_id, equipoVisitante_id, fechaPartido, fecha_id, isResultadoFinal, isTerminado) VALUES
 					 /*Fecha 1*/
 					 (1, 2, 2, 1, 2, 20181104, 1, true, true),
 					 (2, 3, 1, 3, 4, 20181104, 1, true, true),
 					 (3, 2, 4, 5, 6, 20181104, 1, true, true),
 					  /*Fecha 2*/
 					 (4, 2, 1, 1, 3, 20181111, 2, true, true),
 					 (5, 3, 1, 2, 5, 20181111, 2, true, true),
 					 (6, 3, 5, 4, 6, 20181111, 2, true, true),
 					  /*Fecha 3*/
 					 (7, 1, 1, 1, 4, 20181118, 3, true, true),
 					 (8, 1, 0, 2, 6, 20181118, 3, true, true),
 					 (9, 2, 1, 3, 5, 20181118, 3, true, true),
 					  /*Fecha 4*/
 					 (10, 2, 1, 1, 5, 20181125, 4, true, true),
 					 (11, 3, 1, 2, 4, 20181125, 4, true, true),
 					 (12, 2, 2, 3, 6, 20181125, 4, true, true),
 					  /*Fecha 5*/
 					 (13, 1, 1, 1, 6, 20181202, 5, true, true),
 					 (14, 3, 0, 2, 3, 20181202, 5, true, true),
 					 (15, 2, 2, 4, 5, 20181202, 5, true, true);
 		
 INSERT INTO Tabla (id,jugados,puntos,ganados,empatados,perdidos,golesfavor,golescontra,diferenciagoles,equipo_id) VALUES
 
 	/*BOCA*/
 	(1,2,4,1,1,0,6,2,4,1),
 	/*RIVER*/
 	(2,2,6,2,0,0,7,3,4,2),
 	/*RACING*/
 	(3,2,6,2,0,0,10,1,9,3),
 	/*INDEPENDIENTE*/
 	(4,2,0,0,0,2,2,4,-2,4),
 	/*SAN LORENZO*/
 	(5,2,2,0,2,0,0,0,0,5),
 	/*ROSARIO CENTRAL*/
 	(6,2,3,1,0,1,3,0,3,6);
 	
 INSERT INTO Fase (id, instancia, nombreDeLaFase, siguienteFase_id) VALUES
 
 	(4, "FINAL", "PARTIDO_FINAL", NULL),
    (3, "SEMIS", "SEMI_DE_FINAL", 4),
 	(2, "CUARTOS", "CUARTOS_DE_FINAL", 3),
    (1, "OCTAVOS", "OCTAVOS_DE_FINAL", 2);
 	
 