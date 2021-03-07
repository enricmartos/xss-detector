package org.emartos.requestvalidator.service.files;

public interface FileProcessor {

    boolean hasValidHeader(byte[] file, String[] allowedMimeTypes);
}
