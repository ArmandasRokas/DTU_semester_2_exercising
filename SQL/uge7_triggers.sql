USE s185144;
/*******************
Arrange
*********************/
CREATE TABLE document_modified (
document_id int Primary key,
last_modifier text
);

CREATE TABLE document_modified_log (
action text,
document_id int,
last_modifier text,
changedat DATETIME,
foreign key (document_id) references document_modified(document_id)
);

INSERT INTO document_modified values (1, "John");

/**************************
Act
***************************/
DELIMITER $$
CREATE TRIGGER last_modifiers AFTER UPDATE ON document_modified
	FOR EACH ROW
	BEGIN
		INSERT INTO document_modified_log
        SET action = 'update',
        document_id = OLD.document_id,
        last_modifier = OLD.last_modifier,
        changedat = NOW();
	END$$
DELIMITER ;

/*********************
Assert
*********************/
SHOW TRIGGERS;

UPDATE document_modified 
SET last_modifier = 'Sun'
WHERE document_id = 1;
SELECT * FROM document_modified;
SELECT * FROM document_modified_log;

/*
Reference : http://www.mysqltutorial.org/create-the-first-trigger-in-mysql.aspx
*/



