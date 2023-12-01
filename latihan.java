import java.util.Scanner;
import java.util.Arrays;;

public class latihan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //deklarasi
        String nimMhs, passMhs;
        String nama, kelas;
        int semester;
        double poinAkhir;
        int kolom = 5, baris = 9;

        //array login data
        String[] loginData = {
            "1", "1",
            "2341720075", "1"
        };
        //array data kompen kelas yang di inputkan
        String[][] kompenMhs = {
            {"Nama", "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8"},
            {"Naufal", "1", "0", "1", },
            {"Faishal", "1", "2", "1", },
            {"Dhanisa", "4", "0", "1", },
            {"Valen", "2", "1", "3", },
        };

        System.out.println("Sistem Kompen Mahasiswa");

    }
}
