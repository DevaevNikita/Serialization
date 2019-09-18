package Application;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        boolean write_info = true;
            if(!write_info) {

                Catalog Nikita = new Catalog.Builder("+7(915)-150-88-88").Organization("ООО <<ОАК - Центр комплексирования>>").Note("birthday: 26.05.1995").build("Nikita", "Devaev");
                Catalog Alexandr = new Catalog.Builder("+7(915)-454-88-88").Organization("ООО <<ОАК - Центр комплексирования>>").Note("birthday: 217.06.1995").build("Alexandr", "Polov");

                List<Catalog> catalogs = new ArrayList<>();
                catalogs.add(Nikita);
                catalogs.add(Alexandr);

                try {
                    FileOutputStream fos = new FileOutputStream("temp.out");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    for (Catalog I : catalogs) {
                        oos.writeObject(I);
                        oos.flush();
                    }
                    oos.close();
                } catch (FileNotFoundException fnfe) {
                    System.out.println(fnfe);
                } catch (Exception e) {
                    System.out.println(e);
                }finally {
                    catalogs.clear();
                }
            }else{
                List<Catalog> catalogs = new ArrayList<>();
                try {
                    FileInputStream fis = new FileInputStream("temp.out");
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    while (fis.available() > 0){
                        Catalog catalog = (Catalog) ois.readObject();
                        catalogs.add(catalog);
                    }
                    ois.close();

                }catch (FileNotFoundException f) {
                    System.out.println(f);
                }catch (Exception e) {
                    System.out.println(e);
                }
                for(Catalog I: catalogs){
                    I.getInfo();
                }
            }
        }
}
