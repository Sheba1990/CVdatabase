create table cv_table (
  id bigint not null auto_increment,
  person_id bigint,
  primary key (id)
) engine=InnoDB;

create table person_table (
  id bigint not null auto_increment,
  first_name varchar(255) not null,
  last_name varchar(255) not null,
  middle_name varchar(255),
  gender varchar(255) not null,
  birthdate date,
  contact_data_id bigint,
  primary key (id)
) engine=InnoDB;

create table contact_data_table (
  id bigint not null auto_increment,
  mobilephone varchar(255),
  email varchar(255),
  github varchar(255),
  skype varchar(255),
  linkedin varchar(255),
  primary key (id)
) engine=InnoDB;

create table technologies_table (
  id bigint not null auto_increment,
  technology_name varchar(255) not null,
  primary key (id)
) engine=InnoDB;

create table person_technologies_table (
  id bigint not null auto_increment,
  person_id bigint,
  technology_id bigint,
  primary key (id)
) engine=InnoDB;

alter table cv_table
  add constraint personidfk
  foreign key (person_id) references person_table (id);

alter table person_table
  add constraint contact_data_fk
  foreign key (contact_data_id) references contact_data_table (id);

alter table person_technologies_table
  add constraint person_idfk
  foreign key (person_id) references person_table (id);

alter table person_technologies_table
  add constraint technology_idfk
  foreign key (technology_id) references technologies_table (id);