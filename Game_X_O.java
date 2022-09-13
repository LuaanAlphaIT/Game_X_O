import java.util.Scanner;

public class Game_X_O {
    public static void chessboard (byte[][] play) {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (i==0 || j==0) System.out.print(play[i][j] + " ");
                else if (play[i][j]==0) System.out.print("  ");
                else if (play[i][j]==1) System.out.print("X ");
                else System.out.print("O ");
            }
            System.out.print("\n");
        }
    }
    public static byte[][] playChess (byte[][] play, byte a, byte b, boolean XO) {
        if (XO) {
            play[a][b]=1;
        }
        else {
            play[a][b]=2;
        }
        return play;
    }
    public static byte checkWin (boolean XO,byte[][] play) {
        if (XO) {
            if (play[1][1]==1 && play[2][2]==1 && play[3][3]==1) return 1;
            if (play[3][1]==1 && play[2][2]==1 && play[1][3]==1) return 1;
            for (int i=1; i<4; i++) {
                if (play[i][1]==1 && play[i][2]==1 && play[i][3]==1) return 1;
            }
            for (int i=1; i<4; i++) {
                if (play[1][i]==1 && play[2][i]==1 && play[3][i]==1) return 1;
            }
        }
        else {
            if (play[1][1]==2 && play[2][2]==2 && play[3][3]==2) return 2;
            if (play[3][1]==2 && play[2][2]==2 && play[1][3]==2) return 2;
            for (int i=1; i<4; i++) {
                if (play[i][1]==2 && play[i][2]==2 && play[i][3]==2) return 2;
            }
            for (int i=1; i<4; i++) {
                if (play[1][i]==2 && play[2][i]==2 && play[3][i]==2) return 2;
            }
        }
        return 0;
    }
    public static boolean check (byte a, byte b, byte[][] play) {
        if (a<=0 || b<=0 || a>3 ||b>3) return false;
        if (play[a][b]!=0) return false;
        return true;
    }
    public static void main(String[] args) {
        boolean XO=true;
        byte[][] play = {
                {0, 1, 2, 3},
                {1, 0, 0, 0},
                {2, 0, 0, 0},
                {3, 0, 0, 0}
        };
        System.out.println("Game Start");
        while (true) {
            boolean run=true;
            byte x, y;
            Scanner scanner=new Scanner(System.in);
            while (true) {
                if (XO) {
                    System.out.print("X nhap vi tri: ");
                }
                else {
                    System.out.print("O nhap vi tri: ");
                }
                byte a = scanner.nextByte(), b = scanner.nextByte();
                if (check(a, b, play)) {
                    x=a;
                    y=b;
                    break;
                }
                System.out.println("Vi tri nhap bi loi roi :(((");
            }
            while (run) {
                play=playChess(play, x, y, XO);
                chessboard (play);
                run=false;
            }
            byte win=checkWin(XO, play);
            XO=!XO;
            if (win==1) {
                System.out.println("X Win");
                break;
            }
            else if (win==2){
                System.out.println("O Win");
                break;
            }
        }
    }
}
