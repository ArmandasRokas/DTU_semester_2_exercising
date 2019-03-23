USE s185144;

DELIMITER $$
CREATE FUNCTION get_dept_budget_more_than_avarage()
	returns int
    BEGIN
		declare myinteger int default 1;
		return myinteger;
	END
DELIMITER;
    




SELECT * FROM department WHERE budget > (SELECT AVG(budget) FROM department) ;

SELECT * FROM department;


