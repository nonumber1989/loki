package org.sevenup.domain;

public class EntityVisibility {
    public static class Public { }
    public static class Detailed extends Public { }
    public static class Internal extends Detailed { }
}