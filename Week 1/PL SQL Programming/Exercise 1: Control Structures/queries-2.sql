
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Age INT,
    Balance NUMBER(10, 2),
    IsVIP VARCHAR2(10) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    InterestRate NUMBER(5, 2),
    DueDate DATE,
    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


INSERT INTO Customers (CustomerID, CustomerName, Age, Balance) VALUES (1, 'Alice Smith', 65, 5000);
INSERT INTO Customers (CustomerID, CustomerName, Age, Balance) VALUES (2, 'Bob Jones', 45, 15000);
INSERT INTO Customers (CustomerID, CustomerName, Age, Balance) VALUES (3, 'Charlie Brown', 70, 12000);
INSERT INTO Customers (CustomerID, CustomerName, Age, Balance) VALUES (4, 'Diana Prince', 30, 2000);


INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (101, 1, 5.5, SYSDATE + 10);
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (102, 2, 6.0, SYSDATE + 45);
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (103, 3, 4.5, SYSDATE + 20);

COMMIT;


BEGIN
  FOR rec IN (SELECT L.LoanID, C.Age, L.InterestRate 
              FROM Loans L 
              JOIN Customers C ON L.CustomerID = C.CustomerID) 
  LOOP
      IF rec.Age > 60 THEN
          UPDATE Loans
          SET InterestRate = InterestRate - 1
          WHERE LoanID = rec.LoanID;
          
          DBMS_OUTPUT.PUT_LINE('Discount applied to Loan ID: ' || rec.LoanID || '. New Rate: ' || (rec.InterestRate - 1));
      END IF;
  END LOOP;
  COMMIT;
END;
/


BEGIN
  FOR rec IN (SELECT CustomerID, Balance FROM Customers) 
  LOOP
      IF rec.Balance > 10000 THEN
          UPDATE Customers
          SET IsVIP = 'TRUE'
          WHERE CustomerID = rec.CustomerID;
          
          DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' promoted to VIP.');
      END IF;
  END LOOP;
  COMMIT;
END;
/


DECLARE
    CURSOR c_due_loans IS
        SELECT L.LoanID, C.CustomerName, L.DueDate
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.DueDate BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- SENDING REMINDERS ---');
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.CustomerName || 
                             ', your loan ' || rec.LoanID || 
                             ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/


BEGIN
  DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');
  DBMS_OUTPUT.PUT_LINE('UPDATED CUSTOMERS TABLE');
  DBMS_OUTPUT.PUT_LINE('ID | Name           | Age | Balance  | IsVIP');
  DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');
  
  FOR c IN (SELECT * FROM Customers ORDER BY CustomerID) LOOP
      DBMS_OUTPUT.PUT_LINE(
          RPAD(c.CustomerID, 3) || ' | ' || 
          RPAD(c.CustomerName, 14) || ' | ' || 
          RPAD(c.Age, 3) || ' | ' || 
          RPAD(c.Balance, 8) || ' | ' || 
          c.IsVIP
      );
  END LOOP;

  DBMS_OUTPUT.PUT_LINE(CHR(10));

  DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');
  DBMS_OUTPUT.PUT_LINE('UPDATED LOANS TABLE');
  DBMS_OUTPUT.PUT_LINE('LoanID | CustID | Interest Rate | Due Date');
  DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');

  FOR l IN (SELECT * FROM Loans ORDER BY LoanID) LOOP
      DBMS_OUTPUT.PUT_LINE(
          RPAD(l.LoanID, 6) || ' | ' || 
          RPAD(l.CustomerID, 6) || ' | ' || 
          RPAD(l.InterestRate, 13) || ' | ' || 
          TO_CHAR(l.DueDate, 'DD-MON-YYYY')
      );
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');
END;
/