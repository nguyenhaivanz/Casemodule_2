package controller;

import io.ReadAndWrite;
import models.Account;
import models.Product;
import validate.ValidateAccount;
import view.Menu;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    File file = new File("C:\\Users\\Asus\\Desktop\\New folder\\Case2module\\src\\filetext\\account.txt");
    ReadAndWrite<Account> readAndWrite = new ReadAndWrite<>();
    ArrayList<Account> accounts = readAndWrite.read(file);
    Scanner scanner = new Scanner(System.in);
    ManagerProduct managerProduct = new ManagerProduct();
    ValidateAccount validateAccount = new ValidateAccount();

    public Account login() {
        System.out.println("|> nhập acount:");
        String username = scanner.nextLine();
        System.out.println("|> nhập password:");
        String password = scanner.nextLine();
        int choice = 0;
        if (username.equals("adminvan") && password.equals("Van1234")) {
            System.out.println("ĐĂNG NHẬP THÀNH CÔNG!!!");
            menuAdmin();
            ++choice;
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                    System.out.println("ĐĂNG NHẬP THÀNH CÔNG!!!");
                   MenuUser();
                    ++choice;
                }
            }
        }
        if (choice == 0) {
            System.out.println("tài khoản hoặc mật khẩu không tồn tại!!!");
        }
        return null;
    }

    public Account register() {
            String username;
            while (true) {
                username = validateAccount.UserName();
                if (checkUserName(username)) {
                    break;
                }
                System.out.println("Trùng username!!!");
            }
            String password = validateAccount.PassWord();
            String name = validateAccount.Name();
            String age = validateAccount.Age();
            String gender = validateAccount.gender();
            String phoneNumber = validateAccount.PhoneNumber();
            String address = validateAccount.Address();
            System.out.println("Nhập role: ");
            String role = scanner.nextLine();
            return new Account(username,password,name,age,gender,phoneNumber,address,role);

        }

        public boolean checkUserName(String username) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUsername().equals(username)) {
                    return false;
                }
            }
            return true;
        }

        public void addAccount(Account account){
            accounts.add(account);
            readAndWrite.write(file,accounts);

        }

        public  void showAccount(){
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(accounts.get(i).toString());
            }
        }

        public void editAccount() {
            String Name;
            int index;
            while (true){
                System.out.println("Nhập username người dùng :");
                Name = scanner.nextLine();
                index = Integer.parseInt(findIndexByName(Name));
                if (index != -1) {
                    accounts.set(index,register());
                    System.err.println("Sửa thành công");
                    break;
                }else {
                    System.err.println("Không tìm thấy tên tài khoản ");
                }
            }
        }

        public void deleteAccount() {
            String name;
            int index;
            while (true){
                System.out.println("Nhập tên người dùng muốn xóa :");
                name = scanner.nextLine();
                index = Integer.parseInt(findIndexByName(name));
                if(index != -1){
                    accounts.remove(index);
                    System.err.println("Xóa thành công !!!");
                }else {
                    System.err.println("Không tìm thấy tài khoản");
                }
            }
        }

        public String findIndexByName(String Name){
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUsername().equals(Name)) {
                    return String.valueOf(i);
                }
            }
            return String.valueOf(-1);
        }
    public void menuAdmin() {
        while (true) {
            System.out.println(     "╔===========================╗\n" +
                                    "║        █ QUẢN LÝ █        ║\n" +
                                    "╠===========================╣\n" +
                                    "║>[1]. Quản lí Account      ║\n" +
                                    "║>[2]. Quản lí bán hàng     ║\n" +
                                    "║>[3]. Đăng xuất            ║\n" +
                                    "╚===========================╝");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuAccount();
                    break;
                case 2:
                    menuProduct();
                    break;
                case 3:
                    menuLogin();
                    break;
            }
        }
    }

    public void menuLogin() {
        while (true) {
            System.out.println("╔==================================╗\n" +
                               "║          ▅ ▆ █ LOGN █ ▆ ▅        ║\n" +
                               "╠==================================╣\n" +
                               "║>[1]. Đăng nhập                   ║\n" +
                               "║>[2]. Đăng kí                     ║\n" +
                               "║>[3]. Thoát                       ║\n" +
                               "╚==================================╝");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Account account = login();
                    if (account != null && account.getRole().equals("admin")) {
                        menuAdmin();
                    }else if(account != null && account.getRole().equals("user")){
                        MenuUser();
                    }
                    break;
                case 2:
                    Account account1 = register();
                    addAccount(account1);
                    break;
                case 3:
                    return;
            }
        }
    }
    public void menuAccount() {
        while (true) {
            System.out.println( "╔=================================╗\n" +
                                "║   ▅ ▆ █ QUẢN LÝ ACOUNT  █ ▆ ▅   ║\n" +
                                "╠=================================╣\n" +
                                "║>[1]. Hiển thị toàn bộ Account   ║\n" +
                                "║>[2]. Sửa Account theo tên       ║\n" +
                                "║>[3]. Xóa Account theo tên       ║\n" +
                                "║>[4]. Back                       ║\n" +
                                "╚=================================╝");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAccount();
                    break;
                case 2:
                    editAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    menuAdmin();
                    break;
            }
        }
    }

    public void menuProduct() {
        while (true) {
            System.out.println( "╔====================================╗");
            System.out.println( "║   ▅ ▆ █ QUẢN LÝ SẢN PHẨM █ ▆ ▅     ║");
            System.out.println( "╠====================================╣");
            System.out.println( "║>[1]. Hiển thị toàn phẩm            ║");
            System.out.println( "║>[2]. Thêm sản phẩm                 ║");
            System.out.println( "║>[3]. Sửa sản phẩm theo id          ║");
            System.out.println( "║>[4]. Xóa sản phẩm theo id          ║");
            System.out.println( "║>[5]. Doanh thu Sản phẩm            ║");
            System.out.println( "║>[6]. Back                          ║");
            System.out.println( "╚====================================╝");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.show();
                    break;
                case 2:
                    Product product = managerProduct.create();
                    managerProduct.add(product);
                    break;
                case 3:
                    managerProduct.edit();
                    break;
                case 4:
                    managerProduct.delete();
                    break;
                case 5:
                    managerProduct.money();
                case 6:
                    menuAdmin();
            }
        }
    }
    public void MenuUser() {
        while (true) {
                System.out.println( "╔===================================╗");
                System.out.println( "║   ▅ ▆ █ QUẢN LÝ KHÁCH HÀNG █ ▆ ▅  ║");
                System.out.println( "╠===================================╣");
                System.out.println( "║>[1]. Hiển thị toàn bộ sản phẩm    ║");
                System.out.println( "║>[2]. Xem giỏ hàng và tổng tiền    ║");
                System.out.println( "║>[3]. Sửa sản phẩm trong giỏ hàng  ║");
                System.out.println( "║>[4]. Thêm sản phẩm vào giỏ hàng   ║");
                System.out.println( "║>[5]. Thanh toán                   ║");
                System.out.println( "║>[6]. Đăng xuất                    ║");
                System.out.println( "╚===================================╝");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.show();
                    break;
                case 2:
                    managerProduct.showProduct();
                    break;
                case 3:
                    managerProduct.editProduct();
                    break;
                case 4:
                    managerProduct.buyProduct();
                    break;
                case 5:
                    managerProduct.pay();
                    break;
                case 6:
                    menuLogin();
                    break;
            }
        }
    }
        }