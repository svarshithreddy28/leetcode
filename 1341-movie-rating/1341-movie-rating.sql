# Write your MySQL query statement below
(select u.name as results
from Users u
join movierating m on u.user_id=m.user_id
group by u.name
order by count(*) desc,u.name
limit 1)
union all
(select m.title as results
from movies m
join movierating mr on m.movie_id=mr.movie_id
where month(created_at)=2 and year(created_at)=2020
group by m.title
order by avg(rating) desc,m.title
limit 1);


