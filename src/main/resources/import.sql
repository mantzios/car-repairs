INSERT into owners(afm_number,email,password,access,lastname,name) VALUES (748578235,"apo.mantzios@gmail.com","12345","ADMIN","Mantzios","Apostolis");
INSERT into owners(access, afm_number, email, lastname, name, password) VALUES ("USER",192984919,"aggeliki@gmail.com","Aggeliki","Kalyva","1244");
INSERT into vehicle(color, model, plate, year,owner_id) VALUES ("red","vw","AAA-1111","2005",1);
INSERT into vehicle(color, model, plate,year ,owner_id) VALUES ("blue","vw","ABC-1234","2010",1);
INSERT into repair(cost, datetime, status, textarea, type, owner_id, vehicle_id) VALUES (200,"2017-6-6","sta","","a",1,1);
INSERT into repair(cost, datetime, status, textarea, type, owner_id, vehicle_id) VALUES (500,"2017-4-10","s","","f",1,2);
#  INSERT into repair(cost, datetime, status, textarea, type, owner_id, vehicle_id) VALUES (300,"2017-22-22","st","v","a",2,4);