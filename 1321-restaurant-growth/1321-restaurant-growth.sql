# Write your MySQL query statement below
select visited_on,s as amount,round(s/7,2) as average_amount
from (
select distinct(visited_on),sum(amount) over(order by visited_on range between interval 6 day preceding and current row) as s,
min(visited_on) over(order by visited_on) as date1
from Customer) as d
where visited_on>=d.date1+6
order by visited_on;