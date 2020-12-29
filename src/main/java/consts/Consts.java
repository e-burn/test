package consts;

import java.util.HashMap;

public class Consts
{
    public static final long EMPTY_FILE_LENGTH = 0;
    public static final HashMap<ListID, String> listsTitles = new HashMap<>();
    static {
        listsTitles.put(ListID.FAVORITE, "?????????");
        listsTitles.put(ListID.WATCHED, "?????????????");
        listsTitles.put(ListID.WATCHING, "??????????????");
        listsTitles.put(ListID.PLANNED, "???????????????");
    }

    public static final HashMap<OptionID, String> optionsTitles = new HashMap<>();
    static {
        optionsTitles.put(OptionID.LOGIN, "???????? ?????");
        optionsTitles.put(OptionID.PERSONALIZATION, "???????? ??????????");
        optionsTitles.put(OptionID.EXIT, "?????");
    }
}