package ooad.demo1;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongym on 2017/2/28.
 */
public class Inventory {
    public List<Guitar> guitars;

    public Inventory() {
        this.guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, String builder, String model, String type, String backWood, String topWood, double price) {
        Guitar guitar = new Guitar(serialNumber,builder,model,type,backWood,topWood,price);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber){

        for (Guitar guitar:guitars) {
            if(guitar.getSerialNumber().equals(serialNumber)){
                return guitar;
            }
        }

        return null;
    }

    public Guitar search(Guitar searchGuitar){

        for (Guitar guitar: guitars) {

            if(searchGuitar.getBuilder().equals(guitar.getBuilder())){

            }

        }

        return null;
    }

    static class Data{
        byte[] datas = new byte[1024*1024*500];
    }

    public static void main(String[] args) {
        List<SoftReference<Data>> strings = new ArrayList<>();

        int i=0;
        try {
            while (true) {
                strings.add(new SoftReference<>(new Data()));
                i++;
            }
        } catch (Throwable throwable) {
            System.out.println(i);
            throwable.printStackTrace();
        }

    }

}
