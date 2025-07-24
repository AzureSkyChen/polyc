package console;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Format {
    public static final String NONE = "\033[0m";
    public static final String BLACK = "\033[30;1m";
    public static final String RED = "\033[31;1m";
    public static final String GREEN = "\033[32;1m";
    public static final String GREEN_BACK = "\033[42;1;30m";
    public static final String YELLOW = "\033[33;1m";
    public static final String YELLOW_BACK = "\033[43;1;30m";
    public static final String BLUE = "\033[34;1m";
    public static final String BLUE_BACK = "\033[44;1;30m";
    public static final String PURPLE = "\033[35;1m";
    public static final String DARK_GREEN = "\033[36;1m";


    public static @NotNull String addIndent(@Nullable Object o) {
        return "\t" + (o == null ? null : o.toString().replace("\n", "\n\t"));
    }
}
