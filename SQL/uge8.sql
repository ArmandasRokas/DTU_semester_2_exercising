USE s185144;
CREATE TABLE account(
account_number INT,
balance INT CHECK  (balance >= 0));



DROP TABLE account;
INSERT INTO account values(321, 20);
SELECT * FROM account;


/*Transaction exampel*/
START TRANSACTION;
UPDATE account SET balance = balance + 30 WHERE account_number = 123;
Commit; /* enten for bekræfte */
Rollback; /* eller for revert Update*/

SET autocommit = OFF;
UPDATE account SET balance = balance + 30 WHERE account_number = 123;
Commit; /* enten for bekræfte */
Rollback; /* eller for revert Update*/
SET autocommit = ON;

