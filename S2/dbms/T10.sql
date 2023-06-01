
 SET SERVEROUTPUT ON
 DECLARE
 TYPE Alamat IS RECORD (
 NamaJalan VARCHAR2(100),
 NOJalan NUMBER,
 NoRumah VARCHAR2(5),
 Kota VARCHAR2(20)
 );
 TYPE PemilikRumah IS RECORD(
 Nama VARCHAR2(100),
 Domisili Alamat
 );
 REC PemilikRumah; -- REC merupakan nama variabel
 BEGIN
 REC.Nama := 'Ahmad Budianto';
 REC.Domisili.NamaJalan := 'Jalan Melati';
 REC.Domisili.NoJalan := 10;
 REC.Domisili.NoRumah := '10B' ;
 REC.Domisili.Kota := 'Palembang' ;
 DBMS_OUTPUT.PUT_LINE (REC.Nama);
 DBMS_OUTPUT.PUT_LINE (rec.domisili.namaJalan ||' ' ||
 rec.domisili.noJalan || ' ' ||'No' || ' '||
 rec.domisili.NoRumah || ' ' || rec.domisili.kota);
 END;
 /



 SET SERVEROUTPUT ON
 DECLARE
 TYPE LARIK IS TABLE OF NUMBER
 INDEX BY BINARY_INTEGER ;
 A LARIK ;
 BEGIN
 A(1) := 10; A(2) := 20;
 A(3) := 30; A(4) := 40;
 dbms_output.put_line('Nilai elemen larik ke 1 : '|| to_char(a(1)));
 dbms_output.put_line('Nilai elemen larik ke 2 : '|| to_char(a(2)));
 dbms_output.put_line('Nilai elemen larik ke 3 : '|| to_char(a(3)));
 dbms_output.put_line('Nilai elemen larik ke 4 : '|| to_char(a(4)));
 END;
 /
