import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanhBa {
    private String name;
    private String sDT;
    private String nhom;
    private String diaChi;
    private String email;

    public DanhBa() {
    }

    public DanhBa(String name, String sDT, String nhom, String diaChi, String email) {
        this.name = name;
        this.sDT = sDT;
        this.nhom = nhom;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "name='" + name + '\'' +
                ", sDT=" + sDT +
                ", nhom='" + nhom + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void themDanhSach() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.println("nhập sdt");
            String s = "^(09|01[2|6|8|9])+([0-9]{8})\\b";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check = true;
                sDT = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check);

        System.out.println("nhập nhóm ");
        nhom = sc.nextLine();
        System.out.println("nhập tên");
        name = sc.nextLine();
        System.out.println("nhập địa chỉ ");
        diaChi = sc.nextLine();

        boolean check1 = false;
        do {
            System.out.println("nhập địa chỉ email ");
            String s = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check1 = true;
                email = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check1);

    }
}
