# Write your MySQL query s_tatement below
select Department,Employee,Salary from 
(select d.name as Department,e.name as Employee,e.salary,dense_rank() over (partition by d.name order by e.salary desc) as rnk
from employee e
left join department d on e.departmentId=d.id) as x
where x.rnk<=3;