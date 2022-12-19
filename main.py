'''
mapping array 

key => [
    'nama',
    'topping' => [
        'topping1',
        'topping2',
        'topping3',
    ]
]
'''
menu = {
    'K' : {
        'nama' : 'Brownies Kukus',
        'topping' : {
            'P' : {
                'nama' : 'Plain',
                'harga' : '22000'
            },
            'A' : {
                'nama' : 'Almond',
                'harga' : '27500'
            },
            'C' : {
                'nama' : 'Cheese',
                'harga' : '32000'
            },  
        }
    },
    'B' : {
        'nama' : 'Brownies Bakar',
        'topping' : {
            'P' : {
                'nama' : 'Plain',
                'harga' : '25000'
            },
            'A' : {
                'nama' : 'Almond',
                'harga' : '32500'
            },
            'C' : {
                'nama' : 'Cheese',
                'harga' : '37000'
            },  
        }
    }
}

print("=====================================")
print("BROWNIELICIOUZ")
print("=====================================")
i = 1

# while true 
while True:
    nama = input("Nama Pembeli \t\t: ")
    brownis_kode = input("Kode Brownis \t\t: ")

    # apahak brownis yang dipilih ada di menu
    if brownis_kode not in menu:
        print("Brownis tidak tersedia")
        exit()
        
    # ambil nama brownis
    brownis = menu[brownis_kode]
    nama = brownis['nama']

    # input topping
    topping = input("Pilih Topping \t\t: ")

    # cek apakah topping yang dipilih ada di menu
    if topping not in brownis['topping']:
        print("Topping tidak tersedia")
        exit()
        
    # ambil harga 
    harga = brownis['topping'][topping]['harga']
    formatharga = "Rp. {:,}".format(int(harga))
    print("Harga Per Box \t\t:", formatharga)
        
    #input jumlah beli
    jumlahbeli = input("Input Jumlah Beli \t: ")

    print ("-----------------------------------")

    totalkotor = int(harga) * int(jumlahbeli)
    formatTotalKotor = "Rp. {:,}".format(totalkotor)
    print ("Total Pembelian \t:" , formatTotalKotor)

    pajak = totalkotor * 0.1
    pajak = int(pajak)
    formatPajak = "Rp. {:,}".format(pajak)
    print ("Pajak (10%) \t\t:", formatPajak)

    # if jumlahbeli >= 3 add diskon 
    diskon = 0
    if int(jumlahbeli) >= 3:
        diskon = 0.05
        
    hargaDiskon = totalkotor * diskon
    hargaDiskon = int(hargaDiskon)

    # format harga diskon
    formatHargaDiskon = "Rp. {:,}".format(hargaDiskon)
    print ("Diskon \t\t\t:", formatHargaDiskon)

    print ("----------------------------------- +")

    totalbayar = totalkotor + pajak - hargaDiskon
    formatTotalBayar = "Rp. {:,}".format(totalbayar)

    print ("Grand Total \t\t:" , formatTotalBayar)
    
    lanjut = input("Masih Mengisi [Y/T] \t: ")
    
    if lanjut != 'Y':
        break
    
    print ("----------------------------------------------------------------")
    i += 1
    print ("Input Data Pembeli ke-" , i)

print ("Terima Kasih Telah Berbelanja di BROWNIELICIOUZ")