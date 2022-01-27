drop table emp cascade constraints;
drop table dept cascade constraints;
drop table emp_locations cascade constraints;
drop table emp_countries cascade constraints;

create table emp
as
select * from employees;

create table dept
as
select * from departments;


create table emp_locations
as
select * from locations;

create table emp_countries
as
select * from countries;

create sequence seq_emp_loc_id start with 3300 increment by 100 nocycle; 
create sequence seq_dept_id start with 280 increment by 10; 
create sequence seq_emp  start with 210 increment by 1;
    
alter table emp add primary key(employee_id);
alter table dept add primary key(department_id);
alter table emp_locations add primary key(location_id);
alter table emp_countries add primary key(country_id);

alter table emp add foreign key(department_id) references dept;
alter table emp add foreign key(manager_id) references emp;
alter table dept add foreign key(location_id) references emp_locations ;
alter table dept add foreign key(manager_id) references emp ;
alter table emp_locations add foreign key(country_id) references emp_countries;

