package org.emartos.requestvalidator.web;

import org.emartos.requestvalidator.model.FileHeader;
import org.emartos.requestvalidator.model.FileMetadata;
import org.emartos.requestvalidator.model.MimeType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping(RequestValidatorApiConstants.REQUEST_VALIDATOR_API_PATH + RequestValidatorApiConstants.VERSION)
public class RequestValidatorController {
    private static final String[] allowedMediaTypes = new String[] {MimeType.JPG.value(),
            MimeType.PNG.value(), MimeType.PDF.value(), MimeType.WORD.value(),
            MimeType.OPEN_WORD.value(), MimeType.EXCEL.value(), MimeType.OPEN_EXCEL.value()};

    @PostMapping(RequestValidatorApiConstants.REQUEST_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> sendMessage(@RequestBody FileMetadata fileMetadata) {

//        FileHeader.isValid(file.getBytes(), allowedMediaTypes);

        return new ResponseEntity<>(fileMetadata.toString(), HttpStatus.OK);
    }

}
