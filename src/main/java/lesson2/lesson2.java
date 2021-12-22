package lesson2;

public class lesson2 {
    public static void main(String[] args) {

        String[][] testStrArray1 = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
        };

        String[][] testStrArray2 = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4","5"}
        };

        String[][] testStrArray3 = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","0.5"},
        };

        System.out.println(arraySum(testStrArray1));
        //System.out.println(arraySum(testStrArray2));
        System.out.println(arraySum(testStrArray3));
    }

    public static int arraySum(String[][] arrStr) {

        if (arrStr.length == 4) {
            for (String[] i : arrStr) {
                if (i.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        else {
            throw new MyArraySizeException();
        }

        int arraySum = 0;
        for (int i = 0; i < arrStr.length; i++){
            for (int j=0; j < arrStr[i].length; j++ ){
                try{
                    arraySum += Integer.parseInt(arrStr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return arraySum;
    }
}