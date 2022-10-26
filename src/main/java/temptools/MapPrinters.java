package temptools;

public class MapPrinters {


    public static void printMap(Object[][] arr){
        for (int y = 0; y < arr[0].length; y++) {
            for (int x = 0; x < arr.length; x++) {
                System.out.print((Object) arr[x][y] + "\t");
            }
            System.out.println();
        }
    }
   /* public static String jaggerString(JaggerArray arr) {
        String str = "";
        int i = 0;
        for (int y = 0; y < arr.value.length; y++) {
            for (int x = 0; x < arr.value[y].size(); x++) {
                if(arr.value[y]!=null)i++;
                else{
                    str +=  i + "<BR>";
                    break;
                }
            }

            i = 0;

        }
        //System.out.println(str);
        return "<HTML>"+   str + "</HTML>";
    }*/
    public static void printJaggerArray(Object[][] arr){
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {

                //System.out.print((Object) arr[y][x] + "\t");
            }
            System.out.println(arr[y].length);
            System.out.println();
        }
    }

}
