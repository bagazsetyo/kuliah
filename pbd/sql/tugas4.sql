create database pbd_kebunbinatang;

use pbd_kebunbinatang;

create table pengunjung(
    id int auto_increment primary key,
    nama varchar(255) not null,
    umur int not null
)engine=innodb;

insert into pengunjung(id, nama, umur) values 
(1, 'Andi', 5),
(2, 'Budi', 21),
(3, 'Caca', 32),
(4, 'Dedi', 17),
(5, 'Euis', 18),
(6, 'Fafa', 17),
(7, 'Gigi', 45),
(8, 'Hani', 10),
(9, 'Ika', 12),
(10, 'Jaja', 7);

create table tiket(
    id int auto_increment primary key,
    umur int,
    harga int not null
)engine=innodb;

insert into tiket(id, umur, harga) values 
(1, 10, 10000),
(2, 20, 20000),
(3, null, 30000);


create table karyawan(
    id int auto_increment primary key,
    nama varchar(255) not null,
    shift int not null
)engine=innodb;

insert into karyawan(id, nama, shift) values 
(1, 'Bagas', 1),
(2, 'Setyo', 2),
(3, 'Nugroho', 3);

create table transaksi(
    id int auto_increment primary key,
    id_pengunjung int not null,
    id_tiket int not null,
    id_karyawan int not null,
    foreign key (id_pengunjung) references pengunjung(id),
    foreign key (id_tiket) references tiket(id),
    foreign key (id_karyawan) references karyawan(id)
)engine=innodb;

insert into transaksi(id, id_pengunjung, id_tiket, id_karyawan) values 
(1, 1, 1, 1),
(2, 2, 3, 1),
(3, 3, 3, 1),
(4, 4, 2, 2),
(5, 5, 2, 2),
(6, 6, 2, 2),
(7, 7, 3, 3),
(8, 8, 1, 3),
(9, 9, 2, 3),
(10, 10, 1, 3);


select p.nama as pengunjung, tk.harga as tiket, k.nama as karyawan, p.umur as umur_pengunjung, tk.harga as harga_tiket_satuan, SUM(tk.harga) as total_harga_tiket, count(tk.harga) as tiket_terjual
from transaksi t 
join pengunjung p on t.id_pengunjung = p.id
join tiket tk on t.id_tiket = tk.id
join karyawan k on t.id_karyawan = k.id
group by t.id_tiket
having total_harga_tiket > 50000





insert into barang(KODE_BRG, KD_PEMASOK, JUMLAH, LEVEL_MIN, HARGA) values 
('TV01', 'TV X' 2 ,1 ,45000)
('TV02', 'TV Y' 1 ,2 ,50000)
('RD01', 'RADIO A' 5 ,6 ,75000)
('RD02', 'RADIO' 4 ,3 ,82000)
