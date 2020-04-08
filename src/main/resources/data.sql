DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  employee_code VARCHAR(20) DEFAULT NULL,
  email_address VARCHAR(50) DEFAULT NULL,
  city VARCHAR(20) DEFAULT NULL,
  country VARCHAR(20) DEFAULT NULL
);
 
INSERT INTO employee (first_name, last_name, employee_code, email_address, city, country) VALUES
  ('James', 'Smith', 'EMP000190', 'james@example.com', 'New York City', 'US'),
  ('Michael', 'Smith', 'EMP000191', 'michael@example.com', 'Houston', 'US'),
  ('Maria', 'Garcia', 'EMP000192', 'maria@example.com', 'Mexico City', 'Mexico'),
  ('Valentina', 'Flores', 'EMP000193', 'valentina@example.com', 'Guadalajara', 'Mexico'),
  ('Ashok', 'Das', 'EMP000194', 'ashok@example.com', 'Kolkata', 'India'),
  ('Arunabha', 'Dey', 'EMP000195', 'arunabha@example.com', 'Kolkata', 'India'),
  ('Yuva', 'Raj', 'EMP000196', 'yuva@example.com', 'Hyderabad', 'India'),
  ('Krishna', 'Chaitaniya', 'krishna@example.com', 'EMP000197', 'Hyderabad', 'India'),
  ('Viru', 'Reddy', 'EMP000198', 'viru@example.com', 'Bangalore', 'India'),
  ('Bhavani', 'Reddy', 'EMP000199', 'bhavani@example.com', 'Bangalore', 'India'),
  ('Jon', 'Ewing', 'EMP000200', 'jon@example.com', 'London', 'UK'),
  ('Robert', 'Read', 'EMP000201', 'robert@example.com', 'London', 'UK'),
  ('Sasha', 'Weber', 'EMP000202',  'sasha@example.com', 'Germany', 'Germany');
  