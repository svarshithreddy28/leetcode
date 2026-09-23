# Write your MySQL query statement below
select person_name from (select person_name,sum(weight) over (order by turn) as x
from Queue) as m
where x<=1000
order by x desc
limit 1;
