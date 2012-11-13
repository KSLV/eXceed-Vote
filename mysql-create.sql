create table nballot (
  id                        integer auto_increment not null,
  user_pass_db_id           integer,
  question_id               integer,
  ballot                    integer,
  constraint pk_nballot primary key (id))
;

create table question_description (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_question_description primary key (id))
;

create table question_total (
  id                        integer auto_increment not null,
  constraint pk_question_total primary key (id))
;

create table score (
  id                        integer auto_increment not null,
  constraint pk_score primary key (id))
;

create table team_discription (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_team_discription primary key (id))
;

create table team_score (
  id                        integer auto_increment not null,
  constraint pk_team_score primary key (id))
;

create table user (
  id                        integer auto_increment not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;

create table uservote (
  id                        integer auto_increment not null,
  score                     integer,
  constraint pk_uservote primary key (id))
;

alter table nballot add constraint fk_nballot_userPassDB_1 foreign key (user_pass_db_id) references user (id) on delete restrict on update restrict;
create index ix_nballot_userPassDB_1 on nballot (user_pass_db_id);
alter table nballot add constraint fk_nballot_question_2 foreign key (question_id) references question_description (id) on delete restrict on update restrict;
create index ix_nballot_question_2 on nballot (question_id);
alter table question_total add constraint fk_question_total_score_3 foreign key (id) references score (id) on delete restrict on update restrict;
create index ix_question_total_score_3 on question_total (id);
alter table team_score add constraint fk_team_score_question_total_4 foreign key (id) references question_total (id) on delete restrict on update restrict;
create index ix_team_score_question_total_4 on team_score (id);
alter table uservote add constraint fk_uservote_team_score_5 foreign key (id) references team_score (id) on delete restrict on update restrict;
create index ix_uservote_team_score_5 on uservote (id);


