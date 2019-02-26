/*  Opgave 3.1a. */
SELECT title FROM course WHERE dept_name = 'Comp. Sci.' and credits > 3;

/* Tæl hvor mange A karakterer, der er givet i 2009 (Både A, A- og A+ skal tælles */
SELECT COUNT(grade) FROM takes WHERE grade LIKE 'A%';

/* Opgave 3.1.c Find the highest salary of any instructor */
SELECT MAX(salary) FROM instructor;

/* Opgave 3.1.d Find all instructors earning the highest salary */
SELECT name FROM instructor WHERE salary = (SELECT MAX(salary) FROM instructor);

/* Opgave 3.1.e Find the enrollment (antallet af studerende) of each section that was offered in Autumn 2009*/
SELECT course_id, COUNT(takes.ID) AS enrollments
FROM section NATURAL JOIN takes
WHERE semester = 'Fall'
AND year = '2009'
GROUP BY course_id; 

/* Opgave 3.3.a. Increase the salary of each instructor in the Comp. Sci. department by 10%.*/
UPDATE instructor SET salary = salary * 10 WHERE dept_name = 'Comp. Sci.';

/*Opgave 3.3.b. Delete all courses that have never been offered (that is, do not occur in the section relation).*/
DELETE FROM course WHERE course_id not in (select course_id from section);

/*Opgave 3.3.c Insert every student whose tot_cred attribute is greater than 100 as an instructor in the same department, with a salary of $10,000.
Hint: her skal indsættes resultatet af et select, hvor der skal tilføjes en fast værdi 10000 */
INSERT INTO instructor 
SELECT ID, name , dept_name, 10000
FROM student
WHERE tot_cred > 100;

/* Find the IDs of all students who were taught by an instructor named Einstein; make sure there are no duplicates in the result.
Find ud af hvilke sections hver studerende har taget (takes)
Find ud af hvilke sections hver instructor har undervist (teaches)
Kombiner resultatet. Kan gøres med eks. IN og WITH

SELECT distinct student.ID
from (student join takes using(ID))
join (instructor join teaches using(ID))
using(course id, sec id, semester, year)
where instructor.name = ’Einstein’;*/

WITH 
	student_takes (student_ID, takes_course_id, takes_sec_id, takes_semester, takes_year) AS 
		(SELECT student.ID, takes.course_id, takes.sec_id, takes.semester, takes.year from student JOIN takes on takes.ID = student.ID),
	instructor_teaches (teacher_ID, teacher_name, teaches_course_id, teaches_sec_id, teaches_semester, teaches_year ) AS
		(SELECT instructor.ID, instructor.name, teaches.course_id, teaches.sec_id, teaches.semester, teaches.year from instructor JOIN teaches on instructor.ID = teaches.ID)
SELECT student_ID, teacher_ID, teacher_name  , takes_course_id, teaches_course_id
FROM student_takes 
JOIN instructor_teaches 
ON student_takes.takes_course_id = instructor_teaches.teaches_course_id 
WHERE instructor_teaches.teacher_name = 'Einstein';

# Kaloyan udgave

SELECT DISTINCT takes.ID
FROM takes
WHERE takes.course_id in
(SELECT DISTINCT teaches.course_id
FROM teaches
WHERE teaches.ID in
(SELECT instructor.ID
FROM instructor
WHERE instructor.name = 'Einstein'));


/* Prints out student name and instructor name by joining student and instructor using advisor  */
/* https://stackoverflow.com/questions/1416003/sql-select-from-multiple-tables */
SELECT student.name AS 'student', instructor.name AS 'instructor' 
FROM student JOIN advisor on advisor.s_ID=student.ID  /* joins student with advisor */  
JOIN instructor ON instructor.ID = advisor.i_ID ;     /* joins with instructor */
 
SELECT *
FROM student JOIN advisor on advisor.s_ID=student.ID  /* joins student with advisor */  
JOIN instructor ON instructor.ID = advisor.i_ID
WHERE student.dept_name = 'Comp. Sci.';   


/*Testing */
SELECT * FROM student  natural join takes; /* natural join */ 

SELECT dept_name, COUNT(ID) FROM student GROUP BY dept_name; /* count students in each deparment */ 
SELECT * FROM student;

SELECT ID FROM takes WHERE course_id = 'CS-101';
SELECT ID, name from student where ID in (SELECT ID FROM takes WHERE course_id = 'CS-101');
SELECT ID, name FROM student  natural join takes WHERE course_id = 'CS-101';

select * from student natural join takes;
SELECT distinct student.ID, student.namstudente, takes.course_id FROM student natural join takes  WHERE takes.course_id = 'CS-101';
SELECT distinct student.ID, student.namstudente, takes.course_id FROM student natural join takes  WHERE takes.course_id = 'CS-101';  
SELECT student.ID as 'student.id' , takes.ID FROM takes LEFT JOIN student ON takes.id = student.id WHERE takes.course_id = 'CS-101';


SELECT name, course_id FROM instructor, teaches WHERE instructor.ID = teaches.ID;