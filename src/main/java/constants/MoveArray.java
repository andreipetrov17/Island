package constants;

import entity.CanMove;

public class MoveArray {
    public CanMove[][] value;
    public int demension;



    public MoveArray(int i) {
        demension = i;
        value = new CanMove[i * 2 + 1][];
        value[i] = new CanMove[2 * i + 1];
        int delta = 1;
        for (int y = 0; y < value.length; y++) {
            if (y == i) break;
            value[y] = new CanMove[delta];
            value[value.length - y - 1] = new CanMove[delta];
            delta += 2;
        }
        /*
        create this arrays:
                    #
         #         ###
        ###       #####
         #         ###
                    #
        its used for move animal
         */
    }
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder("<HTML>");
            for (CanMove[] canMoves : value) {
                for (CanMove canMove : canMoves) {
                  if(canMove!= null)
                    str.append(" ").append(canMove).append(" ");
                  else str.append("O");
                }
                str.append("<BR>");
            }
            return  str.append("</HTML>").toString();
        }


}
