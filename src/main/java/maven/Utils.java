package maven;


/**
 * Created by User on 05.12.2015.
 */
public class Utils {
    public static boolean isStringIPv6(String ip) {
        int length = ip.length();
        int groupsCount = 0;
        int charsInGroup = 0;
        int colonsCount = 0;
        boolean doubleColonFound = false;
        char prevCh = ' ';
        for (int i = (length - 1); i >= 0; i--) {
            char ch = ip.charAt(i);
            if (charIsHex(ch)) {
                if ((length - 2) == i && ':' == prevCh) {
                    return false;
                }
                charsInGroup++;
                if (charsInGroup > 4) {
                    return false;
                }
                if (' ' == prevCh || ':' == prevCh) {
                    groupsCount++;
                    if (doubleColonFound && groupsCount > 6) {
                        return false;
                    }
                }
            } else if (':' == ch) {
                if (0 == i && charIsHex(prevCh)) {
                    return false;
                }
                if (++colonsCount > 7) {
                    return false;
                }
                if (':' == prevCh) {
                    if (doubleColonFound) {
                        return false;
                    } else {
                        doubleColonFound = true;
                    }
                }
                charsInGroup = 0;
            } else {
                return false;
            }
            prevCh = ch;
        }
        if (groupsCount < 8 && !doubleColonFound) {
            return false;
        }
        return true;
    }

    public static boolean charIsHex(char ch) {
        String stringFromCh = "" + ch;
        if (stringFromCh.matches("[0-9a-fA-F]*")) {
            return true;
        } else {
            return false;
        }
    }
}
