import java.util.Scanner;

public class Board {
    private Scanner in = new Scanner(System.in);
    private int[][] map = new int[3][3];

    public void play(){
        int player = 1;
        while(true){
            player ++;
            while(true){
                System.out.print("Line: ");
                int vertical = in.nextInt();
                System.out.print("column: ");
                int horizontal = in.nextInt();
                if(checkMove(vertical, horizontal)){
                    map[vertical-1][horizontal-1] = (player%2+1)+5;
                    showMap();
                    break;
                }
            }
            if(checkWinner(player)){
                break;
            }
        }
    }

    public boolean checkWinner(int player){
        //Check horizontal and vertical
        int total = 0;
        int total2 = 0;
        for(int y = 0;y < 3;y++){
            for(int x = 0;x < 3;x++){
                total += map[y][x];
                total2 += map[x][y];
            }
            if(total == 18 || total == 21 || total2 == 18 || total2 == 21){
                System.out.println(player % 2 == 0 ? "X win!!" : "O win!!");
                return true;
            }
            total = 0;
            total2 = 0;
        }

        //Check diagonal
        total = map[0][0] + map[1][1] + map[2][2];
        total2 = map[0][2] + map[1][1] + map[2][0];
        if(total == 18 || total == 21 || total2 == 18 || total2 == 21){
            System.out.println(player % 2 == 0 ? "X win!!" : "O win!!");
            return  true;
        }
        return false;
    }

    public boolean checkMove(int vertical, int horizontal){
        if(vertical < 1 || vertical > 3 || horizontal < 1 || horizontal > 3){
            System.out.println("Invalid address\n\n");
            return false;
        }
        if(map[vertical-1][horizontal-1] != 0){
            System.out.println("Address already in use\n\n");
            return false;
        }
        return true;
    }

    public void showMap(){
        for(int y = 0;y < 3;y++){
            for(int x = 0;x < 3;x++){
                switch(map[y][x]){
                    case 0:
                        System.out.print(" |");
                        break;
                    case 6:
                        System.out.print("X|");
                        break;
                    case 7:
                        System.out.print("O|");
                        break;
                }
            }
            System.out.println();
        }
    }
}