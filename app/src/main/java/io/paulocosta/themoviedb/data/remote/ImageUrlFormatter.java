package io.paulocosta.themoviedb.data.remote;


public class ImageUrlFormatter {

    private static final String SIZE_SMALL = "w300";

    private static final String SIZE_LARGE = "w780";


    private ImageUrlFormatter() {
        // No instances
    }

    private static String getImageUrl(final String size, final String path) {
        return Endpoint.IMAGE + size + path;
    }

    public static String getSmallImagePath(final String path) {
        return getImageUrl(SIZE_SMALL, path);
    }

    public static String getLargeImagePath(final String path) {
        return getImageUrl(SIZE_LARGE, path);
    }

}
