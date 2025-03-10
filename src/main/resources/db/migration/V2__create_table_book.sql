CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    customer_id INT NOT NULL,
    Foreign Key (customer_id) references customers(id)
);
