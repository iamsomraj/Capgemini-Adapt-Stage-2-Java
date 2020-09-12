import java.util.*;

class Source {
   public static String encrypt(String message) {
      message = message.toLowerCase();
      char arr[] = message.toCharArray();
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == 'a') {
            arr[i] = 'e';
         } else if (arr[i] == 'e') {
            arr[i] = 'a';
         } else if (arr[i] == 'o') {
            arr[i] = 'u';
         } else if (arr[i] == 'u') {
            arr[i] = 'o';
         } else if (arr[i] == 'i') {
            arr[i] = '!';
         } else if (arr[i] == ' ') {
            arr[i] = '+';
         } else if (arr[i] == 'z') {
            arr[i] = 'b';
         } else if (arr[i] == 'd') {
            arr[i] = 'f';
         } else if (arr[i] == 'h') {
            arr[i] = 'j';
         } else if (arr[i] == 'n') {
            arr[i] = 'p';
         } else if (arr[i] == 't') {
            arr[i] = 'v';
         } else if (arr[i] == '9') {
            arr[i] = '0';
         } else if (arr[i] >= 'a' && arr[i] <= 'z') {
            arr[i] += 1;
         } else if (arr[i] >= '0' && arr[i] <= '9') {
            arr[i] += 1;
         }
      }
      return String.valueOf(arr);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String result = encrypt(sc.nextLine());
      System.out.println(result);
   }
}