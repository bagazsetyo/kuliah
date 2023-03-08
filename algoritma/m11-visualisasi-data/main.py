import numpy as np 
import matplotlib.pyplot as plt

history = []

def janken(int):
    if int == 0:
        return "batu"
    elif int == 1:
        return "kertas"
    elif int == 2:
        return "gunting"
    else:
        return "tidak ada" 
        
# 0 = menang, 1 = kalah, 2 = seri
def hasil_janken(pilihan, lawan):
    if pilihan == lawan:
        return 2
    elif pilihan == 0 and lawan == 1:
        return 1
    elif pilihan == 1 and lawan == 2:
        return 1
    elif pilihan == 2 and lawan == 0:
        return 1
    else:
        return 0
    
# main 
limit = 100
counter = 0
print ("==================================")
print ("Pilih 1 untuk batu, 2 untuk kertas, 3 untuk gunting")
print ("==================================")
while True:
    while len(history) < limit:
        
        pilihan_saya = int(input("Masukkan pilihan: "))
        if(pilihan_saya > 3 or pilihan_saya < 0):
            counter = 0
            limit = 100
            break 
        
        pilihan_lawan = np.random.randint(0, 3)
        
        print ()
        print ("==================================")
        print ()
        print ("Pilihan saya: ", janken(pilihan_saya))
        print ("Pilihan lawan: ", janken(pilihan_lawan))
        
        hasil = hasil_janken(pilihan_saya, pilihan_lawan)
        
        if hasil == 0:
            print ("Hasil : Menang")
        elif hasil == 2:
            print ("Hasil : Seri")
        else:
            print ("Hasil : Kalah")
        
        if hasil == 1:
            print ("Anda Kalah")
            history.append(counter)
            print ("==================================")
            counter = 0
            limit = 100
            print ("Score: ", counter)
            print ("High Score: ", max(history))
            print ("Rata-rata Score: ", np.mean(history))
            print ("==================================")
            selesai = input("Apakah anda ingin bermain lagi? (y/n): ")
            print (history)
            if selesai == "y":
                plt.hist(history)
                plt.title("Score History")
                plt.xlabel("Score")
                plt.ylabel("Frequency")
                plt.show()
            break
        
        if(hasil == 0):
            counter += 1
        
        print ()
        print ("Score Anda: ", counter)