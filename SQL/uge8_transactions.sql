USE s185144;
/* Øvelse 2. 1.a.*/
/* Hvad menes der med atomic måde?*/
START TRANSACTION;
DELETE FROM users_mandatory2 WHERE user_id = 1;
DELETE FROM roles_mandatory2 WHERE user_id = 1;
COMMIT;




SELECT * from roles_mandatory2;







/* Min egen eksampel*/
CREATE TABLE account(
account_number INT PRIMARY KEY,
balance INT NOT NULL CHECK (balance >= 0));

INSERT INTO account values(456, 0);
SELECT * FROM account;

UPDATE account SET balance = balance - 10 WHERE account_number = 123;

/*Transaction exampel*/
START TRANSACTION;
UPDATE account SET balance = balance  - 30 WHERE account_number = 12345;
Commit; /* enten for bekræfte */
Rollback; /* eller for revert Update*/

SET autocommit = OFF;
UPDATE account SET balance = balance + 30 WHERE account_number = 123;
Commit; /* enten for bekræfte */
Rollback; /* eller for revert Update*/
SET autocommit = ON;

