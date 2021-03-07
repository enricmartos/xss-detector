package org.emartos.requestvalidator.service.files;

import org.emartos.requestvalidator.model.files.FileHeader;
import org.springframework.stereotype.Service;

@Service
public class FileProcessorImpl implements FileProcessor {

    @Override
    public boolean hasValidHeader(byte[] file, String[] allowedMimeTypes) {
        return FileHeader.isValid(file, allowedMimeTypes);
    }
}
