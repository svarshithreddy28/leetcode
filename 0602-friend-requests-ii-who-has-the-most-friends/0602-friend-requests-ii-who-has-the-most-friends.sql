# Write your MySQL query statement below
select m.id,count(m.id) as num from 
((select accepter_id as id
from requestaccepted)
union all
(select requester_id as id
from requestaccepted)) as m
group by m.id
order by count(m.id) desc
limit 1;