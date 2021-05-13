public class main {
    public static void main(String[] args) throws Exception {

        MDFive md5 = new MDFive();
        String ship = md5.computeDigest("D:/Dzik/Java/ITSec/src/ship.jpg");
        String plane = md5.computeDigest("D:/Dzik/Java/ITSec/src/plane.jpg");
        System.out.println("MD5 value for ship: " + ship);
        System.out.println("MD5 value for plane: " + plane);
    }
}
