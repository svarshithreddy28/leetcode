# Write your MySQL query statement below
select e1.employee_id,e1.department_id 
from employee e1
group by e1.employee_id
having count(*)=1
union all
select e2.employee_id,e2.department_id
from employee e2
where primary_flag='Y';