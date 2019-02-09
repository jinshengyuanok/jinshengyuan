create table if not exists tb_consume_record
(
	id varchar(32) not null
		primary key,
	goods_name varchar(50) not null comment '商品名称',
	goods_amount int not null comment '商品数量',
	goods_price decimal(9,2) not null comment '商品单价',
	money decimal(9,2) not null comment '消费金额',
	user_id varchar(32) not null comment '消费者id',
	consume_type_code char(2) not null comment '消费类型编码',
	consume_date datetime not null comment '消费日期',
	remark varchar(1000) null comment '备注',
	valid_flag char default '1' null comment '有效标志,1:有效;0:无效'
)
comment '消费记录表';

