
create database rumahsakit_mandiri;

use rumahsakit_mandiri;

create table pasien (
    no_pasien int primary key auto_increment,
    nama_pasien varchar(20),
    alamat varchar(20),
    tgl_lahir date,
    no_telp char(12)
);

create table dokter (
    no_dokter int primary key auto_increment,
    nama_dokter varchar(20),
    alamat varchar(20),
    tgl_lahir date,
    no_telp char(12),
    spesialis varchar(20)
);

create table ruangan (
    no_ruangan int primary key auto_increment,
    nama_ruangan varchar(20),
    kelas varchar(20)
);

create table transaksi (
    no_transaksi int primary key auto_increment,
    no_pasien int(4),
    no_dokter int(4),
    no_ruangan int(4),
    tgl_masuk date,
    biaya int,
    jenis_penyakit varchar(20),
    foreign key (no_pasien) references pasien(no_pasien),
    foreign key (no_dokter) references dokter(no_dokter),
    foreign key (no_ruangan) references ruangan(no_ruangan)
);

INSERT INTO pasien (nama_pasien, alamat, tgl_lahir, no_telp) VALUES 
('Rizky', 'Jl. Cikini', '1999-01-01', '081234567890'),
('Amel', 'Jl. Jakarta', '1999-10-01', '081234567891'),
('Andi', 'Jl. Perintis Kemerdekaan', '1999-01-01', '081234567892'),
('Galih', 'Jl. Kencana', '2009-04-11', '081234567893'),
('Linda', 'Jl. Imam Bonjol', '2004-01-18', '081234567894');

INSERT INTO dokter (nama_dokter, alamat, tgl_lahir, no_telp, spesialis) VALUES 
('Budi', 'Jakarta', '1990-01-11', '081234567810', 'Spesialis Mata'),
('Lukas', 'Bogor', '1970-04-02', '081234567820', 'Spesialis Kulit'),
('Dadi', 'Bandung', '1989-12-03', '081234567830', 'Spesialis Jantung');

INSERT INTO ruangan (nama_ruangan, kelas) VALUES 
('Kelas 1', 'Kelas 1'),
('Kelas 2', 'Kelas 2'),
('Kelas 3', 'Kelas 3');

INSERT INTO transaksi (no_pasien, no_dokter, no_ruangan, tgl_masuk, biaya, jenis_penyakit) VALUES 
('1', '3', '1', '2023-01-11', '114000', 'jantung'),
('2', '2', '2', '2023-02-02', '220000', 'kulit'),
('3', '1', '3', '2020-01-23', '350000', 'mata'),
('4', '3', '1', '2020-12-24', '490000', 'jantung'),
('5', '2', '2', '2022-01-05', '500000', 'kulit'),
('5', '1', '1', '2022-04-14', '750000', 'jantung'),
('5', '3', '2', '2021-11-15', '900000', 'mata'),
('5', '1', '2', '2021-01-09', '340000', 'jantung'),
('5', '2', '1', '2019-01-15', '570000', 'kulit');

alter table transaksi add column lama_menginap int after biaya;

-- select
select pasien.* from pasien 
join transaksi on pasien.no_pasien = transaksi.no_pasien
where pasien.nama_pasien = 'Rizky';

-- group by and having count 
select format(sum(biaya), 0)  as total
from transaksi
GROUP BY jenis_penyakit
HAVING total > "2,000,000";

-- join all table 
select pasien.nama_pasien, dokter.nama_dokter, ruangan.nama_ruangan, transaksi.tgl_masuk, transaksi.biaya, transaksi.jenis_penyakit, format(sum(biaya), 0) as total_biaya, count(*) as jumlah_transaksi
from transaksi
join pasien on transaksi.no_pasien = pasien.no_pasien
join dokter on transaksi.no_dokter = dokter.no_dokter
join ruangan on transaksi.no_ruangan = ruangan.no_ruangan
group by pasien.nama_pasien

-- melihat semua orang yang ada di rumah sakit tersebut 
SELECT no_pasien, nama_pasien, alamat, tgl_lahir, no_telp
FROM pasien
UNION
SELECT no_dokter, nama_dokter, alamat, tgl_lahir, no_telp
FROM dokter;

-- menghitung jarak tanggal lahir pasien dengan sekarang 
SELECT nama_pasien, TIMESTAMPDIFF(YEAR, tgl_lahir, CURDATE()) AS umur, YEAR(CURDATE()) AS tahun_lahir, tgl_lahir as tanggal_lahir
FROM pasien;
