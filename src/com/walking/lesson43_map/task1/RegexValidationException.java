package com.walking.lesson43_map.task1;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String str, String regex) {
        super("%s not matches to '%s'".formatted(str, regex));
    }
}
