CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerName VARCHAR2(100),
    AccountType VARCHAR2(20), 
    Balance NUMBER(15, 2)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER(15, 2)
);


INSERT INTO Accounts VALUES (1, 'Alice', 'Savings', 5000);
INSERT INTO Accounts VALUES (2, 'Bob', 'Savings', 2000);
INSERT INTO Accounts VALUES (3, 'Charlie', 'Checking', 1000);

INSERT INTO Employees VALUES (101, 'John Doe', 'Sales', 50000);
INSERT INTO Employees VALUES (102, 'Jane Smith', 'Sales', 60000);
INSERT INTO Employees VALUES (103, 'Mike Ross', 'HR', 45000);

COMMIT;



CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all Savings accounts.');
END;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept IN VARCHAR2, 
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percentage / 100))
    WHERE Department = p_dept;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salaries updated for Department: ' || p_dept);
END;
/


CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN INT,
    p_to_account   IN INT,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN

    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;
    
 
    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_from_account);
    ELSE
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
        
        
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer Successful: $' || p_amount || ' moved from ' || p_from_account || ' to ' || p_to_account);
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One of the Account IDs does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred.');
        ROLLBACK;
END;
/




EXEC ProcessMonthlyInterest;
EXEC UpdateEmployeeBonus('Sales', 10);
EXEC TransferFunds(1, 3, 500);
EXEC TransferFunds(2, 3, 10000);



BEGIN

    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('                UPDATED ACCOUNTS TABLE');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('ID    | Name            | Type         | Balance');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    
    FOR acc IN (SELECT * FROM Accounts ORDER BY AccountID) LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(acc.AccountID, 5) || ' | ' || 
            RPAD(acc.CustomerName, 15) || ' | ' || 
            RPAD(acc.AccountType, 12) || ' | ' || 
            TO_CHAR(acc.Balance, '99,999.99')
        );
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(CHR(10)); 

 
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('                UPDATED EMPLOYEES TABLE');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('ID    | Name            | Department   | Salary');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');

    FOR emp IN (SELECT * FROM Employees ORDER BY EmployeeID) LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(emp.EmployeeID, 5) || ' | ' || 
            RPAD(emp.Name, 15) || ' | ' || 
            RPAD(emp.Department, 12) || ' | ' || 
            TO_CHAR(emp.Salary, '999,999.99')
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
END;
/