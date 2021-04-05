package org.emartos.xssdetector.service.files;

import org.emartos.xssdetector.model.files.FileHeader;
import org.springframework.stereotype.Service;

@Service
public class FileProcessorServiceImpl implements FileProcessorService {

    @Override
    public boolean hasValidHeader(byte[] file, String[] allowedMimeTypes) {
        return FileHeader.isValid(file, allowedMimeTypes);
    }
}
