package com.bendaten.trainer.chapter11;

import com.google.zxing.WriterException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.bendaten.trainer.chapter11.QRCodeGenerator.generateQRCodeImage;

public class Chapter11 {
    protected static Logger logger = Logger.getLogger(Chapter11.class.getName());

    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    public static void work() {
        logger.log(Level.INFO, "In Chapter 11 - Object Cloning");

        CopyDemo cd1 = new CopyDemo(3, "cd1");
        String output = cd1.toString();
        logger.log(Level.INFO, output);

        CopyDemo cd2 = cd1;  // just create another reference to the same object. try to change one and see what happens to the other:
        cd2.setId(13);
        output = String.format("after calling cd2.setId(13) we see that cd1 was changed: %s", cd1.toString());
        logger.log(Level.INFO, output);

        cd2 = new CopyDemo(cd1);  // now cd2 is a different object with copied contents
        cd2.setId(113);
        output = String.format("after calling cd2.setId(113) we see that cd1 is not changed: %s", cd1.toString());
        logger.log(Level.INFO, output);

        CloneDemo cld1 = new CloneDemo(cd1);
        output = String.format("cld1: %s", cld1.toString());
        logger.log(Level.INFO, output);

        CloneDemo cld2 = new CloneDemo(cld1);  // deep copy cld2 is a new object and its member is a new object
        output = String.format("cld2: %s", cld2.toString());
        logger.log(Level.INFO, output);

        output = String.format("Do cld1 and cld2 have the same member? - %B", cld1.getCd() == cld2.getCd());
        logger.log(Level.INFO, output);
        output = String.format("Do the members of cld1 and cld2 have the same contents? - %B", cld1.getCd().equals(cld2.getCd()));
        logger.log(Level.INFO, output);

        output = "https://confluence.vzbuilders.com/display/AOLPADVERTISERS/DSP+Serving+Component";
        try {
            generateQRCodeImage(output, 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            logger.log(Level.SEVERE, "Could not generate QR Code, WriterException", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not generate QR Code, IOException", e);
        }
    }
}
