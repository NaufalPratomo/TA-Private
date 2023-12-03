import java.util.Scanner;
import java.util.Arrays;

public class tryofmine {
    static Scanner input = new Scanner(System.in);

    // Deklarasi
    static String nimMhs;
    static String passMhs;
    static String nama, kelas;
    static int semester;
    static double poin_akhir = 0;
    static int baris = 5, kolom = 9, kerja = 0;

    // Fungsi Clear the screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Fungsi pilih semester
    public static int pilihSemester() {
        // Input semester (pilih semester)
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║       Perhitungan Kompen Mahasiswa         ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.print("Perhitungan Kompen Mahasiswa");
        System.out.print("Masukkan Semester (1-8): ");
        semester = input.nextInt();
        if (semester > 8 || semester < 1) {
            pilihSemester();
            System.out.print("Semester tidak");
        }
        return semester;
    }

    // Fungsi konfirmasi Semester
    public static int konfirmasiSemester(int kompen) {
        // Rekursif
        System.out.print("Apakah Kompen sudah dikerjakan (y/t) : ");
        String jawabKonfirmasi;
        jawabKonfirmasi = input.nextLine();
        switch (jawabKonfirmasi) {
            case "y":
                kompen *= 0;
                break;

            case "t":
                kompen *= 2;
                break;

            default:
                System.out.println("Pilihan anda salah");
                konfirmasiSemester(kompen);
                break;
        }
        return kompen;
    }

    public static void main(String[] args) {

        System.out.println(
                "█▀ █▀▀ █░░ ▄▀█ █▀▄▀█ ▄▀█ ▀█▀  █▀▄ ▄▀█ ▀█▀ ▄▀█ █▄░█ █▀▀  █▀▄ █  █▀ █ █▀ ▀█▀ █▀▀ █▀▄▀█  █▄▀ █▀█ █▀▄▀█ █▀█ █▀▀ █▄░█ ");
        System.out.println(
                "▄█ ██▄ █▄▄ █▀█ █░▀░█ █▀█ ░█░  █▄▀ █▀█ ░█░ █▀█ █░▀█ █▄█  █▄▀ █  ▄█ █ ▄█ ░█░ ██▄ █░▀░█  █░█ █▄█ █░▀░█ █▀▀ ██▄ █░▀█ ");

        // Array 2D List Kompen Setiap Mahasiswa Pada Kelas yang Diinputkan
        String[][] kompenMhs = {
                { "Nama", "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8" },
                { "Naufal", "2", "0", "1" },
                { "Faishal", "2", "1", "3" },
                { "Dhanisa", "2", "2", "3" },
                { "Valen", "2", "1", "0" },
        };

        // Array for login data (NIM and password)
        String[] loginData = {
                "2341720075", "1",
                "2341720212", "1",
                "2341720218", "1",
                "2341720016", "1",
                "1", "1"
        };

        // Decoration
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║          Sistem Kompen Mahasiswa           ║");
        System.out.println("╚════════════════════════════════════════════╝");

        // login
        System.out.println("===== Sistem Kompen Mahasiswa =====\n");
        boolean loginSukses = false;
        while (!loginSukses) {
            System.out.print("Masukkan NIM: ");
            nimMhs = input.nextLine();
            System.out.print("Masukkan Password: ");
            passMhs = input.nextLine();

            boolean found = false;
            for (int i = 0; i < loginData.length; i += 2) {
                if (nimMhs.equals(loginData[i]) && passMhs.equals(loginData[i + 1])) {
                    found = true;
                    loginSukses = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("NIM atau Password salah. Coba lagi.");
            }
        }
        clearScreen(); // Clear the screen

        // Input data mahasiswa
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║          Menginput Nama Mahasiswa          ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("               ");
        System.out.println("               ");
        System.out.print("Masukkan Nama: ");
        nama = input.nextLine();
        System.out.print("Masukkan Kelas: ");
        kelas = input.nextLine();
        clearScreen(); // Clear the screen

        // Fungsi untuk memasukkan input kompen kedalam array 2D list kompen
        String[][] newMhs = new String[baris + 1][kolom];
        for (int i = 0; i < kompenMhs.length; i++) {
            for (int j = 0; j < kompenMhs[i].length; j++) {
                newMhs[i][j] = kompenMhs[i][j];
            }
        }
        kompenMhs = newMhs;
        kompenMhs[baris][0] = nama;

        // Menu Sistem Kompen
        boolean sistemKompen = true;
        int menu;
        do {
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("           Selamat datang " + nama + "            ");
            System.out.println("║          Silahkan Pilih Menu :             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println("\nSelamat datang " + nama + ", Silahkan pilih menu: ");
            System.out.println("0. Keluar Program");
            System.out.println("1. Perhitungan Kompen Mahasiswa");
            System.out.println("2. List Kompen Pada Kelas " + kelas);
            System.out.print("\nPilih menu: ");
            menu = input.nextInt();
            input.nextLine();
            clearScreen(); // Clear the screen
            switch (menu) {
                case 0:
                    sistemKompen = false;
                    break;
                case 1:
                    // Memanggil fungsi pilihSemester
                    int simpanSemester = pilihSemester();
                    // Input kompen sesuai semester
                    int kompenSemester = 0;
                    for (int i = 1; i <= simpanSemester; i++) {
                        System.out.println("Anda memilih semester " + i + ".");
                        System.out.print("Masukkan Kompen Semester (jam) " + i + ": ");
                        int kompen = input.nextInt();
                        input.nextLine();
                        // memanggil fungsi untuk menanyakan apakah kompen sudah dikerjakan
                        int simpanKompen = konfirmasiSemester(kompen);
                        String kompenString = Integer.toString(simpanKompen);
                        kompenMhs[baris][i] = kompenString;
                        for (int j = 0; j < semester-1; j++) {
                        simpanKompen *= 2;
                        }
                        kerja = simpanKompen;
                        kompenSemester += kerja;
                    }

                    poin_akhir = kompenSemester;

                    // Hasil akhir
                    System.out.println(nama + " kelas " + kelas + " semester " + semester
                            + " memiliki nilai kompen akhir " + poin_akhir);
                case 2:
                    // Cetak array 2D list kompen
                    for (int i = 0; i < kompenMhs.length; i++) {
                        for (int j = 0; j < kompenMhs[i].length; j++) {
                            if (kompenMhs[i][j] == null) {
                                kompenMhs[i][j] = "";
                            }
                            System.out.print(kompenMhs[i][j] + "\t");
                        }
                        System.out.println();
                    }
            }

        } while (sistemKompen);
        System.out.println("\n\nTerima kasih :D");

        // Close the Scanner
        input.close();
    }
}