
CREATE TABLE Fall22_S004_7_Admins(
    AdminID number NOT NULL PRIMARY KEY,
    Password varchar(30),
    Name varchar(25)
);
CREATE TABLE Fall22_S004_7_CUSTOMER(
custId number NOT NULL,
		Name varchar(25),
		DOB date,
		Joining_date date,
		Email varchar(25),
		Street varchar(25),
		Zip number NOT NULL,
		City varchar(25),
		Country varchar(25),
		Phone_no number,
		Password varchar(25) NOT NULL,
		PRIMARY KEY (custid)
);
CREATE TABLE Fall22_S004_7_Supplier(
    SupplierID number not null, 
    Name varchar2(25),
    email varchar2(25),
    phoneno number,
    City varchar2(10),
    Zip number not null,
    AdminID number,
    Primary key(SupplierID),
    FOREIGN KEY (AdminID) REFERENCES Fall22_S004_7_Admins(AdminID) On delete cascade
  );
CREATE TABLE Fall22_S004_7_Product(
    ProductID number not null, 
    Supplied_Qty number,
    Selling_Price float,
    Cost_price float,
    SupplierID number,
    Primary key(ProductID),
    FOREIGN KEY (SupplierID) REFERENCES Fall22_S004_7_Supplier(SupplierID) On delete cascade
  );

CREATE TABLE Fall22_S004_7_ORDER(
Orderid number NOT NULL,
		Order_date date NOT NULL,
		Total_amt float,
		Qty number,
		Custid number,
		Productid number,
		PRIMARY KEY(orderid),
		FOREIGN KEY(custid) REFERENCES Fall22_S004_7_CUSTOMER(custId) on delete cascade,
		FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_PRODUCT(ProductID) on delete cascade
);
CREATE TABLE Fall22_S004_7_CUSTOMERFEEDBACK(
		custfeedbackId number NOT NULL,
		feed_date date,
		comments varchar(50),
		ratings float NOT NULL,
		custid number,  
		productid number,
		PRIMARY KEY(custfeedbackId),
		FOREIGN KEY(custid) REFERENCES Fall22_S004_7_CUSTOMER(custId) on delete cascade,
		FOREIGN KEY(productid) REFERENCES Fall22_S004_7_PRODUCT(productid)on delete cascade
);


CREATE TABLE Fall22_S004_7_Product_Category(
    ProductID number not null, 
    Product_Category varchar(20) not null,
    Primary key(ProductID,Product_Category),
    FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_Product(ProductID) On delete cascade
  );
CREATE TABLE Fall22_S004_7_Product_Size(
    ProductID number not null, 
    Product_Size varchar(10) not null,
    Primary key(ProductID,Product_Size),
    FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_Product(ProductID) On delete cascade
  );
CREATE TABLE Fall22_S004_7_Product_color(
    ProductID number not null, 
    Product_color varchar(15) not null,
    Primary key(ProductID,Product_color),
    FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_Product(ProductID) On delete cascade
  );
CREATE TABLE Fall22_S004_7_Product_Brand(
    ProductID number not null, 
    Product_brand varchar2(20) not null,
    Primary key(ProductID,Product_brand),
    FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_Product(ProductID) On delete cascade
  );
CREATE TABLE Fall22_S004_7_Product_gender(
    ProductID number not null, 
    Product_gender varchar(10) not null,
    Primary key(ProductID,Product_gender),
    FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_Product(ProductID) On delete cascade
  );
CREATE TABLE Fall22_S004_7_Inventory(
    InventoryID number not null, 
    Qty_Avail number,
    Min_Qty number,
    Productid number ,
    Primary key(InventoryID),
    FOREIGN KEY (ProductID) REFERENCES Fall22_S004_7_Product(ProductID) On delete cascade
  );
