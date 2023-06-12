CREATE OR REPLACE PROCEDURE cari_nama_suplier IS
  v_nama_suplier suplier.nama_suplier%TYPE;
BEGIN
  SELECT nama_suplier INTO v_nama_suplier
  FROM suplier
  WHERE kode_suplier = 'S001';
  DBMS_OUTPUT.PUT_LINE('Namanya : ' || v_nama_suplier);
END;
/


CREATE OR REPLACE FUNCTION cari_namasuplier
    RETURN suplier.nama_suplier%TYPE
IS vnamasuplier suplier.nama_suplier%TYPE;
BEGIN
    SELECT nama_suplier INTO vnamasuplier FROM suplier WHERE
    kode_suplier='S001';
    RETURN vnamasuplier;
end;
/

Declare
Nama suplier.nama_suplier%TYPE;
Begin
Nama := cari_namasuplier;
dbms_output.put_line(Nama);
End;
/
