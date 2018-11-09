create table Product
(
	id BIGINT AUTO_INCREMENT not null,
	name LONGVARCHAR not null,
	quantity integer not null,
	brand VARCHAR(1024),
	category VARCHAR(1024),
	netPrice  DECIMAL(10,2) not null,
	grossPrice DECIMAL(10,2) not null,
	taxRate integer not null,
	quantityInWarehouse integer not null,
	quantityInStore integer not null,
	Unit VARCHAR(1024) not null,
	primary key(id)
);

create table Orders
(
	id BIGINT  AUTO_INCREMENT not null,
	netPrice  DECIMAL(10,2) not null,
	grossPrice DECIMAL(10,2) not null,
	dateAndTime DATETIME  not null,
	employeeId integer not null,
 	cashdeskId integer not null,
 	primary key(id)
 	
);

create table OrderDetails
(
	orderDetailsId BIGINT AUTO_INCREMENT not null,	
	orderId	BIGINT not null,
	productId BIGINT not null,	
	quantity integer not null,
	primary key(orderDetailsId)
	/*foreign key(productId) REFERENCES Product(id)*/
	/*foreign key(orderId) REFERENCES Orders(id)*/
);

create table Supplier
(
	id BIGINT AUTO_INCREMENT not null,
	name VARCHAR(1024) not null,
	adress VARCHAR(1024) not null,
	comment VARCHAR(1024),
	phoneNumber BIGINT not null,
	email VARCHAR(320) not null,
	primary key(id)
);

create table Supply
(
	id BIGINT  AUTO_INCREMENT not null,
	netSum  DECIMAL(10,2) not null,
	grossSum DECIMAL(10,2) not null,
	dateAndTime DATETIME  not null,
	supplierId BIGINT not null,
 	primary key(id)
);

create table SupplyDetails
(
	supplyDetailsId BIGINT AUTO_INCREMENT not null,	
	supplyId	BIGINT not null,
	productId BIGINT not null,	
	quantity integer not null,
	primary key(supplyDetailsId)
);
