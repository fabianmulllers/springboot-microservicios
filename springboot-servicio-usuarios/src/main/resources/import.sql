INSERT INTO usuarios(username,password,enabled,nombre,apellido,email) VALUES('fabian','$2a$10$VdYIFMPk2MBbsSYacYtanu/m1.4YOrxNDHl4n8Xxuv5uKtvm/SGre',true,'Fabian','Muller','fabian@correo,cl');
INSERT INTO usuarios(username,password,enabled,nombre,apellido,email) VALUES('admin','$2a$10$f.a1Cwo8gAsP2sWZ/jLtWeCu97qXEt04.EgfpFvUlHA/xoz/gbf6y',true,'Jhon','Doe','jhon.doe@correo,cl');

INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');


INSERT INTO usuarios_roles(usuario_id,role_id) VALUES(1,1);
INSERT INTO usuarios_roles(usuario_id,role_id) VALUES(2,2);
INSERT INTO usuarios_roles(usuario_id,role_id) VALUES(2,1);