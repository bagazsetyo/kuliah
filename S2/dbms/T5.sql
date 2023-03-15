INSERT INTO BARANG (KODE_BARANG, NAMA_BARANG, SATUAN_BARANG,
STOK_BARANG) VALUES ('B002','Rice Cooker','buah', 23);

INSERT INTO BARANG (KODE_BARANG, NAMA_BARANG, SATUAN_BARANG,
STOK_BARANG) VALUES ('B003','TV','', '');

INSERT INTO BARANG (KODE_BARANG, NAMA_BARANG, SATUAN_BARANG,
STOK_BARANG) VALUES ('B004','Radio','buah', '21');

-- update TV 
update barang set stok_barang = 30, satuan_barang = 'unit' where kode_barang = 'B003';

select * from barang;