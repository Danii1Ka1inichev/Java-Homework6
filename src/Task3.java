import java.io.*;

public class Task3 {
    public static class Car implements Serializable {

        String country;
        String model;
        String color;

        Car(String country, String model, String color) {
            this.country = country;
            this.model = model;
            this.color = color;
        }

        public static void main(String[] args) {

            Car bmw = new Car("Germany", "X6 M", "Черный");
            Car nissan = new Car("Japan", "X-Trail", "Серый металлик");


            byte[] bytes = convertObjectToBytes(bmw);
            byte[] bytes1 = convertObjectToBytes(nissan);

            Car b = (Car) convertBytesToObject(bytes);
            Car n = (Car) convertBytesToObject(bytes1);

            System.out.println(b);
            System.out.println(n);

        }

        public static byte[] convertObjectToBytes(Object obj) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(obj);
                return baos.toByteArray();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            throw new RuntimeException();
        }

        public static Object convertBytesToObject(byte[] bytes) {
            InputStream is = new ByteArrayInputStream(bytes);
            try (ObjectInputStream ois = new ObjectInputStream(is)) {
                return ois.readObject();
            } catch (IOException | ClassNotFoundException ioe) {
                ioe.printStackTrace();
            }
            throw new RuntimeException();
        }

        public String toString () {
            return "Car{" +
                    "country=" + country +
                    ", model=" + model +
                    ", color=" + color +
                    '}';
        }
    }
}
