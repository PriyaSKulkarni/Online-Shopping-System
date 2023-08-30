UPDATE Fall22_s004_7_product_category
SET Product_category = 'Tshirt'
WHERE Productid = 108;

UPDATE Fall22_s004_7_product
SET Selling_price= '100' 
WHERE Productid = 134;

delete from fall22_s004_7_customer where custid=34;

INSERT INTO Fall22_S004_7_CUSTOMER VALUES('63','Sonali',To_date('26/10/1987','dd/mm/yyyy'),To_date('23/08/2012','dd/mm/yyyy'),'sonali@gmail.com','N San Bernardo','75089','Dallas','United states','9082158975','sonali21');
INSERT INTO Fall22_S004_7_CUSTOMER VALUES('64','Priyanka',To_date('13/04/2002','dd/mm/yyyy'),To_date('14/09/2021','dd/mm/yyyy'),'priyanka@gmail.com','main','75089','Dallas','United states','6798681019','priyanka73654');

INSERT INTO  Fall22_S004_7_ORDER
VALUES('66', to_date('21/09/2022','dd/mm/yyyy') ,'702','1','63','128');
INSERT INTO  Fall22_S004_7_ORDER
VALUES('67', to_date('12/08/2022','dd/mm/yyyy'),'105.84','1','64','122');
