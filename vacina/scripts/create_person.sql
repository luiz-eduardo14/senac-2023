use vacina;
create table person (
  id int auto_increment primary key,
  name varchar(255) not null,
  age integer not null,
  sex ENUM('M', 'F') not null,
  dateOfBirth date not null,
  cpf text not null
);