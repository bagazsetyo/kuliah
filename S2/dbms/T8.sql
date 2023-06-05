create table karyawan (
    NIK VARCHAR(20) NOT NULL,
    NAMA VARCHAR(20) NULL,
    ALAMAT VARCHAR(20) NULL,
    PRIMARY KEY(NIK)
) 


-- INSERT DATA 
BEGIN
    INSERT INTO karyawan (NIK, NAMA, ALAMAT) VALUES
    ('K001', 'Wawan', 'Plaju');
    INSERT INTO karyawan (NIK, NAMA, ALAMAT) VALUES
    ('K002', 'Badu', 'Perumnas');
END;

-- INSERT INTO KARYAWAN VALUES ('K003', 'Cici', 'Perumnas');
-- UPDATE KARYAWAN SET alamat=’bukit besar’ WHERE NIK=’K003;
-- COMMIT;
-- SELECT * FROM KARYAWAN;

INSERT INTO karyawan (NIK, NAMA, ALAMAT) VALUES
('K003', 'Cici', 'Perumnas')
UPDATE karyawan SET ALAMAT='bukit besar' WHERE NIK='K003'
COMMIT
SELECT * FROM karyawan

-- harus di tambah begin 
BEGIN
  INSERT INTO karyawan (NIK, NAMA, ALAMAT) VALUES ('K004', 'Cici', 'Perumnas');
  UPDATE karyawan SET ALAMAT='bukit besar' WHERE NIK='K004';
  COMMIT;
  SELECT * FROM karyawan;
END;
-- end


BEGIN
  -- DELETE semua data dari tabel karyawan
  DELETE FROM karyawan;
  
  -- ROLLBACK perubahan yang dilakukan sebelumnya
  ROLLBACK;
  
  -- SELECT semua data dari tabel karyawan
  SELECT * FROM karyawan;
  
  -- DELETE data dengan NIK 'K002'
  DELETE FROM karyawan WHERE NIK='K002';
  
  -- SELECT semua data dari tabel karyawan setelah penghapusan
  SELECT * FROM karyawan;
  
  -- COMMIT perubahan yang dilakukan sebelumnya
  COMMIT;
END;