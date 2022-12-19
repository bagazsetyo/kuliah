create database Pegawai_ms;

use Pegawai_ms;

create table peg(
    NIP char(4) primary key,
    Nama varchar(15),
    Sex char(1),
    Alamat varchar(20)
);

create table departemen(
    kd_dep char(2) primary key,
    Nama varchar(15)
);

create table posisi(
    NIP char(4),
    kd_dep char(2),
    primary key (NIP, kd_dep),
    foreign key (NIP) references peg(NIP),
    foreign key (kd_dep) references departemen(kd_dep)
);

drop table posisi;

use Pegawai_ms;
drop database Pegawai_ms;



-- create database Pegawai_ms;

-- create table without foreign key and primary key 
create database Pegawai_ms;

use Pegawai_ms;

create table peg(
    NIP char(4),
    Nama varchar(15),
    Sex char(1),
    Alamat varchar(20)
);

create table departemen(
    kd_dep char(2),
    Nama varchar(15)
);

create table posisi(
    NIP char(4),
    kd_dep char(2),
);
use Pegawai_ms;
-- alter tabel peg add status varchar(5) after alamat;
ALTER TABLE peg ADD status varchar(5) after alamat;

-- ADD CONSTRAINT TO TABLE PEG, DEPARTEMEN, POSISI 

use Pegawai_ms;
ALTER TABLE peg ADD CONSTRAINT pk_peg PRIMARY KEY (NIP);

ALTER TABLE departemen ADD CONSTRAINT pk_dep PRIMARY KEY (kd_dep);

ALTER TABLE posisi ADD CONSTRAINT fk_posisi_peg FOREIGN KEY (NIP) REFERENCES peg(NIP);

use Pegawai_ms;
ALTER TABLE posisi ADD CONSTRAINT fk_posisi_dep FOREIGN KEY (kd_dep) REFERENCES departemen(kd_dep);

-- INSERT MULTIPLE DATA TO TABLE PEG

use Pegawai_ms;
INSERT INTO peg (NIP, Nama, Sex, Alamat, status) VALUES 
('A1','Armadyah','P','Kotabaru','Nikah'),
('A2','HendraGautama', 'L', 'Plosokuning', 'Nikah'),
('A3','Armadyah', 'P', 'Jl. Magelang', 'Belum'),
('A4','GunturMahendra', 'L', 'Jetis', 'Belum'),
('A5','Nouval', 'L', 'Kotagede','Nikah'),
('A6','Hanif', 'L','Plosokuning','Nikah');

-- INSERT MULTIPLE DATA TO TABLE DEPARTEMEN
INSERT INTO departemen (kd_dep, Nama, Tunjangan) VALUES 
('M','Pemasaran', '800000'),
('P','Produksi', '700000'),
('S','SumberDayaManusia', '1000000'),
('A','Administrasi', '750000');

-- INSERT MULTIPLE DATA TO TABLE POSISI
INSERT INTO posisi (NIP, kd_dep) VALUES 
('A1','P'),
('A2','M'),
('A3','P'),
('A4','A'),
('A5','S'),
('A6','M');


use Pegawai_ms;
UPDATE peg SET Alamat = 'Jl. Kaliurang' WHERE Nama = 'GunturMahendra';

use Pegawai_ms;
DELETE posisi WHERE NIP = 'A1';

SELECT * 
FROM peg
join posisi on peg.NIP = posisi.NIP
join departemen on posisi.kd_dep = departemen.kd_dep;
where departemen.Tunjangan > 800000;

-- 
-- ALTER TABLE peg ADD Gaji money after status;
-- sql type data moeny 
ALTER TABLE peg ADD Gaji money(3) after NIP;


-- query antar table 
select peg.NIP, departemen.Nama, peg.Gaji
from peg, departemen, posisi
where peg.NIP = posisi.NIP
and posisi.kd_dep = departemen.kd_dep


