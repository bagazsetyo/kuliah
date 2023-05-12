-- create tabel pengarang 
create table pengarang(
    id char(3),
    nama varchar(50),
    alamat varchar(100),
    kota varchar(20),
    PRIMARY KEY(id)
);

-- create tabel penerbit
create table penerbit(
    id char(3),
    nama varchar(50),
    alamat varchar(100),
    siupp varchar(10),
    PRIMARY KEY(id)
);

-- create tabel buku 
create table buku(
    id char(3),
    judul varchar2(30),
    idpengarang char(3),
    idpenerbit char(3),
    harga varchar(20),
    kategori varchar(10),
    PRIMARY KEY(id),
    FOREIGN KEY(idpengarang) REFERENCES pengarang(id),
    FOREIGN KEY(idpenerbit) REFERENCES penerbit(id)
);

-- menambahkan kolom no_hp tada tabel pengarang
alter table pengarang add no_hp varchar(13);

-- Hapus kolom siupp pada tabel penerbit
alter table penerbit drop column siupp;


insert into pengarang (id, nama, alamat, kota, no_hp) values('Pg1','Tere Liye','Jl. Cikini Raya','Jakarta','01132');
insert into pengarang (id, nama, alamat, kota, no_hp) values('Pg2','Wira Nagara','Jl. Peintis','Yogyakarta','0788');
insert into pengarang (id, nama, alamat, kota, no_hp) values('Pg3','Raditya Dika','Jl. Imambonjol','Jakarta','0965');
insert into pengarang (id, nama, alamat, kota, no_hp) values('Pg4','Orizuka','Jl. Pahlawan','Bnadung','08123');

insert into penerbit (id, nama, alamat) values('Pb1','Gramedia','Jl. Jakarta Raya');
insert into penerbit (id, nama, alamat) values('Pb2','Mizan Pustaka','Jalan Cinambo No. 135, Cisaranten Wetan, Bandung 40294, Indonesia.');
insert into penerbit (id, nama, alamat) values('Pb3','Bentang Pustaka','Jl. Palagan Tentara Pelajar, No.101, Jongkang RT 004 RW 035');
insert into penerbit (id, nama, alamat) values('Pb4','Erlangga','Jl. Jl. H. Baping No. 100, Ciracas Jakarta Timur 13740');

insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk0','Grow rich','Pg4','Pb4','35000','nonfiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk1','Kambing Jantan','Pg1','Pb1','80000','fiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk2','Mohammad Hatta','Pg1','Pb1','150000','nonfiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk3','Destilasi Alkena','Pg2','Pb2','250000','fiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk4','Soekarno ','Pg1','Pb1','50000','nonfiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk5','Disforia Inersia','Pg2','Pb2','40000','fiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk6','Cinta Brontosaurus','Pg3','Pb3','100000','fiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk7','Cinta monyet','Pg3','Pb3','120000','fiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk8','Malam minggu miko','Pg3','Pb3','90000','fiksi');
insert into buku (id, judul, idpengarang, idpenerbit, harga, kategori) values('Bk9','The power of habit','Pg4','Pb4','95000','nonfiksi');


select * from pengarang;

insert into pengarang (id, nama, alamat, kota, no_hp) values('Pg6','Andrea Hirata','Jl. Bekasi','Bekasi','08245');
insert into pengarang (id, nama, alamat, kota, no_hp) values('Pg7','Winna Efendi','Jl. Malang','Malang','0321');

select id , judul, harga from buku;


select buku.id , buku.judul, buku.harga, buku.kategori, pengarang.nama as idpengarang, penerbit.nama as idpenerbit
from buku
join pengarang on buku.idpengarang = pengarang.id
join penerbit on buku.idpenerbit = penerbit.id;

select buku.id , buku.judul, buku.harga, pengarang.nama as idpengarang
from buku
join pengarang on buku.idpengarang = pengarang.id
order by pengarang.nama asc;