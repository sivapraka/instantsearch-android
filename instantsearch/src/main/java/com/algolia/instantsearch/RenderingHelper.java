package com.algolia.instantsearch;

import android.support.annotation.ColorRes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RenderingHelper {

    private static final Set<String> attributeHighlights = new HashSet<>();
    private static final Map<String, Integer> attributeColors = new HashMap<>();

    static final String DEFAULT_COLOR = "@color/highlightingColor";

    public static @ColorRes int getHighlightColor(String attributeName) {
        return attributeColors.get(attributeName);
    }

    public static boolean shouldHighlight(String attributeName) {
        return attributeHighlights.contains(attributeName);
    }

    /**
     * Set a color for this attribute's highlighting.
     *
     * @param attributeName the attribute to color.
     * @param colorId       a {@link ColorRes} to associate with this attribute.
     * @return the previous color associated with this attribute or {@code null} if there was none.
     */
    protected static Integer addColor(String attributeName, @ColorRes int colorId) {
        return attributeColors.put(attributeName, colorId);
    }

    /**
     * Enable highlighting for this attribute.
     *
     * @param attributeName the attribute to color.
     * @return {@code true} if the attribute was not already highlighted, {@code false} otherwise.
     */
    protected static boolean addHighlight(String attributeName) {
        return attributeHighlights.add(attributeName);
    }
}
