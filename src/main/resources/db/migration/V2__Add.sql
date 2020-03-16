insert into contact_data_table (id, mobilephone, email, github, skype, linkedin)
  values
  (1, '+375(29)123-45-67', 'petrovich@gmail.com', 'http://github.com/petya',null,null),
  (2, '+375(29)87-65-43', null, 'http://github.com/vanya','skype:ivanko',null),
  (3, '+375(29)999-99-99', null, null, null,'https://www.linkedin.com/in/mariya/');

insert into person_table (id, first_name, last_name, middle_name, gender, birthdate, contact_data_id)
  values
  (1,'Петр', 'Петров', 'Петрович', 'M', '1986-12-12', 1),
  (2,'Иван', 'Иванов', 'Иванович', 'M', '1997-4-4', 2),
  (3,'Мария', 'Морская', 'Васильевна', 'F', '1999-11-07', 3);

insert into technologies_table (id, technology_name)
values (1, 'Git'),(2, 'Spring Boot'),(3, 'HTML'),(4, 'JavaEE'),(5, 'Java Core'),(6, 'Maven'),(7, 'Rest'),(8, 'Spring');

insert into person_technologies_table (id, person_id, technology_id)
  values
  (1, 1, 1),
  (2, 1, 2),
  (3, 1, 3),
  (4, 2, 1),
  (5, 2, 4),
  (6, 2, 5),
  (7, 3, 6),
  (8, 3, 7),
  (9, 3, 8);

insert into cv_table (id, person_id)
  values
  (1,1), (2,2), (3,3);