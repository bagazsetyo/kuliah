create database if not exists hotel;

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
    foreign key (id_kamar) references kamar(id),
    foreign key (id_user) references users(id),
    foreign key (voucher_id) references voucher(id)
) engine=innodb;