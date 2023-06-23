-- Create the database
CREATE DATABASE bookstore;

-- Switch to the bookstore database
USE bookstore;

-- Create the books table
CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  publication_year INT NOT NULL
);

-- Insert some sample data into the books table
INSERT INTO books (title, author, publication_year) VALUES
  ('Book 1', 'Author 1', 2020),
  ('Book 2', 'Author 2', 2018),
  ('Book 3', 'Author 3', 2021);
