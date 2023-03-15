-- tugas 1
Select kode_barang as kd_brg, min (jumlah_pasok) as
minimum_pasok
From pasok;


INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S001','PT. ABC','Jl. ABC');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S002','PT. DEF','Jl. DEF');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S003','PT. GHI','Jl. GHI');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S004','PT. JKL','Jl. JKL');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S005','PT. MNO','Jl. MNO');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S006','PT. PQR','Jl. PQR');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S007','PT. STU','Jl. STU');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S008','PT. VWX','Jl. VWX');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S009','PT. YZ','Jl. YZ');
INSERT INTO SUPLIER (KODE_SUPLIER, NAMA_SUPLIER, ALAMAT_SUPLIER) VALUES 
('S010','PT. 123','Jl. 123');


INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P001','B001','S001', 10);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P002','B003','S002', 2);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P003','B002','S003', 14);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P004','B004','S004', 23);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P005','B004','S005', 31);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P006','B001','S006', 7);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P007','B004','S007', 28);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P008','B003','S008', 2);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P009','B002','S009', 9);
INSERT INTO PASOK (KODE_PASOK, KODE_BARANG, KODE_SUPLIER, JUMLAH_PASOK) VALUES 
('P010','B001','S010', 16);


Select KODE_SUPLIER as kd_suplier, max (jumlah_pasok) as
minimum_pasok
From pasok
group by KODE_SUPLIER;

-- rata rata 
Select avg (jumlah_pasok) as rata_rata, kode_barang as kd_brg
From pasok
group by KODE_BARANG;

INSERT INTO CUSTOMER (KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER) VALUES 
('C001','PT. MAJA','Jl. MAJAPAHIT');
INSERT INTO CUSTOMER (KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER) VALUES 
('C002','PT. RATU','Jl. RATU');
INSERT INTO CUSTOMER (KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER) VALUES 
('C003','PT. KENCANA','Jl. KENCANA');
INSERT INTO CUSTOMER (KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER) VALUES 
('C004','PT. MULIA','Jl. MULIA');
INSERT INTO CUSTOMER (KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER) VALUES 
('C005','PT. JAYA','Jl. JAYA');
INSERT INTO CUSTOMER (KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER) VALUES 
('C006','PT. MANDIRI','Jl. MANDIRI');

-- SELECT ALL FROM CUSTOMER ORDER BY NAMA_CUSTOMER ASC; 
select * from customer order by nama_customer asc;

-- Tampilkan kode barang yang jumlah pasoknya kurang dari atau sama dengan 5. 
select kode_barang, jumlah_pasok  
from pasok where jumlah_pasok <= 5;