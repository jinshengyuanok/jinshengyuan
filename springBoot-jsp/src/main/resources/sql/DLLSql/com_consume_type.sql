create table com_consume_type
(
  consume_type_code char(2)     not null
  comment '消费类型编码'
    primary key,
  consume_type_name varchar(50) null
  comment '消费类型名称',
  valid_flag        char        null
  comment '有效标志,1:有效;0:无效'
)
  comment '消费类型表';

