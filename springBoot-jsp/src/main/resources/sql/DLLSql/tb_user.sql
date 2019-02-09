create table tb_user
(
  id            varchar(32)  not null
    primary key,
  user_name     varchar(200) not null,
  password      varchar(100) null,
  email         varchar(50)  null,
  mobile_phone  int          null,
  nick_name     varchar(200) null,
  gender        char         null,
  photo_url     varchar(200) null,
  register_time datetime     null
);

