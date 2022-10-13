package controller;

import io.ReadAndWrite;
import models.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    File file = new File("C:\\Users\\Asus\\Desktop\\New folder\\Case2module\\src\\filetext\\product.txt");

    File file1 = new File("C:\\Users\\Asus\\Desktop\\New folder\\Case2module\\src\\filetext\\giohang.txt");

    File file2 = new File("C:\\Users\\Asus\\Desktop\\New folder\\Case2module\\src\\filetext\\turnover");
    ReadAndWrite<Product> readAndWrite = new ReadAndWrite<>();
    ArrayList<Product> products = readAndWrite.read(file);
    ArrayList<Product> Giohang = readAndWrite.read(file1);
    //        ArrayList<Product> turnover = readAndWrite.read(file1);
    Scanner scanner = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public void add(Product product) {
        products.add(product);

        readAndWrite.write(file, products);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public Product create1() {
        int id;
        System.out.println("Nhập id :");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập price");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price);
    }

    public Product create() {
        int id;
        int index;
        while (true) {
            System.out.println("Nhập id :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index == -1) {
                break;
            }
            System.out.println("Nhập trùng id rồi.");
        }
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập price");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price);
    }

    public void edit() {
        int id;
        int index;
        while (true) {
            System.out.println("Nhập id sản phẩm cần sửa :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1) {
                products.set(index, create1());
                System.out.println("Sửa thành công");
                break;
            } else {
                System.out.println("Không tìm thấy id sản phẩm ");
            }
        }

    }

    public void delete() {
        int id;
        int index;
        while (true) {
            System.out.println("Nhập id sản phẩm muốn xóa");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1) {
                products.remove(index);
                System.out.println("Xóa thành công ");
                break;
            } else {
                System.err.println("Không có id sản phẩm cần xóa");
            }
        }
        readAndWrite.write(file, products);
    }

    public void buyProduct() {
        System.out.println("Nhập tên sản phẩm muốn thêm vào giỏ hàng :");
        String name = scanner.nextLine();
        int choice = 0;
        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getName().equals(name)) {
                Giohang.add(products.get(i));
                System.out.println("Thêm sản phẩm thành công");
                ++choice;
                break;
            }
            }if(choice == 0){
                System.err.println("Sản phẩm không tồn tại!!!");
            }
        readAndWrite.write(file1, Giohang);
    }

    public void editProduct() {
        System.out.println("Nhập tên sản phẩm muốn xóa khỏi giỏ hàng:");
        String name = scanner.nextLine();
        int choice = 0;
        for (int i = 0; i < Giohang.size(); i++) {
            if (Giohang.get(i).getName().equals(name)) {
                Giohang.remove(i);
                System.out.println("Xóa sản phẩm thành công");
                ++choice;
                break;
            }
        }
        if(choice == 0){
            System.err.println("Sản phẩm không tồn tại!");
        }
        readAndWrite.write(file1, Giohang);
    }


    public void showProduct() {
        for (int i = 0; i < Giohang.size(); i++) {
            System.out.println(Giohang.get(i).toString());
        }
        System.out.println("Tổng tiền giỏ hàng :" + allmoney());
    }

    public double allmoney() {
        double tongTien = 0.0;

        for (int i = 0; i < Giohang.size(); i++) {
            tongTien += Giohang.get(i).getPrice();
        }
        return tongTien;
    }

    public void pay() {
        System.out.println("Bạn có muốn mua hàng không ?");
        System.out.println("Y/N");
        String x = scanner.nextLine();
        if (x.equalsIgnoreCase("Y")) {
            System.out.println("Thanh toán thành công !");
        }
        Giohang = new ArrayList<>();
        readAndWrite.write(file1, Giohang);

    }

    public double money() {
        products = readAndWrite.read(file);
        Giohang = readAndWrite.read(file1);
        double doanhthu = 0;
        for (int i = 0; i < Giohang.size(); i++) {
            doanhthu += Giohang.get(i).getPrice();
        }
        System.out.println("|> Thu nhập của bạn là: " + doanhthu);
        return doanhthu;
    }
}