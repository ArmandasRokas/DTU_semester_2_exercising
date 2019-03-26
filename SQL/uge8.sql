USE s185144;
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

