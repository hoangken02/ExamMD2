import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChucNang implements HienThi {
    ArrayList<DanhBa> danhBas = new ArrayList();
    Scanner scanner = new Scanner(System.in);



    public List<DanhBa> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("listphonebook.dat");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        danhBas = (ArrayList<DanhBa>) (ojb.readObject());
        ojb.close();
        fileInputStream.close();
        return danhBas;
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("listphonebook.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(danhBas);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void hienthi() throws IOException,ClassNotFoundException {
        writeToFile();
        readFile();
        int nhap = 0;
        do {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Hiển thị");
            System.out.println("0. Thoát");
            try {
                nhap = Integer.parseInt(scanner.nextLine());
                if (nhap == 1) {
                    for (DanhBa danhBa :
                            danhBas) {
                        System.out.println(danhBa.toString());
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại: ");
            }
        } while (nhap != 0);
    }

    @Override
    public void them() throws IOException, ClassNotFoundException {
        DanhBa danhBa = new DanhBa();
        readFile();
        int nhap = 0;
        do {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm");
            System.out.println("0. Thoát");
            try {
                nhap = Integer.parseInt(scanner.nextLine());
                switch (nhap) {
                    case 1:
                        danhBa.themDanhSach();
                        danhBas.add(danhBa);
                        break;

                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Vui lòng nhập lại: ");
            }
        } while (nhap != 0);
    }

    @Override
    public void tim() {
        int nhap = 0;
        do {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Tìm");
            System.out.println("0. Thoát");
            try {
                nhap = Integer.parseInt(scanner.nextLine());
                if (nhap == 0) {
                    System.out.println("Tìm tên: ");
                    String tenNhapVao = scanner.nextLine();
                    int kiemTra = 0;
                    Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{8}");
                    Matcher matcher;
                    matcher = pattern.matcher(tenNhapVao);

                    for (int i = 0; i < danhBas.size(); i++) {
                        if (tenNhapVao.equalsIgnoreCase(danhBas.get(i).getName())) {
                            System.out.println(i + danhBas.get(i).toString());
                            kiemTra++;
                        }
                    }
                    if (kiemTra <= 0) {
                        System.out.println("Không tìm thấy người này: ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại: ");
            }
        } while (nhap != 0);
    }

    @Override
    public void sua() {
        int chon = 0;
        do {
            System.out.println("Chọn chức năng");
            System.out.println("1.Nhập tên hoặc số điện thoại bạn muốn sửa");
            System.out.println("0.Thoát");
            try {
                chon = Integer.parseInt(scanner.nextLine());
                String suaThongTin = scanner.nextLine();
                for (int i = 0; i < danhBas.size(); i++) {
                    if (suaThongTin == danhBas.get(i).getName() || suaThongTin == danhBas.get(i).getsDT()) {
                        int xoaThongTin = danhBas.indexOf(danhBas.get(i));
                        them();
                    }
                }
                System.out.println("Không tìm thấy:");

            } catch (Exception e) {
                System.out.println("Không tìm thấy");
            }
        } while (chon != 0);
    }

    @Override
    public void xoa() {
        int nhap = 0;
        do {
            System.out.println("Nhập chức năng");
            System.out.println("1. Xoá");
            System.out.println("0. Thoát");
            try {
                nhap = Integer.parseInt(scanner.nextLine());
                if (nhap == 1) {
                    System.out.println("Nhập tên cần xóa ");
                    String ten = scanner.nextLine();
                    DanhBa danhBa = null;
                    int size = danhBas.size();
                    for (int i = 0; i < size; i++) {
                        if (danhBas.get(i).getName().equals(ten)) {
                            danhBa = danhBas.get(i);
                            break;
                        }
                    }
                    if (danhBa != null) {
                        System.out.println("Đã Xóa Tên Là : \n" + danhBa.getName());
                        danhBas.remove(danhBa);
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
            }
        } while (nhap!=0);
    }
}


