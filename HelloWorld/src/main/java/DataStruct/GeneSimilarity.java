package DataStruct;

public class GeneSimilarity {
    /**
     * @param Gene1: a string
     * @param Gene2: a string
     * @return: return the similarity of two gene fragments
     */
    int    count;
    int    index;
    char[] arrStr;
    char   baseChar;

    void updateBaseChar() {
        baseChar = ' ';
        count = 0;
        if (index >= arrStr.length) {
            return;
        }
        while (baseChar == ' ') {
            if (arrStr[index] >= '0' && arrStr[index] <= '9') {
                count = count * 10 + arrStr[index]-'0';
            } else {
                baseChar = arrStr[index];
            }
            index++;
        }
    }

    public GeneSimilarity(String str) {
        count = 0;
        baseChar = ' ';
        arrStr = str.toCharArray();
        index = 0;
    }

    public GeneSimilarity() {
    }

    public static String GeneSimilarity(String str1, String str2) {
        // write your code here
        if (str1 == null || str2 == null) {
            return null;
        }
        GeneSimilarity g1 = new GeneSimilarity(str1);
        GeneSimilarity g2 = new GeneSimilarity(str2);
        g1.updateBaseChar();
        g2.updateBaseChar();
        int sameCnt = 0;
        int strLength = g1.count;
        while (g1.baseChar != ' ' && g2.baseChar != ' ') {
            if (g1.baseChar == g2.baseChar) {
                sameCnt += Math.min(g1.count, g2.count);

            }
            if (g1.count > g2.count) {
                g1.count -= g2.count;
                g2.updateBaseChar();
            } else if (g1.count < g2.count) {
                g2.count -= g1.count;
                g1.updateBaseChar();
                strLength += g1.count;
            } else {
                g1.updateBaseChar();
                g2.updateBaseChar();
                strLength += g1.count;
            }

        }
        return sameCnt + "/" + strLength;

    }

    public static void main(String[] args) {
        System.out.println(GeneSimilarity.GeneSimilarity("1A2T","2A1T"));
    }
}