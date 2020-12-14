import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChucNang chucNang = new ChucNang();

        int choice = 0;
        do {
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xoá");
            System.out.println("5.Tìm kiếm");
            System.out.println("0.Thoát");
            System.out.println("Chọn chức năng:");
        try {
            chucNang.readFile();
            chucNang.writeToFile();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    chucNang.hienthi();
                    break;
                case 2:
                    chucNang.them();
                    break;
                case 3:
                    chucNang.sua();
                    break;
                case 4:
                    chucNang.xoa();
                    break;
                case 5:
                    chucNang.tim();
            }
        }catch (Exception e ){
            System.out.println("nhập lại đê ");
        }
    } while (choice != 0);
    }
}
