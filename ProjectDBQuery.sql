/* Query 1:  Which product, brand, color, size, gender is ordered frequently. */

Select d.productID, cat.product_category, sz.product_size, color.product_color, brand.product_brand, gen.product_gender
from (Select a.productID, a.cnt
        from(
            Select productID, count(*) as cnt
              from Fall22_S004_7_ORDER
              Where order_date >= '01-Jul-2022' and order_date <= '30-Sep-2022' Group by productID
              order by cnt desc) a
              where rownum < 2) d , Fall22_S004_7_Product_Category cat, Fall22_S004_7_Product_Size sz, Fall22_S004_7_Product_color color,
Fall22_S004_7_Product_Brand brand , Fall22_S004_7_Product_gender gen Where d.productID=cat.productID
AND d.productID=sz.productID
AND d.productID=color.productID
AND d.productID=brand.productID
AND d.productID=gen.productID;

/* Query 2: Which product, brand, color, size, gender is ordered frequently by customers that generates maximum profit.*/
 
Select d.productID, cat.product_category, sz.product_size, color.product_color, brand.product_brand, gen.product_gender, d.profit, d.cnt
from (select b.productID, b.cnt ,b.profit
From (
Select a.productID, a.cnt, (p.selling_price-p.cost_price) as profit
from(
Select productID, count(*) as cnt
from Fall22_S004_7_ORDER
Where order_date between '01-Jul-2022' and '30-Sep-2022' Group by productID) a, Fall22_S004_7_Product p
Where a.productID=p.productID
Order by profit desc
) b
Fetch first 1 row only ) d, Fall22_S004_7_Product_Category cat, Fall22_S004_7_Product_Size sz, Fall22_S004_7_Product_color color,
Fall22_S004_7_Product_Brand brand , Fall22_S004_7_Product_gender gen Where d.productID=cat.productID
AND d.productID=sz.productID
AND d.productID=color.productID
AND d.productID=brand.productID
AND d.productID=gen.productID;

/* Query 3: Identify the regular customer */

select b.custID, cus.name, b.cnt, round((sysdate-dob)/365) as Age
from(
Select a.custID ,a.cnt
From (
Select custID, count(custID) as cnt
From Fall22_S004_7_ORDER
Where order_date between '01-Jul-2022' and '30-Sep-2022' Group by custID
Order by cnt desc
) a Where rownum < 2
) b , Fall22_S004_7_CUSTOMER cus
where b.custid = cus.custid order by b.cnt desc;

/* Query 4: Identifying the frequency of orders made by customers based on the  location.*/

select a.city ,a.cnt as OrderCount
From
(Select city, count(*) cnt
From Fall22_S004_7_ORDER o, Fall22_S004_7_CUSTOMER cus Where o.custID=cus.custID and order_date between '01-Jul-2022' and '30-Sep-2022' Group by city
Order by cnt desc) a
Fetch first 5 row only;

/* Query 5: Which month of the year has the highest no of orders by the customer based on  product, brand, color, size, gender */

select b.months, b.productID,b.Order_count, cat.product_category, sz.product_size, color.product_color, brand.product_brand, gen.product_gender
From (
select a.months, a.productID,a.Order_count
from(
Select to_char(order_date,'Mon') as months, productID,count(*) as Order_Count
From Fall22_S004_7_ORDER
Where order_date between '01-Jul-2022' and '30-Sep-2022' Group by to_char(order_date,'Mon') ,productID
order by Order_count desc
)a
where rownum <= 1
) b, Fall22_S004_7_Product_Category cat, Fall22_S004_7_Product_Size sz, Fall22_S004_7_Product_color color, Fall22_S004_7_Product_Brand brand ,
Fall22_S004_7_Product_gender gen Where b.productID=cat.productID
AND b.productID=sz.productID
AND b.productID=color.productID
AND b.productID=brand.productID
AND b.productID=gen.productID;

/* Query 6: Which month of the year has the highest number of new registration of what age */

Select c.joining_Mon, c.age_range, cnt
From (
Select b.joining_Mon, b.age_range, count(b.joining_Mon) as cnt
from(
Select custID, joining_Mon,
Case When age<18 then 'under_18' When age>=18 then '18_or_above'
End age_range
From(
select custID, round((sysdate-dob)/365) as age , to_char(Joining_date,'Mon') as joining_Mon
From Fall22_S004_7_CUSTOMER
Where Joining_date between '01-Jan-2022' and sysdate )a
) b
Group by joining_Mon, age_range
order by cnt desc ) c Where rownum < = 2 ;

/* Query 7: Which product of a particular supplier is selling most with good reviews and has a better profit margin for the company */

select s.supplierID, d.ProductId, d.avg_ratings, d.profit
    from(
    select b.ProductId, b.profit, b.avg_ratings, b.SupplierID
	from (Select a.productID, a.avg_ratings, (p.selling_price-p.cost_price) as profit, p.SupplierID
		  from
		  (Select productID, avg(ratings) as avg_ratings
				 From Fall22_S004_7_CUSTOMERFEEDBACK
				 Where feed_date between '01-Jul-2022' and '30-Sep-2022'
				 Group by productID
				 having avg(ratings) > 3
				)a, Fall22_S004_7_Product p
   where a.productid = p.productid
   Order by profit desc) b where
   rownum < 2) d, Fall22_S004_7_Supplier s
   Where d.SupplierID = s.SupplierID;

/* Query 8: Identify the least selling product in the inventory. */

/*least selling product */

select p.ProductID, s.supplierid,s.name as supplier_name, Qty_Avail, Supplied_Qty, ( p.Supplied_Qty - i.Qty_Avail ) as lowest_sale
	from Fall22_S004_7_Inventory i, Fall22_S004_7_Product p, Fall22_s004_7_supplier s
	where i.Productid = p.ProductID and s.supplierid= p.supplierid 
	Order by lowest_sale asc
 fetch first 5 rows only ;

/* most selling product */

select p.ProductID, s.supplierid,s.name as supplier_name, Qty_Avail, Supplied_Qty, ( p.Supplied_Qty - i.Qty_Avail ) as highest_sale
	from Fall22_S004_7_Inventory i, Fall22_S004_7_Product p, Fall22_s004_7_supplier s
	where i.Productid = p.ProductID and s.supplierid= p.supplierid 
	Order by highest_sale desc
 fetch first 5 rows only ;

/*Rollup Query:*/

select  EXTRACT(year FROM order_date) As Year, productid , sum(Total_amt) as Annual_Sales_amount
from Fall22_S004_7_ORDER 
group by rollup ( EXTRACT(year FROM order_date) , productid) order by Year;

/*Cube Query:*/

select  custid , productid, sum(Total_amt) as Amount_for_all_orders
from Fall22_S004_7_ORDER where order_date between '01-Jul-2022' and '30-Sep-2022'
group by cube (productid, custid ) order by custid;

/* Over Query: */

SELECT Distinct Extract( year from Order_Date) AS OrderYear, extract(month from Order_Date) AS OrderMonth, 
	   SUM(total_amt) 
			OVER(PARTITION BY Extract( year from Order_Date), extract(month from Order_Date) 
			     ORDER BY Extract( year from Order_Date), extract(month from Order_Date)) AS Monthly_Revenue, 
		   SUM(Total_amt) 
			OVER(PARTITION BY Extract( year from Order_Date) 
			     ORDER BY extract(month from Order_Date)) AS Running_Revenue_Total
FROM fall22_s004_7_order
ORDER BY Extract( year from Order_Date) , extract(month from Order_Date);
