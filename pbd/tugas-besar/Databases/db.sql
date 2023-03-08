create database if not exists hotel;

use hotel;

create table jabatan (
    id int auto_increment primary key,
    nama varchar(255) not null,
    gaji int not null,
    tunjangan int not null,
    jam_kerja varchar(20) default '08:00:00'
) engine=innodb;

CREATE table users (
    id INTEGER PRIMARY KEY auto_increment,
    id_jabatan INTEGER,
    nama VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    tgl_masuk DATE,
    tgl_lahir DATE,
    alamat VARCHAR(255),
    foreign key (id_jabatan) references jabatan(id)
) engine=innodb;

create table voucher (
    id INTEGER PRIMARY KEY auto_increment,
    kode varchar(20),
    potongan int not null,
    stock int not null
) engine=innodb;

create table kamar (
    id INTEGER PRIMARY KEY auto_increment,
    nama varchar(255) not null,
    harga int not null,
    tipe_kamar varchar(255) not null,
    nomor_kamar varchar(255) not null,
    keterangan varchar(255) not null,
    status varchar(255) not NULL
) engine=innodb;

create table maintenance (
    id INTEGER PRIMARY KEY auto_increment,
    id_kamar INTEGER not null,
    id_user INTEGER not null,
    tanggal date not null,
    keterangan varchar(255) not null,
    status varchar(255) not null,
    foreign key (id_kamar) references kamar(id),
    foreign key (id_user) references users(id)
) engine=innodb;

create table reservasi (
    id INTEGER PRIMARY KEY auto_increment,
    id_kamar INTEGER not null,
    id_user INTEGER not null,
    tanggal_masuk date not null,
    tanggal_keluar date not null,
    keterangan varchar(255) not null,
    voucher_id INTEGER not null,
    nama varchar(255) not null,
    foreign key (id_kamar) references kamar(id),
    foreign key (id_user) references users(id),
    foreign key (voucher_id) references voucher(id)
) engine=innodb;

insert into jabatan (id, nama, gaji, tunjangan, jam_kerja) values 
(1, 'Manager', 5000000, 1000000, '08:00:00'),
(2, 'Kasir', 3000000, 500000, '08:00:00'),
(3, 'Koki', 3000000, 500000, '08:00:00'),
(4, 'Pelayan', 3000000, 500000, '08:00:00'),
(5, 'Satpam', 3000000, 500000, '08:00:00');

insert into users (id, id_jabatan, nama, username, password, tgl_masuk, tgl_lahir, alamat) values 
(1, 1, 'Bagas', 'bagas', 'bagas', '2016-11-11', '1990-11-01', 'Jl. Jalan'),
(2, 2, 'Roni', 'roni', 'roni', '2015-10-21', '1991-01-11', 'Jl. Jalan'),
(3, 3, 'Diko', 'diko', 'diko', '2014-04-03', '1992-12-14', 'Jl. Jalan'),
(4, 4, 'Asep', 'asep', 'asep', '2014-05-27', '1993-11-22', 'Jl. Jalan'),
(5, 4, 'Siti', 'siti', 'siti', '2012-05-26', '1993-04-21', 'Jl. Jalan'),
(6, 5, 'Diki', 'diki', 'diki', '2019-08-21', '1991-03-31', 'Jl. Jalan'),
(7, 3, 'Kak Seto', 'seto', 'seto', '2020-11-01', '2000-12-01', 'Jl. Jalan'),
(8, 3, 'Windah', 'windah', 'windah', '2021-12-14', '1999-01-01', 'Jl. Jalan'),
(9, 2, 'Kelvin', 'kelvin', 'kelvin', '2019-01-04', '1999-10-19', 'Jl. Jalan');

insert into voucher (id, kode, potongan, stock) values 
(1, 'PROMO1', 100000, 10),
(2, 'PROMO2', 200000, 10),
(3, 'PROMO3', 300000, 10),
(4, 'PROMO4', 400000, 10),
(5, 'PROMO5', 500000, 10);

insert into kamar (id, nama, harga, tipe_kamar, nomor_kamar, keterangan, status) values 
(1, 'Kamar 1', 1000000, 'VIP I', '1', 'Kamar VIP', 'Kosong'),
(2, 'Kamar 2', 1000000, 'VIP II', '2', 'Kamar VIP', 'Kosong'),
(3, 'Kamar 3', 1000000, 'VIP III', '3', 'Kamar VIP', 'Kosong'),
(4, 'Kamar 4', 1000000, 'VIP III', '4', 'Kamar VIP', 'Kosong'),
(5, 'Kamar 5', 1000000, 'VIP III', '5', 'Kamar VIP', 'Kosong');

insert into maintenance (id_kamar, id_user, tanggal, keterangan, status) values 
(1, 1, '2019-01-15', 'Kamar 1 rusak' , 'Selesai'),
(2, 1, '2020-11-11', 'Kamar 2 rusak' , 'Selesai'),
(3, 1, '2020-02-24', 'Kamar 3 rusak' , 'Perbaikan'),
(4, 1, '2021-08-25', 'Kamar 4 rusak' , 'Selesai'),
(5, 1, '2022-04-30', 'Kamar 5 rusak' , 'Perbaikan');

insert into reservasi (id_kamar, id_user, tanggal_masuk, tanggal_keluar, keterangan, voucher_id, nama) values 
(1, 1, '2019-01-01', '2019-01-02', 'Reservasi 1' , 1, 'Reservasi 1'),
(2, 1, '2019-01-01', '2019-01-02', 'Reservasi 2' , 2, 'Reservasi 2'),
(3, 1, '2019-01-01', '2019-01-02', 'Reservasi 3' , 3, 'Reservasi 3'),
(4, 1, '2019-01-01', '2019-01-02', 'Reservasi 4' , 4, 'Reservasi 4'),
(5, 1, '2019-01-01', '2019-01-02', 'Reservasi 5' , 5, 'Reservasi 5');

SELECT kamar.*, maintenance.status FROM kamar 
join maintenance on maintenance.id_kamar = kamar.id
