package org.emartos.requestvalidator.model.files;

public enum MimeType {
    JPG("image/jpeg"),
    PNG("image/png"),
    PDF("application/pdf"),
    WORD("application/msword"),
    OPEN_WORD("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    EXCEL("application/vnd.ms-excel"),
    OPEN_EXCEL("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    private final String value;

    MimeType(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
