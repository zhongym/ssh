//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.commons.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.CharSetUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.text.StrBuilder;

public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;

    public StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /** @deprecated */
    public static String clean(String str) {
        return str == null?"":str.trim();
    }

    public static String trim(String str) {
        return str == null?null:str.trim();
    }

    public static String trimToNull(String str) {
        String ts = trim(str);
        return isEmpty(ts)?null:ts;
    }

    public static String trimToEmpty(String str) {
        return str == null?"":str.trim();
    }

    public static String strip(String str) {
        return strip(str, (String)null);
    }

    public static String stripToNull(String str) {
        if(str == null) {
            return null;
        } else {
            str = strip(str, (String)null);
            return str.length() == 0?null:str;
        }
    }

    public static String stripToEmpty(String str) {
        return str == null?"":strip(str, (String)null);
    }

    public static String strip(String str, String stripChars) {
        if(isEmpty(str)) {
            return str;
        } else {
            str = stripStart(str, stripChars);
            return stripEnd(str, stripChars);
        }
    }

    public static String stripStart(String str, String stripChars) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            int start = 0;
            if(stripChars == null) {
                while(start != strLen && Character.isWhitespace(str.charAt(start))) {
                    ++start;
                }
            } else {
                if(stripChars.length() == 0) {
                    return str;
                }

                while(start != strLen && stripChars.indexOf(str.charAt(start)) != -1) {
                    ++start;
                }
            }

            return str.substring(start);
        } else {
            return str;
        }
    }

    public static String stripEnd(String str, String stripChars) {
        int end;
        if(str != null && (end = str.length()) != 0) {
            if(stripChars == null) {
                while(end != 0 && Character.isWhitespace(str.charAt(end - 1))) {
                    --end;
                }
            } else {
                if(stripChars.length() == 0) {
                    return str;
                }

                while(end != 0 && stripChars.indexOf(str.charAt(end - 1)) != -1) {
                    --end;
                }
            }

            return str.substring(0, end);
        } else {
            return str;
        }
    }

    public static String[] stripAll(String[] strs) {
        return stripAll(strs, (String)null);
    }

    public static String[] stripAll(String[] strs, String stripChars) {
        int strsLen;
        if(strs != null && (strsLen = strs.length) != 0) {
            String[] newArr = new String[strsLen];

            for(int i = 0; i < strsLen; ++i) {
                newArr[i] = strip(strs[i], stripChars);
            }

            return newArr;
        } else {
            return strs;
        }
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null?str2 == null:str1.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null?str2 == null:str1.equalsIgnoreCase(str2);
    }

    public static int indexOf(String str, char searchChar) {
        return isEmpty(str)?-1:str.indexOf(searchChar);
    }

    public static int indexOf(String str, char searchChar, int startPos) {
        return isEmpty(str)?-1:str.indexOf(searchChar, startPos);
    }

    public static int indexOf(String str, String searchStr) {
        return str != null && searchStr != null?str.indexOf(searchStr):-1;
    }

    public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
        return ordinalIndexOf(str, searchStr, ordinal, false);
    }

    private static int ordinalIndexOf(String str, String searchStr, int ordinal, boolean lastIndex) {
        if(str != null && searchStr != null && ordinal > 0) {
            if(searchStr.length() == 0) {
                return lastIndex?str.length():0;
            } else {
                int found = 0;
                int index = lastIndex?str.length():-1;

                do {
                    if(lastIndex) {
                        index = str.lastIndexOf(searchStr, index - 1);
                    } else {
                        index = str.indexOf(searchStr, index + 1);
                    }

                    if(index < 0) {
                        return index;
                    }

                    ++found;
                } while(found < ordinal);

                return index;
            }
        } else {
            return -1;
        }
    }

    public static int indexOf(String str, String searchStr, int startPos) {
        return str != null && searchStr != null?(searchStr.length() == 0 && startPos >= str.length()?str.length():str.indexOf(searchStr, startPos)):-1;
    }

    public static int indexOfIgnoreCase(String str, String searchStr) {
        return indexOfIgnoreCase(str, searchStr, 0);
    }

    public static int indexOfIgnoreCase(String str, String searchStr, int startPos) {
        if(str != null && searchStr != null) {
            if(startPos < 0) {
                startPos = 0;
            }

            int endLimit = str.length() - searchStr.length() + 1;
            if(startPos > endLimit) {
                return -1;
            } else if(searchStr.length() == 0) {
                return startPos;
            } else {
                for(int i = startPos; i < endLimit; ++i) {
                    if(str.regionMatches(true, i, searchStr, 0, searchStr.length())) {
                        return i;
                    }
                }

                return -1;
            }
        } else {
            return -1;
        }
    }

    public static int lastIndexOf(String str, char searchChar) {
        return isEmpty(str)?-1:str.lastIndexOf(searchChar);
    }

    public static int lastIndexOf(String str, char searchChar, int startPos) {
        return isEmpty(str)?-1:str.lastIndexOf(searchChar, startPos);
    }

    public static int lastIndexOf(String str, String searchStr) {
        return str != null && searchStr != null?str.lastIndexOf(searchStr):-1;
    }

    public static int lastOrdinalIndexOf(String str, String searchStr, int ordinal) {
        return ordinalIndexOf(str, searchStr, ordinal, true);
    }

    public static int lastIndexOf(String str, String searchStr, int startPos) {
        return str != null && searchStr != null?str.lastIndexOf(searchStr, startPos):-1;
    }

    public static int lastIndexOfIgnoreCase(String str, String searchStr) {
        return str != null && searchStr != null?lastIndexOfIgnoreCase(str, searchStr, str.length()):-1;
    }

    public static int lastIndexOfIgnoreCase(String str, String searchStr, int startPos) {
        if(str != null && searchStr != null) {
            if(startPos > str.length() - searchStr.length()) {
                startPos = str.length() - searchStr.length();
            }

            if(startPos < 0) {
                return -1;
            } else if(searchStr.length() == 0) {
                return startPos;
            } else {
                for(int i = startPos; i >= 0; --i) {
                    if(str.regionMatches(true, i, searchStr, 0, searchStr.length())) {
                        return i;
                    }
                }

                return -1;
            }
        } else {
            return -1;
        }
    }

    public static boolean contains(String str, char searchChar) {
        return isEmpty(str)?false:str.indexOf(searchChar) >= 0;
    }

    public static boolean contains(String str, String searchStr) {
        return str != null && searchStr != null?str.indexOf(searchStr) >= 0:false;
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if(str != null && searchStr != null) {
            int len = searchStr.length();
            int max = str.length() - len;

            for(int i = 0; i <= max; ++i) {
                if(str.regionMatches(true, i, searchStr, 0, len)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static int indexOfAny(String str, char[] searchChars) {
        if(!isEmpty(str) && !ArrayUtils.isEmpty(searchChars)) {
            int csLen = str.length();
            int csLast = csLen - 1;
            int searchLen = searchChars.length;
            int searchLast = searchLen - 1;

            for(int i = 0; i < csLen; ++i) {
                char ch = str.charAt(i);

                for(int j = 0; j < searchLen; ++j) {
                    if(searchChars[j] == ch) {
                        if(i >= csLast || j >= searchLast || !CharUtils.isHighSurrogate(ch)) {
                            return i;
                        }

                        if(searchChars[j + 1] == str.charAt(i + 1)) {
                            return i;
                        }
                    }
                }
            }

            return -1;
        } else {
            return -1;
        }
    }

    public static int indexOfAny(String str, String searchChars) {
        return !isEmpty(str) && !isEmpty(searchChars)?indexOfAny(str, searchChars.toCharArray()):-1;
    }

    public static boolean containsAny(String str, char[] searchChars) {
        if(!isEmpty(str) && !ArrayUtils.isEmpty(searchChars)) {
            int csLength = str.length();
            int searchLength = searchChars.length;
            int csLast = csLength - 1;
            int searchLast = searchLength - 1;

            for(int i = 0; i < csLength; ++i) {
                char ch = str.charAt(i);

                for(int j = 0; j < searchLength; ++j) {
                    if(searchChars[j] == ch) {
                        if(!CharUtils.isHighSurrogate(ch)) {
                            return true;
                        }

                        if(j == searchLast) {
                            return true;
                        }

                        if(i < csLast && searchChars[j + 1] == str.charAt(i + 1)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean containsAny(String str, String searchChars) {
        return searchChars == null?false:containsAny(str, searchChars.toCharArray());
    }

    public static int indexOfAnyBut(String str, char[] searchChars) {
        if(!isEmpty(str) && !ArrayUtils.isEmpty(searchChars)) {
            int csLen = str.length();
            int csLast = csLen - 1;
            int searchLen = searchChars.length;
            int searchLast = searchLen - 1;

            label38:
            for(int i = 0; i < csLen; ++i) {
                char ch = str.charAt(i);

                for(int j = 0; j < searchLen; ++j) {
                    if(searchChars[j] == ch && (i >= csLast || j >= searchLast || !CharUtils.isHighSurrogate(ch) || searchChars[j + 1] == str.charAt(i + 1))) {
                        continue label38;
                    }
                }

                return i;
            }

            return -1;
        } else {
            return -1;
        }
    }

    public static int indexOfAnyBut(String str, String searchChars) {
        if(!isEmpty(str) && !isEmpty(searchChars)) {
            int strLen = str.length();

            for(int i = 0; i < strLen; ++i) {
                char ch = str.charAt(i);
                boolean chFound = searchChars.indexOf(ch) >= 0;
                if(i + 1 < strLen && CharUtils.isHighSurrogate(ch)) {
                    char ch2 = str.charAt(i + 1);
                    if(chFound && searchChars.indexOf(ch2) < 0) {
                        return i;
                    }
                } else if(!chFound) {
                    return i;
                }
            }

            return -1;
        } else {
            return -1;
        }
    }

    public static boolean containsOnly(String str, char[] valid) {
        return valid != null && str != null?(str.length() == 0?true:(valid.length == 0?false:indexOfAnyBut(str, valid) == -1)):false;
    }

    public static boolean containsOnly(String str, String validChars) {
        return str != null && validChars != null?containsOnly(str, validChars.toCharArray()):false;
    }

    public static boolean containsNone(String str, char[] searchChars) {
        if(str != null && searchChars != null) {
            int csLen = str.length();
            int csLast = csLen - 1;
            int searchLen = searchChars.length;
            int searchLast = searchLen - 1;

            for(int i = 0; i < csLen; ++i) {
                char ch = str.charAt(i);

                for(int j = 0; j < searchLen; ++j) {
                    if(searchChars[j] == ch) {
                        if(!CharUtils.isHighSurrogate(ch)) {
                            return false;
                        }

                        if(j == searchLast) {
                            return false;
                        }

                        if(i < csLast && searchChars[j + 1] == str.charAt(i + 1)) {
                            return false;
                        }
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean containsNone(String str, String invalidChars) {
        return str != null && invalidChars != null?containsNone(str, invalidChars.toCharArray()):true;
    }

    public static int indexOfAny(String str, String[] searchStrs) {
        if(str != null && searchStrs != null) {
            int sz = searchStrs.length;
            int ret = 2147483647;
            boolean tmp = false;

            for(int i = 0; i < sz; ++i) {
                String search = searchStrs[i];
                if(search != null) {
                    int var7 = str.indexOf(search);
                    if(var7 != -1 && var7 < ret) {
                        ret = var7;
                    }
                }
            }

            return ret == 2147483647?-1:ret;
        } else {
            return -1;
        }
    }

    public static int lastIndexOfAny(String str, String[] searchStrs) {
        if(str != null && searchStrs != null) {
            int sz = searchStrs.length;
            int ret = -1;
            boolean tmp = false;

            for(int i = 0; i < sz; ++i) {
                String search = searchStrs[i];
                if(search != null) {
                    int var7 = str.lastIndexOf(search);
                    if(var7 > ret) {
                        ret = var7;
                    }
                }
            }

            return ret;
        } else {
            return -1;
        }
    }

    public static String substring(String str, int start) {
        if(str == null) {
            return null;
        } else {
            if(start < 0) {
                start += str.length();
            }

            if(start < 0) {
                start = 0;
            }

            return start > str.length()?"":str.substring(start);
        }
    }

    public static String substring(String str, int start, int end) {
        if(str == null) {
            return null;
        } else {
            if(end < 0) {
                end += str.length();
            }

            if(start < 0) {
                start += str.length();
            }

            if(end > str.length()) {
                end = str.length();
            }

            if(start > end) {
                return "";
            } else {
                if(start < 0) {
                    start = 0;
                }

                if(end < 0) {
                    end = 0;
                }

                return str.substring(start, end);
            }
        }
    }

    public static String left(String str, int len) {
        return str == null?null:(len < 0?"":(str.length() <= len?str:str.substring(0, len)));
    }

    public static String right(String str, int len) {
        return str == null?null:(len < 0?"":(str.length() <= len?str:str.substring(str.length() - len)));
    }

    public static String mid(String str, int pos, int len) {
        if(str == null) {
            return null;
        } else if(len >= 0 && pos <= str.length()) {
            if(pos < 0) {
                pos = 0;
            }

            return str.length() <= pos + len?str.substring(pos):str.substring(pos, pos + len);
        } else {
            return "";
        }
    }

    public static String substringBefore(String str, String separator) {
        if(!isEmpty(str) && separator != null) {
            if(separator.length() == 0) {
                return "";
            } else {
                int pos = str.indexOf(separator);
                return pos == -1?str:str.substring(0, pos);
            }
        } else {
            return str;
        }
    }

    public static String substringAfter(String str, String separator) {
        if(isEmpty(str)) {
            return str;
        } else if(separator == null) {
            return "";
        } else {
            int pos = str.indexOf(separator);
            return pos == -1?"":str.substring(pos + separator.length());
        }
    }

    public static String substringBeforeLast(String str, String separator) {
        if(!isEmpty(str) && !isEmpty(separator)) {
            int pos = str.lastIndexOf(separator);
            return pos == -1?str:str.substring(0, pos);
        } else {
            return str;
        }
    }

    public static String substringAfterLast(String str, String separator) {
        if(isEmpty(str)) {
            return str;
        } else if(isEmpty(separator)) {
            return "";
        } else {
            int pos = str.lastIndexOf(separator);
            return pos != -1 && pos != str.length() - separator.length()?str.substring(pos + separator.length()):"";
        }
    }

    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    public static String substringBetween(String str, String open, String close) {
        if(str != null && open != null && close != null) {
            int start = str.indexOf(open);
            if(start != -1) {
                int end = str.indexOf(close, start + open.length());
                if(end != -1) {
                    return str.substring(start + open.length(), end);
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public static String[] substringsBetween(String str, String open, String close) {
        if(str != null && !isEmpty(open) && !isEmpty(close)) {
            int strLen = str.length();
            if(strLen == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            } else {
                int closeLen = close.length();
                int openLen = open.length();
                ArrayList list = new ArrayList();

                int end;
                for(int pos = 0; pos < strLen - closeLen; pos = end + closeLen) {
                    int start = str.indexOf(open, pos);
                    if(start < 0) {
                        break;
                    }

                    start += openLen;
                    end = str.indexOf(close, start);
                    if(end < 0) {
                        break;
                    }

                    list.add(str.substring(start, end));
                }

                return list.isEmpty()?null:(String[])((String[])list.toArray(new String[list.size()]));
            }
        } else {
            return null;
        }
    }

    /** @deprecated */
    public static String getNestedString(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /** @deprecated */
    public static String getNestedString(String str, String open, String close) {
        return substringBetween(str, open, close);
    }

    public static String[] split(String str) {
        return split(str, (String)null, -1);
    }

    public static String[] split(String str, char separatorChar) {
        return splitWorker(str, separatorChar, false);
    }

    public static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }

    public static String[] split(String str, String separatorChars, int max) {
        return splitWorker(str, separatorChars, max, false);
    }

    public static String[] splitByWholeSeparator(String str, String separator) {
        return splitByWholeSeparatorWorker(str, separator, -1, false);
    }

    public static String[] splitByWholeSeparator(String str, String separator, int max) {
        return splitByWholeSeparatorWorker(str, separator, max, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        return splitByWholeSeparatorWorker(str, separator, -1, true);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator, int max) {
        return splitByWholeSeparatorWorker(str, separator, max, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String separator, int max, boolean preserveAllTokens) {
        if(str == null) {
            return null;
        } else {
            int len = str.length();
            if(len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            } else if(separator != null && !"".equals(separator)) {
                int separatorLength = separator.length();
                ArrayList substrings = new ArrayList();
                int numberOfSubstrings = 0;
                int beg = 0;
                int end = 0;

                while(end < len) {
                    end = str.indexOf(separator, beg);
                    if(end > -1) {
                        if(end > beg) {
                            ++numberOfSubstrings;
                            if(numberOfSubstrings == max) {
                                end = len;
                                substrings.add(str.substring(beg));
                            } else {
                                substrings.add(str.substring(beg, end));
                                beg = end + separatorLength;
                            }
                        } else {
                            if(preserveAllTokens) {
                                ++numberOfSubstrings;
                                if(numberOfSubstrings == max) {
                                    end = len;
                                    substrings.add(str.substring(beg));
                                } else {
                                    substrings.add("");
                                }
                            }

                            beg = end + separatorLength;
                        }
                    } else {
                        substrings.add(str.substring(beg));
                        end = len;
                    }
                }

                return (String[])((String[])substrings.toArray(new String[substrings.size()]));
            } else {
                return splitWorker(str, (String)null, max, preserveAllTokens);
            }
        }
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, (String)null, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, char separatorChar) {
        return splitWorker(str, separatorChar, true);
    }

    private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        if(str == null) {
            return null;
        } else {
            int len = str.length();
            if(len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            } else {
                ArrayList list = new ArrayList();
                int i = 0;
                int start = 0;
                boolean match = false;
                boolean lastMatch = false;

                while(true) {
                    while(i < len) {
                        if(str.charAt(i) == separatorChar) {
                            if(match || preserveAllTokens) {
                                list.add(str.substring(start, i));
                                match = false;
                                lastMatch = true;
                            }

                            ++i;
                            start = i;
                        } else {
                            lastMatch = false;
                            match = true;
                            ++i;
                        }
                    }

                    if(match || preserveAllTokens && lastMatch) {
                        list.add(str.substring(start, i));
                    }

                    return (String[])((String[])list.toArray(new String[list.size()]));
                }
            }
        }
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
        return splitWorker(str, separatorChars, max, true);
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        if(str == null) {
            return null;
        } else {
            int len = str.length();
            if(len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            } else {
                ArrayList list = new ArrayList();
                int sizePlus1 = 1;
                int i = 0;
                int start = 0;
                boolean match = false;
                boolean lastMatch = false;
                if(separatorChars != null) {
                    if(separatorChars.length() != 1) {
                        label87:
                        while(true) {
                            while(true) {
                                if(i >= len) {
                                    break label87;
                                }

                                if(separatorChars.indexOf(str.charAt(i)) >= 0) {
                                    if(match || preserveAllTokens) {
                                        lastMatch = true;
                                        if(sizePlus1++ == max) {
                                            i = len;
                                            lastMatch = false;
                                        }

                                        list.add(str.substring(start, i));
                                        match = false;
                                    }

                                    ++i;
                                    start = i;
                                } else {
                                    lastMatch = false;
                                    match = true;
                                    ++i;
                                }
                            }
                        }
                    } else {
                        char sep = separatorChars.charAt(0);

                        label71:
                        while(true) {
                            while(true) {
                                if(i >= len) {
                                    break label71;
                                }

                                if(str.charAt(i) == sep) {
                                    if(match || preserveAllTokens) {
                                        lastMatch = true;
                                        if(sizePlus1++ == max) {
                                            i = len;
                                            lastMatch = false;
                                        }

                                        list.add(str.substring(start, i));
                                        match = false;
                                    }

                                    ++i;
                                    start = i;
                                } else {
                                    lastMatch = false;
                                    match = true;
                                    ++i;
                                }
                            }
                        }
                    }
                } else {
                    label103:
                    while(true) {
                        while(true) {
                            if(i >= len) {
                                break label103;
                            }

                            if(Character.isWhitespace(str.charAt(i))) {
                                if(match || preserveAllTokens) {
                                    lastMatch = true;
                                    if(sizePlus1++ == max) {
                                        i = len;
                                        lastMatch = false;
                                    }

                                    list.add(str.substring(start, i));
                                    match = false;
                                }

                                ++i;
                                start = i;
                            } else {
                                lastMatch = false;
                                match = true;
                                ++i;
                            }
                        }
                    }
                }

                if(match || preserveAllTokens && lastMatch) {
                    list.add(str.substring(start, i));
                }

                return (String[])((String[])list.toArray(new String[list.size()]));
            }
        }
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    private static String[] splitByCharacterType(String str, boolean camelCase) {
        if(str == null) {
            return null;
        } else if(str.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        } else {
            char[] c = str.toCharArray();
            ArrayList list = new ArrayList();
            int tokenStart = 0;
            int currentType = Character.getType(c[tokenStart]);

            for(int pos = tokenStart + 1; pos < c.length; ++pos) {
                int type = Character.getType(c[pos]);
                if(type != currentType) {
                    if(camelCase && type == 2 && currentType == 1) {
                        int newTokenStart = pos - 1;
                        if(newTokenStart != tokenStart) {
                            list.add(new String(c, tokenStart, newTokenStart - tokenStart));
                            tokenStart = newTokenStart;
                        }
                    } else {
                        list.add(new String(c, tokenStart, pos - tokenStart));
                        tokenStart = pos;
                    }

                    currentType = type;
                }
            }

            list.add(new String(c, tokenStart, c.length - tokenStart));
            return (String[])((String[])list.toArray(new String[list.size()]));
        }
    }

    /** @deprecated */
    public static String concatenate(Object[] array) {
        return join((Object[])array, (String)null);
    }

    public static String join(Object[] array) {
        return join((Object[])array, (String)null);
    }

    public static String join(Object[] array, char separator) {
        return array == null?null:join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        if(array == null) {
            return null;
        } else {
            int bufSize = endIndex - startIndex;
            if(bufSize <= 0) {
                return "";
            } else {
                bufSize *= (array[startIndex] == null?16:array[startIndex].toString().length()) + 1;
                StrBuilder buf = new StrBuilder(bufSize);

                for(int i = startIndex; i < endIndex; ++i) {
                    if(i > startIndex) {
                        buf.append(separator);
                    }

                    if(array[i] != null) {
                        buf.append(array[i]);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Object[] array, String separator) {
        return array == null?null:join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if(array == null) {
            return null;
        } else {
            if(separator == null) {
                separator = "";
            }

            int bufSize = endIndex - startIndex;
            if(bufSize <= 0) {
                return "";
            } else {
                bufSize *= (array[startIndex] == null?16:array[startIndex].toString().length()) + separator.length();
                StrBuilder buf = new StrBuilder(bufSize);

                for(int i = startIndex; i < endIndex; ++i) {
                    if(i > startIndex) {
                        buf.append(separator);
                    }

                    if(array[i] != null) {
                        buf.append(array[i]);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Iterator iterator, char separator) {
        if(iterator == null) {
            return null;
        } else if(!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if(!iterator.hasNext()) {
                return ObjectUtils.toString(first);
            } else {
                StrBuilder buf = new StrBuilder(256);
                if(first != null) {
                    buf.append(first);
                }

                while(iterator.hasNext()) {
                    buf.append(separator);
                    Object obj = iterator.next();
                    if(obj != null) {
                        buf.append(obj);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Iterator iterator, String separator) {
        if(iterator == null) {
            return null;
        } else if(!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if(!iterator.hasNext()) {
                return ObjectUtils.toString(first);
            } else {
                StrBuilder buf = new StrBuilder(256);
                if(first != null) {
                    buf.append(first);
                }

                while(iterator.hasNext()) {
                    if(separator != null) {
                        buf.append(separator);
                    }

                    Object obj = iterator.next();
                    if(obj != null) {
                        buf.append(obj);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Collection collection, char separator) {
        return collection == null?null:join(collection.iterator(), separator);
    }

    public static String join(Collection collection, String separator) {
        return collection == null?null:join(collection.iterator(), separator);
    }

    /** @deprecated */
    public static String deleteSpaces(String str) {
        return str == null?null:CharSetUtils.delete(str, " \t\r\n\b");
    }

    public static String deleteWhitespace(String str) {
        if(isEmpty(str)) {
            return str;
        } else {
            int sz = str.length();
            char[] chs = new char[sz];
            int count = 0;

            for(int i = 0; i < sz; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    chs[count++] = str.charAt(i);
                }
            }

            if(count == sz) {
                return str;
            } else {
                return new String(chs, 0, count);
            }
        }
    }

    public static String removeStart(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove)?(str.startsWith(remove)?str.substring(remove.length()):str):str;
    }

    public static String removeStartIgnoreCase(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove)?(startsWithIgnoreCase(str, remove)?str.substring(remove.length()):str):str;
    }

    public static String removeEnd(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove)?(str.endsWith(remove)?str.substring(0, str.length() - remove.length()):str):str;
    }

    public static String removeEndIgnoreCase(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove)?(endsWithIgnoreCase(str, remove)?str.substring(0, str.length() - remove.length()):str):str;
    }

    public static String remove(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove)?replace(str, remove, "", -1):str;
    }

    public static String remove(String str, char remove) {
        if(!isEmpty(str) && str.indexOf(remove) != -1) {
            char[] chars = str.toCharArray();
            int pos = 0;

            for(int i = 0; i < chars.length; ++i) {
                if(chars[i] != remove) {
                    chars[pos++] = chars[i];
                }
            }

            return new String(chars, 0, pos);
        } else {
            return str;
        }
    }

    public static String replaceOnce(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, 1);
    }

    public static String replace(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, -1);
    }

    public static String replace(String text, String searchString, String replacement, int max) {
        if(!isEmpty(text) && !isEmpty(searchString) && replacement != null && max != 0) {
            int start = 0;
            int end = text.indexOf(searchString, start);
            if(end == -1) {
                return text;
            } else {
                int replLength = searchString.length();
                int increase = replacement.length() - replLength;
                increase = increase < 0?0:increase;
                increase *= max < 0?16:(max > 64?64:max);

                StrBuilder buf;
                for(buf = new StrBuilder(text.length() + increase); end != -1; end = text.indexOf(searchString, start)) {
                    buf.append(text.substring(start, end)).append(replacement);
                    start = end + replLength;
                    --max;
                    if(max == 0) {
                        break;
                    }
                }

                buf.append(text.substring(start));
                return buf.toString();
            }
        } else {
            return text;
        }
    }

    public static String replaceEach(String text, String[] searchList, String[] replacementList) {
        return replaceEach(text, searchList, replacementList, false, 0);
    }

    public static String replaceEachRepeatedly(String text, String[] searchList, String[] replacementList) {
        int timeToLive = searchList == null?0:searchList.length;
        return replaceEach(text, searchList, replacementList, true, timeToLive);
    }

    private static String replaceEach(String text, String[] searchList, String[] replacementList, boolean repeat, int timeToLive) {
        if(text != null && text.length() != 0 && searchList != null && searchList.length != 0 && replacementList != null && replacementList.length != 0) {
            if(timeToLive < 0) {
                throw new IllegalStateException("TimeToLive of " + timeToLive + " is less than 0: " + text);
            } else {
                int searchLength = searchList.length;
                int replacementLength = replacementList.length;
                if(searchLength != replacementLength) {
                    throw new IllegalArgumentException("Search and Replace array lengths don\'t match: " + searchLength + " vs " + replacementLength);
                } else {
                    boolean[] noMoreMatchesForReplIndex = new boolean[searchLength];
                    int textIndex = -1;
                    int replaceIndex = -1;
                    boolean tempIndex = true;

                    int start;
                    int var16;
                    for(start = 0; start < searchLength; ++start) {
                        if(!noMoreMatchesForReplIndex[start] && searchList[start] != null && searchList[start].length() != 0 && replacementList[start] != null) {
                            var16 = text.indexOf(searchList[start]);
                            if(var16 == -1) {
                                noMoreMatchesForReplIndex[start] = true;
                            } else if(textIndex == -1 || var16 < textIndex) {
                                textIndex = var16;
                                replaceIndex = start;
                            }
                        }
                    }

                    if(textIndex == -1) {
                        return text;
                    } else {
                        start = 0;
                        int increase = 0;

                        int textLength;
                        for(int buf = 0; buf < searchList.length; ++buf) {
                            if(searchList[buf] != null && replacementList[buf] != null) {
                                textLength = replacementList[buf].length() - searchList[buf].length();
                                if(textLength > 0) {
                                    increase += 3 * textLength;
                                }
                            }
                        }

                        increase = Math.min(increase, text.length() / 5);
                        StrBuilder var17 = new StrBuilder(text.length() + increase);

                        while(textIndex != -1) {
                            for(textLength = start; textLength < textIndex; ++textLength) {
                                var17.append(text.charAt(textLength));
                            }

                            var17.append(replacementList[replaceIndex]);
                            start = textIndex + searchList[replaceIndex].length();
                            textIndex = -1;
                            replaceIndex = -1;
                            tempIndex = true;

                            for(textLength = 0; textLength < searchLength; ++textLength) {
                                if(!noMoreMatchesForReplIndex[textLength] && searchList[textLength] != null && searchList[textLength].length() != 0 && replacementList[textLength] != null) {
                                    var16 = text.indexOf(searchList[textLength], start);
                                    if(var16 == -1) {
                                        noMoreMatchesForReplIndex[textLength] = true;
                                    } else if(textIndex == -1 || var16 < textIndex) {
                                        textIndex = var16;
                                        replaceIndex = textLength;
                                    }
                                }
                            }
                        }

                        textLength = text.length();

                        for(int result = start; result < textLength; ++result) {
                            var17.append(text.charAt(result));
                        }

                        String var18 = var17.toString();
                        if(!repeat) {
                            return var18;
                        } else {
                            return replaceEach(var18, searchList, replacementList, repeat, timeToLive - 1);
                        }
                    }
                }
            }
        } else {
            return text;
        }
    }

    public static String replaceChars(String str, char searchChar, char replaceChar) {
        return str == null?null:str.replace(searchChar, replaceChar);
    }

    public static String replaceChars(String str, String searchChars, String replaceChars) {
        if(!isEmpty(str) && !isEmpty(searchChars)) {
            if(replaceChars == null) {
                replaceChars = "";
            }

            boolean modified = false;
            int replaceCharsLength = replaceChars.length();
            int strLength = str.length();
            StrBuilder buf = new StrBuilder(strLength);

            for(int i = 0; i < strLength; ++i) {
                char ch = str.charAt(i);
                int index = searchChars.indexOf(ch);
                if(index >= 0) {
                    modified = true;
                    if(index < replaceCharsLength) {
                        buf.append(replaceChars.charAt(index));
                    }
                } else {
                    buf.append(ch);
                }
            }

            if(modified) {
                return buf.toString();
            } else {
                return str;
            }
        } else {
            return str;
        }
    }

    /** @deprecated */
    public static String overlayString(String text, String overlay, int start, int end) {
        return (new StrBuilder(start + overlay.length() + text.length() - end + 1)).append(text.substring(0, start)).append(overlay).append(text.substring(end)).toString();
    }

    public static String overlay(String str, String overlay, int start, int end) {
        if(str == null) {
            return null;
        } else {
            if(overlay == null) {
                overlay = "";
            }

            int len = str.length();
            if(start < 0) {
                start = 0;
            }

            if(start > len) {
                start = len;
            }

            if(end < 0) {
                end = 0;
            }

            if(end > len) {
                end = len;
            }

            if(start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            return (new StrBuilder(len + start - end + overlay.length() + 1)).append(str.substring(0, start)).append(overlay).append(str.substring(end)).toString();
        }
    }

    public static String chomp(String str) {
        if(isEmpty(str)) {
            return str;
        } else if(str.length() == 1) {
            char var3 = str.charAt(0);
            return var3 != 13 && var3 != 10?str:"";
        } else {
            int lastIdx = str.length() - 1;
            char last = str.charAt(lastIdx);
            if(last == 10) {
                if(str.charAt(lastIdx - 1) == 13) {
                    --lastIdx;
                }
            } else if(last != 13) {
                ++lastIdx;
            }

            return str.substring(0, lastIdx);
        }
    }

    public static String chomp(String str, String separator) {
        return !isEmpty(str) && separator != null?(str.endsWith(separator)?str.substring(0, str.length() - separator.length()):str):str;
    }

    /** @deprecated */
    public static String chompLast(String str) {
        return chompLast(str, "\n");
    }

    /** @deprecated */
    public static String chompLast(String str, String sep) {
        if(str.length() == 0) {
            return str;
        } else {
            String sub = str.substring(str.length() - sep.length());
            return sep.equals(sub)?str.substring(0, str.length() - sep.length()):str;
        }
    }

    /** @deprecated */
    public static String getChomp(String str, String sep) {
        int idx = str.lastIndexOf(sep);
        return idx == str.length() - sep.length()?sep:(idx != -1?str.substring(idx):"");
    }

    /** @deprecated */
    public static String prechomp(String str, String sep) {
        int idx = str.indexOf(sep);
        return idx == -1?str:str.substring(idx + sep.length());
    }

    /** @deprecated */
    public static String getPrechomp(String str, String sep) {
        int idx = str.indexOf(sep);
        return idx == -1?"":str.substring(0, idx + sep.length());
    }

    public static String chop(String str) {
        if(str == null) {
            return null;
        } else {
            int strLen = str.length();
            if(strLen < 2) {
                return "";
            } else {
                int lastIdx = strLen - 1;
                String ret = str.substring(0, lastIdx);
                char last = str.charAt(lastIdx);
                return last == 10 && ret.charAt(lastIdx - 1) == 13?ret.substring(0, lastIdx - 1):ret;
            }
        }
    }

    /** @deprecated */
    public static String chopNewline(String str) {
        int lastIdx = str.length() - 1;
        if(lastIdx <= 0) {
            return "";
        } else {
            char last = str.charAt(lastIdx);
            if(last == 10) {
                if(str.charAt(lastIdx - 1) == 13) {
                    --lastIdx;
                }
            } else {
                ++lastIdx;
            }

            return str.substring(0, lastIdx);
        }
    }

    /** @deprecated */
    public static String escape(String str) {
        return StringEscapeUtils.escapeJava(str);
    }

    public static String repeat(String str, int repeat) {
        if(str == null) {
            return null;
        } else if(repeat <= 0) {
            return "";
        } else {
            int inputLength = str.length();
            if(repeat != 1 && inputLength != 0) {
                if(inputLength == 1 && repeat <= 8192) {
                    return padding(repeat, str.charAt(0));
                } else {
                    int outputLength = inputLength * repeat;
                    switch(inputLength) {
                        case 1:
                            char ch = str.charAt(0);
                            char[] output1 = new char[outputLength];

                            for(int var11 = repeat - 1; var11 >= 0; --var11) {
                                output1[var11] = ch;
                            }

                            return new String(output1);
                        case 2:
                            char ch0 = str.charAt(0);
                            char ch1 = str.charAt(1);
                            char[] output2 = new char[outputLength];

                            for(int buf = repeat * 2 - 2; buf >= 0; --buf) {
                                output2[buf] = ch0;
                                output2[buf + 1] = ch1;
                                --buf;
                            }

                            return new String(output2);
                        default:
                            StrBuilder var12 = new StrBuilder(outputLength);

                            for(int i = 0; i < repeat; ++i) {
                                var12.append(str);
                            }

                            return var12.toString();
                    }
                }
            } else {
                return str;
            }
        }
    }

    public static String repeat(String str, String separator, int repeat) {
        if(str != null && separator != null) {
            String result = repeat(str + separator, repeat);
            return removeEnd(result, separator);
        } else {
            return repeat(str, repeat);
        }
    }

    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if(repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        } else {
            char[] buf = new char[repeat];

            for(int i = 0; i < buf.length; ++i) {
                buf[i] = padChar;
            }

            return new String(buf);
        }
    }

    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    public static String rightPad(String str, int size, char padChar) {
        if(str == null) {
            return null;
        } else {
            int pads = size - str.length();
            return pads <= 0?str:(pads > 8192?rightPad(str, size, String.valueOf(padChar)):str.concat(padding(pads, padChar)));
        }
    }

    public static String rightPad(String str, int size, String padStr) {
        if(str == null) {
            return null;
        } else {
            if(isEmpty(padStr)) {
                padStr = " ";
            }

            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else if(padLen == 1 && pads <= 8192) {
                return rightPad(str, size, padStr.charAt(0));
            } else if(pads == padLen) {
                return str.concat(padStr);
            } else if(pads < padLen) {
                return str.concat(padStr.substring(0, pads));
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();

                for(int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }

                return str.concat(new String(padding));
            }
        }
    }

    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    public static String leftPad(String str, int size, char padChar) {
        if(str == null) {
            return null;
        } else {
            int pads = size - str.length();
            return pads <= 0?str:(pads > 8192?leftPad(str, size, String.valueOf(padChar)):padding(pads, padChar).concat(str));
        }
    }

    public static String leftPad(String str, int size, String padStr) {
        if(str == null) {
            return null;
        } else {
            if(isEmpty(padStr)) {
                padStr = " ";
            }

            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else if(padLen == 1 && pads <= 8192) {
                return leftPad(str, size, padStr.charAt(0));
            } else if(pads == padLen) {
                return padStr.concat(str);
            } else if(pads < padLen) {
                return padStr.substring(0, pads).concat(str);
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();

                for(int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }

                return (new String(padding)).concat(str);
            }
        }
    }

    public static int length(String str) {
        return str == null?0:str.length();
    }

    public static String center(String str, int size) {
        return center(str, size, ' ');
    }

    public static String center(String str, int size, char padChar) {
        if(str != null && size > 0) {
            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else {
                str = leftPad(str, strLen + pads / 2, padChar);
                str = rightPad(str, size, padChar);
                return str;
            }
        } else {
            return str;
        }
    }

    public static String center(String str, int size, String padStr) {
        if(str != null && size > 0) {
            if(isEmpty(padStr)) {
                padStr = " ";
            }

            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else {
                str = leftPad(str, strLen + pads / 2, padStr);
                str = rightPad(str, size, padStr);
                return str;
            }
        } else {
            return str;
        }
    }

    public static String upperCase(String str) {
        return str == null?null:str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        return str == null?null:str.toUpperCase(locale);
    }

    public static String lowerCase(String str) {
        return str == null?null:str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        return str == null?null:str.toLowerCase(locale);
    }

    public static String capitalize(String str) {
        int strLen;
        return str != null && (strLen = str.length()) != 0?(new StrBuilder(strLen)).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString():str;
    }

    /** @deprecated */
    public static String capitalise(String str) {
        return capitalize(str);
    }

    public static String uncapitalize(String str) {
        int strLen;
        return str != null && (strLen = str.length()) != 0?(new StrBuilder(strLen)).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString():str;
    }

    /** @deprecated */
    public static String uncapitalise(String str) {
        return uncapitalize(str);
    }

    public static String swapCase(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            StrBuilder buffer = new StrBuilder(strLen);
            boolean ch = false;

            for(int i = 0; i < strLen; ++i) {
                char var5 = str.charAt(i);
                if(Character.isUpperCase(var5)) {
                    var5 = Character.toLowerCase(var5);
                } else if(Character.isTitleCase(var5)) {
                    var5 = Character.toLowerCase(var5);
                } else if(Character.isLowerCase(var5)) {
                    var5 = Character.toUpperCase(var5);
                }

                buffer.append(var5);
            }

            return buffer.toString();
        } else {
            return str;
        }
    }

    /** @deprecated */
    public static String capitaliseAllWords(String str) {
        return WordUtils.capitalize(str);
    }

    public static int countMatches(String str, String sub) {
        if(!isEmpty(str) && !isEmpty(sub)) {
            int count = 0;

            for(int idx = 0; (idx = str.indexOf(sub, idx)) != -1; idx += sub.length()) {
                ++count;
            }

            return count;
        } else {
            return 0;
        }
    }

    public static boolean isAlpha(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isLetter(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAlphaSpace(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isLetter(str.charAt(i)) && str.charAt(i) != 32) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAlphanumeric(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isLetterOrDigit(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAlphanumericSpace(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isLetterOrDigit(str.charAt(i)) && str.charAt(i) != 32) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAsciiPrintable(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!CharUtils.isAsciiPrintable(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isNumeric(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isNumericSpace(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isDigit(str.charAt(i)) && str.charAt(i) != 32) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isWhitespace(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAllLowerCase(String str) {
        if(str != null && !isEmpty(str)) {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isLowerCase(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static boolean isAllUpperCase(String str) {
        if(str != null && !isEmpty(str)) {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isUpperCase(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static String defaultString(String str) {
        return str == null?"":str;
    }

    public static String defaultString(String str, String defaultStr) {
        return str == null?defaultStr:str;
    }

    public static String defaultIfBlank(String str, String defaultStr) {
        return isBlank(str)?defaultStr:str;
    }

    public static String defaultIfEmpty(String str, String defaultStr) {
        return isEmpty(str)?defaultStr:str;
    }

    public static String reverse(String str) {
        return str == null?null:(new StrBuilder(str)).reverse().toString();
    }

    public static String reverseDelimited(String str, char separatorChar) {
        if(str == null) {
            return null;
        } else {
            String[] strs = split(str, separatorChar);
            ArrayUtils.reverse(strs);
            return join((Object[])strs, separatorChar);
        }
    }

    /** @deprecated */
    public static String reverseDelimitedString(String str, String separatorChars) {
        if(str == null) {
            return null;
        } else {
            String[] strs = split(str, separatorChars);
            ArrayUtils.reverse(strs);
            return separatorChars == null?join((Object[])strs, ' '):join((Object[])strs, separatorChars);
        }
    }

    public static String abbreviate(String str, int maxWidth) {
        return abbreviate(str, 0, maxWidth);
    }

    public static String abbreviate(String str, int offset, int maxWidth) {
        if(str == null) {
            return null;
        } else if(maxWidth < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if(str.length() <= maxWidth) {
            return str;
        } else {
            if(offset > str.length()) {
                offset = str.length();
            }

            if(str.length() - offset < maxWidth - 3) {
                offset = str.length() - (maxWidth - 3);
            }

            if(offset <= 4) {
                return str.substring(0, maxWidth - 3) + "...";
            } else if(maxWidth < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else {
                return offset + (maxWidth - 3) < str.length()?"..." + abbreviate(str.substring(offset), maxWidth - 3):"..." + str.substring(str.length() - (maxWidth - 3));
            }
        }
    }

    public static String abbreviateMiddle(String str, String middle, int length) {
        if(!isEmpty(str) && !isEmpty(middle)) {
            if(length < str.length() && length >= middle.length() + 2) {
                int targetSting = length - middle.length();
                int startOffset = targetSting / 2 + targetSting % 2;
                int endOffset = str.length() - targetSting / 2;
                StrBuilder builder = new StrBuilder(length);
                builder.append(str.substring(0, startOffset));
                builder.append(middle);
                builder.append(str.substring(endOffset));
                return builder.toString();
            } else {
                return str;
            }
        } else {
            return str;
        }
    }

    public static String difference(String str1, String str2) {
        if(str1 == null) {
            return str2;
        } else if(str2 == null) {
            return str1;
        } else {
            int at = indexOfDifference(str1, str2);
            return at == -1?"":str2.substring(at);
        }
    }

    public static int indexOfDifference(String str1, String str2) {
        if(str1 == str2) {
            return -1;
        } else if(str1 != null && str2 != null) {
            int i;
            for(i = 0; i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i); ++i) {
                ;
            }

            return i >= str2.length() && i >= str1.length()?-1:i;
        } else {
            return 0;
        }
    }

    public static int indexOfDifference(String[] strs) {
        if(strs != null && strs.length > 1) {
            boolean anyStringNull = false;
            boolean allStringsNull = true;
            int arrayLen = strs.length;
            int shortestStrLen = 2147483647;
            int longestStrLen = 0;

            int firstDiff;
            for(firstDiff = 0; firstDiff < arrayLen; ++firstDiff) {
                if(strs[firstDiff] == null) {
                    anyStringNull = true;
                    shortestStrLen = 0;
                } else {
                    allStringsNull = false;
                    shortestStrLen = Math.min(strs[firstDiff].length(), shortestStrLen);
                    longestStrLen = Math.max(strs[firstDiff].length(), longestStrLen);
                }
            }

            if(allStringsNull || longestStrLen == 0 && !anyStringNull) {
                return -1;
            } else if(shortestStrLen == 0) {
                return 0;
            } else {
                firstDiff = -1;

                for(int stringPos = 0; stringPos < shortestStrLen; ++stringPos) {
                    char comparisonChar = strs[0].charAt(stringPos);

                    for(int arrayPos = 1; arrayPos < arrayLen; ++arrayPos) {
                        if(strs[arrayPos].charAt(stringPos) != comparisonChar) {
                            firstDiff = stringPos;
                            break;
                        }
                    }

                    if(firstDiff != -1) {
                        break;
                    }
                }

                return firstDiff == -1 && shortestStrLen != longestStrLen?shortestStrLen:firstDiff;
            }
        } else {
            return -1;
        }
    }

    public static String getCommonPrefix(String[] strs) {
        if(strs != null && strs.length != 0) {
            int smallestIndexOfDiff = indexOfDifference(strs);
            return smallestIndexOfDiff == -1?(strs[0] == null?"":strs[0]):(smallestIndexOfDiff == 0?"":strs[0].substring(0, smallestIndexOfDiff));
        } else {
            return "";
        }
    }

    public static int getLevenshteinDistance(String s, String t) {
        if(s != null && t != null) {
            int n = s.length();
            int m = t.length();
            if(n == 0) {
                return m;
            } else if(m == 0) {
                return n;
            } else {
                if(n > m) {
                    String p = s;
                    s = t;
                    t = p;
                    n = m;
                    m = p.length();
                }

                int[] var11 = new int[n + 1];
                int[] d = new int[n + 1];

                int i;
                for(i = 0; i <= n; var11[i] = i++) {
                    ;
                }

                for(int j = 1; j <= m; ++j) {
                    char t_j = t.charAt(j - 1);
                    d[0] = j;

                    for(i = 1; i <= n; ++i) {
                        int cost = s.charAt(i - 1) == t_j?0:1;
                        d[i] = Math.min(Math.min(d[i - 1] + 1, var11[i] + 1), var11[i - 1] + cost);
                    }

                    int[] _d = var11;
                    var11 = d;
                    d = _d;
                }

                return var11[n];
            }
        } else {
            throw new IllegalArgumentException("Strings must not be null");
        }
    }

    public static boolean startsWith(String str, String prefix) {
        return startsWith(str, prefix, false);
    }

    public static boolean startsWithIgnoreCase(String str, String prefix) {
        return startsWith(str, prefix, true);
    }

    private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        return str != null && prefix != null?(prefix.length() > str.length()?false:str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length())):str == null && prefix == null;
    }

    public static boolean startsWithAny(String string, String[] searchStrings) {
        if(!isEmpty(string) && !ArrayUtils.isEmpty(searchStrings)) {
            for(int i = 0; i < searchStrings.length; ++i) {
                String searchString = searchStrings[i];
                if(startsWith(string, searchString)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean endsWith(String str, String suffix) {
        return endsWith(str, suffix, false);
    }

    public static boolean endsWithIgnoreCase(String str, String suffix) {
        return endsWith(str, suffix, true);
    }

    private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        if(str != null && suffix != null) {
            if(suffix.length() > str.length()) {
                return false;
            } else {
                int strOffset = str.length() - suffix.length();
                return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
            }
        } else {
            return str == null && suffix == null;
        }
    }

    public static String normalizeSpace(String str) {
        str = strip(str);
        if(str != null && str.length() > 2) {
            StrBuilder b = new StrBuilder(str.length());

            for(int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if(Character.isWhitespace(c)) {
                    if(i > 0 && !Character.isWhitespace(str.charAt(i - 1))) {
                        b.append(' ');
                    }
                } else {
                    b.append(c);
                }
            }

            return b.toString();
        } else {
            return str;
        }
    }

    public static boolean endsWithAny(String string, String[] searchStrings) {
        if(!isEmpty(string) && !ArrayUtils.isEmpty(searchStrings)) {
            for(int i = 0; i < searchStrings.length; ++i) {
                String searchString = searchStrings[i];
                if(endsWith(string, searchString)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
