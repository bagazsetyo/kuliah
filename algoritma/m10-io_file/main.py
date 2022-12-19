# create file with name random 

import random
import os 

path = os.path.dirname(__file__) + "/tiket"
count = len(os.listdir(path)) + 1
count = str(count)

jumlah_tiket = str(input("Masukkan jumlah tiket yang ingin dibeli: "))


for i in range(int(jumlah_tiket)):
    random_number = random.randint(100000, 999999)
        
    with open(path + "/tiket_" + count + ".txt", "a") as f:
        f.write("Tiket bioskop indo XXI\n")
        f.write("kode : " + str(random_number) + "\n")
        f.write("harga : Rp 100.000 \n")
        f.write("=================================\n")
        
        f.close()
    
print ()
print ()
print ("Tiket yang dipesan")
open = open(path + "/tiket_" + count + ".txt", "r")
print(open.read())