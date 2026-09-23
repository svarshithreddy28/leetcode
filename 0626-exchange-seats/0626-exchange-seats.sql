# Write your MySQL query statement below
select id,if(id mod 2=0,lag(student) over(order by id),ifnull(lead(student) over(order by id),student)) as student from Seat;