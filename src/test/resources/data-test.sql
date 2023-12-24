-- Insert data into the BRANDS table
INSERT INTO BRANDS (NAME) VALUES
    ('Brand1'),
    ('Brand2'),
    ('Brand3');

-- Insert data into the PRODUCTS table
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION)
VALUES ('35455', 'Product1', 'Description1'),
       ('35456', 'Product2', 'Description2'),
       ('35457', 'Product3', 'Description3');

-- Insert data into the PRIORITY table
INSERT INTO PRIORITY (ID, NAME)
VALUES ('0', 'Priority1'),
       ('1', 'Priority2'),
       ('2', 'Priority3');

-- Insert data into the PRICES table
INSERT INTO PRICES (BRAND_ID, PRODUCT_ID, START_DATE, END_DATE, PRIORITY_ID, PRICE_LIST_ID, PRICE, CURR)
VALUES (1, '35455', '2020-06-14 00:00:00', '2020-12-31 23:59:59', '0', 1, 35.5, 'EUR'),
       (1, '35455', '2020-06-14 15:00:00', '2020-06-14 18:30:00', '1', 2, 25.45, 'EUR'),
       (1, '35455', '2020-06-15 00:00:00', '2020-06-15 11:00:00', '1', 3, 30.5, 'EUR'),
       (1, '35455', '2020-06-15 16:00:00', '2020-12-31 23:59:59', '1', 4, 38.95, 'EUR');
