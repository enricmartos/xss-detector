package org.emartos.xssdetector.web.controllers;

import org.emartos.xssdetector.configuration.PropertyResolver;
import org.emartos.xssdetector.model.exceptions.InvalidFileException;
import org.emartos.xssdetector.model.files.FileMetadata;
import org.emartos.xssdetector.service.files.FileProcessorService;
import org.emartos.xssdetector.web.constants.XssDetectorApiConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping(XssDetectorApiConstants.XSS_DETECTOR_API_PATH + XssDetectorApiConstants.VERSION)
public class XssDetectorController {
    private static final String NO_XSS_INJECTION = "No XSS injection during JSON deserialization";
    private static final String INVALID_FILE_EXCEPTION_MESSAGE = "The media type of the file is not allowed";
    private static final String NO_INVALID_FILE = "The media type of the file is allowed";

    private final PropertyResolver propertyResolver;

    private final FileProcessorService fileProcessorService;

    public XssDetectorController(PropertyResolver propertyResolver, FileProcessorService fileProcessorService) {
        this.propertyResolver = propertyResolver;
        this.fileProcessorService = fileProcessorService;
    }

    @PostMapping(XssDetectorApiConstants.FILE_METADATA_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> validateFileMetadata(@RequestBody FileMetadata fileMetadata) {

        return new ResponseEntity<>(NO_XSS_INJECTION, HttpStatus.OK);
    }

    @PostMapping(XssDetectorApiConstants.FILE_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> validateFile(@RequestParam MultipartFile file) throws IOException, InvalidFileException {
        checkFile(file.getBytes());

        return new ResponseEntity<>(NO_INVALID_FILE, HttpStatus.OK);
    }

    private void checkFile(byte[] file) throws InvalidFileException {
        if (!fileProcessorService.hasValidHeader(file, propertyResolver.getAllowedMediaTypes())) {
            throw new InvalidFileException(INVALID_FILE_EXCEPTION_MESSAGE);
        }
    }

}
