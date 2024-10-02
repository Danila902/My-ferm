create table "user"
(
    id        integer     not null
        constraint user_id
            primary key,
    user_name varchar(50) not null,
    wallet_id integer     not null,
    password  varchar(50) not null
);

alter table "user"
    owner to postgres;

create table user_role
(
    user_id integer                  not null
        constraint "FK_user_id_to_id"
            references "user",
    role    varchar(50) default USER not null,
    id      integer                  not null
        constraint role_id
            primary key
);

alter table user_role
    owner to postgres;

create table time
(
    id   integer   not null
        constraint time_id
            primary key,
    time timestamp not null
);

alter table time
    owner to postgres;

create table pet
(
    id      integer     not null
        constraint id_pet
            primary key,
    name    varchar(50) not null,
    user_id integer     not null
        constraint "FK_user_id"
            references "user",
    time_id integer
        constraint "FK_time_id"
            references time,
    mome_id integer
        constraint "FK_mome_id"
            references pet,
    dad_id  integer
        constraint "FK_dad_id"
            references pet
);

alter table pet
    owner to postgres;

create table wallet
(
    id      integer not null
        constraint id
            primary key,
    user_id integer not null
        constraint "FK_user_id"
            references "user",
    sum     integer not null,
    time_id integer not null
        constraint "FK_time_id"
            references time
);

alter table wallet
    owner to postgres;

alter table "user"
    add constraint foreign_key_name
        foreign key (wallet_id) references wallet;

create table client
(
    id         integer     not null
        constraint id_client
            primary key,
    first_name varchar(50) not null,
    last_name  varchar(50)
);

alter table client
    owner to postgres;

create table measurment_unit
(
    id        integer     not null
        constraint unit_id
            primary key,
    unit_name varchar(50) not null
);

alter table measurment_unit
    owner to postgres;

create table price
(
    name    varchar(50) not null,
    unit_id integer     not null
        constraint fk3
            references measurment_unit,
    id      integer     not null
        constraint price_id
            primary key,
    price   integer     not null
);

alter table price
    owner to postgres;

create table buy
(
    price_id  integer           not null
        constraint "FK_price_id"
            references price,
    quantity  integer default 0 not null,
    id        integer           not null
        constraint buy_id
            primary key,
    time_id   integer           not null
        constraint "FK_time_id"
            references time,
    client_id integer           not null
        constraint "FK3_client_id"
            references client
);

alter table buy
    owner to postgres;

create table sell
(
    price_id  integer
        constraint "FK1_price_id"
            references price,
    quantity  numeric default 0 not null,
    id        integer           not null
        constraint sell_pk
            primary key,
    time_id   integer
        constraint "FK2_data_id"
            references time,
    client_id integer           not null
        constraint "FK3_client_id"
            references client
);

alter table sell
    owner to postgres;


