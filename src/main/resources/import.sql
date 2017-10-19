INSERT into owners(afm_number,email,password,access) VALUES (748578235,"apo.mantzios@gmail.com","12345","ADMIN");
INSERT into owners(access, afm_number, email, lastname, name, password) VALUES ("USER",19298491,"aggeliki@gmail.com","agg","agg","1244");
INSERT into vehicle(color, model, plate, owner_id) VALUES ("red","vw","sdsf-12",1);
INSERT into vehicle(color, model, plate, owner_id) VALUES ("blue","vw","ABC-1234",1);
INSERT into repair(cost, datetime, status, textarea, type, owner_id, vehicle_id) VALUES (200,"2017-6-6","sta","","a",1,1);
INSERT into repair(cost, datetime, status, textarea, type, owner_id, vehicle_id) VALUES (500,"2017-4-10","s","","f",1,2);
#  INSERT into repair(cost, datetime, status, textarea, type, owner_id, vehicle_id) VALUES (300,"2017-22-22","st","v","a",2,4);