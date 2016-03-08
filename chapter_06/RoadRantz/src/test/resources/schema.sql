drop table if exists rant;

create table rant (
  id identity,
  rantText varchar(25) not null,
  postedDate date not null
);
