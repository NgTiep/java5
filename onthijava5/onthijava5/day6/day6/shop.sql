CREATE TABLE category (
    id INT PRIMARY KEY IDENTITY (1, 1),
    name VARCHAR (100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL
);

CREATE TABLE product (
    id INT PRIMARY KEY IDENTITY (1, 1),
    name VARCHAR (100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL,
    price int NOT NULL,
    category_id INT NOT NULL,
    create_date DATE NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE product_attribute (
    id INT PRIMARY KEY IDENTITY (1, 1),
    name VARCHAR (100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL,
    value VARCHAR(100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id)
);
