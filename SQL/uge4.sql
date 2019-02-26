 /*Opgave 4.1a
 Display a list of all instructors, showing their ID, name, and the number of sections that they have taught.
 Make sure to show the number of sections as 0 for instructors who have not taught any section.
 Your query should use an outerjoin, and should not use scalar subqueries. */
 
SELECT instructor.id, instructor.name, COUNT(course_id)   # count(*) counts all null values too
FROM instructor 
LEFT JOIN teaches 
ON teaches.id = instructor.id
GROUP BY instructor.id;
 
/* Opgave 4.1c.
Display the list of all course sections offered in Spring 2010, along with the names of the instructors teaching the section.
 If a section has more than one instructor, it should appear as many times in the result as it has instructors. 
 If it does not have any instructor, it should still appear in the result with the instructor name set to “—”.
*/

SELECT section.course_id, instructor.name, section.semester, section.year
FROM section 
LEFT JOIN teaches
ON section.course_id = teaches.course_id
AND section.sec_id = teaches.sec_id  #VIGTIGT! at bruge alle primær nøgler til at joine
AND section.semester = teaches.semester
AND section.year = teaches.year
LEFT JOIN instructor
ON teaches.ID = instructor.ID
WHERE section.semester = 'Spring' 
AND section.year = '2010';


/* Min example 1.1
 I denne eksampel får man en forkert output, fordi der kun bruges
course_id til at JOINe tabeller. 
Man skal vælge alle primær nøgler, som gør tuple unik, til at få en korrekt resultat, 
når der joines. 
I dette tilfælde course_id , sec_id, semester, year
Hvis vi kun joiner på course_id, så får vi kurser som bliver sættet sammen med kurser fra teaches 
fra forskellige semester og/eller year. Så Kurser, som ikke har nogen teacher,kommer til at have en, 
hvilket er forkert.
*/
# selects all courses, som ikke har en lærer
SELECT section.course_id, teaches.id  FROM section 
LEFT JOIN teaches
ON section.course_id = teaches.course_id
AND section.semester = teaches.semester  # det er vigtigt at bruge 
AND section.year = teaches.year;

/* Opgave 4.1d
Display the list of all departments, with the total number of instructors in each department, without using scalar subqueries.
 Make sure to correctly handle departments with no instructors.
*/
INSERT INTO department VALUES("Medicine", "Panum", 100.00);

SELECT department.dept_name, COUNT(instructor.ID) 
FROM department LEFT JOIN instructor
ON department.dept_name = instructor.dept_name
GROUP BY dept_name;

/* Opgave 4.2
*/


CREATE TABLE grade_points(
amercian_grade TEXT,
number_grade INT
); 

INSERT INTO grade_points values("A-", 5);
SELECT * FROM grade_points;

/*
Opret et View student_grades, der returnerer en liste over studerendes karakterer
*/
CREATE VIEW student_grades 
AS SELECT number_grade FROM grade_points
JOIN takes 
ON amercian_grade = takes.grade;
SELECT * FROM student_grades;

/*
Opret et View student_avg, der returnerer de studerende gennemsnit
 */
CREATE VIEW student_avg 
AS SELECT AVG(number_grade) 
FROM student_grades;

SELECT * FROM student_avg;
















