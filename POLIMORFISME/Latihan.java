abstract class Kue {
    private String nama;
    private double harga;

    public String getNama() {
        return this.nama;
    }

    public double getHarga() {
        return this.harga;
    }

    Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();

    public String toString() {
        return "Nama : " + nama + ", Harga : " + harga;
    };
}

class KuePesanan extends Kue {
    private double berat;

    KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    public double hitungHarga() {
        return super.getHarga() * berat;
    }

}

class KueJadi extends Kue {
    private double jumlah;

    KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    public double hitungHarga() {
        return super.getHarga() * jumlah * 2;
    }
}

public class Latihan {
    public static void main(String[] args) {
        double totalHarga = 0, hargaPesanan = 0, beratPesanan = 0, hargaJadi = 0, jumlahJadi = 0;
        Object[] arrayKue = new Kue[20];
        for (int i = 0; i < 20; i += 2) {
            arrayKue[i] = new KuePesanan("kue " + (i + 1), i * 1000, i);
        }
        for (int i = 1; i <= 20; i += 2) {
            arrayKue[i] = new KueJadi("Kue " + (i + 1), i * 1000, i);
        }

        // print
        for (int i = 0; i < arrayKue.length; i++) {
            if (arrayKue[i] instanceof KuePesanan) {
                KuePesanan kuePesanan = (KuePesanan) arrayKue[i];
                System.out.println(kuePesanan.toString() + ", Jenis : Pesanan");
                totalHarga += kuePesanan.getHarga();
                hargaPesanan += kuePesanan.getHarga();
                beratPesanan += kuePesanan.getBerat();
            } else {
                KueJadi kueJadi = (KueJadi) arrayKue[i];
                System.out.println(kueJadi.toString() + ", Jenis : Jadi");
                totalHarga += kueJadi.getHarga();
                hargaJadi += kueJadi.getHarga();
                jumlahJadi += kueJadi.getJumlah();
            }
        }
        System.out.println("");
        System.out.println("Total harga semua : " + totalHarga);
        System.out.println("Total harga pesanan : " + hargaPesanan + ", Total berat : " + beratPesanan);
        System.out.println("Total harga jadi : " + hargaJadi + ", Total berat : " + jumlahJadi);
        if (hargaPesanan >= hargaJadi)
            System.out.println("Harga terbesar : Kue pesanan Rp" + hargaPesanan);
        else
            System.out.println("Harga terbesar : Kue jadi Rp" + hargaJadi);
    }
}