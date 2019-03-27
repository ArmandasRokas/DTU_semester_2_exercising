USE s185144;
 DELIMITER //
 CREATE PROCEDURE GetAllStudents()
   BEGIN
   SELECT *  FROM student;
   END //
 DELIMITER ;
 
CALL GetAllStudents();
 
DROP PROCEDURE GetAllStudents;


/*
Reference: http://www.mysqltutorial.org/getting-started-with-mysql-stored-procedures.aspx
*/
 