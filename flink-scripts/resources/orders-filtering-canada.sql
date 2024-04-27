-- source
CREATE TABLE orders (
    amount DOUBLE,
    country VARCHAR,
    description VARCHAR,
    order_timestamp  VARCHAR
) WITH (
    'connector' = 'kafka',
    'properties.bootstrap.servers' = '',
    'scan.startup.mode' = 'earliest-offset',
    'topic' = 'orders',
    'value.format' = 'json'
)

-- sink
CREATE TABLE orders_canada (
    amount DOUBLE,
    country VARCHAR,
    description VARCHAR,
    order_timestamp VARCHAR 
) WITH (
    'connector' = 'kafka',
    'properties.bootstrap.servers' = '',
    'scan.startup.mode' = 'earliest-offset',
    'topic' = 'orders_canada',
    'value.format' = 'json'
)

-- filter
INSERT INTO orders_canada
SELECT 
    o.amount,
    o.country,
    o.description,
    o.order_timestamp
 from orders o
 where o.country = 'Canada'