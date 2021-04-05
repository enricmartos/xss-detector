package org.emartos.xssdetector.model.files;

import org.emartos.xssdetector.configuration.PropertyResolver;
import org.emartos.xssdetector.model.files.mother.FileMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FileHeaderTest {
    @Autowired
    private PropertyResolver propertyResolver;

    // HAPPY PATH TESTS
    @Test
    public void givenJPGImageAndJPGMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] jpgImage = FileMother.jpgImage();

        Assertions.assertTrue(FileHeader.isValid(jpgImage, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenPNGImageAndPNGMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] pngImage = FileMother.pngImage();

        Assertions.assertTrue(FileHeader.isValid(pngImage, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenPDFDocumentAndPDFMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] pdfDocument = FileMother.pdfDocument();

        Assertions.assertTrue(FileHeader.isValid(pdfDocument, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenDOCDocumentAndDOCMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] docDocument = FileMother.docDocument();

        Assertions.assertTrue(FileHeader.isValid(docDocument, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenDOCXDocumentAndDocMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] docxDocument = FileMother.docxDocument();

        Assertions.assertTrue(FileHeader.isValid(docxDocument, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenXLSDocumentAndXLSMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] xlsDocument = FileMother.xlsDocument();

        Assertions.assertTrue(FileHeader.isValid(xlsDocument, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenXLSXDocumentAndXLSXMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] xlsxDocument = FileMother.xlsxDocument();

        Assertions.assertTrue(FileHeader.isValid(xlsxDocument, propertyResolver.getAllowedMediaTypes()));
    }

    // CORNER CASES TESTS
    @Test
    public void givenGIFImageAndGIFMimeTypeIsNotAllowedThenFileHeaderIsValidReturnsFalse() {
        byte[] gifImage = FileMother.gifImage();

        Assertions.assertFalse(FileHeader.isValid(gifImage, propertyResolver.getAllowedMediaTypes()));
    }

    @Test
    public void givenHTMLDocumentAndHTMLMimeTypeIsNotAllowedThenFileHeaderIsValidReturnsFalse() {
        byte[] htmlDocument = FileMother.htmlDocument();

        Assertions.assertFalse(FileHeader.isValid(htmlDocument, propertyResolver.getAllowedMediaTypes()));
    }

}
