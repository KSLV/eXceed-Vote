create table nballot (
  id                        integer auto_increment not null,
  user_id                   integer,
  question_id               integer,
  ballot                    integer,
  constraint pk_nballot primary key (id))
;

create table question_description (
  id                        integer auto_increment not null,
  name                      varchar(255),
  maxballot                 integer,
  constraint pk_question_description primary key (id))
;

create table team_description (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_team_description primary key (id))
;

create table user (
  id                        integer auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  surename                  varchar(255),
  constraint pk_user primary key (id))
;

create table vote_log (
  user_id                   integer,
  question_id               integer,
  team_id                   integer,
  time                      datetime)
;

alter table nballot add constraint fk_nballot_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_nballot_user_1 on nballot (user_id);
alter table nballot add constraint fk_nballot_question_2 foreign key (question_id) references question_description (id) on delete restrict on update restrict;
create index ix_nballot_question_2 on nballot (question_id);


