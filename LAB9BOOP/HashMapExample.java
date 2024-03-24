import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // สร้าง HashMap ที่เก็บข้อมูลเกี่ยวกับนักเรียนโดยมีเลขประจำตัวนักเรียนเป็นคีย์และชื่อเรียนเป็นค่า
        HashMap<Integer, String> studentMap = new HashMap<>();

        // เพิ่มข้อมูลลงใน HashMap
        studentMap.put(101, "John");
        studentMap.put(102, "Alice");
        studentMap.put(103, "Bob");
        studentMap.put(104, "Eva");

        // แสดงข้อมูลทั้งหมดใน HashMap
        System.out.println("Student HashMap: " + studentMap);

        // ดึงข้อมูลจาก HashMap ด้วยคีย์
        int studentId = 102;
        String studentName = studentMap.get(studentId);
        System.out.println("Student with ID " + studentId + ": " + studentName);

        // ตรวจสอบว่าคีย์มีอยู่ใน HashMap หรือไม่
        int checkKey = 105;
        boolean keyExists = studentMap.containsKey(checkKey);
        System.out.println("Key " + checkKey + " exists: " + keyExists);

        // ลบข้อมูลจาก HashMap ด้วยคีย์
        studentMap.remove(103);
        System.out.println("After removing student with ID 103: " + studentMap);
    }
}
