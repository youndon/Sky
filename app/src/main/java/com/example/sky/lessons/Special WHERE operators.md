## Special WHERE operators

You already know how to write complex SQL queries and logical expressions. In this topic, we will go further and take a look at the special WHERE operators: BETWEEN, IN, LIKE, EXISTS, ANY, IS NULL and IS DISTINCT FROM that will make your queries more advanced and readable.

##### BETWEEN operator

The **BETWEEN operator** in WHERE clause selects values that are within the given range. The range is set by the minimum and maximum values and can include dates, numbers, or text data. The **BETWEEN operator** is inclusive, so the minimum and maximum values are included in the range.

Let's select products with a price greater than or equal to 8 and less than or equal to 13 from the table *products* given below.

| product | price |
| ------- | ----- |
| milk    | 10    |
| tofu    | 15    |
| pasta   | 12    |
| bread   | 8     |

The query with WHERE BETWEEN will look as follows:

```sql
SELECT
    product 
FROM
    products 
WHERE 
    price BETWEEN 8 AND 13; 
```

The result set of the query above will have three rows:

| product |
| ------- |
| milk    |
| pasta   |
| bread   |

You can also get the same result set with the query without BETWEEN:

```sql
SELECT
    product 
FROM
    products 
WHERE 
    (price >= 8 
     AND price <= 13); 
```

so you can think of WHERE BETWEEN as a shorthand for >= AND <= in WHERE clause.

To select all the products outside of the range you can use **NOT BETWEEN operator**:

```sql
SELECT
    product 
FROM
    products 
WHERE 
    price NOT BETWEEN 8 AND 13; 
```

The result set will have three rows excluded now:

| product |
| ------- |
| tofu    |

##### IN operator

The **IN operator in WHERE clause** is a shorthand to multiple OR conditions and allows to specify multiple values.

Let's select products with price equal to 10 or 12 or 16 from the table *products* from the previous example:

```sql
SELECT
    product 
FROM
    products 
WHERE
    price IN (10, 12, 16); 
```

The result of this query looks like this:

| product |
| ------- |
| milk    |
| pasta   |

To select products with prices other than 10, 12, or 16 you can negate IN operator using NOT:

```sql
SELECT
    product 
FROM
    products 
WHERE
    price NOT IN (10, 12, 16); 
```

With this query, you will get all the products except 'milk' and 'pasta':

| product |
| ------- |
| tofu    |
| bread   |

##### LIKE operator

The **LIKE operator** can be used in the WHERE clause to check if a string matches a **pattern**. To create a pattern you can use two **wildcard match options**: '%' and '_'.

The **'%'** represents any number of characters: zero, one, or more. For example, if you write a pattern '%s%', the strings 's', 'toaster', 'string', and 'cats' will all match this pattern.

The **'_'** represents exactly one character. Thus, if you write pattern 's_', the string 'so' will match this pattern, but the strings 's' and 'soap' will not.

Let's select all the products with the letter 'a' in any position from our *products* table:

```sql
SELECT
    product 
FROM
    products 
WHERE
    product LIKE '%a%'; 
```

The query will return this table:

| product |
| ------- |
| pasta   |
| bread   |

As with BETWEEN and IN operator, you can negate LIKE operator with NOT to get all the products without the 'a' in the product name:

```sql
SELECT
    product 
FROM
    products
WHERE
    product NOT LIKE '%a%';
```

##### EXISTS operator

The **EXISTS operator** checks if the subquery returns any records or not. If the subquery returns any records, the EXISTS operator will return TRUE, otherwise, it will return FALSE.

Let's consider the following table *suppliers*:

| supplier   | product |
| ---------- | ------- |
| Good food  | pasta   |
| Happy farm | milk    |
| Good food  | milk    |
| Happy farm | bread   |
| Good food  | cheese  |

We will use the EXISTS operator to select all the suppliers who supply both milk and pasta:

```sql
SELECT DISTINCT
    supplier 
FROM
    suppliers AS milk_suppliers
WHERE
    product = 'milk'
    AND EXISTS
(SELECT supplier
FROM
    suppliers 
WHERE
    product = 'pasta'
    AND supplier = milk_suppliers.supplier);
                         
```

In our case the query result looks as follows:

| supplier  |
| --------- |
| Good food |

The negated EXISTS operator returns FALSE if the subquery returns any records and TRUE otherwise. We can modify our previous query to get the suppliers who supply milk but not pasta:

```sql
SELECT DISTINCT 
    supplier 
FROM
    suppliers AS milk_suppliers
WHERE
    product = 'milk'
    AND NOT EXISTS 
(SELECT
    supplier
FROM
    suppliers 
WHERE 
    product = 'pasta'
    AND supplier = milk_suppliers.supplier);
                         
```

This query will return this table:

| supplier   |
| ---------- |
| Happy farm |

##### ANY operator

The **ANY operator** returns TRUE if any of the subquery values meet the condition.

Let's use our tables *products* and *suppliers* and use ANY operator to find the supplier who supplies a product that is not listed in the *products* table:

```sql
SELECT DISTINCT
    supplier
FROM
    suppliers
WHERE
    NOT product = ANY (SELECT product FROM products);
```

The result of this query looks like this:

| supplier  |
| --------- |
| Good food |

The ANY operator can be used only after standard comparison operators such as =, !=, <=, etc.

##### IS NULL operator

The **IS NULL operator** returns TRUE if the value in the column is equal to NULL.

Let's consider the *persons* table given below:

| name       | city     |
| ---------- | -------- |
| John Oh    | New-York |
| Eve Comer  | NULL     |
| Kim Wilson | London   |

We can use IS NULL operator to select all rows without the information about the city from the *persons* table:

```sql
SELECT
    name 
FROM
    persons 
WHERE
    city IS NULL;
```

The query result will look as follows:

| name      |
| --------- |
| Eve Comer |

We can also use **IS NOT NULL operator** to select all rows where the city is non-null:

```sql
SELECT
    name
FROM
    persons
WHERE
    city IS NOT NULL;
```

##### IS DISTINCT FROM operator

The **IS DISTINCT FROM operator** is very similar to not equality check (!= or <>). This operator checks if two values are equal and returns FALSE in case it's true and TRUE otherwise. If both values are equal to NULL, the IS DISTINCT FROM operator will return FALSE, which distinguishes IS DISTINCT FROM operator from the standard not equality check.

Let's select all the rows where the city is not equal to New-York from the *persons* table:

```sql
SELECT
    * 
FROM
    persons 
WHERE
    city IS DISTINCT FROM 'New-York'; 
```

The query above will select two rows:

| name       | city   |
| ---------- | ------ |
| Eve Comer  | NULL   |
| Kim Wilson | London |

The operator with negation IS NOT DISTINCT FROM works as an equality check for non-null values and returns TRUE if both values are NULL.

Let's select all the rows where the city is equal to NULL from the *persons* table:

```sql
SELECT
    *
FROM
    persons
WHERE
    city IS NOT DISTINCT FROM NULL;
```

This query will return this row:

| name      | city |
| --------- | ---- |
| Eve Comer | NULL |

##### Conclusion

The special WHERE operators allow you to make your queries simpler and more advanced with a subquery.