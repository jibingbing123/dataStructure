package arithmetic;

/**
 * @description: 替换空格
 * @author: jibingbing
 * @create: 2018/04/03
 **/
public class Topic5 {

    public static void main(String[] args) {
        String s = "We are happy";
        String s1 = replaceBlank(s);
        System.out.println(s1);

    }

    public static String replaceBlank(String s){

        int blankNum = 0;
        for(int i = 0;i < s.length();i++){
            if(s.substring(i,i+1).equals(" ")){
                blankNum++;
            }
        }

        int newLength = s.length() + blankNum * 2;

        if(newLength < s.length()){
            return "替换空格后String长度不应该比之前的小";
        }

        char[] newString = new char[newLength];
        int indexOfOriginal = s.length() - 1;
        int indexOfNew = newLength - 1;

        while(indexOfOriginal >= 0 && indexOfNew >= 0){
            String temp = s.substring(indexOfOriginal,indexOfOriginal + 1);
            if(!temp.equals(" ")){
                newString[indexOfNew--] = s.charAt(indexOfOriginal);
                indexOfOriginal--;
            } else {
                indexOfOriginal--;
                indexOfNew -= 3;
                newString[indexOfNew] = '%';
                newString[indexOfNew + 1] = '2';
                newString[indexOfNew + 2] = '0';
            }
        }

        return String.valueOf(newString);
    }
}
