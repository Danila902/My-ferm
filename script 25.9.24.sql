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
    user_id integer not null
        constraint "FK_user_id_to_id"
            references "user",
    role    integer not null,
    id      integer not null
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

create table price
(
    name    varchar(50) not null,
    weight  integer     not null,
    id      integer     not null
        constraint key_name
            primary key,
    price   integer     not null,
    pet_id  integer
        constraint price_pet_id_fk
            references pet,
    time_id integer
        constraint price___fk2
            references time
);

alter table price
    owner to postgres;

create table buy
(
    price_id integer not null
        constraint "FK_price_id"
            references price,
    weight   integer not null,
    id       integer not null
        constraint buy_id
            primary key,
    time_id  integer not null
        constraint "FK_time_id"
            references time
);

alter table buy
    owner to postgres;

create table sell
(
    price_id integer,
    weight   integer,
    id       integer,
    time_id  integer
);

alter table sell
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


