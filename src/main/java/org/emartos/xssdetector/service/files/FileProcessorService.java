package org.emartos.xssdetector.service.files;

public interface FileProcessorService {

    boolean hasValidHeader(byte[] file, String[] allowedMimeTypes);
}
