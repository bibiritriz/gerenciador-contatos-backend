INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Beatriz');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Camila');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Olivia');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Isabella');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Sophia');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Valentina');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Helena');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Luna');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Clara');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Giovanna');
INSERT INTO TBL_PHOTOS (url) VALUES ('https://api.dicebear.com/7.x/lorelei/svg?seed=Laura');

-- Inserir categorias
INSERT INTO TBL_CATEGORIES (name) VALUES ('Family');
INSERT INTO TBL_CATEGORIES (name) VALUES ('Friends');
INSERT INTO TBL_CATEGORIES (name) VALUES ('Work');

-- Inserir contatos (necessário caso queira popular Address, Phone e Email corretamente)
INSERT INTO TBL_CONTACTS (name, lastname, nickname, birthday, note, favorite, photo_id) 
VALUES ('John', 'Doe', 'Johnny', '1990-05-15', 'Best friend', TRUE, 1);

INSERT INTO TBL_CONTACTS (name, lastname, nickname, birthday, note, favorite, photo_id) 
VALUES ('Jane', 'Smith', 'Janey', '1992-08-22', 'Colleague', FALSE, 1);

-- Relacionar contatos com categorias (tabela ManyToMany)
INSERT INTO CONTACTS_CATEGORIES (contact_id, category_id) VALUES (1, 1);
INSERT INTO CONTACTS_CATEGORIES (contact_id, category_id) VALUES (1, 2);
INSERT INTO CONTACTS_CATEGORIES (contact_id, category_id) VALUES (2, 3);


-- Inserir endereços
INSERT INTO TBL_ADDRESSES (number, street, neighborhood, complement, city, state, country, zip_code)
VALUES ('123', 'Main St', 'Downtown', 'Apt 101', 'Springfield', 'IL', 'USA', '62701');

INSERT INTO TBL_ADDRESSES (number, street, neighborhood, complement, city, state, country, zip_code)
VALUES ('456', 'Second St', 'Uptown', 'Suite 200', 'Springfield', 'IL', 'USA', '62702');

INSERT INTO CONTACTS_ADDRESSES(contact_id, address_id) VALUES (1, 2);
INSERT INTO CONTACTS_ADDRESSES(contact_id, address_id) VALUES (2, 1);

-- Inserir telefones
INSERT INTO TBL_PHONES (number, label, contact_id)
VALUES ('+15551234567', 'Mobile', 1);

INSERT INTO TBL_PHONES (number, label, contact_id)
VALUES ('+15557654321', 'Work', 2);

-- Inserir e-mails
INSERT INTO TBL_EMAILS (address, label, contact_id)
VALUES ('john.doe@example.com', 'Personal', 1);

INSERT INTO TBL_EMAILS (address, label, contact_id)
VALUES ('jane.smith@work.com', 'Work', 2);

-- Contact
INSERT INTO TBL_CONTACTS (name, lastname, nickname, birthday, note, favorite, photo_id)
VALUES ('Camila', 'Santos', 'Cami', '1995-03-10', 'Friend from college', TRUE, 2);

-- Category: Friends
INSERT INTO CONTACTS_CATEGORIES (contact_id, category_id) VALUES (3, 2);

-- Address
INSERT INTO TBL_ADDRESSES (number, street, neighborhood, complement, city, state, country, zip_code)
VALUES ('789', 'Third Ave', 'Downtown', 'Apt 9B', 'New York', 'NY', 'USA', '10001');

INSERT INTO CONTACTS_ADDRESSES (contact_id, address_id) VALUES (3, 3);

-- Phone
INSERT INTO TBL_PHONES (number, label, contact_id)
VALUES ('+15559876543', 'Mobile', 3);

-- Email
INSERT INTO TBL_EMAILS (address, label, contact_id)
VALUES ('camila.santos@gmail.com', 'Personal', 3);


-- Contact
INSERT INTO TBL_CONTACTS (name, lastname, nickname, birthday, note, favorite, photo_id)
VALUES ('Olivia', 'Martins', 'Liv', '1998-12-01', 'Work colleague', FALSE, 3);

-- Category: Work
INSERT INTO CONTACTS_CATEGORIES (contact_id, category_id) VALUES (4, 3);

-- Address
INSERT INTO TBL_ADDRESSES (number, street, neighborhood, complement, city, state, country, zip_code)
VALUES ('101', 'Paulista Ave', 'Financial District', '', 'Chicago', 'IL', 'USA', '60601');

INSERT INTO CONTACTS_ADDRESSES (contact_id, address_id) VALUES (4, 4);

-- Phone
INSERT INTO TBL_PHONES (number, label, contact_id)
VALUES ('+15551234567', 'Work', 4);

-- Email
INSERT INTO TBL_EMAILS (address, label, contact_id)
VALUES ('olivia.martins@company.com', 'Work', 4);

-- Contact
INSERT INTO TBL_CONTACTS (name, lastname, nickname, birthday, note, favorite, photo_id)
VALUES ('Clara', 'Oliveira', 'Clary', '2000-06-21', 'Sweet cousin', TRUE, 9);

-- Category: Family
INSERT INTO CONTACTS_CATEGORIES (contact_id, category_id) VALUES (5, 1);

-- Address
INSERT INTO TBL_ADDRESSES (number, street, neighborhood, complement, city, state, country, zip_code)
VALUES ('202', 'Flower St', 'Green Hills', '', 'San Francisco', 'CA', 'USA', '94101');

INSERT INTO CONTACTS_ADDRESSES (contact_id, address_id) VALUES (5, 5);

-- Phone
INSERT INTO TBL_PHONES (number, label, contact_id)
VALUES ('+15557654321', 'Home', 5);

-- Email
INSERT INTO TBL_EMAILS (address, label, contact_id)
VALUES ('clara.oliveira@example.com', 'Personal', 5);